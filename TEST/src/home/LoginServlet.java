package home;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	public String usu="em";
	public String pass="em";
	private static final long serialVersionUID = 8438320730846730385L;
	@Override
	
	
	
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String articulo = req.getParameter("articulo");
		
		
		
		datos datos=new datos();
		datos.getarticulo(articulo);
		try {
			datos.getclientes();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rs1=datos.rs;
		float valor=datos.valor;
		String vl=String.valueOf(valor);
		String user = req.getParameter("user");
		String pass = req.getParameter("password");
		
		
		if ("user".equals(user) && "pass".equals(pass)) {
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			response(resp, "login ok");
			response(resp,vl);
			try {
				while (rs1.next())
				{
				response (resp,rs1.getString(1));	
				
				}
				response (resp,"<A HREF='http://localhost:8080/TEST' TITLE='Volver atras'>Volver Atras</A>");	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				
			} 
		else {
			response(resp, "Invalid login");
		}
	}
	private void response(HttpServletResponse resp, String msg)
			throws IOException {
		PrintWriter out = resp.getWriter();

		out.println( msg);
		
				
	}

}
