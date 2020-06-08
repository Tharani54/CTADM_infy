package com.example.movieRating.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.movieRating.model.Rating;
import com.example.movieRating.model.movies;


public interface RatingDao extends JpaRepository <Rating, Integer> {
	@Query(" FROM Rating where Customerid=:Customerid")
	List<Rating> findByCustomerid(@Param("Customerid") int Customerid);
	
	
	@Query("SELECT" +
			 " new com.example.movieRating.model.movies(AVG(customerRating) as avgrate,Movie) "
			  + "FROM" + " Rating" + " GROUP BY" + " Movie")
	//@Query("Select Max(AvgRating) from (SELECT AVG(customerRating),Movie FROM Rating GROUP BY Movie  as AvgRating)")
	List<movies> findBycustomerRating();
	
	
	@Query("from Rating")
	List<Rating> SelectAll();
	
	
}

