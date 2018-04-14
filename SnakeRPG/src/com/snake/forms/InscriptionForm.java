package com.snake.forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.snake.beans.Snake;
import com.snake.dao.SnakeDAO;

public final class InscriptionForm {

	//Inscription
	public static final String PSEUDOINS = "r-form-first-name";
	public static final String MDP = "l-form-password";
	public static final String MDP_CONF = "l-form-confpassword";
	public static final String COULEUR = "radio";

	//Objet DAO du snake
	public SnakeDAO snakeDAO = null;
	
	//String pour stocker le message d'erreur s'il y en a 
	private String erreur = "no";

	public String getErreur() {
		return this.erreur;
	}

	public Snake inscrireSnake(HttpServletRequest request, SnakeDAO snakeDAO) {

		String pseudoIns = getValeurChamp(request, PSEUDOINS);
		String mdpIns = getValeurChamp(request, MDP);
		String mdp_conf = getValeurChamp(request, MDP_CONF);
		String couleur = getValeurChamp(request, COULEUR);
		Snake snake = null;
		this.snakeDAO = snakeDAO;
		try {
			validationNom(pseudoIns);
			validationMotsDePasse(mdpIns, mdp_conf);
			snake = new Snake(pseudoIns,mdpIns,couleur);
			snakeDAO.ajouter(snake);
		} catch (Exception e1) {
			e1.printStackTrace();
			this.erreur = e1.getMessage();
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
	 * Valide le pseudo d'utilisateur saisi.
	 */
	private void validationNom( String pseudo ) throws Exception {
		if ( pseudo != null && pseudo.trim().length() < 3 ) {
			throw new Exception( "Le pseudo doit contenir au moins 3 caractères." );
		}
		if (snakeDAO.SnakePseudoExists(pseudo)) {
			throw new Exception( "Ce pseudo existe déjà !" );
		}
	}
}
