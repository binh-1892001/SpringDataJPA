package com.ra.service;

import com.ra.model.Users;

import java.util.List;

public interface UserService extends IBaseService<Users,String>{
	List<Users> searchUserByFullName(String keyword);
}
