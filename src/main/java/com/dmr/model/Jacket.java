package com.dmr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Jacket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long jacket_id;

	private String colour;
	@OneToOne(mappedBy = "jacket")
	private CD cd;

	public Jacket() {
		super();
	}

	public Jacket(String colour, CD cd) {
		super();
		this.colour = colour;
		this.cd = cd;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public CD getCd() {
		return cd;
	}

	public void setCd(CD cd) {
		this.cd = cd;
	}

	public Long getJacket_id() {
		return jacket_id;
	}

	public void setJacket_id(Long jacket_id) {
		this.jacket_id = jacket_id;
	}

}
