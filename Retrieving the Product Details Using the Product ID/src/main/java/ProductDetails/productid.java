package ProductDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/product")
public class productid extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="jdbc:oracle:thin:@localhost:1522:xe";
		String username="SNEHAL";
		String password="2102000";
		
		response.setContentType("text/html");
		
		String pId = request.getParameter("productid");
	
		PrintWriter out = response.getWriter();
		
		String query="select * from products where productid=?";
		out.print("<h1>Displaying the Product Details...</h1>");
		out.print("<table border='1'><tr><th>productid</th><th>Productname</th><th>quantity</th>");
		
		try {
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      Connection dbCon = DriverManager.getConnection(url, username, password);
	      PreparedStatement st=  dbCon.prepareStatement(query);
	      
	      st.setString(1, pId);
	      
	      ResultSet rs =st.executeQuery();
	      
	      while(rs.next()) {
	    	  
	    	  out.print("<tr><td>");
	    	  out.println(rs.getInt(1));
	    	  out.print("</td>");
	    	  out.print("<td>");
	    	  out.print(rs.getString(2));
	    	  out.print("</td>");
	    	  out.print("<td>");
	    	  out.print(rs.getInt(3));
	    	  out.print("</td>");
	    	  out.print("</tr>");
	    
	    	  
			}
	      
		}
		catch(Exception e){
			
			System.out.println("Some Issue : "+ e.getMessage());
			
			
		}
		
		out.print("</table>");
		
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
}
}