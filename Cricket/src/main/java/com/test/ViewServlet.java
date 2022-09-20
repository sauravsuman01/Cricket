package com.test;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='PlayerRegister.html'>Add New Player</a>");  
        out.println("<h1>Cricketers  List</h1>");  
          
        List<Player> list=PlayerDao.getAllPlayers();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Matches</th><th>Score</th><th>Wickets</th><th>Ducks</th><th>Players</th><th>Average</th><th>Edit</th><th>Delete</th></tr>");  
        for(Player e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getMatches()+"</td><td>"+e.getSocre()+"</td><td>"+e.getWickets()+"</td><td>"+e.getDucks()+"</td><td>"+e.getPlayers()+"</td><td>"+e.getAverage()+"</td><td>"+"<a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  