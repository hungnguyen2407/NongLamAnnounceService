package vn.edu.hcmuaf.NongLamAnnounceService.model;

public class FormMail {
	public static String forgetPasswordTemplate(String username, String pass) {
		StringBuilder s = new StringBuilder();
		s.append("<h3><strong>LẤY LẠI MẬT KHẨU THÀNH CÔNG</strong></h3><br>");
		s.append("<div>Bạn đã yêu cầu lấy lại mật khẩu<br>");
		s.append("Mật khẩu tài khoản " + username + " của bạn được đổi thành <strong>" + pass + "<strong><br>");
		s.append("Cảm ơn bạn đã đồng hành cùng chúng tôi trong thời gian qua!<br></div>");
		s.append("<hr><br>");
		return s.toString();
	}
}
