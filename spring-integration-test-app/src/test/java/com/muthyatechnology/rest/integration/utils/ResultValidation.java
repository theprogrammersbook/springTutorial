package com.muthyatechnology.rest.integration.utils;

import static org.junit.Assert.assertArrayEquals;

import org.json.simple.JSONObject;

public class ResultValidation {
	public static JSONObject getJSONObject(String errorMessage) {
		JSONObject object = new JSONObject();
		String[] response = errorMessage.split("@");
		if (response != null) {
			if (response[0] != null) {
				object.put("Code", response[0]);
			}
			if (response[1] != null) {
				object.put("Message", response[1]);
			}
		}
		return object;
	}

	public static void checkErrorCodeResponse(String errorMessage, Object[] expected) {
		String[] response = errorMessage.split("@");
		assertArrayEquals(expected,response);
	}

}
