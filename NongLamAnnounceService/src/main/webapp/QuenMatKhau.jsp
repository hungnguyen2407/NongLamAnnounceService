<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="css/css.css"/>
<title>Quên mật khẩu</title>
</head>
<body>
<div id="left">
		<img src="images/Logo_HCMUAF.png" />   
    <center>
    <div id="dn">
    <h2><u>Quên mật khẩu</u></h2>
      <form id="form1" name="form1" method="post" action="XuLyQuenMatKhau">
	  <label for="user"></label>
	  <input type="text" name="tenuser" id="tentaikhoan" 
      style="margin-top:10%; width:90%; min-height:30px; border-radius: 5px 5px 5px 5px;" placeholder="Nhập email"/>
      <input type="submit" name="dn" id="dn2" value="Gửi mật khẩu mới" 
      style="margin-top:10%; width:50%; min-height:30px; border-radius: 5px 5px 5px 5px;
       background-color:#090; color:#FFF" /><br /><br />
      </form>
      <a href="index.jsp">Quay lại</a>
    </div><!--end dn-->
    </center>
</div><!--end left-->
<div id="right">
	<img src="images/bg2.jpg" />
</div><!--end right-->
</body>
</html>