<%-- 
    Document   : registerUser
    Created on : Mar 10, 2015, 2:24:56 PM
    Author     : Maureen
--%>

<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>OVC FILING TRACKER </title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<!--[if IE 8]><link href="css/ie8.css" rel="stylesheet" type="text/css" /><![endif]-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>
<link rel="shortcut icon" href="img/logo_1.png"/>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&amp;sensor=false"></script>

<script type="text/javascript" src="js/plugins/charts/jquery.sparkline.min.js"></script>

<script type="text/javascript" src="js/plugins/ui/jquery.easytabs.min.js"></script>
<script type="text/javascript" src="js/plugins/ui/jquery.collapsible.min.js"></script>
<script type="text/javascript" src="js/plugins/ui/jquery.mousewheel.js"></script>
<script type="text/javascript" src="js/plugins/ui/jquery.bootbox.min.js"></script>
<script type="text/javascript" src="js/plugins/ui/jquery.colorpicker.js"></script>
<script type="text/javascript" src="js/plugins/ui/jquery.timepicker.min.js"></script>
<script type="text/javascript" src="js/plugins/ui/jquery.jgrowl.js"></script>
<script type="text/javascript" src="js/plugins/ui/jquery.fancybox.js"></script>
<script type="text/javascript" src="js/plugins/ui/jquery.fullcalendar.min.js"></script>
<script type="text/javascript" src="js/plugins/ui/jquery.elfinder.js"></script>

<script type="text/javascript" src="js/plugins/uploader/plupload.js"></script>
<script type="text/javascript" src="js/plugins/uploader/plupload.html4.js"></script>
<script type="text/javascript" src="js/plugins/uploader/plupload.html5.js"></script>
<script type="text/javascript" src="js/plugins/uploader/jquery.plupload.queue.js"></script>

<script type="text/javascript" src="js/plugins/forms/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/plugins/forms/jquery.autosize.js"></script>
<script type="text/javascript" src="js/plugins/forms/jquery.inputlimiter.min.js"></script>
<script type="text/javascript" src="js/plugins/forms/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="js/plugins/forms/jquery.inputmask.js"></script>
<script type="text/javascript" src="js/plugins/forms/jquery.select2.min.js"></script>
<script type="text/javascript" src="js/plugins/forms/jquery.listbox.js"></script>
<script type="text/javascript" src="js/plugins/forms/jquery.validation.js"></script>
<script type="text/javascript" src="js/plugins/forms/jquery.validationEngine-en.js"></script>
<script type="text/javascript" src="js/plugins/forms/jquery.form.wizard.js"></script>
<script type="text/javascript" src="js/plugins/forms/jquery.form.js"></script>

<script type="text/javascript" src="js/globalize/globalize.js"></script>
<script type="text/javascript" src="js/globalize/globalize.culture.de-DE.js"></script>
<script type="text/javascript" src="js/globalize/globalize.culture.ja-JP.js"></script>

<script type="text/javascript" src="js/plugins/tables/jquery.dataTables.min.js"></script>

<script type="text/javascript" src="js/files/bootstrap.min.js"></script>

<script type="text/javascript" src="js/files/functions.js"></script>
<script type="text/javascript" src="js/noty/jquery.noty.js"></script>

 
        <script type="text/javascript" src="js/noty/layouts/top.js"></script>
        <script type="text/javascript" src="js/noty/layouts/center.js"></script>
        <!-- You can add more layouts if you want -->

        <script type="text/javascript" src="js/noty/themes/default.js"></script>
    
</head>

<body>
<%
String fname="";
String lname="";
String username="";
if(session.getAttribute("fname")!=null){
fname=session.getAttribute("fname").toString();
}
if(session.getAttribute("lname")!=null){
lname=session.getAttribute("lname").toString();
}
if(session.getAttribute("username")!=null){
username=session.getAttribute("username").toString();
}
else{
//   response.sendRedirect("index.jsp");
}


