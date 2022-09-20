package com.test;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Player</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Player e=PlayerDao.getPlayerById(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
        out.print("<tr><td>Matches:</td><td><input type='number' name='matches' value='"+e.getMatches()+"'/></td></tr>");  
        out.print("<tr><td>Score:</td><td><input type='number' name='score' value='"+e.getSocre()+"'/></td></tr>"); 
        out.print("<tr><td>Wicket:</td><td><input type='number' name='wickets' value='"+e.getWickets()+"'/></td></tr>");  
        out.print("<tr><td>Duck:</td><td><input type='number' name='ducks' value='"+e.getDucks()+"'/></td></tr>");  
        out.print("<tr><td>Player:</td><td><input type='text' name='players' value='"+e.getPlayers()+"'/></td></tr>"); 
        out.print("<tr><td>Average:</td><td><input type='text' name='average' value='"+e.getAverage()+"'/></td></tr>");  


        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}  