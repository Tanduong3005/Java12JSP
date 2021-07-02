package cysbersoft.java12.jsp.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.MysqlConnection;

import cybersoft.java12.jsp.dbconnection.MySqlConnection;

@WebServlet(name = "healthCheckServlet", urlPatterns = "/health")
public class HealthCheckServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection testConnection = MySqlConnection.getConnection();
		if(testConnection != null) {
			try {
				testConnection.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			resp.getWriter().append("Database connection has been created Successfully");
		}else {
			resp.getWriter().append("Database connection has been created Unsuccessfully");
		}
	}
}
