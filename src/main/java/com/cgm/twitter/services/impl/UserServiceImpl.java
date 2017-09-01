package com.cgm.twitter.services.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cgm.builder.AccountBuilder;
import com.cgm.entities.Account;
import com.cgm.twitter.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public Account getAccount(Account account) {
		Account myAccount = null;
		for(Account accountElement:AccountBuilder.accounts) {
			if(accountElement.getPassword().equals(account.getPassword()) && accountElement.getUsername().equals(account.getUsername())) {
				myAccount = accountElement;
			}
		}
		return myAccount;
	}
	
	@Override
	public ArrayList<String> getMessages(String username){
		ArrayList<String> messages = new ArrayList<String>();
		
		return messages;
	}
	
}
