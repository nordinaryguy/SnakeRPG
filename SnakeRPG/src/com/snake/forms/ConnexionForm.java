package com.snake.forms;

import javax.servlet.http.HttpServletRequest;

import com.snake.beans.Snake;
import com.snake.dao.SnakeDAO;

public final class ConnexionForm {

	//Connexion
	public static final String PSEUDOCO = "l-form-username";
	public static final String MDPCO = "l-form-passwordco";

	//Objet DAO du snake
	public SnakeDAO snakeDAO = null;

	//String pour stocker le message d'erreur s'il y en a 
	private String erreur = "no";

	public String getErreur() {
		return this.erreur;
	}
	
	public Snake connecterSnake(HttpServletRequest request, SnakeDAO snakeDAO) {
		String pseudoco = getValeurChamp(request, PSEUDOCO);
		String mdpco = getValeurChamp(request, MDPCO);
		Snake snake = null;
		this.snakeDAO = snakeDAO;
		
		try {
			validationPseudo(pseudoco);
			validationPassword(mdpco);
			validationCredentials(pseudoco,mdpco);
			snake = snakeDAO.getSnake(pseudoco);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			this.erreur = e.getMessage();
			return null;
		}
		
		return snake;
	}
	
	
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter( nomChamp );
		if ( valeur == null || valeur.trim().length() == 0 ) {
			return null;
		} else {
			return valeur.trim();
		}
	}
	
	/**
	 * Valide le pseudo d'utilisateur saisi.
	 */
	private void validationPseudo( String pseudo ) throws Exception {
		if ( pseudo != null && pseudo.trim().length() < 3 ) {
			throw new Exception( "Le pseudo doit contenir au moins 3 caractères." );
		}
		if (!snakeDAO.SnakePseudoExists(pseudo)) {
			throw new Exception( "Ce pseudo n'existe pas !" );
		}
	}
	
	
	/**
	 * Valide le mot de passe d'utilisateur saisi.
	 */
	private void validationPassword( String password ) throws Exception {
		if ( password != null && password.trim().length() < 3 ) {
			throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
		}
	}
	
	
	/**
	 * Valide le couple pseudo/mot de passe permettant la connexion
	 */
	private void validationCredentials(String pseudo, String password) throws Exception {
		if (!snakeDAO.getSnakePassword(pseudo).equals(password)) {
			throw new Exception( "Le mot de passe entré n'est pas bon." );
		}
	}
}
