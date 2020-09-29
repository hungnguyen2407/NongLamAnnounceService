package vn.edu.hcmuaf.NongLamAnnounceService.code;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.hcmuaf.NongLamAnnounceService.dao.UserDAO;
import vn.edu.hcmuaf.NongLamAnnounceService.model.FormMail;
import vn.edu.hcmuaf.NongLamAnnounceService.model.RandomString;

/**
 * Servlet implementation class XuLyQuenMatKhau
 */
@WebServlet("/XulyQuenMatKhau")
public class XuLyQuenMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyQuenMatKhau() {
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
		doGet(request, response);
		String user = request.getParameter("tenuser");
		String new_pass = RandomString.randomString(8);//gọi ra phương thức lấy pass ngẫu nhiên
		String email = UserDAO.getInfoUser(user).getEmail();
		if(SendMail.sendMail(email, FormMail.forgetPasswordTemplate(user, new_pass), "LẤY LẠI MẬT KHẨU")){
			UserDAO.updatePassword(user, new_pass);
		}
		request.getRequestDispatcher("/DangNhap.jsp").forward(request, response);
	}

}
