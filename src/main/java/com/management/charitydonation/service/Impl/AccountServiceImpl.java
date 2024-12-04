package com.management.charitydonation.service.Impl;


import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.management.charitydonation.Response.AuthenticationResponse;
import com.management.charitydonation.Response.IntrospectReponse;
import com.management.charitydonation.Response.LoginResponse;
import com.management.charitydonation.dto.AccountDto;
import com.management.charitydonation.entity.Account;
import com.management.charitydonation.exception.AppException;
import com.management.charitydonation.exception.ErrorCode;
import com.management.charitydonation.exception.ResourceNotFoundException;
import com.management.charitydonation.mapper.AccountMapper;
import com.management.charitydonation.repository.AccountRepository;
import com.management.charitydonation.repository.OutboundIdentityClient;
import com.management.charitydonation.request.ExchangeTokenRequest;
import com.management.charitydonation.service.AccountService;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import lombok.AllArgsConstructor;
import lombok.experimental.NonFinal;
import lombok.experimental.var;


@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
	private AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;
    private OutboundIdentityClient outboundIdentityClient;
    @NonFinal
//    @Value("${jwt.signerKey}")
    protected static final String SIGNER_KEY="tX/nQ+evyqQdmSa9jxVjHyAEQ4Svb++/gxm1hVkfOaYzlxOx0M2wtxI45lUWk1Hz";
   
    @NonFinal
    protected static final String 	CLIENT_ID="1044781847135-sckdb8f98q60nfbre1v3987sndggjssf.apps.googleusercontent.com";
    @NonFinal
    protected static final String 	CLIENT_SECRET="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";
    
    @NonFinal
    protected static final String REDIRECT_URL="http://localhost:3000/authenticate";
    
    @NonFinal 
    protected static final String GRANT_TYPE="authorization_code";
    
	@Override
	public AccountDto createAccount(AccountDto accountdto) {
		Account account=AccountMapper.mapAccount(accountdto);
		Account saveAccount = accountRepository.save(account);
		return AccountMapper.mapAccountDto(saveAccount);
	}
    
	@Override
	public AccountDto updateAccount(AccountDto accountDto, int id) {
		Account account=accountRepository.findById(id).orElseThrow(()
				->new ResourceNotFoundException("account not found"));
	
		account.setPassword(accountDto.getPassword());
		account.setUserName(accountDto.getUserName());
		Account saveAccount=accountRepository.save(account);
		return AccountMapper.mapAccountDto(saveAccount);
	}

	@Override
	public Page<AccountDto> getAccountActive(int page, int size) {
		Page<Account>accountList=accountRepository.getAllAccount(PageRequest.of(page,size));
		
		return accountList.map(account->AccountMapper.mapAccountDto(account));
	}


	@Override
	public LoginResponse loginAdmin(AccountDto accountDto) {
			Boolean authenticated=false;
		   Account getAccount=accountRepository.getAccount(accountDto.getUserName());
		   if(getAccount!=null) {
			   if(getAccount.getIsActive()!=0) {
				   if(passwordEncoder.matches(accountDto.getPassword(), getAccount.getPassword())) {
					   var token=generateToken(AccountMapper.mapAccountDto(getAccount));
					   return LoginResponse.builder()
							   .token(token)
							   .errorcode(null)
							   .authenticated(true)
							   .build();
					
				   }else {
					return new LoginResponse(null,ErrorCode.PASSWORD_NOT_MATCH,false);					  
				   }
			   }else {
				 return new LoginResponse(null,ErrorCode.ACCOUNT_NOT_ACTIVE,false);
			   }
			   
		   }else {
			   return new LoginResponse(null,ErrorCode.USER_NOT_EXISTED,false);
		   }
		
	}

	@Override
	public LoginResponse login(AccountDto accountDto) {
//		
		  Account getAccount=accountRepository.findByuserName(accountDto.getUserName());
		   if(getAccount!=null) {
			   if(accountRepository.isActive(accountDto.getUserName())) {
				   if(passwordEncoder.matches(accountDto.getPassword(), getAccount.getPassword())) {
					   var token=generateToken(AccountMapper.mapAccountDto(getAccount));
					   return LoginResponse.builder()
							   .token(token)
							   .errorcode(null)
							   .authenticated(true)
							   .build();
				   }else {
					   return new LoginResponse(null,ErrorCode.PASSWORD_NOT_MATCH,false);
				   }
			   }else {
				   return new LoginResponse(null,ErrorCode.ACCOUNT_NOT_ACTIVE,false);
			   }
			   
		   }else {
			   return new LoginResponse(null,ErrorCode.USER_NOT_EXISTED, false);
		   }
	
	}

	@Override
	public String generateToken(AccountDto accountDto) {
		JWSHeader header=new JWSHeader(JWSAlgorithm.HS512);
		JWTClaimsSet jwtClaimSet=new JWTClaimsSet.Builder()
				.subject(accountDto.getUserName())
				.issuer("donation.com")
				.issueTime(new Date())
				.expirationTime(new Date(Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()))
				.claim("scope",buildPermit(accountDto))
				
				.build();
		Payload payLoad=new Payload(jwtClaimSet.toJSONObject());
		JWSObject jwsObject=new JWSObject(header, payLoad);
		try {
			jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
			return jwsObject.serialize() ;
		} catch (KeyLengthException e) {
		
			e.printStackTrace();
		} catch (JOSEException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public IntrospectReponse introspect(String token) {
	try {
		JWSVerifier verifier=new MACVerifier(SIGNER_KEY.getBytes());
		SignedJWT signedJWT=SignedJWT.parse(token);
		Date expireTime=signedJWT.getJWTClaimsSet().getExpirationTime();
		
	Boolean checkVerified=	signedJWT.verify(verifier);
	return IntrospectReponse.builder()
			.valid((checkVerified&&expireTime.after(new Date())))
			.build();
	} catch (JOSEException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	}
private String buildPermit(AccountDto accountDto) {
	StringJoiner stringJoiner=new StringJoiner(" ");
	if(!CollectionUtils.isEmpty(accountDto.getPermit())) {
		accountDto.getPermit().forEach(string->stringJoiner.add(string));
	}
	return stringJoiner.toString();
}

@Override
public AccountDto getAccount(int id) {
	Account account=accountRepository.findByIdAccount(id);
	return AccountMapper.mapAccountDto(account);
}

@Override
public AccountDto getAccountByUserName(String userName) {
   Account account=accountRepository.findByuserName(userName);
	return AccountMapper.mapAccountDto(account);
}

@Override
public LoginResponse googleAuthentication(String code) {
	var response=outboundIdentityClient.exchangeToken(ExchangeTokenRequest.builder()
			.code(code)
			.clientId(CLIENT_ID)
			.clientSecret(CLIENT_SECRET)
			.redirectUri(REDIRECT_URL)
			.grantType("authorization_code")
			.build()
			);
	
	return LoginResponse.builder()
			.token(response.getAccessToken())
			.build();
}
@Override
 public AuthenticationResponse outboundAuthentication(String code) {
	 var response = outboundIdentityClient.exchangeToken(ExchangeTokenRequest.builder()
             .code(code)
             .clientId(CLIENT_ID)
             .clientSecret(CLIENT_SECRET)
             .redirectUri(REDIRECT_URL)
             .grantType(GRANT_TYPE)
             .build());

     

     return AuthenticationResponse.builder().token(response.getAccessToken()).build();
 }
}
