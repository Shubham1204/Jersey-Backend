package com.kraftwork.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kraftwork.DAO.CommonDAO;
import com.kraftwork.Model.Category;


public class CategoryRepository {

	HashMap<String, Object> catHashList = new HashMap<String, Object>();
	List<Category> catList;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Category c;
	public CategoryRepository() throws ClassNotFoundException {

		con = CommonDAO.getConnection(); 
	}
	
	public HashMap<String, Object> getCategory(){
		if(con!=null) {
			try {
				ps = con.prepareStatement("select catid,catname,description,catimagepath,status from category_mst");
				rs = ps.executeQuery();
				catList = new ArrayList<Category>();
				if(rs.next()) { 
				    do { 
				    	c = new Category();
						c.setCategoryId(rs.getInt("catid"));
						c.setCategoryName(rs.getString("catname"));
						c.setCategoryDescription(rs.getString("description"));
						c.setCategoryImagePath(rs.getString("catimagepath"));
						c.setCategoryStatus(rs.getString("status"));
						catList.add(c);
				    } while (rs.next());
				    catHashList.put("message", "success");
				    catHashList.put("categories", catList);
				    }else {
				    	catHashList.put("message", "fail");
				    	catHashList.put("error_message","no records avaliable");
				    }
			} catch (SQLException e) {
				catHashList.put("message", "fail");
				catHashList.put("error_code", e.getErrorCode());
				catHashList.put("error_message", e.toString());
			}
		}
		else {
			catHashList.put("message","fail");
			catHashList.put("error_message","failed to esatblish connection");
		}
			return catHashList;
		}
		
		public HashMap<String, Object> getByIdCategory(int c1){
		if(con!=null) {
			try {
				
				ps = con.prepareStatement("select catid,catname,description,catimagepath from category_mst where catid=?");
				ps.setInt(1,c1);
				rs = ps.executeQuery();
				if(rs.next()) {
					c = new Category();
					c.setCategoryId(rs.getInt("catid"));
					c.setCategoryName(rs.getString("catname"));
					c.setCategoryDescription(rs.getString("description"));
					c.setCategoryImagePath(rs.getString("catimagepath"));
					catHashList.put("message", "success");
					catHashList.put("category", c);
				}
				else {
					catHashList.put("message", "fail");
					catHashList.put("error_message","no records avaliable");
				} 
			}catch (SQLException e) {
				catHashList.put("message", "fail");
				catHashList.put("error_code", e.getErrorCode());
				catHashList.put("error_message", e.toString());
			}
		}
		else {
			catHashList.put("message","fail");
			catHashList.put("error_message","failed to esatblish connection");
		}
			return catHashList;
		}
		
		
		public HashMap<String,Object> addCategory(Category c){
			if(con!=null) {
			try {
				ps = con.prepareStatement("insert into category_mst(catid,catname,description,catimagepath) values(?,?,?,?)");
				ps.setInt(1, c.getCategoryId());
				ps.setString(2, c.getCategoryName());
				ps.setString(3, c.getCategoryDescription());
				ps.setString(4, c.getCategoryImagePath());
				int recordCount = ps.executeUpdate();
				if(recordCount>0) {
					System.out.println("register successfully");
					catHashList.put("message","success");
				}
				else {
					catHashList.put("message","fail");
					catHashList.put("error_message", "couldn't add to db");
				}
			} catch (SQLException e) {
				catHashList.put("message","fail");
				catHashList.put("error_code", e.getErrorCode());
				catHashList.put("error_message", e.toString());
			}
			}
			else {
				catHashList.put("message","fail");
			}
			return catHashList;
		}
		
		public HashMap<String,Object> updateCategory(Category c,int s){
			if(con!=null) {
			try {
				ps = con.prepareStatement("update category_mst set catname=?,description=?,catimagepath=? where catid=?");
				ps.setString(1, c.getCategoryName());
				ps.setString(2, c.getCategoryDescription());
				ps.setString(3, c.getCategoryImagePath());
				ps.setInt(4, s);
				int recordCount = ps.executeUpdate();
				System.out.println(recordCount);
				if(recordCount>0) {
					System.out.println("updated successfully");
					catHashList.put("message","success");
				}
				else {
					catHashList.put("message","fail");
					catHashList.put("error_message", "couldn't update db");
				}
			} catch (SQLException e) {
				catHashList.put("message","fail");
				catHashList.put("error_code", e.getErrorCode());
				catHashList.put("error_message", e.toString());
			}
			}
			else {
				catHashList.put("message","fail");
			}
			return catHashList;
		}
		
		public HashMap<String,Object> deleteCategory(int s){
			if(con!=null) {
			try {
				ps = con.prepareStatement("update category_mst set status=? where catid=?");	
				ps.setString(1, "N");
				ps.setInt(2, s);
				int recordCount = ps.executeUpdate();
				System.out.println(recordCount);
				if(recordCount>0) {
					System.out.println("deleted successfully");
					catHashList.put("message","success");
				}
				else {
					catHashList.put("message","fail");
					catHashList.put("error_message", "couldn't delete from db");
				}
			} catch (SQLException e) {
				catHashList.put("message","fail");
				catHashList.put("error_code", e.getErrorCode());
				catHashList.put("error_message", e.toString());
			}
			}
			else {
				catHashList.put("message","fail");
			}
			return catHashList;
		}
}
