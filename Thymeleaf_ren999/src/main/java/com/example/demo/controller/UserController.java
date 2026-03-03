package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

public class UserController {
	/*
	 * ユーザー情報　controller
	 * */

	/*
	 * ユーザー情報　service
	 * */
	@Autowired
	private UserService userService;

	/*
	 * ユーザー情報一覧画面の表示
	 * @param modelNodel
	 * return ユーザー情報一覧画面のHTML
	 * 
	 * displayList
	 * HTTP GETで「http://localhost:8080/user/list」に
	 * アクセスしたときに動き出すメソッド。
	 * 「ユーザー情報一覧」画面の初期表示をおこなう。
	 * */
	@GetMapping(value = "/user/list")
	public String displayList(Model model) {
		List<User> userlist = userService.searchAll();
		model.addAttribute("userlist", userlist);
		return "user/list";
	}

	/*
	 * ユーザー新規登録画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 * 
	 * displayAdd
	 * 「ユーザー情報一覧」画面の
	 * 「新規登録はこちら」ボタン押下時に
	 * 動き出すメソッド。
	 * 「ユーザー新規登録」画面の初期表示をおこなう。
	 * 
	 * */
	@GetMapping(value = "/user/add")
	public String displayAdd(Model model) {
		model.addAttribute("userRequest", new UserRequest());
		return "user/add";
	}

	/*
	 * ユーザー新規登録
	 * @param userRequest リクエストデータ
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 * 
	 * 
	 * 
	 * */
	@RequestMapping(value = "user/create", method = RequestMethod.POST)
	public String sreate(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			//入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);

			return "user/add";
		}
		//ユーザー情報の登録

		/*create
		 * 「ユーザー新規登録」画面の「登録」ボタン押下時に動き出すメソッド
		 * ユーザー情報の登録処理をおこなう。
		 * 
		 * */
		userService.create(userRequest);
		return "redirect:/user/list";
	}

	/*
	 * ユーザー情報詳細画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 * 
	 * 
	 * 
	 * displayView
	 * 「ユーザー情報一覧」画面の「詳細」ボタン押下時に動き出すメソッド。
	 * 「ユーザー情報詳細画面ダミー」画面の初期表示をおこなう。
	 * */
	@GetMapping("user/{id}")
	public String displayView(@PathVariable Long id, Model model) {
		return "user/view";
	}

}
