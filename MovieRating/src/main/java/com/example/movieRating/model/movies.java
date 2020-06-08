package com.example.movieRating.model;


public class movies {
	private Double AvgRating;
	private String Movielist;
	public movies(Double avgRating, String movielist) {
		super();
		this.AvgRating = avgRating;
		this.Movielist = movielist;
	}
	
	public Double getAvgRating() {
		return AvgRating;
	}
	public void setAvgRating(Double avgRating) {
		AvgRating = avgRating;
	}
	public String getMovielist() {
		return Movielist;
	}
	public void setMovielist(String movielist) {
		Movielist = movielist;
	}
	
	
	

}
