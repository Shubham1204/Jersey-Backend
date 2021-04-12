package com.kraftwork.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import com.kraftwork.DAO.CommonDAO;
import com.kraftwork.Model.Category;
import com.kraftwork.Model.User;

public class UserRepository {

	HashMap<String, Object> userHashList = new HashMap<String, Object>();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public UserRepository() throws ClassNotFoundException {
		
		con = CommonDAO.getConnection(); 
	}
	
	public HashMap<String,Object> addUser(User user){
		if(con!=null) {
			
		}
		return userHashList;
		}
}
