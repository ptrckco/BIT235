package bookportal.controller;

import bookportal.model.bean.Book;
import bookportal.model.dao.BookDAO;
import java.sql.Timestamp;  
import java.util.Date;  

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
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub     
    }
    public void init() {
        bookDAO = new BookDAO();
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
		if (action==null) {
			action="No action";
		}
		RequestDispatcher dispatcher;
		try {
            switch (action) {
                case "new":
                    showNewBook(request, response);
                    break;
                case "insert":
                    insertBook(request, response);
                    break;
                case "delete":
                    deleteBook(request, response);
                    break;
                case "edit":
                    showEditBook(request, response);
                    break;
                case "update":
                    updateBook(request, response);
                    break;
                default:
                    listBook(request, response);
                    break;
            }
				} catch (Exception ex) {
	            throw new ServletException(ex);
	        }

	    }//End of doPost method
	private void listBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List < Book > listBook = bookDAO.selectAllBooks();
		request.setAttribute("listBook", listBook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("booklist.jsp");
		dispatcher.forward(request, response);
		}
	
	private void showNewBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("bookform.jsp");
		dispatcher.forward(request, response);
		}
	
	private void insertBook(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException {
		   String booktitle = request.getParameter("booktitle");
		   int bid = Integer.parseInt(request.getParameter("bid"));
		   int cid = Integer.parseInt(request.getParameter("cid"));
		   String description = request.getParameter("description");
		   String author = request.getParameter("author");
		   Timestamp publisheddate = Timestamp.valueOf(request.getParameter("publisheddate"));
		   String isbn = request.getParameter("isbn");
		   float price = Float.parseFloat(request.getParameter("price"));
		   int noofpages = Integer.parseInt(request.getParameter("noofpages"));
		   Book e = new Book(bid, booktitle, cid,description, author, publisheddate, isbn, price, noofpages);
		   bookDAO.insertBook(e);
		  response.sendRedirect(request.getContextPath()+"/BookServlet?action=list");
		}
	
	private void showEditBook(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException {
		   int id = Integer.parseInt(request.getParameter("id"));
		   Book existingBook = bookDAO.selectBook(id);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("bookform.jsp");
		 request.setAttribute("book", existingBook);
		 dispatcher.forward(request, response);
		}
	
	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		   
		   
		   
		   String booktitle = request.getParameter("booktitle");
		   String description = request.getParameter("description");
		   String author = request.getParameter("author");
		   Timestamp publisheddate = Timestamp.valueOf(request.getParameter("publisheddate"));
		   String isbn =  request.getParameter("isbn");
		   float price = Float.parseFloat(request.getParameter("price"));
		   int noofpages = Integer.parseInt(request.getParameter("noofpages"));
		   int bid = Integer.parseInt(request.getParameter("bid"));
		   int cid = Integer.parseInt(request.getParameter("cid"));
		   Book e = new Book(bid, booktitle, cid, description, author, publisheddate, isbn, price, noofpages);
		   bookDAO.updateBook(e);
		 response.sendRedirect(request.getContextPath() +"/BookServlet?action=list");
		}
	
	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		bookDAO.deleteBook(id);
	response.sendRedirect(request.getContextPath() +"/BookServlet?action=list");
		}

}
