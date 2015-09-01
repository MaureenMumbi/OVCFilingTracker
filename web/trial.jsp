<%-- 
    Document   : trial
    Created on : May 29, 2015, 9:05:51 AM
    Author     : user
--%>

<%@page import="DBCONNECT.dbConn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>Pannonia - premium responsive admin template by Eugene Kopyov</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<!--[if IE 8]><link href="css/ie8.css" rel="stylesheet" type="text/css" /><![endif]-->
<!--<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>-->

<!--<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&amp;sensor=false"></script>-->
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>

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

<script type="text/javascript" src="js/plugins/tables/jquery.dataTables.min.js"></script>

<script type="text/javascript" src="js/files/bootstrap.min.js"></script>

<script type="text/javascript" src="js/files/functions.js"></script>
  <script type="text/javascript">
                            function getChildDetails(){
                  
                       var chwid = document.getElementById("chwid").value;   
                       var year = document.getElementById("Year").value;   
                       var cboid = document.getElementById("cboid").value;   
//                   alert(cboid);

                if(document.getElementById("chwid").value!=""){  
                
                    $.ajax({  
                        url:"loadclients?chwid="+chwid+"&year="+year+"&cboid="+cboid,
                        type:'post',  
                        dataType: 'json',  
                        success: function(data) {
                       
                            document.getElementById("datatable").innerHTML=data.view;
                     
                        //   alert(chwid);
//				$('#datatable').dataTable().makeEditable({
//                              "aoColumns": [ null,null,null ]    
//                          
//                       	});
			 oTable = $('#datatable').dataTable();	
			$('form[name=formname]').submit(function(){

                           //replace 'yourformsnameattribute' with the name of your form
//  $(oTable.fnGetHiddenNodes()).find('input:checkbox').appendTo(this);
  $(oTable.fnGetHiddenNodes()).attr('checked',this.checked).appendTo(this).css("visibility","hidden");

  ////this is what passes any hidden nodes to your form when a user clicks SUBMIT on your FORM
} );
 
//$('.checkall').click( function() { //this is the function that will mark all your checkboxes when the input with the .checkall class is clicked
//    $('input', oTable.fnGetFilteredNodes()).attr('checked',this.checked); //note it's calling fnGetFilteredNodes() - this is so it will mark all nodes whether they are filtered or not
//} );
                        }
                    }); 
                
                }//end of if
                
                            }
                
                                             
//                   $(document).ready(function () {
//        oTable = $('#datatable').dataTable();
//} );
                  
                   
                                                 </script>
</head>

