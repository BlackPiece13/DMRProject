package com.dmr.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("CD")
public class CD extends Media {
	private String capacity;

	@OneToOne
	private Jacket jacket;

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

}
