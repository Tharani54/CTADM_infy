package com.example.movieRating.Controller;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movieRating.dao.RatingDao;
import com.example.movieRating.model.Rating;
import com.example.movieRating.model.movies;

@RestController
public class RatingController {

	@Autowired
	RatingDao rate;

	/*
	 * // jsp page
	 * 	 * @RequestMapping(value = "/api") public String display() { return "rest.jsp";}
	 */

	/*
	 * jsp page
	 * 
	 * @RequestMapping(value = "/addrating") public String addrating(ModelMap
	 * m,Rating rating) {
	 * 
	 * 
	 * rate.save(rating);
	 * 
	 * //List<String> movielist = rate.findByMovie();
	 * //System.out.println(movielist);
	 * 
	 * float avgRating = rate.findBycustomerRating("Movie 1");
	 * System.out.println(avgRating);
	 * 
	 * m.put("avgRating", avgRating); m.put("rating",rating );
	 * 
	 * return "showresult.jsp"; }
	 */

	@PostMapping("/api/rest/customer/{Customerid}/rate")
	public Rating addRating(Rating rating) {
		rate.save(rating);

		return rating;

	}

	@GetMapping(path = "/Ratings")
	public List<Rating> getrating() {
		return rate.findAll();
	}

	/*
	 * @GetMapping(path = "/HighestRatings/{Movie}") public float
	 * HighestRatings(@PathVariable String Movie) { float avgRating =
	 * rate.findBycustomerRating(Movie);
	 * 
	 * 
	 * return avgRating; }
	 */

	// To get the highest rate movie
	@GetMapping(path = "api/rest/HighestRatedMovie")
	public String HighestRatings() {
		List<movies> avgRating = rate.findBycustomerRating();
		movies m = avgRating.stream().max(Comparator.comparing(movies::getAvgRating)).get();
		return "Highest Rated movie " + m.getMovielist() + " (on Average) " + m.getAvgRating();
	}

	// to display the rating details of particular customer
	@RequestMapping(path = "api/rest/customer/{Customerid}")
	public List<Rating> getrating(@PathVariable("Customerid") int Customerid) {
		return rate.findByCustomerid(Customerid);
	}

	@GetMapping(path = "api/rest/HighestedRatedCustomer")
	public String getratings() {
		List<Rating> r = rate.SelectAll();

		Double OverallAvgRating = r.stream().mapToDouble(i -> i.getCustomerRating()).average().getAsDouble();

		int highRatedCustomerId = r.stream().map(i -> i.getCustomerid())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
		
		Double CustomerAvgRating = r.stream().filter(i -> i.getCustomerid() == highRatedCustomerId)
				.mapToDouble(i -> i.getCustomerRating()).average().getAsDouble();

		Rating HighRatedCustomer=  r.stream().filter(i -> i.getCustomerid() == highRatedCustomerId).findFirst().orElse(null);
		
		return "{id:" + HighRatedCustomer.getCustomerid()+ ", firstName:" + HighRatedCustomer.getCustomerfirstname() + ", lastName:" + HighRatedCustomer.getCustomersecondname()
				+ ", CustomerAverageRating=" + CustomerAvgRating + ", averageRating=" + OverallAvgRating + "} ";
	}

}
