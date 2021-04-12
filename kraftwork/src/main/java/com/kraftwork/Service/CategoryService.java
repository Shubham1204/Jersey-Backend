package com.kraftwork.Service;

import com.google.gson.Gson;
import com.kraftwork.Model.Category;
import com.kraftwork.Repository.CategoryRepository;

public class CategoryService {

	CategoryRepository repo;
	Gson gson;
	String js;
	
	public CategoryService() throws ClassNotFoundException{
		 gson = new Gson();
		 repo = new CategoryRepository();
	}
	
	public String getCategoryJson() {
		js= gson.toJson(repo.getCategory()); 
		return js; 
	}
	public String getByIdCategoryJson(int c1) {
		js= gson.toJson(repo.getByIdCategory(c1)); 
		return js; 
	}
	
	public String addCategoryJson(String c1) {
		Category c = gson.fromJson(c1, Category.class);
		js= gson.toJson(repo.addCategory(c));
		return js;
	}
	public String updateCategoryJson(String c1,int s) {
		Category c = gson.fromJson(c1, Category.class);
		js= gson.toJson(repo.updateCategory(c,s));
		return js;
	}
	public String deleteCategoryJson(int s) {
		js= gson.toJson(repo.deleteCategory(s));
		return js;
	}
}
