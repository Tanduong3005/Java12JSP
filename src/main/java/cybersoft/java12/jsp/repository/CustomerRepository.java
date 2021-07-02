package cybersoft.java12.jsp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import cybersoft.java12.jsp.dbconnection.MySqlConnection;
import cybersoft.java12.jsp.model.Customer;

public class CustomerRepository {
	public List<Customer> findallCustomers(){
		List<Customer> customers = new LinkedList<Customer>();
		try {
			Connection connection = MySqlConnection.getConnection();
				
			String query = "SELECT code, name, address, email FROM customer";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				Customer customer = new Customer();
				
				customer.setCode(resultSet.getInt("code"));
				customer.setName(resultSet.getNString("name"));
				customer.setAddress(resultSet.getNString("address"));
				customer.setEmail(resultSet.getString("email"));
				
				customers.add(customer);
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Connection to DB has been dissconnected!!");
			e.printStackTrace();
		}
		return customers;
	}
	
	public Customer findCustomerByCode(int code) {
		Customer customer = null;
		
		try {
			Connection connection = MySqlConnection.getConnection();
			
			String query = "SELECT code, name, address, email FROM customer WHERE code = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, code);
			
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				customer = new Customer();
				customer.setCode(resultSet.getInt("code"));;
				customer.setName(resultSet.getNString("name"));
				customer.setAddress(resultSet.getNString("address"));
				customer.setEmail(resultSet.getString("email"));
			}
			
		} catch (SQLException e) {
			System.out.println("Connection to database has been disconnected!");
			e.printStackTrace();
		}
		
		return customer;
	}
	
	public int addNewCustomer(Customer customer) {
		int result = 0;
		try {
			Connection connection = MySqlConnection.getConnection();
			String query = "INSERT INTO customer(name, address, email) values(?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getAddress());
			statement.setString(3, customer.getEmail());
			result = statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Connection to database has been disconnected!");
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int deleteCustomerByCode(int code) {
		int result=0;
		try {
			Connection connection = MySqlConnection.getConnection();
			
			String query = "DELETE FROM customer WHERE code = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, code);
			result = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Connection to database has been disconnected!");
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateCustomer(Customer customer, int code) {
		int result=0;
		try {
			Connection connection = MySqlConnection.getConnection();
			
			String query = "UPDATE customer SET name = ?, address = ?, email = ? WHERE code = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getAddress());
			statement.setString(3, customer.getEmail());
			statement.setInt(4, code);
			result = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Connection to database has been disconnected!");
			e.printStackTrace();
		}
		return result;
	}
}
