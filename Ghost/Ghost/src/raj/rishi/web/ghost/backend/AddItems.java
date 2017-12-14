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

/**
 * This class is used to connect to a datasource.
 * You can remove it and delete all its references and still be fine,
 * but it can be used to add a GUI for running pre-configured commands and apps
 * listed in a database
 * @author Raj
 */
public class AddItems {

	/**
	 * It simplifies the process of adding items. You can use the readme.md
	 * file to know how to make a database and use it for displaying tables
	 * that execute a given command.
	 * @param request Used to check authenticity of user
	 * @param response Used to display the list of commands
	 */
	public static void getList(HttpServletRequest request, HttpServletResponse response)
	{
		
		try{
			PrintWriter out=response.getWriter();
			SecurityUtils security = new SecurityUtils();
			if(!security.getAuthencticity(request))
				return;
			out.append("<br>");
			out.append("<label>Type in a command</label><form method=\"post\" action=\"Output\"><input type=\"text\" name=\"command\" ><input type=\"submit\" name=\"Submit\"></input></form>");
			
			
			/*---------------Database related code: Edit this to make it run with your database----------------------*/
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Class found");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ghostinfo","root","");
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from apps order by precedence desc"); 
			
			/*-------------------------End of Database related code-----------------------*/
			
			
			System.out.println("Executed query");
			out.append("<table>");
			addMouse(out);
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
		out.append("<footer align = \"center\">Made by Rishi Raj</footer>");
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
	/**
	 * This method adds the link for getting a screenshot from Screen servlet{@see raj.rishi.web.ghost.backend.AddItems#getList(HttpServletRequest, HttpServletResponse)}
	 */
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
	private static void addMouse(PrintWriter out) throws IOException {
		System.out.println("Inside add mouse");
		out.append("<tr>");
		out.append("<td> <a href=\"command.html\">");
		out.append("<img width = \"128\" height = \"128\" src=\"img/remote.png\">");
		out.append("</a> </td>");
		out.append("<td> <a href=\"command.html\">");
		out.append("<p>Control mouse</p>");
		out.append("</a> </td>");
		out.append("</tr>");
		System.out.println("Added control mouse");
	}
}
