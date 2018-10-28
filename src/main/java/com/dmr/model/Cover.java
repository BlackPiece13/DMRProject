package com.dmr.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class Cover {

	@Lob
	@Column(name = "cover_pic")
	private byte[] image;

	private String url;

	public Cover() {

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