%>
	<!-- Fixed top -->
	<div id="top">
		<div class="fixed">
		<a href="index.jsp" title="" class="logo" style="padding-top:2px;"><img src="img/logo.png" alt="" style=" height:48px; padding-top:0px;" /></a>
                        <a><img src="img/logo2.png" alt="" style=" height:48px; margin-left: 250px" /></a>
			<ul class="top-menu">
<!--				<li><a class="fullview"></a></li>
				<li><a class="showmenu"></a></li>
				<li><a href="#" title="" class="messages"><i class="new-message"></i></a></li>-->
				<li class="dropdown">
					<!--<a class="user-menu" data-toggle="dropdown"><span>Howdy,  <%= fname+"   "+lname %>  ! <b class="caret"></b></span></a>-->
<!--					<ul class="dropdown-menu">
						<li><a href="#" title=""><i class="icon-user"></i>Profile</a></li>
						<li><a href="#" title=""><i class="icon-inbox"></i>Messages<span class="badge badge-info">9</span></a></li>
						<li><a href="#" title=""><i class="icon-cog"></i>Settings</a></li>
						<li><a href="#" title=""><i class="icon-remove"></i>Logout</a></li>
					</ul>-->
				</li>
			</ul>
		</div>
	</div>
	<!-- /fixed top -->


	<!-- Content container -->
	<div id="container">

		<!-- Sidebar -->
		<div id="sidebar">

			<div class="sidebar-tabs">
<!--		        <ul class="tabs-nav two-items">
		            <li><a href="#general" title=""><i class="icon-reorder"></i></a></li>
		            <li><a href="#stuff" title=""><i class="icon-cogs"></i></a></li>
		        </ul>-->

		        <div id="general">

			        <!-- Sidebar user -->
			        <div class="sidebar-user widget">
						<div class="navbar"><div class="navbar-inner"><h6>Hi, <%= fname+"   "+lname %> !</h6></div></div>
			          
			        </div>
			        <!-- /sidebar user -->

			      

				    <!-- Main navigation -->
			        <ul class="navigation widget">
			            <%@include file="/menu.jsp"%>	
			        </ul>
			        <!-- /main navigation -->

		        </div>

		        <div id="stuff">

			  
			       

			     

		        </div>

		    </div>
		</div>
		<!-- /sidebar -->

		<!-- Content -->
		<div id="content">

			<!-- Content wrapper -->
		    <div class="wrapper">

			    <!-- Breadcrumbs line -->
			    <div class="crumbs">
		            <ul id="breadcrumbs" class="breadcrumb" style="margin-top: 10px;"> 
<!--		                <li><a href="index.jsp">Dashboard</a></li>
		                <li><a href="forms.html">Form elements</a></li>
		                <li class="active"><a href="forms.html" title="">Form components</a></li>-->
		            </ul>
			        
		           
			    </div>
			    <!-- /breadcrumbs line -->

			    <!-- Page header -->
<!--			    <div class="page-header">
			    	<div class="page-title">
				    	<h5>New Entries </h5>
				    	<span>Enter data in the fields provided </span>
			    	</div>

			    
			    </div>-->
			    <!-- /page header -->

			    <!-- Action tabs -->
<!--			    <div class="actions-wrapper">
				    <div class="actions">

				    

				    	

				  
				    </div>
				</div>-->
			    <!-- /action tabs -->

		    	<!-- Search widget -->
		    	
		    	<!-- /search widget -->


		    	<!-- Basic inputs -->
	            <h5 class="widget-name"><i class="icon-align-justify"></i>Register User</h5>
  <%
                            if (session.getAttribute("useradded") != null)  { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("useradded")%>',
                        layout: 'center',
                        type: 'Success'
 
                       
                     });
                    
                </script> <%
                
                session.removeAttribute("useradded");
                            }

                        %>
	            <form class="form-horizontal" method="post" id="validate" action="registerUser">
					<fieldset>

						<!-- General form elements -->
						<div class="widget row-fluid">
						    <div class="navbar">