<body onload="getChildDetails();">

	<!-- Fixed top -->
	<div id="top">
		<div class="fixed">
			<!--<a href="index.jsp" title="" class="logo"><img src="img/logo.png" alt="" /></a>-->
			<ul class="top-menu">
				<li><a class="fullview"></a></li>
				<li><a class="showmenu"></a></li>
				<li><a href="#" title="" class="messages"><i class="new-message"></i></a></li>
				<li class="dropdown">
					<a class="user-menu" data-toggle="dropdown"><img src="img/userpic.png" alt="" /><span>Howdy, Eugene! <b class="caret"></b></span></a>
					<ul class="dropdown-menu">
						<li><a href="#" title=""><i class="icon-user"></i>Profile</a></li>
						<li><a href="#" title=""><i class="icon-inbox"></i>Messages<span class="badge badge-info">9</span></a></li>
						<li><a href="#" title=""><i class="icon-cog"></i>Settings</a></li>
						<li><a href="#" title=""><i class="icon-remove"></i>Logout</a></li>
					</ul>
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
		        <ul class="tabs-nav two-items">
		            <li><a href="#general" title=""><i class="icon-reorder"></i></a></li>
		            <li><a href="#stuff" title=""><i class="icon-cogs"></i></a></li>
		        </ul>

		        <div id="general">

			        <!-- Sidebar user -->
			        <div class="sidebar-user widget">
						<div class="navbar"><div class="navbar-inner"><h6>Wazzup, Eugene!</h6></div></div>
			            <a href="#" title="" class="user"><img src="http://placehold.it/210x110" alt="" /></a>
			            <ul class="user-links">
			            	<li><a href="" title="">New users<strong>+12</strong></a></li>
			            	<li><a href="" title="">New orders<strong>+156</strong></a></li>
			            	<li><a href="" title="">New messages<strong>+45</strong></a></li>
			            </ul>
			        </div>
			        <!-- /sidebar user -->

			        <div class="general-stats widget">
				        <ul class="head">
				        	<li><span>Users</span></li>
				        	<li><span>Orders</span></li>
				        	<li><span>Visits</span></li>
				        </ul>
				        <ul class="body">
				        	<li><strong>116k+</strong></li>
				        	<li><strong>1290</strong></li>
				        	<li><strong>554</strong></li>
				        </ul>
				    </div>

				    <!-- Main navigation -->
			        <ul class="navigation widget">
			            <li><a href="index.jsp" title=""><i class="icon-home"></i>Dashboard</a></li>
			            <li><a href="#" title="" class="expand"><i class="icon-reorder"></i>Form elements<strong>3</strong></a>
			                <ul>
			                    <li><a href="forms.html" title="">Form components</a></li>
			                    <li><a href="wysiwyg.html" title="">WYSIWYG editor</a></li>
			                    <li><a href="form_wizards.html" title="">Wizards</a></li>
			                </ul>
			            </li>
			            <li><a href="#" title="" class="expand"><i class="icon-tasks"></i>Components<strong>4</strong></a>
			                <ul>
			                    <li><a href="components.html" title="">Content components</a></li>
			                    <li><a href="content_grid.html" title="">Content grid</a></li>
			                    <li><a href="blank.html" title="">Blank page</a></li>
			                </ul>
			            </li>
			            <li><a href="media.html" title=""><i class="icon-picture"></i>Media</a></li>
			            <li><a href="icons.html" title=""><i class="icon-th"></i>Icons</a></li>
			            <li><a href="charts.html" title=""><i class="icon-signal"></i>Charts &amp; graphs</a></li>
			            <li><a href="invoice.html" title=""><i class="icon-copy"></i>Invoice</a></li>
			            <li class="active"><a href="tables.html" title=""><i class="icon-table"></i>Tables</a></li>
			            <li><a href="#" title="" class="expand"><i class="icon-warning-sign"></i>Error pages<strong>6</strong></a>
			                <ul>
			                    <li><a href="403.html" title="">403 page</a></li>
			                    <li><a href="404.html" title="">404 page</a></li>
			                    <li><a href="405.html" title="">405 page</a></li>
			                    <li><a href="500.html" title="">500 page</a></li>
			                    <li><a href="503.html" title="">503 page</a></li>
			                    <li><a href="offline.html" title="">Offline page</a></li>
			                </ul>
			            </li>
			            <li><a href="typography.html" title=""><i class="icon-text-height"></i>Typography</a></li>
			            <li><a href="calendar.html" title=""><i class="icon-calendar"></i>Calendar</a></li>
			            <li><a href="file_management.html" title=""><i class="icon-cogs"></i>File management</a></li>
	                    <li><a href="#" title="" class="expand"><i class="icon-indent-right"></i>Menu levels<strong>3</strong></a>
			                <ul>
			                    <li><a href="#" title="">Link</a></li>
			                    <li><a href="#" title="" class="expand">Link with submenu</a>
					                <ul>
					                    <li><a href="#" title="">Lorem ipsum</a></li>
					                    <li><a href="#" title="">Dolor sit amet</a></li>
					                </ul>
			                    </li>
			                    <li><a href="#" title="">Link</a></li>
			                </ul>
	                    </li>
			            <li><a href="#" title="" class="expand"><i class="icon-sitemap"></i>Page layouts<strong>3</strong></a>
			                <ul>
			                    <li><a href="no_sidebar_tabs.html" title="">No sidebar tabs</a></li>
			                    <li><a href="no_action_tabs.html" title="">No action tabs</a></li>
			                    <li><a href="actions_on_top.html" title="">Action tabs on top</a></li>
			                    <li><a href="no_breadcrumbs.html" title="">No breadcrumbs line</a></li>
			                </ul>
			            </li>
			        </ul>
			        <!-- /main navigation -->

		        </div>


		    </div>
		</div>
		<!-- /sidebar -->


		<!-- Content -->
		<div id="content">

		    <!-- Content wrapper -->
		    <div class="wrapper">

			  
			    <!-- /breadcrumbs line -->

			    <!-- Page header -->
			    <div class="page-header">
			    	
			    </div>
			    <!-- /page header -->

			    <!-- Action tabs -->
			   

		    


		   

                <%  if( session.getAttribute("chwid")!=null ){%>
     <input type="hidden" value="<%= session.getAttribute("chwid")%>" id="chwid" name="chwid" >	
     <input type="hidden" value="<%= session.getAttribute("Year")%>" id="Year" name="Year" >	
     <input type="hidden" value="<%= session.getAttribute("CBOID")%>" id="cboid" name="cboid" >
     <%
                        }
     %>
	       
	
                            <%
                     dbConn conn = new dbConn("1");
                     
                     String chwname="";
                   
                             String getchwid="select * from CHW where CHWID='"+session.getAttribute("chwid")+"'";
  conn.rs = conn.state.executeQuery(getchwid);
  while(conn.rs.next()){
chwname=conn.rs.getString("FirstName") +" "+conn.rs.getString("MiddleName")+" "+conn.rs.getString("Surname")+"-"+conn.rs.getString("ID");
  }
  String cboname="";
   String getcbo= "select * from CBO where CBOID='"+session.getAttribute("CBOID")+"'";
   conn.rs2= conn.state2.executeQuery(getcbo);
   while(conn.rs2.next()){
   cboname= conn.rs2.getString("CBO");
   }
   
    
   
        
      
                            
                            
                            
                            %>
                                                    
              


                <h5 class="widget-name"><i class="icon-columns"></i>Custom tables</h5>
	                                               
                <!-- Default datatable -->
                <div class="widget">
                	<div class="navbar"><div class="navbar-inner"><h6>Default datatable</h6></div></div>
                    <div class="table-overflow">
                        <table class="table table-striped table-bordered" id="datatable">
<!--                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Username</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Larry</td>
                                    <td>the Bird</td>
                                    <td>@twitter</td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Larry</td>
                                    <td>the Bird</td>
                                    <td>@twitter</td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Larry</td>
                                    <td>the Bird</td>
                                    <td>@twitter</td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Larry</td>
                                    <td>the Bird</td>
                                    <td>@twitter</td>
                                </tr>
                            </tbody>-->
                        </table>
                    </div>
                </div>
                <!-- /default datatable -->
	                        	                        
                <!-- Table with footer -->
               

		    </div>
		    <!-- /content wrapper -->

		</div>
		<!-- content -->

	</div>
	<!-- /content container -->


	<!-- Footer -->
	<div id="footer">
		<div class="copyrights">&copy;  Brought to you by Eugene Kopyov.</div>
		<ul class="footer-links">
			<li><a href="" title=""><i class="icon-cogs"></i>Contact admin</a></li>
			<li><a href="" title=""><i class="icon-screenshot"></i>Report bug</a></li>
		</ul>
	</div>
	<!-- /footer -->

</body>
</html>
