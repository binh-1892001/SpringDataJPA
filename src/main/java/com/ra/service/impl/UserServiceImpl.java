package com.ra.service.impl;

import com.ra.model.Users;
import com.ra.repository.UserRepository;
import com.ra.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	
	@Override
	public List<Users> findAll() {
		return userRepository.findAll();
	}
	
	@Override
	public Users findById(String s) {
		Optional<Users> optionalUsers = userRepository.findById(s);
		return optionalUsers.orElse(null);
	}
	
	@Override
	public Users save(Users users) {
		Users newUsers = userRepository.save(users);
		return newUsers;
	}
	
	@Override
	public void delete(String s) {
		if (findById(s) != null) {
			userRepository.deleteById(s);
		}else {
			System.err.println("Không tìm thấy user");
		}
	}
	
	@Override
	public List<Users> searchUserByFullName(String keyword) {
		return userRepository.searchUsersByNameCustom(keyword);
	}
}
