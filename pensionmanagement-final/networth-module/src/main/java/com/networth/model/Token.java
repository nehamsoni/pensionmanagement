package com.networth.model;
public class Token{
		private String token;

		

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		@Override
		public String toString() {
			return String.format("Token [token=%s]", token);
		}
		
	}