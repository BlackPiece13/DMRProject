package com.dmr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchPerson extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3649337180201976623L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String resultat = "valide";
		// String nom = request.getParameter("nom");
		/*
		 * PersonneDaoImpl daoImpl = new PersonneDaoImpl(); boolean result =
		 * daoImpl.findByNom(nom); response.setContentType("text/xml"); if (result) {
		 * resultat = "invalide"; }
		 */
		System.out.println("search controller hello" + req.getParameter("input-value"));
		resp.setContentType("text/xml");
		resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		resp.getWriter().write("<message>" + "hello tout le monde" + "</ message>");
	}

}
