<%@page import="vn.edu.hcmuaf.NongLamAnnounceService.dao.AnnounceDAO"%>
<%@page import="vn.edu.hcmuaf.NongLamAnnounceService.model.Announce"%>
<%@page import="vn.edu.hcmuaf.NongLamAnnounceService.model.InfoGroupOfUser"%>
<%@page
	import="vn.edu.hcmuaf.NongLamAnnounceService.model.InformationUser"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/css.css" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script language="javascript">
	function openCity(evt, cityName) {
		// Declare all variables
		var i, tabcontent, tablinks;

		// Get all elements with class="tabcontent" and hide them
		tabcontent = document.getElementsByClassName("tabcontent");
		for (i = 0; i < tabcontent.length; i++) {
			tabcontent[i].style.display = "none";
		}

		// Get all elements with class="tablinks" and remove the class "active"
		tablinks = document.getElementsByClassName("tablinks");
		for (i = 0; i < tablinks.length; i++) {
			tablinks[i].className = tablinks[i].className
					.replace(" active", "");
		}

		// Show the current tab, and add an "active" class to the button that opened the tab
		document.getElementById(cityName).style.display = "block";
		evt.currentTarget.className += " active";
	}
</script>
<title>Thông báo</title>
</head>

<body>
	<div class="tabbable">
		<%
			if (session.getAttribute("user") == null) {
		%>
		<jsp:forward page="/DangNhap.jsp"></jsp:forward>
		<%
			} else {
				InformationUser user = (InformationUser) session.getAttribute("user");
		%>
		<div id="homeLeft" style="height: 100%">
			<div id="user">
				<a href="#"><img src="images/Unknown-avatar.jpg" /></a>
				<p>
					Họ và tên:
					<%
					out.print(user.getlName() + " " + user.getfName());
				%>
				</p>
				<br />
				<p>
					Mssv:
					<%
					out.print(user.getId());
				%>
				</p>
				<br />
				<p>
					Lớp:
					<%
					out.print(user.getClassID());
					}
				%>
				</p>
				<br />
				<form action="XuLyDangXuat" method="post">
					<input type="submit" name="dn" id="dn2" value="Đăng xuất"
						style="margin-left: 10px; width: 50%; min-height: 30px; border-radius: 5px 5px 5px 5px; background-color: #090; color: #FFF">
				</form>
			</div>
			<!--end user-->
			<div id="menu">
				<h5>-Group:</h5>
				<div class="group" style="background-color: #0C3;">
					<div class="tabs">
						<%
							if (session.getAttribute("listClass") != null) {
								List<InfoGroupOfUser> listClass = (List<InfoGroupOfUser>) session.getAttribute("listClass");
								for (int i = 0; i < listClass.size(); i++) {
						%>
						<button class="tablinks"
							onclick="openCity(event, '<%=listClass.get(i).getClass_id()%>')"><%=listClass.get(i).getClass_name()%></button>
						<%
							}
						%>
					</div>
				</div>
				<!--end group-->
			</div>
			<!--end menu-->
		</div>
		<!--end homeLeft-->
		<div id="homeright">
			<div id="timkiem">
				<img src="images/banner_nlu.jpg" />
				<center>
					<form id="form1" name="form1" method="post" action="">
						<input type="text" name="timkiem" class="tim"
							placeholder="Nhập từ khóa tìm kiếm..." /> <input type="submit"
							name="timkiem" value="Tìm" class="btntim" />
					</form>
				</center>
			</div>
			<!--end timkiem-->
			<hr width="99%" color="#999999" />

			<% for (int i=0;i<listClass.size();i++){%>
				<div id="<%=listClass.get(i).getClass_id()%>" class="tabcontent">
				<% List<Announce> listAnnounce = AnnounceDAO.getAnnounceList(listClass.get(i).getClass_id());
					if(listAnnounce!=null) for(int j=0;j<listAnnounce.size();j++){%>
						<h3><%=listAnnounce.get(j).getTitle()%></h3>
						<p><%=listAnnounce.get(j).getContent()%></p>
				<% 
				}
				%>
			</div>
			<% 	
			}
			}
			%>
		</div>
		</div>
		<!--end homeright-->
</body>
</html>