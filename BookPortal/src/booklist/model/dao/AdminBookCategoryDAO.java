package booklist.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import booklist.model.bean.AdminBookCategory;

public class AdminBookCategoryDAO {
	private String DBURL = "jdbc:mysql://localhost:3306/bookstore";
	private String DBUsername = "root";
	private String DBPassword = "mysql";
	private String INSERTCATEGORY = "INSERT INTO book_category (cid, categorytitle) VALUES " + " (?, ?);";
	private String SELECTCATEGORY = "select cid, categorytitle from book_category where cid =?";
	private String SELECTALLCATEGORY = "select * from book_category";
	private String DELETECATEGORY = "delete from book_category where cid =?;";
	private String UPDATECATEGORY = "update book_category set categorytitle=? where cid = ?;";
	
	//Constructor
	public AdminBookCategoryDAO() {}
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DBURL, DBUsername, DBPassword); 
		} catch (SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public void insertAdminBookCategory(AdminBookCategory category) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//try-with-resource statement will auto close the connection
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(INSERTCATEGORY);
			preparedStatement.setInt(1, category.getCid());
			preparedStatement.setString(2, category.getCategoryTitle());
			System.out.println(preparedStatement);
			preparedStatement.executeLargeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		} finally {
			finallySQLException(connection, preparedStatement, null);
		}
	}
	
	public AdminBookCategory selectAdminBookCategory(int cid) {
		AdminBookCategory category = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		//step1: Establishing a Connection
		try {
			connection = getConnection();
			//step2: Create a statement using connection object
			preparedStatement = connection.prepareStatement(SELECTCATEGORY);
			preparedStatement.setInt(1, cid);
			System.out.println(preparedStatement);
			//step3: Execute the query or update query
			rs = preparedStatement.executeQuery();
			//step4: Process the ResultSet object
			while (rs.next()) {
				category = new AdminBookCategory();
				category.setCid(rs.getInt("cid"));
				category.setCategoryTitle(rs.getString("categorytitle"));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} finally {
			finallySQLException(connection, preparedStatement, rs);
		}
		return category;
	}
	
	public List <AdminBookCategory> selectAllAdminBookCategory(){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		// using try-with-resources to avoid closing resources (boiler plate code)
		List <AdminBookCategory> list = new ArrayList<> ();
		//step1: Establishing a Connection
		try {
			connection = getConnection();
			// Step2:Create a statement using connection object
			preparedStatement = connection.prepareStatement(SELECTALLCATEGORY);
			System.out.println(preparedStatement);
			//step3: Execute the query or update query
			rs = preparedStatement.executeQuery();
			//step4: Process the ResultSet object
			while (rs.next()) {
				AdminBookCategory category = new AdminBookCategory();
				category.setCid(rs.getInt("cid"));
				category.setCategoryTitle(rs.getNString("categoryTitle"));
				list.add(category);
			}
		} catch (SQLException e) {
			printSQLException(e);
		} finally {
			finallySQLException(connection, preparedStatement, rs);
		}
		return list;
	}
	
	public boolean deleteAdminBookCategory(int cid) throws SQLException {
		boolean categoryDeleted = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(DELETECATEGORY);
			preparedStatement.setInt(1, cid);
			categoryDeleted = preparedStatement.executeUpdate() > 0 ? true : false;
		} finally {
			finallySQLException(connection, preparedStatement, null);
		}
		return categoryDeleted;
	}
	
	public boolean updateAdminBookCategory(AdminBookCategory category) throws SQLException {
		boolean categoryUpdated = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(UPDATECATEGORY);
			preparedStatement.setString(1, category.getCategoryTitle());
			preparedStatement.setInt(2, category.getCid());
			categoryUpdated = preparedStatement.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			printSQLException(e);
		} finally {
			finallySQLException(connection, preparedStatement, null);
		}
		return categoryUpdated;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState:" + ((SQLException) e).getSQLState());
				System.err.println("Error Code:" + ((SQLException) e).getErrorCode());
				System.err.println("Message:" + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause:" + t);
					t = t.getCause();
				}
			}
		}
	}
	
	private void finallySQLException(Connection c, PreparedStatement p, ResultSet r) {
		if (r != null) {
			try {
				r.close();
			} catch (Exception e) {}
			r = null;
		}
		if (p != null) {
			try {
				p.close();
			} catch (Exception e) {}
			p = null;
		}
		if (c != null) {
			try {
				c.close();
			} catch (Exception e) {
				c = null;
			}
		}
	}

}
