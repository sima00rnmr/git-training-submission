package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import lombok.Data;


/*
 * ユーザー情報　Entity
 * */
 
@Entity
@Data
@Table(name ="user")
public class User{
	/*
	 * ID
	 * 
	 * */
	@ID
	@Colum(name = "id")
	@GeneratedValue(strategy = GenerationeType.IDENITY)
	private Long id;
	
	/*
	 * 名前
	 * 
	 * */
	@Colum(name ="name")
	private String name;
	
	/*
	 * 住所
	 * */
	@Colum(name ="address")
	private String address;
	
	
	/*
	 * 電話番号
	 * */
	@Colum(name = "phone")
	private String phone;
	
	/*
	 * 更新日時
	 * */
	@Colum(name = "update_date")
	private Date updateDate;
	
	
	/*
	 * 登録日時
	 * */
	@Colum(name = "create_date")
	private Date criateDate;
	
	/*
	 * 削除日時
	 * */
	@Colum(name = "delete_date")
	private Date deleteDate;
	
	
	
}