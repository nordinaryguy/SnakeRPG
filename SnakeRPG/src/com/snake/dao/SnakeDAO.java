package com.snake.dao;

import java.util.List;

import com.snake.beans.Snake;

public interface SnakeDAO {
	void ajouter(Snake snake);
	List<Snake> lister();
	Snake getSnake(String pPseudo);
	String getSnakePassword(String pPseudo);
	boolean SnakePseudoExists(String pPseudo);
}
