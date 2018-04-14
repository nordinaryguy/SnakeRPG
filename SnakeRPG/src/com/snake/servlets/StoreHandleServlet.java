package com.snake.servlets;

import java.io.IOException;
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

/**
 * Servlet implementation class StoreHandleServlet
 */
@WebServlet("/store")
public class StoreHandleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ARTICLENAME = "articleName";
	private static final String INVIS_ART = "invisibilite";
	private static final String INVINC_ART = "invincibilite";
	private static final String XP100 = "xp100";
	private static final String LEVELUP ="levelup";

	//Objet SnakeDAO
	private SnakeDAO snakeDAO;

	//String msg erreur
	private String erreur = null;

	public void init() throws ServletException{
		DAOFactory daoFactory = DAOFactory.getInstance();
		this.snakeDAO = daoFactory.getSnakeDAO();
	}
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StoreHandleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
			Object s = session.getAttribute("snake");
			Snake snake = (Snake) s;
			if (snake.getPseudo().equals(null)) {

			}else {
				String article_name = request.getParameter(ARTICLENAME);
				switch (article_name) {
				case INVINC_ART:
					if ((snakeDAO.getSnake(snake.getPseudo())).getArgent() >= 30) {
						Bonus bonus = new Bonus(0, "invincibilite", "Snake devient invincible durant 10s", "invincLogo.png", 30, (snakeDAO.getSnake(snake.getPseudo())).getiD());
						snakeDAO.debit((snakeDAO.getSnake(snake.getPseudo())).getPseudo(),((snakeDAO.getSnake(snake.getPseudo())).getArgent()-30));
						snakeDAO.addBonus(bonus);
						snake = snakeDAO.getSnake(snake.getPseudo());
						session.setAttribute("snake", snake);
						session.setAttribute("snakes", snakeDAO.lister());
					}else {
						System.out.println("Pas assez d'argent !");
					}
					break;

				case INVIS_ART:
					if ((snakeDAO.getSnake(snake.getPseudo())).getArgent() >= 30) {
						Bonus bonus = new Bonus(0, "invisibilite", "Snake devient invisible durant 10s", "invisLogo.png", 20, (snakeDAO.getSnake(snake.getPseudo())).getiD());
						snakeDAO.debit((snakeDAO.getSnake(snake.getPseudo())).getPseudo(),((snakeDAO.getSnake(snake.getPseudo())).getArgent()-30));
						snakeDAO.addBonus(bonus);
						snake = snakeDAO.getSnake(snake.getPseudo());
						session.setAttribute("snake", snake);
						session.setAttribute("snakes", snakeDAO.lister());
					}else {
						System.out.println("Pas assez d'argent !");
					}
					break;

				case XP100:
					if ((snakeDAO.getSnake(snake.getPseudo())).getArgent() >= 10) {
						snakeDAO.debit((snakeDAO.getSnake(snake.getPseudo())).getPseudo(),((snakeDAO.getSnake(snake.getPseudo())).getArgent()-10));
						snakeDAO.addXP((snakeDAO.getSnake(snake.getPseudo())).getPseudo(),((snakeDAO.getSnake(snake.getPseudo())).getxP())+100);
						snake = snakeDAO.getSnake(snake.getPseudo());
						session.setAttribute("snake", snake);
						session.setAttribute("snakes", snakeDAO.lister());
					}else {
						System.out.println("Pas assez d'argent !");
					}
					break;

				case LEVELUP:
					if ((snakeDAO.getSnake(snake.getPseudo())).getArgent() >= 50) {
						snakeDAO.debit((snakeDAO.getSnake(snake.getPseudo())).getPseudo(),((snakeDAO.getSnake(snake.getPseudo())).getArgent()-50));
						snakeDAO.incrementLevel((snakeDAO.getSnake(snake.getPseudo())).getPseudo(),((snakeDAO.getSnake(snake.getPseudo())).getLevel())+1);
						snake = snakeDAO.getSnake(snake.getPseudo());
						session.setAttribute("snake", snake);
						session.setAttribute("snakes", snakeDAO.lister());
					}else {
						System.out.println("Pas assez d'argent !");
					}
					break;
				default:
					break;
				}
				response.sendRedirect(request.getContextPath()+"/snakerpg#store");			}
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
