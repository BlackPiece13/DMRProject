package com.dmr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dmr.dao.BookDAO;
import com.dmr.model.Book;

public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 4542252189153119019L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("controller index get");
		BookDAO bookDAO = new BookDAO();
		bookDAO.intialiazeSession();
		List<Book> books = bookDAO.findAll();
		bookDAO.closeSession();
		req.setAttribute("books", books);
		req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("controller Index post");
		req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, resp);
	}

}
