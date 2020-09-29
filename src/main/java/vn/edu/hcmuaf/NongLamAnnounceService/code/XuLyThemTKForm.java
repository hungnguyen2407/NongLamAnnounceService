package vn.edu.hcmuaf.NongLamAnnounceService.code;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.hcmuaf.NongLamAnnounceService.dao.UserDAO;

/**
 * Servlet implementation class XuLyThemTKForm
 */
@WebServlet("/XulyThemTaiKhoanFrom")
public class XuLyThemTKForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyThemTKForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ;charset=UTF-8");
		//Thêm tài khoản nhập từ from
		String id = request.getParameter("mssv");
		String email = request.getParameter("mail");
		String fName = request.getParameter("iname");
		String lName = request.getParameter("fname");
		String birthday = request.getParameter("date");
		String facultyID = request.getParameter("khoa");
		String classID = request.getParameter("class");
		String url = request.getParameter("pass");
		UserDAO.addUser(id, email, fName, lName, birthday, facultyID, classID, url);
		request.getRequestDispatcher("/DangNhap.jsp").forward(request, response);
	}

}
