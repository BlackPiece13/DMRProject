package com.dmr.dao;

import com.dmr.model.Media;

public class MediaDAO extends GenericDAO<Media> {

	public MediaDAO() {
		typeParameterClass = Media.class;
	}

}
