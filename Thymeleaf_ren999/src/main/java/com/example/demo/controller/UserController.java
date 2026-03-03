package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.User;
import com.example.demo.service.UserServise.UserService;

public class UserController {
	/*
	 * ユーザー情報　controller
	 * */
	@Controller
	public class Usercontroller{
		
	}

	/*
	 * ユーザー情報　service
	 * */
	@Autowired
	UserService userservice;
	
	/*
	 * ユーザー情報一覧画面の表示
	 * @param modelNodel
	 * return ユーザー情報一覧画面のHTML
	 * */
	@RequestMapping(value = "/user/list",method = RequestMethod.GET)public String displayList(Model model) {
		List<User> userlist = userservice.searchAll();
		model.addAttribute("userlist",userlist);
		return "user/list";
	}
	
	
}
