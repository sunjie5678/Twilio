package com.jie.twilio.test;

import com.twilio.Twilio;
import com.twilio.jwt.accesstoken.AccessToken;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Main {
	  private final static String ACCOUNT_SID = "ACfXXXXXXXXXXXXXXXXXXXXXXXXX"; 
	    private final static String AUTH_TOKEN = "959013334XXXXXXXXXXXXXXXXXXX"; 
	    private final static  String twilioApiKey = "SKXXXXXXXXXXXXXXXXX";
	    private final static   String twilioApiSecret = "XLXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	public static void main(String[] args) {
	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	    String identity = "user";
	 // Create access token
	    AccessToken token = new AccessToken.Builder(
	    		ACCOUNT_SID,
	      twilioApiKey,
	      twilioApiSecret
	    ).identity(identity).build();

	    System.out.println(token.toJwt());
	    Message message = Message
	        .creator(new PhoneNumber("+xxxxxxxxxx"), new PhoneNumber("+xxxxxxxxxx"),
	        		token.toJwt())
	        .create();

	    System.out.println(message.getSid());
	  }
}
