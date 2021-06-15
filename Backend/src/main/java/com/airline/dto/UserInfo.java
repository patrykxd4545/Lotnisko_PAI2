package com.airline.dto;

import java.util.List;

import lombok.Value;

@Value
public class UserInfo {
	private String displayName, email, lName, fName;
	private Long userId, contactNo;
	private List<String> roles;

}
