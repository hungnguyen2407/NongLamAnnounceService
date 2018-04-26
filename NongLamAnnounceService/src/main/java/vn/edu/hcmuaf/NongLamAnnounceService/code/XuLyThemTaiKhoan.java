package vn.edu.hcmuaf.NongLamAnnounceService.code;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.edu.hcmuaf.NongLamAnnounceService.dao.UserDAO;
import vn.edu.hcmuaf.NongLamAnnounceService.model.InformationUser;

/**
 * Servlet implementation class XuLyThemTaiKhoan
 */
@WebServlet("/XulyThemTaiKhoan")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024
		* 100)
public class XuLyThemTaiKhoan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XuLyThemTaiKhoan() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// process only if its multipart content
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html ;charset=UTF-8");
		//Thêm tài khoản nhập từ from
//		String id = request.getParameter("mssv");
//		String email = request.getParameter("mail");
//		String fName = request.getParameter("iname");
//		String lName = request.getParameter("fname");
//		String birthday = request.getParameter("date");
//		String facultyID = request.getParameter("khoa");
//		String classID = request.getParameter("class");
//		String url = request.getParameter("pass");
//		UserDAO.addUser(id, email, fName, lName, birthday, facultyID, classID, url);
		
		//thêm tài khoản import file excel
		String uploadFolder =
				getServletContext().getRealPath("/UploadFile");
		String fileDir = "";
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String name = new File(item.getName()).getName();
						fileDir = uploadFolder + File.separator + name;
						item.write(new File(fileDir));
					}
				}
				List<InformationUser> listUser = ReadExcel.readUserExcel(fileDir);
				for (InformationUser informationUser : listUser) {
					UserDAO.addUser(informationUser.getId(), informationUser.getEmail(), informationUser.getfName(),
							informationUser.getlName(), informationUser.getBirthday(), informationUser.getFacultyID(), informationUser.getClassID(),
							informationUser.getUrl_avatar());
				}
				// File uploaded successfully
				request.setAttribute("message", "File Uploaded Successfully");
			} catch (Exception ex) {
				request.setAttribute("message", "File Upload Failed due to " + ex);
			}

		} else {
			request.setAttribute("message", "Sorry this Servlet only handles file upload request");
		}		
		request.getRequestDispatcher("/DangNhap.jsp").forward(request, response);
	}

}
