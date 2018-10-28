package com.dmr.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dmr.dao.MediaDAO;
import com.dmr.model.Book;
import com.dmr.model.Cover;

public class ManageMediaController extends HttpServlet {
	private static final long serialVersionUID = 1078533949591233871L;
	// private String filePath;

	public void init() {
		// for solution bis (photos)
		// filePath = getServletContext().getInitParameter("file-upload");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/** Gestion d'ajout des livres et cd */
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String resume = req.getParameter("resume");
		Part part = req.getPart("cover");

		if (title != null && author != null && resume != null && part.getSize() > 0) {
			Book book = new Book();
			book.setAuthor(author);
			book.setResume(resume);
			book.setTitle(title);

			InputStream inputStream = part.getInputStream();
			book.setCover(new Cover());
			book.getCover().setImage(inputStream.readAllBytes());

			/*
			 * solution bis part.write(filePath + File.separator +
			 * part.getSubmittedFileName()); File file = new File(
			 * "C:\\Users\\dmr\\eclipse-workspace\\ServletJAVA\\ServletJAVA\\src\\main\\webapp\\static\\"
			 * + part.getSubmittedFileName()); byte[] picInBytes = new byte[(int)
			 * file.length()]; FileInputStream fileInputStream = new FileInputStream(file);
			 * fileInputStream.read(picInBytes); fileInputStream.close(); book.setCover(new
			 * Cover()); book.getCover().setImage(picInBytes); fin
			 */

			MediaDAO mediaDAO = new MediaDAO();
			mediaDAO.intialiazeSession();
			mediaDAO.save(book);
			mediaDAO.closeSession();
		}
		resp.sendRedirect(".");
	}

}
