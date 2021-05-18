package mvccrudpackage.controller;

import mvccrudpackage.model.bean.Employee;
import mvccrudpackage.model.dao.EmployeeDAO;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO empDAO; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
        empDAO = new EmployeeDAO();
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String action = request.getServletPath();
				String action = request.getParameter("action");
				if (action==null) {
					action="No action";
				}
				RequestDispatcher dispatcher;
				try {
		            switch (action) {
		                case "new":
		                    showNewEmployee(request, response);
		                    break;
		                case "insert":
		                    insertEmployee(request, response);
		                    break;
		                case "delete":
		                    deleteEmployee(request, response);
		                    break;
		                case "edit":
		                    showEditEmployee(request, response);
		                    break;
		                case "update":
		                    updateEmployee(request, response);
		                    break;
		                default:
		                    listEmployee(request, response);
		                    break;
		            }
						} catch (Exception ex) {
			            throw new ServletException(ex);
			        }

			    }//End of doPost method
	
	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List < Employee > listEmployee = empDAO.selectAllEmployees();
		request.setAttribute("listEmployee", listEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
		}
	
	private void showNewEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("employeeform.jsp");
		dispatcher.forward(request, response);
		}
	
	private void insertEmployee(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException {
		   String ename = request.getParameter("name");
		   int eage = Integer.parseInt(request.getParameter("age"));
		   Employee e = new Employee(ename, eage);
		   empDAO.insertEmployee(e);
		  response.sendRedirect(request.getContextPath()+"/EmployeeServlet?action=list");
		}
	
	private void showEditEmployee(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException {
		   int id = Integer.parseInt(request.getParameter("id"));
		   Employee existingEmployee = empDAO.selectEmployee(id);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("employeeform.jsp");
		 request.setAttribute("employee", existingEmployee);
		 dispatcher.forward(request, response);
		}
	
	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		   int id = Integer.parseInt(request.getParameter("id"));
		   String ename = request.getParameter("name");
		   int eage = Integer.parseInt(request.getParameter("age"));
		   Employee e = new Employee(id, ename, eage);
		   empDAO.updateEmployee(e);
		 response.sendRedirect(request.getContextPath() +"/EmployeeServlet?action=list");
		}
	
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		empDAO.deleteEmployee(id);
	response.sendRedirect(request.getContextPath() +"/EmployeeServlet?action=list");
		}
		
}


