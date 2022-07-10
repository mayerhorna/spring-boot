package com.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="tb_user")
public class User {
	
	private Integer code;
	private String name;
	private String password;
	private String gender;
	private String country;
	private String aboutYou;
	private String[] community;
	private Boolean mailingList;
	
	public User() {
	}
	
	public User(Integer code){
		this.code = code;
	}
	
	@Id
	@Column(name = "code")
	@GeneratedValue(generator="seq_user")
	@SequenceGenerator(allocationSize = 1, name="seq_user", sequenceName = "seq_user" )
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "gender")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name = "country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Column(name = "aboutyou")
	public String getAboutYou() {
		return aboutYou;
	}
	public void setAboutYou(String aboutYou) {
		this.aboutYou = aboutYou;
	}
	
	@Column(name = "community")
	@Type(type = "com.demo.dao.hibernate.types.CommunityType")
	public String[] getCommunity() {
		return community;
	}
	public void setCommunity(String[] community) {
		this.community = community;
	}
	
	@Column(name = "mailinglist")
	public Boolean getMailingList() {
		return mailingList;
	}
	public void setMailingList(Boolean mailingList) {
		this.mailingList = mailingList;
	}
	
}
