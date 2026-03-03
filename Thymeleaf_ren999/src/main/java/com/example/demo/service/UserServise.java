package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;


public class UserServise {
	
	/*
	 * ユーザー情報　service
	 * */
	@Service
	@Transactional(rollbackFor = Exception.class)
	public class UserService{
	
	/*
	 * ユーザー情報　Repository
	 * 
	 * */
	@Autowired
	UserRepository userRepository;
	/*
	 * ユーザー情報　全検索
	 * @return 検索結果
	 * */
	
	
	public List<User> searchAll(){
		return userRepository.findAll();
	}
	/*
	 * ユーザー情報新規登録
	 * @param 失せrユーザー情報 
	 * */
	public void create(UserRequest userRequest) {
		Date now =new Date();
		User user =new User();
		user.setName(userRequest.getName());
		user.setAddress(userRequest.getAddress());
		user.setPhone(userRequest.getPhone());
		user.setCreateDate(now);
		user.setUpdateDate(now);
		userRepository.save(user);
	}
	
	}
	

}
