package com.saucedemo.utilities;

public class StringUtility {

	public static String deleteAChar(String price) {

		StringBuilder builder = new StringBuilder(price);
		String priceonly = builder.deleteCharAt(0).toString();
		return priceonly;
	}

}