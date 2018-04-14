package com.snake.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.snake.beans.Snake;
import com.snake.dao.DAOFactory;
import com.snake.dao.SnakeDAO;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/snakerpg")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			HttpSession session = request.getSession();
			Object s = session.getAttribute("snake");
			Snake snake = (Snake) s;
			if (snake.getPseudo().equals(null)) {

			}else {
				this.getServletContext().getRequestDispatcher( "/WEB-INF/MainPage.jsp" ).forward( request, response );
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.sendRedirect(request.getContextPath()+"/snakerpg_auth");
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
