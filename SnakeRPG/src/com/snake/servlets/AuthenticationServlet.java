package com.snake.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.snake.beans.Snake;
import com.snake.dao.DAOFactory;
import com.snake.dao.SnakeDAO;
import com.snake.dao.SnakeDAOImpl;

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
	//Inscription
	public static final String PSEUDOINS = "r-form-first-name";
	public static final String MDP = "l-form-password";
	public static final String MDP_CONF = "l-form-confpassword";
	public static final String COULEUR = "radio";
	//Connexion
	public static final String PSEUDOCO = "l-form-username";
	public static final String MDPCO = "l-form-passwordco";
	
	//Objet SnakeDAO
	private SnakeDAO snakeDAO;
	
	private String erreur = null;

	public void init() throws ServletException{
		DAOFactory daoFactory = DAOFactory.getInstance();
        this.snakeDAO = daoFactory.getSnakeDAO();
	}
	
	public AuthenticationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();
		this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String methodAuth = request.getParameter(METHODAUTH);
		System.out.println(methodAuth);
		if (methodAuth.equals("enregistrer")) {
			String pseudoIns = request.getParameter(PSEUDOINS);
			String mdpIns = request.getParameter(MDP);
			String mdp_conf = request.getParameter(MDP_CONF);
			String couleur = request.getParameter(COULEUR);
			//String samemdp = null;
			try {
				validationNom(pseudoIns);
				validationMotsDePasse(mdpIns, mdp_conf);
				System.out.println("Inscription : ");
				System.out.println(pseudoIns);
				System.out.println(mdpIns);
				System.out.println(couleur);
				Snake snake = new Snake(pseudoIns,mdpIns,couleur);
				snakeDAO.ajouter(snake);
				HttpSession session = request.getSession();
				
				session.setAttribute("snake", snake);
				session.setAttribute("snakes", snakeDAO.lister());
				response.sendRedirect(request.getContextPath()+"/snakerpg");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				erreur = e1.getMessage();
				request.setAttribute("erreur", erreur);
				this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
			}
		}else if(methodAuth.equals("connecter")){
			String pseudoco = request.getParameter(PSEUDOCO);
			String mdpco = request.getParameter(MDPCO);
//			System.out.println("Connexion : ");
//			System.out.println(pseudoco);
//			System.out.println(mdpco);
			
			try {
				Snake snake = snakeDAO.getSnake(pseudoco);
				String passwordSnakeBDD = snakeDAO.getSnakePassword(snake.getPseudo());
				if (snake.getPseudo().equals(pseudoco) && snakeDAO.getSnakePassword(pseudoco).equals(mdpco)) {
					HttpSession session = request.getSession();
					session.setAttribute("snake", snake);
					session.setAttribute("snakes", snakeDAO.lister());
					response.sendRedirect(request.getContextPath()+"/snakerpg");
				}else {
					this.erreur= "Désolé ! Le pseudo et/ou le mot de passe est incorrect !";
					request.setAttribute("erreur", erreur);
					this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
				}
			} catch (Exception e) {
				// TODO: handle exception
				erreur = "Désolé ! Le pseudo et/ou le mot de passe est incorrect !";
				request.setAttribute("erreur", erreur);
				this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/snakerpg_auth");
		}
	}

	/**
	 * Valide les mots de passe saisis.
	 */
	private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception{
		if (motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0) {
			if (!motDePasse.equals(confirmation)) {
				throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
			} else if (motDePasse.trim().length() < 3) {
				throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
			}
		} else {
			throw new Exception("Merci de saisir et confirmer votre mot de passe.");
		}
	}

	/**
	 * Valide le nom d'utilisateur saisi.
	 */
	private void validationNom( String nom ) throws Exception {
		if ( nom != null && nom.trim().length() < 3 ) {
			throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
		}
	}
}
