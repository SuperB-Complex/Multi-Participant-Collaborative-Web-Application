package com.slack.dao;

import java.util.List;

public interface CustomerDAO  {
	boolean register(String userName, String nickName, String userEmail,String passWrd);
	List<Object[]> login(int isEmail, String nickNameOrUserEmail, String passWord);
	boolean inputExist(String isEmail, String nickNameOrUserEmail);
}