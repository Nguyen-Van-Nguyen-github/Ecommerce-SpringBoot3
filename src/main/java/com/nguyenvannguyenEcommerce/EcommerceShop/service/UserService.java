package com.nguyenvannguyenEcommerce.EcommerceShop.service;

import java.util.List;

import com.nguyenvannguyenEcommerce.EcommerceShop.model.UserDtls;

public interface UserService {
	
	public UserDtls saveUser(UserDtls user);
	
	public UserDtls getUserByEmail(String email);
	
	public List<UserDtls> getUsers(String role);

	public Boolean updateAccountStatus(Integer id, Boolean status);
}
