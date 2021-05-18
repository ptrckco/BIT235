package booklist.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booklist.model.dao.AdminBookCategoryDAO;
import booklist.model.bean.AdminBookCategory;


/**
 * Servlet implementation class AdminBookCategoryServlet
 */
@WebServlet("/AdminBookCategoryServlet")
public class AdminBookCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminBookCategoryDAO bookcategoryDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBookCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
		bookcategoryDAO = new AdminBookCategoryDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action == null) {
			action = "No action";
		}
		RequestDispatcher dispatcher;
		try {
			switch (action) {
			case "new":
				showAdminNewBookCategory(request, response);
				break;
			case "insert":
				insertAdminBookCategory(request, response);
				break;
			case "delete":
				deleteAdminBookCategory(request, response);
				break;
			case "edit":
				showAdminEditBookCategory(request, response);
				break;
			case "update":
				updateAdminBookCategory(request, response);
				break;
			default:
				listBookCategory(request, response);
			    break;   
			 }
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listBookCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List < AdminBookCategory > listBookCategory = bookcategoryDAO.selectAllAdminBookCategory();
		request.setAttribute("listBookCategory", listBookCategory);
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminbookcategorylist.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showAdminNewBookCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminbookcategoryform.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertAdminBookCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String title = request.getParameter("categorytitle");
		int cid = Integer.parseInt(request.getParameter("cid"));
		AdminBookCategory category = new AdminBookCategory();
		category.setCid(cid);
		category.setCategoryTitle(title);
		bookcategoryDAO.insertAdminBookCategory(category);
		response.sendRedirect(request.getContextPath() + "/AdminBookCategoryServlet?action=list");
	}
	
	private void showAdminEditBookCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		AdminBookCategory category = bookcategoryDAO.selectAdminBookCategory(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminbookcategoryform.jsp");
		request.setAttribute("category", category);
		dispatcher.forward(request, response);
	}
	
	private void updateAdminBookCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String title = request.getParameter("categorytitle");
		int cid = Integer.parseInt(request.getParameter("cid"));
		AdminBookCategory category = new AdminBookCategory();
		category.setCid(cid);
		category.setCategoryTitle(title);
		bookcategoryDAO.updateAdminBookCategory(category);
		response.sendRedirect(request.getContextPath() + "/AdminBookCategoryServlet?action=list");
	}
	
	private void deleteAdminBookCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		bookcategoryDAO.deleteAdminBookCategory(id);
		response.sendRedirect(request.getContextPath() + "/AdminBookCategoryServlet?action=list");
	}
	
}
