package com.example.movieRating.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rating  {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int SerialNo;
		private int customerid;
		private String customerfirstname;
		private String customersecondname;
		private float customerRating;
		private String Movie;
		
		public int getSerialNo() {
			return SerialNo;
		}
		public void setSerialNo(int serialNo) {
			SerialNo = serialNo;
		}
		
		public int getCustomerid() {
			return customerid;
		}
		public void setCustomerid(int customerid) {
			this.customerid = customerid;
		}

		public String getCustomerfirstname() {
			return customerfirstname;
		}
		public void setCustomerfirstname(String customerfirstname) {
			this.customerfirstname = customerfirstname;
		}
		
		public String getCustomersecondname() {
			return customersecondname;
		}
		public void setCustomersecondname(String customersecondname) {
			this.customersecondname = customersecondname;
		}
		
		public float getCustomerRating() {
			return customerRating;
		}
		public void setCustomerRating(float customerRating) {
			this.customerRating = customerRating;
		} 
		 public String getMovie() { 
			 return Movie;
		} 
		 public void setMovie(String movie) {
			 this.Movie = movie; }
		

		
		
}
