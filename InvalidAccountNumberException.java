package com.coursecube.jdbc;

public class InvalidAccountNumberException extends RuntimeException {

	public String toString() {
		return "Account no is Invalid";
	}
}