<!--						        <div class="navbar-inner">
						            <h6>Full size inputs</h6>
	                                <ul class="navbar-icons">
	                                    <li><a href="#" class="tip" title="Add new option"><i class="icon-plus"></i></a></li>
	                                    <li><a href="#" class="tip" title="View statistics"><i class="icon-reorder"></i></a></li>
	                                    <li><a href="#" class="tip" title="Parameters"><i class="icon-cogs"></i></a></li>
	                                </ul>-->
						        </div>
						    </div>

						    <div class="well">

<!--						    	<div class="alert margin">
						    		<button type="button" class="close" data-dismiss="alert">×</button>
						    		will be for alerts 
						    	</div>
                                                      -->
         
						      
<!--  <div class="control-group">
	                                <label class="control-label">UserID <span class="text-error">*</span></label>
	                                <div class="controls">
	                                    <input type="text" value="" readonly class="validate[required] span12" name="userid" id="req"/>
	                                </div>
	                            </div>-->
<!--  <div class="control-group">
	                                <label class="control-label">First name <span class="text-error">*</span></label>
	                                <div class="controls">
	                                    <input type="text" class="validate[required] span12" name="f_name" id="req"/>
	                                </div>
	                            </div>
  <div class="control-group">
	                                <label class="control-label">Last name <span class="text-error">*</span></label>
	                                <div class="controls">
	                                    <input type="text" class="validate[required] span12" name="m_name" id="req"/>
	                                </div>
	                            </div>-->
  <div class="control-group">
	                                <label class="control-label">User name <span class="text-error">*</span></label>
	                                <div class="controls">
	                                    <input type="text" class="validate[required] span12" name="username" id="req"/>
	                                </div>
	                            </div>
<!--  <div class="control-group">
	                                <label class="control-label">Phone No. <span class="text-error">*</span></label>
	                                <div class="controls">
	                                  
                                            <input type="text"  name="phoneno" class="validate[required] span12" data-mask="0799-999-999">
                                                        <span class="help-block">0799-999-999</span>
                                           
	                                </div>
-->	                            
<!--                                                    </div>
                                                        <div class="control-group">
	                                <label class="control-label">Email address: <span class="text-error">*</span></label>
	                                <div class="controls">
	                                    <input type="text" value="" class="validate[required,custom[email]] span12" name="emailaddress" id="emailValid"/>
	                                </div>
	                            </div>-->
	                        
	                            <div class="control-group">
	                                <label class="control-label">Password: <span class="text-error">*</span></label>
	                                <div class="controls">
	                                    <input type="password" value="" class="validate[required] span12" name="password" id="password1" />
	                                </div>
	                            </div>
	                        
	                            <div class="control-group">
	                                <label class="control-label">Repeat password: <span class="text-error">*</span></label>
	                                <div class="controls">
	                                    <input type="password" value="" class="validate[required,equals[password1]] span12" name="password2" id="password2" />
	                                </div>
	                            </div>
	                        
<!--	                             <div class="control-group">
	                                <label class="control-label">Access Level  <span class="text-error">*</span></label>
	                                <div class="controls">
	                                  <select class="validate[required] span12" name="userlevel" id="req"/>
                                          <option value=""></option>
                                          <option value="Admin">Admin</option>
                                          <option value="User">User</option>
                                        
                                        </select>
	                                </div>
	                            </div>-->
	                        <div class="form-actions">
	                                        <button class="btn btn-primary" type="submit">Submit</button>
	                                        <!--<button class="btn btn-danger" type="button">Cancel</button>-->
	                                        <button class="btn" type="reset">Reset</button>
<!--	                                        <span class="help-inline">Left aligned buttons</span>-->
	                                    </div>
	                            
					</fieldset> 

					
				</form>
				<!-- /basic inputs -->


		    </div>
		    <!-- /content wrapper -->

		</div>
		<!-- /content -->

	</div>
	<!-- /content container -->


	<!-- Footer -->
	<div id="footer">
		<div class="copyrights">&copy;  USAID/APHIAplus.</div>
<!--		<ul class="footer-links">
			<li><a href="" title=""><i class="icon-cogs"></i>Contact admin</a></li>
			<li><a href="" title=""><i class="icon-screenshot"></i>Report bug</a></li>
		</ul>-->
	</div>
	<!-- /footer -->


</body>
</html>


