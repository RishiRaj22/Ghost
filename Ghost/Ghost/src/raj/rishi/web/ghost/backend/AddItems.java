package raj.rishi.web.ghost.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import raj.rishi.web.ghost.utils.SecurityUtils;

public class AddItems {

	public static void getTable(HttpServletRequest request, HttpServletResponse response)
	{
		
		try{
			PrintWriter out=response.getWriter();
			SecurityUtils security = new SecurityUtils();
			if(!security.getAuthencticity(request, response))
				return;
			out.append("<br>");
			out.append("<label>Type in a command</label><form method=\"post\" action=\"Output\"><input type=\"text\" name=\"command\" ><input type=\"submit\" name=\"Submit\"></input></form>");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Class found");
	
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ghostinfo","root","");
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from apps order by precedence desc"); 
			System.out.println("Executed query");
			out.append("<table>");
			addScreenShot(out);
			while(rs.next())  
			{
				System.out.println("Inside rs.next()");
				out.append("<tr>");
				out.append("<td>");
				out.append("<a href=\"Output?command="+rs.getString(3)+"\">");
				out.append("<img src=\""+rs.getString(4)+"\" alt=\""+rs.getString(2)+"\">");
				out.append("</a");
				out.append("</td>");
				out.append("<td>");
				
				out.append("<a href=\"Output?command="+rs.getString(3)+"\">");
				out.append(rs.getString(2));
				out.append("</a");
				out.append("</td>");
				out.append("</tr>");
			}
		out.append("</table>");
	} catch (Exception e) {
		System.out.println("Database error");
		try {
			response.getWriter().append("Error. Database connection not established.");
			response.sendError(501);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.printStackTrace();
		
	}
	}
	private static void addScreenShot(PrintWriter out) throws IOException {
		System.out.println("Inside add Screenshot");
		out.append("<tr>");
		out.append("<td> <a href=\"Screen\">");
		out.append("<img src=\"img/screenshot.png\">");
		out.append("</a> </td>");
		out.append("<td> <a href=\"Screen\">");
		out.append("<p>Screen Capture</p>");
		out.append("</a> </td>");
		out.append("</tr>");
		System.out.println("Added Screenshot");
	}
}
