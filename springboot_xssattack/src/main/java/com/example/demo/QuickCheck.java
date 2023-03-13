package com.example.demo;

import java.util.regex.Pattern;

public class QuickCheck {

	static void main(String[] args) {
		System.out.println(Pattern.matches("^[a-zA-Z]*$", "<script"));
	}
}
