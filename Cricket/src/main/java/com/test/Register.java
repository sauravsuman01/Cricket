package com.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int matches = Integer.parseInt(request.getParameter("matches"));
		int score = Integer.parseInt(request.getParameter("score"));
		int wickets = Integer.parseInt(request.getParameter("wickets"));
		int ducks = Integer.parseInt(request.getParameter("ducks"));
		String players = request.getParameter("players");
		
		Player player1 = new Player();
		player1.setId(id);
		player1.setName(name);
		player1.setMatches(matches);
		player1.setSocre(score);
		player1.setWickets(wickets);
		player1.setDucks(ducks);
		player1.setPlayers(players);
		player1.setAverage(score, matches);
		
		PlayerDao playerdao = new PlayerDao();
		playerdao.save(player1);
		response.sendRedirect("ViewServlet");
		}

}
