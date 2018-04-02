package com.snake.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.snake.beans.Snake;

public class SnakeDAOImpl implements SnakeDAO {

	private DAOFactory daoFactory;

	SnakeDAOImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Snake snake) {
		// TODO Auto-generated method stub
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
			resultat = statement.executeQuery("SELECT pseudo, password FROM snake;");

			while (resultat.next()) {
				String pseudo = resultat.getString("pseudo");
				String password = resultat.getString("password");
				Snake snake = new Snake();
				snake.setPseudo(pseudo);
				snake.setPassword(password);

				snakes.add(snake);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return snakes;
	}

}
