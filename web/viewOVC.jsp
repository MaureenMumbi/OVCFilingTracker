<%-- 
    Document   : viewOVC
    Created on : Mar 11, 2015, 3:07:31 PM
    Author     : user
--%>



<%@page import="DBCONNECT.dbConn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />-->
<title>OVC FILING TRACKER </title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<!--[if IE 8]><link href="css/ie8.css" rel="stylesheet" type="text/css" /><![endif]-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>
<!--
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&amp;sensor=false"></script>-->
 
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>

<!--<script type="text/javascript" src="js/getChildDetails.js"></script>-->
                                                 
<script type="text/javascript" src="js/jquery.dataTables.js"></script>
<script type="text/javascript" src="js/dataTables.fnGetHiddenNodes.js"></script>
<script type="text/javascript" src="js/dataTables.fnGetFilteredNodes.js"></script>
<script type="text/javascript" src="js/plugins/tables/jquery.dataTables.editable.js"></script>
<script type="text/javascript" src="js/plugins/tables/jquery.jeditable.js"></script>   
<script type="text/javascript" src="js/files/functions.js"></script>
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

<script type="text/javascript" src="js/plugins/forms/jquery.uniform.js"></script>
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

<script type="text/javascript" src="js/files/bootstrap.min.js"></script>

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
//                          
//                          
//                          
//                          
//                          
//                          
//                          
//                          
//                          
//                          
//                          
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
<!--                                                 <script type="text/javascript">
   function callFunc(elem){
       alert( document.getElementById(elem).value);
    document.getElementById(elem).checked = elem.checked;
   }
    </script>                                             -->
<style>
    body{font-family: cambria; }
    .paginate_button {
   margin-left: 10px;     
      background: #fafafa;
  background: -moz-linear-gradient(top,  #ffffff 0%, #fafafa 100%);
  background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#ffffff), color-stop(100%,#fafafa));
  background: -webkit-linear-gradient(top,  #ffffff 0%,#fafafa 100%);
  background: -o-linear-gradient(top,  #ffffff 0%,#fafafa 100%);
  background: -ms-linear-gradient(top,  #ffffff 0%,#fafafa 100%);
  background: linear-gradient(top,  #ffffff 0%,#fafafa 100%);   
        
    }  
.datatable-footer { font-size: 11px;
  background: #fafafa;
  background: -moz-linear-gradient(top,  #ffffff 0%, #fafafa 100%);
  background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#ffffff), color-stop(100%,#fafafa));
  background: -webkit-linear-gradient(top,  #ffffff 0%,#fafafa 100%);
  background: -o-linear-gradient(top,  #ffffff 0%,#fafafa 100%);
  background: -ms-linear-gradient(top,  #ffffff 0%,#fafafa 100%);
  background: linear-gradient(top,  #ffffff 0%,#fafafa 100%);
}
</style>                                                       
</head>

<body  onload="getChildDetails();">
<%
//String fname="";
//String lname="";
//String username="";
//String accesslevel="";
//
//if(session.getAttribute("username")!=null){
//    if(session.getAttribute("fname")!=null){
//fname=session.getAttribute("fname").toString();
//}
//if(session.getAttribute("lname")!=null){
//lname=session.getAttribute("lname").toString();
//}
//username=session.getAttribute("username").toString();
//accesslevel=session.getAttribute("level").toString();
//
//}
//else{
////   response.sendRedirect("index.jsp");
//}


%>
	<!-- Fixed top -->
	<div id="top">
		<div class="fixed" style="height:60px;">
			<a href="index.html" title="" class="logo" style="padding-top:2px;"><img src="img/logo.png" alt="" style=" height:48px; padding-top:0px;" /></a>
                        <a><img src="img/logo2.png" alt="" style=" height:48px; margin-left: 250px" /></a>
			<ul class="top-menu">
				
				<li class="dropdown">
					<!--<a class="user-menu" data-toggle="dropdown"><span>     <b class="caret"></b></span></a>-->
					
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
						<div class="navbar"><div class="navbar-inner"><h6></h6></div></div>
			          
			        </div>
			        <!-- /sidebar user -->

			    

				    <!-- Main navigation -->
			        <ul class="navigation widget">
			              <%@include file="/menu.html"%>	
			        </ul>
			        <!-- /main navigation -->

		        </div>

		      

		    </div>
		</div>
		<!-- /sidebar -->

<!--                <input type="checkbox" onclick="callFunc(this)" >-->
		<!-- Content -->
		<div id="content">

		    <!-- Content wrapper -->
		    <div class="wrapper">

			    <!-- Breadcrumbs line -->
			    <div class="crumbs" style="margin-top: 10px;">
		            <ul id="breadcrumbs" class="breadcrumb"> 
		                <li><a href="index.html">Home</a></li>
		                <li class="active"><a href="viewentries.jsp" title="">View Entries</a></li>
		            </ul>
			        
		           
			    </div>
		

		    	<h5 class="widget-name"><i class="icon-th"></i>View Entries</h5>
                        
                        <%  if( session.getAttribute("chwid")!=null ){%>
     <input type="hidden" value="<%= session.getAttribute("chwid")%>" id="chwid" name="chwid" >	
     <input type="hidden" value="<%= session.getAttribute("Year")%>" id="Year" name="Year" >	
     <input type="hidden" value="<%= session.getAttribute("CBOID")%>" id="cboid" name="cboid" >
     <%
                        }
     %>
                <!-- Media datatable -->
<!--                <div class="widget">
                	<div class="navbar">
                    	<div class="navbar-inner">
                        	<h6>Entries</h6>
                           
                        </div>
                    </div>
                    <div class="table-overflow">
                        <form action="saveFileInfo" method="post">
                            <table  class="table table-striped table-bordered table-checks media-table" >
                         
                         // to add the table from the servlet 
<table id="viewdetails">
    
</table>
                        </table>
                        </form>
                    </div>
                </div>-->
                <!-- /media datatable -->
  <div class="widget">
                
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
                            
                            <div class="navbar"><div class="navbar-inner"><h6>View child filing details for :    &nbsp;&nbsp;&nbsp;  <font color="red" ><%=chwname+"  &nbsp;&nbsp;&nbsp;    "+ cboname +" &nbsp;&nbsp;&nbsp; "+ session.getAttribute("Year")%></font></h6></div></div>
                    <div class="table-overflow">
                        <div  class="control-group">
                        <form action="saveFileInfo" method="post" name="formname" > 
<!--                            <p></p>                      -->
<!--                            <div id="">-->
<table style="table-layout: fixed; width:100%;" class="table table-striped table-bordered dataTable control-group" id="datatable" >                 
    <tr><td><i style="margin-left: 450px; margin-top: 200px;">  loading data...<img src="img/utube.gif"></i></td></tr>
</table>  
<!--                            </div>-->
<!--                           <thead id="view1">
                           
                           </thead>
                           <tbody id="view">
                                                       

                           </tbody>-->

                      
                             </form>
                            </div>
                    </div>
                </div>
                <!-- /default datatable -->
<!--                <div class="row-fluid">
                	<div class="span6">

			

                	
                </div>



		    </div>-->
		    <!-- /content wrapper -->

		</div>
		<!-- /content -->

	</div>
	<!-- /content container -->


	<!-- Footer -->
	<div id="footer">
		<div class="copyrights">&copy; USAID: APHIAplus</div>
		
	</div>
	<!-- /footer -->
       
    
</body>
       
<!--<script>
    
              getChildDetails();   
</script>-->







           
</html>

