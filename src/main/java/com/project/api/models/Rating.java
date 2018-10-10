package com.project.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rating")
public class Rating {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="star_rating")
	private float starRating;
	
	@Column(name="compliment")
	private String compliment;
	
	@ManyToOne
	private AppUser user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getStarRating() {
		return starRating;
	}

	public void setStarRating(float starRating) {
		this.starRating = starRating;
	}

	public String getCompliment() {
		return compliment;
	}

	public void setCompliment(String compliment) {
		this.compliment = compliment;
	}
	
	
	

}
