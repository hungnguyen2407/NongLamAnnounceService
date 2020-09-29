package vn.edu.hcmuaf.NongLamAnnounceService.code;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.edu.hcmuaf.NongLamAnnounceService.dao.UserDAO;
import vn.edu.hcmuaf.NongLamAnnounceService.model.InfoGroupOfUser;
import vn.edu.hcmuaf.NongLamAnnounceService.model.InformationUser;

/**
 * Servlet implementation class XuLyDangNhap
 */
@WebServlet("/XulyDangNhap")
public class XuLyDangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyDangNhap() {
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
//		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ;charset=UTF-8");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		boolean error = false;
		boolean dangNhap = UserDAO.login(user, pass);
		String DangNhap_err = "";
		if (!dangNhap) {
		DangNhap_err = "Sai thông tin đăng nhập !";
		error = true;
		request.setAttribute("DangNhap_err", DangNhap_err);
		}
		if(error){		
			RequestDispatcher rd =getServletContext().getRequestDispatcher("/DangNhap.jsp");
			rd.forward(request, response);
		}  
		else{
		HttpSession session= request.getSession() ;
		InformationUser informationUser = UserDAO.getInfoUser(user);
		List<InfoGroupOfUser> listClass = UserDAO.getdsGroupOfUser(user);
		session.setAttribute("user", informationUser);
		session.setAttribute("listClass", listClass);
		response.sendRedirect("../NongLamAnnounceService/index.jsp");
		}
	}

}
