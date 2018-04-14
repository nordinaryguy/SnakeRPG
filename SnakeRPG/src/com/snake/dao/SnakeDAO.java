package com.snake.dao;

import java.util.ArrayList;
import java.util.List;

import com.snake.beans.Bonus;
import com.snake.beans.Snake;

public interface SnakeDAO {
	void ajouter(Snake snake);
	List<Snake> lister();
	Snake getSnake(String pPseudo);
	String getSnakePassword(String pPseudo);
	boolean SnakePseudoExists(String pPseudo);
	ArrayList<Bonus> getSnakeBonus(int idSnake);
	void debit(String pseudo, double n);
	void incrementLevel(String pseudo, int n);
	void addXP(String pseudo, double n);
	void addBonus(Bonus bonus);
}
