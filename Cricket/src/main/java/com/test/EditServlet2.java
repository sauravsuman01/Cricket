package com.test;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");  
        int matches=Integer.parseInt(request.getParameter("matches"));  
        int score=Integer.parseInt(request.getParameter("score")); 
        int wicket=Integer.parseInt(request.getParameter("wickets"));  
        int duck=Integer.parseInt(request.getParameter("ducks")); 
        String player=request.getParameter("players");  
        int average=Integer.parseInt(request.getParameter("average")); 


          
        Player e=new Player();  
        e.setId(id);  
        e.setName(name);
        e.setMatches(matches);  
        e.setSocre(score);  
        e.setWickets(wicket);  
        e.setDucks(duck); 
        e.setPlayers(player);
        e.setAverage(score, matches);
          
        int status=PlayerDao.update(e);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  