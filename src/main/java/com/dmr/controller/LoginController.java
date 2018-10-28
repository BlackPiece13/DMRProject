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
		req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password = req.getParameter("password");
		String login = req.getParameter("login");
		String role = req.getParameter("role");

		System.out.println("valeurs formulaire " + password + " " + login + " " + role);

		if (!password.isEmpty() && !login.isEmpty() && !role.isEmpty()) {

			if (isFound(login, password, role)) {
				HttpSession session = req.getSession(true);
				session.setAttribute("login", login);
				session.setAttribute("password", password);
				session.setAttribute("role", role);
				resp.sendRedirect(".");
			} else {
				System.out.println("renvoi vers inscription");
				req.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(req, resp);
			}
		} else {
			System.out.println("champs formulaire login vide");
			req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
		}
	}

	private boolean isFound(String login, String password, String role) {
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
				} else {
					if (!role.equals(user.getRole())) {
						found = false;
					}
				}
			}
			if (found) {
				userDAO.closeSession();
				System.out.println("Utilisateur trouve");
				userDAO.closeSession();
				return found;
			}
		}
		System.out.println("Utilisateur non trouve");
		userDAO.closeSession();
		return found;
	}
}
