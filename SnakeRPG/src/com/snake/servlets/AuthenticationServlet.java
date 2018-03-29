package com.snake.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public static final String METHODAUTH = "auth";
	//Inscription
	public static final String PSEUDOINS = "r-form-first-name";
	public static final String MDP = "l-form-password";
	public static final String MDP_CONF = "l-form-confpassword";
	public static final String COULEUR = "radio";
	//Connexion
	public static final String PSEUDOCO = "l-form-username";
	public static final String MDPCO = "l-form-passwordco";
	
	public AuthenticationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
			boolean samemdp = true;
			if (!mdpIns.equals(mdp_conf)) {
				samemdp = false;
				request.setAttribute("samedp", samemdp);
				System.out.println("Erreur ! mots de passe non identiques");
				this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
			}else {
				request.setAttribute("samedp", samemdp);
				System.out.println("Inscription : ");
				System.out.println(pseudoIns);
				System.out.println(mdpIns);
				System.out.println(couleur);
			}
		}else if(methodAuth.equals("connecter")){
			String pseudoco = request.getParameter(PSEUDOCO);
			String mdpco = request.getParameter(MDPCO);
			System.out.println("Connexion : ");
			System.out.println(pseudoco);
			System.out.println(mdpco);
			request.setAttribute("nom", pseudoco);
			request.setAttribute("mdp", mdpco);
			this.getServletContext().getRequestDispatcher("/WEB-INF/MainPage.jsp").forward( request, response );
		}else {
			System.out.println("Erreur");
			//Renvoyer vers une page d'erreur ou vers la page d'auth
		}
	}
}
