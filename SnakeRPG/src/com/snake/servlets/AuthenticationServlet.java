package com.snake.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.snake.beans.Bonus;
import com.snake.beans.Snake;
import com.snake.dao.DAOFactory;
import com.snake.dao.SnakeDAO;
import com.snake.forms.ConnexionForm;
import com.snake.forms.InscriptionForm;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/snakerpg_auth")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public static final String VUE = "/WEB-INF/Authentication.jsp";
	public static final String VUE2 = "/WEB-INF/MainPage.jsp";
	public static final String METHODAUTH = "auth";

	//Objet SnakeDAO
	private SnakeDAO snakeDAO;

	//String msg erreur
	private String erreur = null;

	public void init() throws ServletException{
		DAOFactory daoFactory = DAOFactory.getInstance();
		this.snakeDAO = daoFactory.getSnakeDAO();
	}

	public AuthenticationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String methodAuth = request.getParameter(METHODAUTH);
		System.out.println(methodAuth);
		if (methodAuth.equals("enregistrer")) { //Enregistrement
			/* Préparation de l'objet formulaire */
			InscriptionForm insform = new InscriptionForm();

			/* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
			Snake snake = insform.inscrireSnake( request,snakeDAO );
			erreur = insform.getErreur();
			if(erreur.equals("no")) {
				HttpSession session = request.getSession();
				session.setAttribute("snake", snake);
				session.setAttribute("snakes", snakeDAO.lister());
				response.sendRedirect(request.getContextPath()+"/snakerpg");
			}else {
				request.setAttribute("erreur", erreur);
				this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
			}
		}else if(methodAuth.equals("connecter")){ //Connexion
			ConnexionForm coform = new ConnexionForm();

			Snake snake = coform.connecterSnake(request, snakeDAO);
			erreur = coform.getErreur();
			if (erreur.equals("no")) {
				HttpSession session = request.getSession();
				session.setAttribute("snake", snake);
				session.setAttribute("snakes", snakeDAO.lister());
				response.sendRedirect(request.getContextPath()+"/snakerpg");
			}else {
				request.setAttribute("erreur", erreur);
				this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/snakerpg_auth");
		}
	}
}
