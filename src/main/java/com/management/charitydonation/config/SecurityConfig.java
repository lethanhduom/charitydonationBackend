package com.management.charitydonation.config;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer.JwtConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.management.charitydonation.entity.Role;
import com.management.charitydonation.enums.Permit;
import com.nimbusds.jose.JWSAlgorithm;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	@Value("${jwt.signerkey}")
	private String signerKey;
//	private List<String>PUBLIC_ENDPOINT=new List<String>["/api/admin/login",""];
	
//	   @Bean
//	    public CorsConfigurationSource corsConfigurationSource() {
//	        CorsConfiguration configuration = new CorsConfiguration();
//	        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
//	        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
//	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	        source.registerCorsConfiguration("/**", configuration);
//	        return source;
		   
//	    }
	   @Bean
	    public CorsFilter corsFilter() {
	        CorsConfiguration config = new CorsConfiguration();
	    
	        config.setAllowCredentials(true);  // Cho phép gửi cookie và thông tin xác thực
	        config.addAllowedOrigin("http://localhost:3000"); // Địa chỉ ứng dụng React
	        config.addAllowedHeader("Authorization"); // Cho phép tất cả header
	       
	        config.addAllowedHeader("*");
	        
	        config.addAllowedMethod("*"); // Cho phép tất cả phương thức HTTP (GET, POST, PUT, DELETE
//	        CorsRegistry corsregister=new CorsRegistry();
//	        addCros(corsregister);
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", config); // Áp dụng cho tất cả các endpoint
	        return new CorsFilter(source);
	    }
//	   public CorsRegistry addCros(CorsRegistry corsRegister) {
//		   corsRegister.addMapping("/api/**")
//		   				.allowedOrigins("http://localhost:3000")
//		   				.allowedMethods("GET","POST","PUT","DELETE")
//		   				.allowedHeaders("Authorization")
//		   				.allowCredentials(true);
//		   return corsRegister
//	
//	   }
	
	 @Bean
	 public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
		 
		 httpSecurity.csrf(AbstractHttpConfigurer::disable);
		 httpSecurity.cors().disable()
		 .authorizeRequests()
		 .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll();
		 
//		httpSecurity.cors(c -> c.configurationSource(corsFilter()));
		 httpSecurity.authorizeRequests(request->
		 request
	
		 .requestMatchers(HttpMethod.POST,"/api/admin/login").permitAll()
		 .requestMatchers(HttpMethod.GET,"api/account/getaccountactive").hasAnyRole(Permit.ADMIN.name())
		 .requestMatchers(HttpMethod.GET,"api/role/listrole").hasAnyRole(Permit.ADMIN.name())
		 .requestMatchers(HttpMethod.POST,"api/account/introspect").permitAll()
		 .requestMatchers(HttpMethod.GET,"api/account/getaccountactive").permitAll()
		 .requestMatchers(HttpMethod.POST,"/api/admin/temp").permitAll()
		 .requestMatchers(HttpMethod.POST,"/api/admin/**").permitAll()
		 .requestMatchers(HttpMethod.GET,"/api/admin/campaign").permitAll()
		 .requestMatchers(HttpMethod.GET,"/api/user/**").permitAll()
		 .requestMatchers(HttpMethod.POST,"/api/paypal/create").permitAll()
		 .requestMatchers(HttpMethod.POST,"/api/account/login").permitAll()
        
		 .anyRequest().authenticated()
	  
	  
	     
		
		 
		 );
		
		 httpSecurity.oauth2ResourceServer(oauth2->
		 oauth2.jwt(JwtConfigurer->JwtConfigurer.decoder(jwtDecoder())
				 .jwtAuthenticationConverter(jwtauthenticationConverter()))
		 );
		
		 return httpSecurity.build();
	 }
	 JwtAuthenticationConverter jwtauthenticationConverter () {
		 JwtGrantedAuthoritiesConverter jwtGranteAuthoritiesConverter=new JwtGrantedAuthoritiesConverter();
		 jwtGranteAuthoritiesConverter.setAuthorityPrefix("ROLE_");
		 JwtAuthenticationConverter jwauthenticationConverter=new JwtAuthenticationConverter();
		 jwauthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGranteAuthoritiesConverter);
		 
		 return jwauthenticationConverter;
		 }
	 @Bean
	 JwtDecoder jwtDecoder() {
		 SecretKeySpec secretkeySpec=new SecretKeySpec(signerKey.getBytes(),"HS512");
		return NimbusJwtDecoder
				.withSecretKey(secretkeySpec)
				.macAlgorithm(MacAlgorithm.HS512)
				.build();
//		 return null;
		
		 
	 };
//	 @Bean
//	    public CorsFilter corsFilter() {
//	        CorsConfiguration corsConfiguration = new CorsConfiguration();
//
//	        corsConfiguration.addAllowedOrigin("*");
//	        corsConfiguration.addAllowedMethod("*");
//	        corsConfiguration.addAllowedHeader("*");
//
//	        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//	        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//
//	        return new CorsFilter((CorsConfigurationSource) urlBasedCorsConfigurationSource);
//	    }
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder(10);
	}
}
