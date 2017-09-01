package com.cgm.twitter.services;

import java.util.ArrayList;

import com.cgm.entities.Account;

public interface UserService {

	public Account getAccount(Account account);
	public ArrayList<String> getMessages(String username);
	
}
