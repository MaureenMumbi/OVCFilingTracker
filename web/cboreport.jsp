<%-- 
    Document   : cboreport
    Created on : Mar 20, 2015, 8:14:09 AM
    Author     : user
--%>


<%@page import="DBCONNECT.dbConn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>OVC FILING TRACKER </title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<!--[if IE 8]><link href="css/ie8.css" rel="stylesheet" type="text/css" /><![endif]-->
<link href='css/fonts.css' rel='stylesheet' type='text/css'>
<link rel="shortcut icon" href="img/logo_1.png"/>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>


<script type="text/javascript" src="js/plugins/charts/jquery.sparkline.min.js"></script>

<script type="text/javascript" src="js/plugins/ui/jquery.easytabs.min.js"></script>
<script type="text/javascript" src="js/plugins/ui/jquery.collapsible.min.js"></script>
<script type="text/javascript" src="js/plugins/ui/jquery.mousewheel.js"></script>
<script type="text/javascript" src="js/plugins/ui/jquery.bootbox.min.js"></script>
<script type="text/javascript" src="js/plugins/ui/jquery.colorpicker.js"></script>
<script type="text/javascript" src="js/plugins/ui/jquery.timepicker.min.js"></script>
<script type="text/javascript" src="js/plugins/ui/jquery.jgrowl.js"></script>
<script type="text/javascript" src="js/plugins/ui/jquery.fancybox.js"></script>
<script type="text/javascript" src="js/plugins/ui/jquery.fullcalendar.min.js"></script><!--
--><script type="text/javascript" src="js/plugins/ui/jquery.elfinder.js"></script><!--

--><script type="text/javascript" src="js/plugins/uploader/plupload.js"></script>
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
        <script type="text/javascript">
   
// a function that filters the districts in the passed county as per the county drop down.
// a function that filters the districts in the passed county as per the county drop down.
    
function filter_district(countys){
//    alert(index);
//      var cnt="county1_"+i;
//          var dist = "district"+districts;
         var county=countys;
       
//         alert(distr);
//    var t=document.getElementById("county_"+index);
    var dist =county.options[county.selectedIndex].value;   

var xmlhttp;  
  
    
if (dist=="")
{
//filter the districts    



document.getElementById("District").innerHTML="<option value=\"\">Choose District</option>";
return;
}
if (window.XMLHttpRequest)
{// code for IE7+, Firefox, Chrome, Opera, Safari
xmlhttp=new XMLHttpRequest();
}
else
{// code for IE6, IE5
xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
}
xmlhttp.onreadystatechange=function()
{
if (xmlhttp.readyState==4 && xmlhttp.status==200)
{

document.getElementById("District").innerHTML=xmlhttp.responseText;


}
}

xmlhttp.open("POST","/OVCFilingTracker/districtselector?district="+dist,true);

xmlhttp.send();
    
   
  
 }  
function filter_cbo(district){
//    alert(index);
//      var cnt="county1_"+i;
//          var dist = "district"+districts;
         var distr=district;
       
//         alert(distr);
//    var t=document.getElementById("county_"+index);
    var dist =distr.options[distr.selectedIndex].value;   

var xmlhttp;  
  
   
if (dist=="")
{
//filter the districts    



document.getElementById("CBO").innerHTML="<option value=\"\">Choose cbo</option>";
return;
}
if (window.XMLHttpRequest)
{// code for IE7+, Firefox, Chrome, Opera, Safari
xmlhttp=new XMLHttpRequest();
}
else
{// code for IE6, IE5
xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
}
xmlhttp.onreadystatechange=function()
{
if (xmlhttp.readyState==4 && xmlhttp.status==200)
{
document.getElementById("CBO").innerHTML=xmlhttp.responseText;
}
}

xmlhttp.open("POST","/OVCFilingTracker/filtercbo?district="+dist,true);

xmlhttp.send();
    
   
  
 }  

</script> 
</head>

