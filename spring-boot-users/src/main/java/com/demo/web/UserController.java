package com.demo.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.domain.Country;
import com.demo.domain.User;
import com.demo.service.UserService;
import com.demo.util.Util;

@Controller
@RequestMapping("/users")
public class UserController { 
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("loadUsers")
	public String loadUsers(ModelMap model)  {
		List<User> users = userService.loadAll();
		for (User user : users) {
			user.setCountry(getCountryLabel(user.getCountry()));
			user.setGender(Util.getGenderLabel(user.getGender()));
		}
		model.put("users", users);
		return "userList";
	}

	@RequestMapping("add")
	public String add(HttpServletRequest request, ModelMap model){
		String id = request.getParameter("id");
		model.put("user", new User());
		return "userForm";
	}
	
	
	@RequestMapping("edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap model){
		model.put("user", userService.get(Integer.parseInt(id)));
		return "userForm";
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id, ModelMap model){
		userService.delete(id);
		return loadUsers(model);
	}
	
	@RequestMapping(value="save", method = RequestMethod.POST)
	protected ModelAndView save(@ModelAttribute User user)  {
		if (user.getCode() == null || user.getCode().equals("")) {
			userService.add(user);
		} else {
			userService.update(user);
		}
		user.setCountry(getCountryLabel(user.getCountry()));
		user.setGender(Util.getGenderLabel(user.getGender()));
		return new ModelAndView("userSuccess", "user", user);
	}
	

	@ModelAttribute("countries")
	public List<Country> getCountries(){
		ArrayList<Country> countries = new ArrayList<Country>();
		countries.add(new Country( 0, "Select"));
		countries.add(new Country( 2, "India"));
		countries.add(new Country( 3, "USA"));
		countries.add(new Country( 4, "UK"));
		return countries;
	}
	
	@ModelAttribute("module")
	public String getModule(){
		return "users";
	}
	
	private String getCountryLabel(String country) {
		List<Country> contries = getCountries();
		for (Country countryBean : contries) {
			if(country.equals(countryBean.getId().toString())) {
				return countryBean.getName();
			}
		}
		return "";
	}
	
}
