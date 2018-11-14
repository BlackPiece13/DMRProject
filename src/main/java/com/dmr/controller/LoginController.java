package com.dmr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dmr.dao.UserDAO;
import com.dmr.model.User;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 5578375573095525806L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Controller get logincontroller");
		req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password = req.getParameter("password");
		String login = req.getParameter("login");

		if (!password.isEmpty() && !login.isEmpty()) {
			User user = isFound(login, password);
			if (user != null) {
				HttpSession session = req.getSession(true);
				session.setAttribute("user", user);
				resp.sendRedirect("./home");
			} else {
				System.out.println("erreur authentification");
				req.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(req, resp);
//				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
//				resp.setContentType("text/xml");
//				resp.getWriter().write("Utilisateur non trouve");
			}
		} else {
			System.out.println("champs formulaire login vide");
//			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
//			resp.setContentType("text/xml");
//			resp.getWriter().write("Champs formulaire vides");
			req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, resp);
		}
	}

	private User isFound(String login, String password) {
		UserDAO userDAO = new UserDAO();
		userDAO.intialiazeSession();
		List<User> users = userDAO.findAll();
		boolean found = false;
		for (User user : users) {
			found = true;
			if (!password.equals(user.getPwd())) {
				found = false;
			} else {
				if (!login.equals(user.getLogin())) {
					found = false;
				}
			}
			if (found) {
				userDAO.closeSession();
				System.out.println("Utilisateur trouve");
				userDAO.closeSession();
				return user;
			}
		}
		System.out.println("Utilisateur non trouve");
		userDAO.closeSession();
		return null;
	}
}
