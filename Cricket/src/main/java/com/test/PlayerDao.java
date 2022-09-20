package com.test;

import java.util.*;  
import java.sql.*;  
  
public class PlayerDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/perfios", "root", "password");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Player e){  
        int status=0;  
        try{  
            Connection con=PlayerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into cricket(id,name,matches,score,wickets,ducks,players,average) values (?,?,?,?,?,?,?,?)");  
            ps.setInt(1,e.getId()); 
            
            ps.setString(2,e.getName());  
            ps.setInt(3,e.getMatches());  
            ps.setInt(4,e.getSocre());  
            ps.setInt(5,e.getWickets());  
            ps.setInt(6,e.getDucks());  
            ps.setString(7,e.getPlayers());  
            ps.setInt(8, e.getAverage());

              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Player e){  
        int status=0;  
        try{  
            Connection con=PlayerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update cricket set name=?,matches=?,score=?,wickets=?,ducks=?, players=? ,average=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setInt(2,e.getMatches());  
            ps.setInt(3,e.getSocre());  
            ps.setInt(4,e.getWickets());  
            ps.setInt(5,e.getDucks());  

            ps.setString(6,e.getPlayers()); 
             
            ps.setInt(7, e.getAverage());
            ps.setInt(8,e.getId()); 
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=PlayerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from cricket where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Player getPlayerById(int id){  
        Player e=new Player();  
          
        try{  
            Connection con=PlayerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from cricket where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setMatches(rs.getInt(3));  
                e.setSocre(rs.getInt(4));  
                e.setWickets(rs.getInt(5));  
                e.setDucks(rs.getInt(6));  

                e.setPlayers(rs.getString(7)); 
                e.setAverage(rs.getInt(4),rs.getInt(3));
                
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Player> getAllPlayers(){  
        List<Player> list=new ArrayList<Player>();  
          
        try{  
            Connection con=PlayerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from cricket");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Player e=new Player();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setMatches(rs.getInt(3));  
                e.setSocre(rs.getInt(4));  
                e.setWickets(rs.getInt(5));  
                e.setDucks(rs.getInt(6));  

                e.setPlayers(rs.getString(7)); 
                e.setAverage(rs.getInt(4),rs.getInt(3) );
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  