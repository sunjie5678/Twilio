package com.jie.twilio.test;

import java.net.ProtocolException;

import com.authy.*;
import com.authy.api.*;


public class Main {
	
	public static void main(String[] args) throws ProtocolException {
		String apiKey = "cNY4Z6ngPPx9CZS7PqN39Q5m9XDxa0cT";
		String apiUrl = "https://api.authy.com/";
		boolean debugMode = false;

		AuthyApiClient client = new AuthyApiClient(apiKey, apiUrl, debugMode);
		Users users = client.getUsers();
		Tokens tokens = client.getTokens();
		User user = users.createUser("new_user@email.com", "2269729354", "1");
		 if(user.isOk()){
			     int uId = user.getId();
			     Hash sms = users.requestSms(uId);
			     
			  } else {
				  user.getError();
			  }
	  }
}