<body>
<!-- Fixed top -->
	<div id="top">
		<div class="fixed" style="height:60px;">
			<a href="index.html" title="" class="logo" style="padding-top:2px;"><img src="img/logo.png" alt="" style=" height:48px; padding-top:0px;" /></a>
                        <a><img src="img/logo2.png" alt="" style=" height:48px; margin-left: 250px" /></a>
			<ul class="top-menu">
<!--				<li><a class="fullview"></a></li>
				<li><a class="showmenu"></a></li>
				<li><a href="#" title="" class="messages"><i class="new-message"></i></a></li>-->
				<li class="dropdown">
					<!--<a class="user-menu" data-toggle="dropdown"><span> <b class="caret"></b></span></a>-->
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
						<div class="navbar"><div class="navbar-inner"><h6>Hi</h6></div></div>
			          
			        </div>
			        <!-- /sidebar user -->

			      

				    <!-- Main navigation -->
			        <ul class="navigation widget">
			            <%@include file="/menu.html"%>	
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
			    <div class="crumbs" style="margin-top: 10px;">
		            <ul id="breadcrumbs" class="breadcrumb"> 
<!--		                <li><a href="index.html">Dashboard</a></li>
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
	            <h5 class="widget-name"><i class="icon-align-justify"></i>New Entries</h5>
  <%
                            if (session.getAttribute("replytext") != null)  { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("replytext")%>',
                        layout: 'center',
                        type: 'Success'
 
                       
                     });
                    
                </script> <%
                
                session.removeAttribute("replytext");
                            }

                        %>
	            <form class="form-horizontal" method="post" id="validate" action="cboreport">
					<fieldset>

						<!-- General form elements -->
						<div class="widget row-fluid">
						    <div class="navbar">
						        <div class="navbar-inner">
						            <h6>Select the required parameters</h6>
<!--	                                <ul class="navbar-icons">
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
						    	</div>-->
						       <div class="control-group">
	                                        <label class="control-label">County</label>
	                                        <div class="controls">
	                                            <select onchange="filter_district(this);" data-placeholder="Choose a County..." class="select" tabindex="2">
	                                                <option value=""></option> 
                                                        <% 
                            
                           
                            dbConn conn = new dbConn("1");
            System.out.println("Database before is "+conn.dbsetup[1]);
            String getcounty="select * from county";
                        conn.rs = conn.state.executeQuery(getcounty);
                        while(conn.rs.next()){
                                                        
                                                        
                                                        %>
	                                                <option value="<%= conn.rs.getString("CountyID")%>"><%= conn.rs.getString("County")%></option> 
	                                              <%} %> 
	                                            </select>
	                                        </div>             
	                                    </div>
						       <div class="control-group">
	                                        <label class="control-label">District</label>
	                                        <div class="controls">
	                                             <select multiple id="District"  class=" validate[required] select "   name="District"  data-placeholder="Choose a District..."  tabindex="2">
                                 <option value="">Choose District Name</option>  

                                 </select>
	                                        </div>             
	                                    </div>
<!--						       <div class="control-group">
	                                        <label class="control-label">CBO</label>
	                                        <div class="controls">
	                                             <select   id="CBO"  name="cbo"  data-placeholder="Choose a CBO..." class="select" tabindex="2">
                                 <option value="">Choose CBO Name</option>  

                                 </select>
	                                        </div>             
	                                    </div>-->
					  <div class="control-group">
	                                        <label class="control-label">Year</label>
	                                        <div class="controls">
	                                             <select id="Year"  name="Year"  data-placeholder="Choose Year..." class="select" tabindex="2" >
                                                                    <option value="">Choose Year</option>  
                                                                    <option value="2010">2010</option>  
                                                                    <option value="2011">2011</option>  
                                                                    <option value="2012">2012</option>  
                                                                    <option value="2013">2013</option>  
                                                                    <option value="2014">2014</option>  
                                                                    <option value="2015">2015</option>  
                                                     </select>
	                                        </div>             
	                                    </div>	     
                                                       
                                             
                                          <div class="form-actions">
                                                    <button class="btn btn-primary" type="submit">GENERATE REPORT</button>
	                                       
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
		<div class="copyrights">&copy; USAID:APHIAplus.</div>
		
	</div>
	<!-- /footer -->


</body>
</html>

