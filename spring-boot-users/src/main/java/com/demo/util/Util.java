package com.demo.util;

import java.util.Arrays;
import java.util.List;

public class Util {

	public static String getCountryLabel(String countryIndex) {
		List<String> countries = Arrays.asList(Constantes.COUNTRIES);
		return countries.get(Integer.parseInt(countryIndex));
	}

	public static String getGenderLabel(String gender) {
		if(gender == null || gender.equals(""))
			return "";
		List<String> genderList = Arrays.asList(Constantes.SEX);
		return gender.equals("M")?genderList.get(0):genderList.get(1);
	}

	public static String getCommunities(String[] communitiesArray) {
		List<String> communitiesList = Arrays.asList(communitiesArray);
		String c = "";
		for (String community : communitiesList) {
			c = c + (c.length()>0?",":"") + community;
		}
		return c;
	}
	
	

}
