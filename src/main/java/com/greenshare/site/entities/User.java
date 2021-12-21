package com.greenshare.site.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class User {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String email;
		private String password;
		private String authorization;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getAuthorization() {
			return authorization;
		}
		public void setAuthorization(String authorization) {
			this.authorization = authorization;
		}
}
