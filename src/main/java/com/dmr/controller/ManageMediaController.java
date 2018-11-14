package com.dmr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String id = req.getParameter("button-id");
		System.out.println("remove media with id " + id);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/** Gestion d'ajout des livres et cd */
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String resume = req.getParameter("resume");
		String url = req.getParameter("url");
		// Part part = req.getPart("cover");
		if (title != null && author != null && resume != null && url != null) {
			Book book = new Book();
			book.setAuthor(author);
			book.setResume(resume);
			book.setTitle(title);
			book.setCover(new Cover());
			book.getCover().setUrl(url);
			/*
			 * InputStream inputStream = part.getInputStream(); book.setCover(new Cover());
			 * book.getCover().setImage(inputStream.readAllBytes());
			 */

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
			System.out.println("enregistrement media book");
		}
		resp.sendRedirect("./home");
	}

}
