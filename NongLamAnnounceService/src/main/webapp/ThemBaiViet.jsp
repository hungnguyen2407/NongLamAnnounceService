<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
						<li class="active"><a class="" href="quantri.php?act=sanpham">Quản lý</a>
                        </li>
						<li><a class="" href="quantri.php?act=themsp">Thêm mới</a>
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
						<li class="active"><a class="" href="quantri.php?act=tintuc">Yêu cầu</a>
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
								<a href="index.html">Quản trị</a> 
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
                        <h4>Thêm tin</h4>
                     </div>
                     <div class="portlet-body form">
                        <!-- BEGIN FORM-->
                        <form action="#" class="form-horizontal" method="post" enctype="multipart/form-data" />
                           <div class="control-group">
                              <label class="control-label">Mã tin</label>
                              <div class="controls">
                                 <input type="text" class="span6 m-wrap" name="matin">
                              </div>
                           </div>
                           <div class="control-group">
                              <label class="control-label">Tiêu đề</label>
                              <div class="controls">
                                 <input type="text" class="span6 m-wrap" name="tieude">
                              </div>
                           </div>

                           <div class="control-group">
                              <label class="control-label">Ngày nhập</label>
                              <div class="controls">
                                 <div data-date-minviewmode="months" data-date-viewmode="years" data-date-format="mm/yyyy" data-date="102/2012" class="input-append date date-picker">
                                    <input type="text" value="02/2012" size="16" class="m-wrap m-ctrl-medium date-picker" name="ngaynhap"><span class="add-on"><i class="icon-calendar"></i></span>
                                 </div>
                              </div>
                           </div>
                           <div class="control-group">
                              <label class="control-label">Nội dung</label>
                              <div class="controls">
                                 <textarea name="noidung" class="span10 m-wrap" id="noidung"></textarea>
                                 <script type="text/javascript">

                                  var editor = CKEDITOR.replace( 'noidung',

                                    {

                                       filebrowserImageBrowseUrl : 'scripts/ckfinder/ckfinder.html?Type=Images',

                                       filebrowserImageUploadUrl : 'scripts/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Images',

                                       filebrowserFlashBrowseUrl : 'scripts/ckfinder/ckfinder.html?Type=Flash',

                                       filebrowserFlashUploadUrl : 'scripts/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Flash'

                                    });

                                 </script>
                              </div>
                           </div>
                           <div class="control-group">
                              <label class="control-label">Hình</label>
                              <div class="controls">
                                 <div data-provides="fileupload" class="fileupload fileupload-new">
                                    <div class="input-append">
                                       <div class="uneditable-input">
                                          <i class="icon-file fileupload-exists"></i> 
                                          <span class="fileupload-preview"></span>
                                       </div>
                                       <span class="btn btn-file">
                                       <span class="fileupload-new">Select file</span>
                                       <span class="fileupload-exists">Change</span>
                                       <input type="file" class="default" name="hinh">
                                       </span>
                                       <a data-dismiss="fileupload" class="btn fileupload-exists" href="#">Remove</a>
                                    </div>
                                 </div>
                              </div>
                           </div>
                           <p align="center">
                           	<input type="submit" name="themtin" value="Thêm tin"/>
                           </p>
                        </form>
                        <!-- END FORM-->           
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
</html>