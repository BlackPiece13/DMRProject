package com.dmr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dmr.dao.UserDAO;
import com.dmr.model.User;

public class ManageUserController extends HttpServlet {

	private static final long serialVersionUID = 7656383561429378330L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Get controller");
		req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/** Ajout utilisateur */
		UserDAO userDAO = new UserDAO();
		userDAO.intialiazeSession();

		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		String mail = req.getParameter("mail");

		if (!login.isEmpty() && !password.isEmpty() && !role.isEmpty()) {

			if (userDAO.findByMail(mail).isEmpty()) {
				User user = new User(login, password, role, mail);
				userDAO.save(user);
				userDAO.closeSession();
				HttpSession session = req.getSession(true);
				session.setAttribute("login", login);
				session.setAttribute("password", password);
				session.setAttribute("role", role);
				session.setAttribute("mail", mail);
				resp.sendRedirect(".");
			} else {
				req.setAttribute("error", "erreur : utilisateur deja existant");
				userDAO.closeSession();
				req.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("error", "erreur remplissage formulaire inscription");
			userDAO.closeSession();
			req.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(req, resp);
		}
	}

}