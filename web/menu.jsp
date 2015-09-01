<%-- 
    Document   : menu
    Created on : Sep 1, 2015, 12:10:54 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <ul class="navigation widget">
			            <li><a href="selectParameters.jsp" title=""><i class="icon-home"></i>Home</a></li>
			            <li class="active"><a href="#" title="" class="expand" id="current"><i class="icon-reorder"></i>FORM ENTRY</a>
			                <ul>
			                    <li><a href="selectParameters.jsp" title="">Data Entry</a></li>
<!--			                    <li><a href="wysiwyg.html" title="">WYSIWYG editor</a></li>
			                    <li><a href="form_wizards.html" title="" class="current">Wizards</a></li>-->
			                </ul>
			            </li>
			            <li><a href="#" title="" class="expand"><i class="icon-tasks"></i>Reports</a>
			                <ul>
			                    <li><a href="cbodetails.jsp" title="">OVC DETAILS REPORT</a></li>
			                    <li><a href="cboreport.jsp" title="">CBO REPORT</a></li>
			                    <li><a href="countyreport.jsp" title="">COUNTY REPORT </a></li>
			                </ul>
			            </li>
                                    <% if(session.getAttribute("level")!=null){
                                        if(session.getAttribute("level").toString().equals("0")){
                                            
    %>
			         <li><a title="" href="registerUser.jsp"><i class="icon-user"></i>Register User</a></li>
			         <%}}%>
                                 <li><a title="" href="logout.jsp"><i class="icon-remove"></i>Logout</a></li>
			        
			        </ul>
    </body>
</html>

