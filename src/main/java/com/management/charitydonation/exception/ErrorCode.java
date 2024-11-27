package com.management.charitydonation.exception;

import lombok.Getter;

@Getter
public enum  ErrorCode {
	    USER_NOT_EXISTED(1000, "User not existed"),
	    ACCOUNT_NOT_ACTIVE (1001,"Account not Active"),
		PASSWORD_NOT_MATCH(1002,"Password not Match")
	    ;

	  ErrorCode(int code, String message ) {
	        this.code = code;
	        this.message = message;
//	        this.statusCode = statusCode;
	    }

	    private final int code;
	    private final String message;
//	    private final HttpStatusCode statusCode;

}
