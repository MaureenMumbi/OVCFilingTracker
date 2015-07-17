<%-- 
    Document   : index
    Created on : Mar 11, 2015, 12:34:05 PM
    Author     : user
--%>


<%@page import="DBCONNECT.dbConn"%>
<%@page import="FILING.decryptor"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />-->
<title>OVC FILING TRACKER </title>
<link rel="shortcut icon" href="img/logo_1.png"/>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<!--[if IE 8]><link href="css/ie8.css" rel="stylesheet" type="text/css" /><![endif]-->
<!--[if IE 9]><link href="css/ie9.css" rel="stylesheet" type="text/css" /><![endif]-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>

<script type="text/javascript" src="js/plugins/forms/jquery.uniform.min.js"></script>

<script type="text/javascript" src="js/files/bootstrap.min.js"></script>

<script type="text/javascript" src="js/files/login.js"></script>

</head>

<body class="no-background">

	<!-- Fixed top -->
	<div id="top">
	<div class="fixed" style="height:60px;">
			<a href="index.html" title="" class="logo" style="padding-top:2px;"><img src="img/logo.png" alt="" style=" height:48px; padding-top:0px;" /></a>
                        <a><img src="img/logo1.png" alt="" style=" height:48px; margin-left: 250px" /></a>
			<ul class="top-menu">
				<li class="dropdown">
					<!--<a class="login-top" data-toggle="dropdown"></a>-->
					
				</li>
			</ul>
		</div>
	</div>
	<!-- /fixed top -->


    <!-- Login block -->
    <div class="login">
        <div class="navbar">
            <div class="navbar-inner">
                <h6><i class="icon-user"></i>Login page</h6>
                <div class="nav pull-right">
                    <a href="#" class="dropdown-toggle navbar-icon" data-toggle="dropdown"><i class="icon-cog"></i></a>
                                  </div>
            </div>
        </div>
        <div class="well">
            <form action="login" class="row-fluid">
                <div class="control-group">
                    <label class="control-label">Username</label>
                    <div class="controls"><input class="span12" type="text"  name="username" placeholder="username" /></div>
                </div>
                
                <div class="control-group">
                    <label class="control-label">Password:</label>
                    <div class="controls"><input class="span12" type="password" name="password" placeholder="password" /></div>
                </div>

               

                <div class="login-btn"><input type="submit" value="Log me in" class="btn btn-danger btn-block" /></div>
            </form>
        </div>
    </div>
    <!-- /login block -->
<%
     dbConn conn = new dbConn("1");
     String usernames="";
     String pwds="";
String getPasword="select * from Users";
conn.rs = conn.state.executeQuery(getPasword);
while(conn.rs.next()){
usernames= conn.rs.getString(1);
pwds=conn.rs.getString(2);
System.out.println(pwds);

 decryptor myEncryptor= new decryptor();
   String stringToEncrypt=pwds;
        //String encrypted=pwds;
        String decrypted=myEncryptor.decrypt(pwds);
        System.out.println(decrypted +"   "+usernames);

}
%>

	<!-- Footer -->
	<div id="footer">
		<div class="copyrights">&copy;  USAID:APHIAPLUS.</div>
		<ul class="footer-links">
<!--			<li><a href="" title=""><i class="icon-cogs"></i>Contact admin</a></li>
			<li><a href="" title=""><i class="icon-screenshot"></i>Report bug</a></li>-->
		</ul>
	</div>
	<!-- /footer -->

</body>
</html>
