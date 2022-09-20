package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeamSelectionServlet")
public class TeamSelectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		

		List<Player> playerList = PlayerDao.getAllPlayers().stream().sorted(new PlayerAverageScoreComparator())
				.collect(Collectors.toList());
		
		
		List<Player> selectedTeam = new ArrayList<>();
		int numberOfPlayers = 0;
		int numberOfBowlers = 0;
		int numberOfWicketkeeper = 0;
		int selectedPlayers = 0;

		Iterator<Player> iterator = playerList.listIterator();
		while (iterator.hasNext()) {
			Player player = iterator.next();
			 System.out.println(player.getId() + "\t" + player.getName() + "\t" + player.getMatches() + "\t" + player.getSocre() + "\t" + player.getWickets() +"\t" + player.getDucks() + "\t" + player.getPlayers() +"\t" + player.getAverage());
			numberOfPlayers++;
			if (player.getPlayers().equals("Bowler"))
				numberOfBowlers++;

			if (player.getPlayers().equals("WK"))
				numberOfWicketkeeper++;
		}
		
		playerList = playerList.stream().sorted(new PlayerAverageScoreComparator()).collect(Collectors.toList());

		if (numberOfBowlers >= 3 && numberOfWicketkeeper >= 1 && numberOfPlayers>=12) {
			
			numberOfBowlers =0;
			numberOfWicketkeeper=0;
			
			iterator = playerList.listIterator();
			while (iterator.hasNext() && selectedPlayers <11) {
				Player player = iterator.next();
				if (selectedPlayers < 7) {
					if (player.getPlayers().equals("Wicket-Keeper"))
						numberOfWicketkeeper++;
					if (player.getPlayers().equals("Bowler"))
						numberOfBowlers++;
					selectedTeam.add(player);
					selectedPlayers++;
				} else {
					if (numberOfBowlers >= 3 && numberOfWicketkeeper >= 1) {
						selectedTeam.add(player);
						selectedPlayers++;
					} else if (numberOfWicketkeeper == 0 && player.getPlayers().equals("WK")) {
						numberOfWicketkeeper++;
						selectedPlayers++;
						selectedTeam.add(player);
					} else if (numberOfBowlers < 3 && player.getPlayers().equals("Bowler")) {
						numberOfBowlers++;
						selectedPlayers++;
						selectedTeam.add(player);
					} else if (numberOfBowlers < 3 && numberOfWicketkeeper == 0
							&& (player.getPlayers().equals("WK")
									|| player.getPlayers().equals("Bowler"))) {
						selectedPlayers++;
						selectedTeam.add(player);
						if (player.getPlayers().equals("WK"))
							numberOfWicketkeeper++;
						if (player.getPlayers().equals("Bowler"))
							numberOfBowlers++;
					}
				}
			}

			out.println("<h1>Selected Team</h1>");
			out.print("<table border='1' width='100%'");
			out.print(
					"<tr><th>Id</th><th>Name</th><th>Matches</th><th>Score</th><th>Wickets</th><th>Ducks</th><th>Player Type</th><th>Average Score</th></tr>");
			for (Player player : selectedTeam) {
				out.print("<tr><td>" + player.getId() + "</td><td>" + player.getName() + "</td><td>"
						+ player.getMatches() + "</td><td>" + player.getSocre() + "</td><td>" + player.getWickets()
						+ "</td><td>" + player.getDucks() + "</td><td>" + player.getPlayers()
						+ "</td><td>" + player.getAverage()
						+ "</td></tr>");
			}
			out.print("</table>");
		}
		else if(numberOfPlayers<12) {
			out.print("<h2>Please add more players atleast 20 players are required to make the team.</h2>");
		}
		else if(numberOfBowlers<3) {
			out.print("<h2>Please add more players as number of bowlers has to be atleast 3</h2>");
		}
		else if(numberOfWicketkeeper<1) {
			out.print("<h2>Please add more players as number of wicketkeepers has to be atleast 1</h2>");
		}

		out.println("<a href='Home.html'>Dashboard</a>");
		
		out.close();
	}
}