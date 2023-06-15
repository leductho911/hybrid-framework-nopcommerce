package com.nopcommerce.testdata;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserDataMapper {

	public static UserDataMapper getUserData(String filename) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/resources/" + filename),
					UserDataMapper.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@JsonProperty("firstName")
	String firstName;

	@JsonProperty("lastName")
	String lastName;

	@JsonProperty("email")
	String email;

	@JsonProperty("address")
	String address;

	@JsonProperty("validPassword")
	String validPassword;

	@JsonProperty("date")
	String date;

	@JsonProperty("month")
	String month;

	@JsonProperty("year")
	String year;

	@JsonProperty("login")
	private Login login;

	static class Login {
		@JsonProperty("username")
		String username;

		@JsonProperty("password")
		String password;

	}

	public String getLoginUsername() {
		return login.username;
	}

	public String getLoginPassword() {
		return login.password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getValidPassword() {
		return validPassword;
	}

	public String getDate() {
		return date;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

}
