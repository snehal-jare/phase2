package com.servelets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.Dao;
import com.mysql.cj.xdevapi.Statement;


@WebServlet("/InsertFlight")
public class InsertFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String Source=request.getParameter("Source");
		String Dest=request.getParameter("Dest");
		String departure=request.getParameter("departure");
		String time=request.getParameter("time");
		String price=request.getParameter("price");
		
		HashMap<String,String> flight=new HashMap();
		flight.put("name", name);
		flight.put("Source", Source);
		flight.put("Dest", Dest);
		flight.put("date", departure);
		flight.put("time", time);
		flight.put("price", price);
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ailine", "root", "12345678");
		Statement st=(Statement) conn.createStatement();

		int i=((java.sql.Statement) st).executeUpdate("insert into flight(name, Source, Dest, date, time, price)values('"+name+"','"+Source+"','"+Dest+"','"+departure+"','"+time+"','"+price+"')");
//		out.println("Data is successfully inserted!");
//		String sql = "insert into flight(name, Source, Dest, date, time, price) values (?,?, ?, ?, ?)";

		}
		catch(Exception e)
		{
		System.out.print(e);
		e.printStackTrace();
		}
		
		try {
			Dao dao=new Dao();
			HttpSession session=request.getSession();
			if(dao.insertFlight(flight)) {
				
				session.setAttribute("message", "Flight Added Successfully");
			}
			else {
				session.setAttribute("message", "Invalid Details");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("error");
			e.printStackTrace();
		}
		response.sendRedirect("AdminHome.jsp");
		
	}

}