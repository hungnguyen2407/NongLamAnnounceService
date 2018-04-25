<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8" />
	<title>Quản trị hệt thống</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="assets/css/metro.css" rel="stylesheet" />
	<link href="assets/bootstrap/css/bootstrap-fileupload.css" rel="stylesheet" />
	<link href="assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
	<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<link href="assets/css/style.css" rel="stylesheet" />
	<link href="assets/css/style_responsive.css" rel="stylesheet" />
	<link href="assets/css/style_default.css" rel="stylesheet" id="style_color" />
	<link rel="stylesheet" type="text/css" href="assets/bootstrap-datepicker/css/datepicker.css" />
	<link rel="shortcut icon" href="favicon.ico" />
	<script src="assets/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="scripts/ckeditor/ckeditor.js"></script>
	<script type="text/javascript" src="scripts/ckeditor/config.js"></script>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="fixed-top">
	<!-- BEGIN HEADER -->
	<div class="header navbar navbar-inverse navbar-fixed-top">
		<!-- BEGIN TOP NAVIGATION BAR -->
		<div class="navbar-inner">
			<div class="container-fluid">
				<!-- BEGIN LOGO -->
				<a class="brand" href="admin.jsp">
				     QUẢN TRỊ HỆ THỐNG
				</a>
                <a href="Home.jsp" style="float:right; color:#FFF; padding:10px;">
                	Trở lại trang chủ
                </a>
				<!-- END LOGO -->
				<!-- BEGIN RESPONSIVE MENU TOGGLER -->
				<a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">
				<img src="assets/img/menu-toggler.png" alt="" />
				</a>
				<!-- END RESPONSIVE MENU TOGGLER -->
			</div>
		</div>
		<!-- END TOP NAVIGATION BAR -->
	</div>
	<!-- END HEADER -->
	<!-- BEGIN CONTAINER -->
	<div class="page-container row-fluid">
		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar nav-collapse collapse">
			<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
			<div class="slide hide">
				<i class="icon-angle-left"></i>
			</div>
			<div class="clearfix"></div>
			<!-- END RESPONSIVE QUICK SEARCH FORM -->
			<!-- BEGIN SIDEBAR MENU -->
			<ul>
				<li class="">
					<a href="index.html">
					<i class="icon-home"></i> Bảng thông tin
					<span class="selected"></span>
					</a>
				</li>
                			<li class="has-sub active">
					<a href="javascript:;" class="">
						Bài viết
					<span class="selected"></span>
					<span class="arrow open"></span>
					</a>
					<ul class="sub">
						<li class="active"><a class="" href="admin.jsp">Quản lý</a>
                        </li>
						<li><a class="" href="ThemBaiViet.jsp">Thêm mới</a>
                        </li>
					</ul>
				</li>
            <li class="has-sub active">
					<a href="javascript:;" class="">
						Yêu cầu gia nhập
					<span class="selected"></span>
					<span class="arrow open"></span>
					</a>
					<ul class="sub">
						<li class="active"><a class="" href="#">Yêu cầu</a>
                        </li>
                        <li><a class="" href="ThemTaiKhoan.jsp">Thêm mới</a>
                        </li>
					</ul>
				</li>
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
		<!-- END SIDEBAR -->
		<!-- BEGIN PAGE -->
		<div class="page-content">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<div id="portlet-config" class="modal hide">
				<div class="modal-header">
					<button data-dismiss="modal" class="close" type="button"></button>
					<h3>portlet Settings</h3>
				</div>
				<div class="modal-body">
					<p>Here will be a configuration form</p>
				</div>
			</div>
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- BEGIN PAGE CONTAINER-->
			<div class="container-fluid">
				<!-- BEGIN PAGE HEADER-->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							Quản lý
						</h3>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="admin.php">Quản trị</a> 
								<span class="icon-angle-right"></span>
							</li>
							<li>
								<a href="#">Bài viết</a>
							</li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN SAMPLE TABLE PORTLET-->
							
                  <!-- BEGIN SAMPLE FORM PORTLET-->   
                  <div class="portlet box blue">
                     <div class="portlet-title">
                        <h4>Thêm tài khoản</h4>
                     </div>
                     <div class="portlet-body form">
                        <!-- BEGIN FORM-->
                       		
                        <!-- END FORM-->           
                       <form name="form1" method="post" action="XuLyThemTaiKhoan" enctype="multipart/form-data">
                         <table width="479" height="373" border="0" align="center">
                           <tr>
                             <td width="127" align="center">Mã sinh viên</td>
                             <td width="336"><label for="mssv"></label>
                             <input type="text" name="mssv" id="mssv" style="margin-left:20px;"></td>
                           </tr>
                           <tr>
                             <td align="center">Email</td>
                             <td><label for="mail"></label>
                             <input type="text" name="mail" id="mail" style="margin-left:20px;"></td>
                           </tr>
                           <tr>
                             <td align="center">Tên</td>
                             <td><label for="iname"></label>
                             <input type="text" name="iname" id="iname" style="margin-left:20px;"></td>
                           </tr>
                           <tr>
                             <td align="center">Họ</td>
                             <td><label for="fname"></label>
                             <input type="text" name="fname" id="fname" style="margin-left:20px;"></td>
                           </tr>
                           <tr>
                             <td align="center">Ngày sinh</td>
                             <td><label for="date"></label>
                             <input type="text" name="date" id="date" style="margin-left:20px;"></td>
                           </tr>
                           <tr>
                             <td align="center">Khoa</td>
                             <td><label for="khoa"></label>
                             <input type="text" name="khoa" id="khoa" style="margin-left:20px;"></td>
                           </tr>
                           <tr>
                             <td align="center">Lớp</td>
                             <td><label for="class"></label>
                             <input type="text" name="class" id="class" style="margin-left:20px;"></td>
                           </tr>
                           <tr>
                             <td align="center">Mật khẩu</td>
                             <td><label for="pass"></label>
                             <input type="password" name="pass" id="pass" style="margin-left:20px;"></td>
                           </tr>
                         </table>
                         <p align="center">
                         	<input type="file" name="file" id="fileUpload"><br>
                           	<input type="submit" name="themtin" value="Thêm tài khoản"/>
                           </p>
                       </form>
                     </div>
                  </div>
                  <!-- END SAMPLE FORM PORTLET-->
              
						<!-- END SAMPLE TABLE PORTLET-->
					</div>
				</div>
				<!-- END PAGE CONTENT-->
			</div>
			<!-- END PAGE CONTAINER-->
		</div>
		<!-- END PAGE -->
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
	<div class="footer">
		2013 &copy; Mr. H2S. Giao diện quản trị.
		<div class="span pull-right">
			<span class="go-top"><i class="icon-angle-up"></i></span>
		</div>
	</div>
	<!-- END FOOTER -->
	<!-- BEGIN JAVASCRIPTS -->
	<!-- Load javascripts at bottom, this will reduce page load time -->
	<script src="assets/breakpoints/breakpoints.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/bootstrap/js/bootstrap-fileupload.js"></script>
	<script src="assets/js/jquery.blockui.js"></script>
	<!-- ie8 fixes -->
	<!--[if lt IE 9]>
	<script src="assets/js/excanvas.js"></script>
	<script src="assets/js/respond.js"></script>
	<![endif]-->
	<script type="text/javascript" src="assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="assets/bootstrap-daterangepicker/date.js"></script>
	<script type="text/javascript" src="assets/bootstrap-daterangepicker/daterangepicker.js"></script> 
	<script type="text/javascript" src="assets/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
	<script src="assets/js/app.js"></script>
	<script>
	  jQuery(document).ready(function() {
	     // initiate layout and plugins
	     App.init();
	  });
	</script>
</body>
<!-- END BODY -->
</html>