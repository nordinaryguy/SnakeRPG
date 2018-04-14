package com.snake.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.snake.beans.Bonus;
import com.snake.beans.Snake;

public class SnakeDAOImpl implements SnakeDAO {

	private DAOFactory daoFactory;

	SnakeDAOImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Snake snake) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO snake(level, nbEnnemisTues, nbMorts, partiesGagnees, partiesPerdues, bonusPris, pseudo, password, couleur, image, xp, score, argent) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			preparedStatement.setInt(1, snake.getLevel());
			preparedStatement.setInt(2, snake.getNbEnnemisTues());
			preparedStatement.setInt(3, snake.getNbMorts());
			preparedStatement.setInt(4, snake.getPartiesGagnees());
			preparedStatement.setInt(5, snake.getPartiesPerdues());
			preparedStatement.setInt(6, snake.getBonusPris());

			preparedStatement.setString(7, snake.getPseudo());
			preparedStatement.setString(8, snake.getPassword());
			preparedStatement.setString(9, snake.getCouleur());
			preparedStatement.setString(10, snake.getImage());

			preparedStatement.setDouble(11, snake.getxP());
			preparedStatement.setDouble(12, snake.getScore());
			preparedStatement.setDouble(13, snake.getArgent());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Snake> lister() {

		List<Snake> snakes = new ArrayList<Snake>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT pseudo, level FROM snake ORDER BY id DESC LIMIT 5;");

			while (resultat.next()) {
				String pseudo = resultat.getString("pseudo");
				int level = resultat.getInt("level");
				Snake snake = new Snake();
				snake.setPseudo(pseudo);
				snake.setLevel(level);
				snakes.add(snake);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return snakes;
	}

	public boolean SnakePseudoExists(String pPseudo) {
		boolean pseudoExists = false;
		String pseudo = null;
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			String pseudoForQuery = "\""+pPseudo+"\"";
			resultat = statement.executeQuery("SELECT pseudo FROM snake WHERE pseudo="+pseudoForQuery+";");

			while (resultat.next()) {
				pseudo = resultat.getString("pseudo");
				if (!pseudo.equals(null)) {
					pseudoExists = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pseudoExists;
	}

	public String getSnakePassword(String pPseudo) {
		String password = null;
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			String pseudoForQuery = "\""+pPseudo+"\"";
			resultat = statement.executeQuery("SELECT password FROM snake WHERE pseudo="+pseudoForQuery+";");

			while (resultat.next()) {
				password = resultat.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return password;
	}

	public Snake getSnake(String pPseudo) {

		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		Snake snake = new Snake();
		ArrayList<Bonus> bonusArray = new ArrayList<>();
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			String pseudoForQuery = "\""+pPseudo+"\"";
			resultat = statement.executeQuery("SELECT * FROM snake WHERE pseudo="+pseudoForQuery+";");

			while (resultat.next()) {
				int id = resultat.getInt("id");
				bonusArray = getSnakeBonus(id);
				String pseudo = resultat.getString("pseudo");
				int level = resultat.getInt("level");
				int nbEnnemisTues = resultat.getInt("nbEnnemisTues");
				int nbMorts = resultat.getInt("nbMorts");
				int partiesGagnees = resultat.getInt("partiesGagnees");
				int partiesPerdues = resultat.getInt("partiesPerdues");
				//int bonusPris = resultat.getInt("bonusPris");
				int bonusPris = bonusArray.size();
				String couleur = resultat.getString("couleur");
				String image = resultat.getString("image");

				double xP = resultat.getDouble("xP");
				double score = resultat.getDouble("score");;
				double argent = resultat.getDouble("argent");;

				snake.setiD(id);
				snake.setPseudo(pseudo);
				snake.setLevel(level);
				snake.setNbEnnemisTues(nbEnnemisTues);
				snake.setNbMorts(nbMorts);
				snake.setPartiesGagnees(partiesGagnees);
				snake.setPartiesPerdues(partiesPerdues);
				snake.setBonusPris(bonusPris);
				snake.setCouleur(couleur);
				snake.setImage(image);
				snake.setxP(xP);
				snake.setScore(score);
				snake.setArgent(argent);
				snake.setBonusPossedes(bonusArray);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return snake;
	}

	public ArrayList<Bonus> getSnakeBonus(int idSnake) {
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		ArrayList<Bonus> bonusArray = new ArrayList<Bonus>();
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT b.*, s.pseudo\r\n" + 
					"FROM snake s\r\n" + 
					"INNER JOIN bonus b\r\n" + 
					"ON s.id = b.idsnakeassocie\r\n" + 
					"WHERE s.id="+idSnake);

			while (resultat.next()) {
				int id = resultat.getInt("id");
				String nom = resultat.getString("nom");
				String effet = resultat.getString("effet");
				String image = resultat.getString("image");
				int prix = resultat.getInt("prix");
				int idsnakeassocie = resultat.getInt("idsnakeassocie");

				Bonus b = new Bonus(id, nom, effet, image, prix,idsnakeassocie);
				bonusArray.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//		for (Bonus bonus : bonusArray) {
		//			System.out.println(bonus.getNom());
		//		}
		return bonusArray;
	}
}
