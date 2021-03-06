<%-- 
    Document   : index
    Created on : Aug 5, 2013, 9:03:18 PM
    Author     : SIXTYFOURBIT
--%>


<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>set up the database</title>
        <link rel="stylesheet" type="text/css" href="css/Main.css"/>
        <script type="text/javascript" src="js/jquery-1.9.1.js"></script>

        <script type="text/javascript" src="js/noty/jquery.noty.js"></script>

        <script type="text/javascript" src="js/noty/layouts/top.js"></script>
        <script type="text/javascript" src="js/noty/layouts/center.js"></script>
        <!-- You can add more layouts if you want -->
<link href="css/main.css" rel="stylesheet" type="text/css" />
<!--[if IE 8]><link href="css/ie8.css" rel="stylesheet" type="text/css" /><![endif]-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>
        <script type="text/javascript" src="js/noty/themes/default.js"></script>


        <!--tooltip-->
        <link href="js/css/start/jquery-ui-1.10.3.custom.css" rel="stylesheet"/>

        <script src="js/js/jquery-ui-1.10.3.custom.js"></script>
        <link rel="stylesheet" href="js/demos.css" />

        <script type="text/javascript">
            $(function() {

                $( document ).tooltip();
                $( "#accordion" ).accordion();

            }); 
        </script>
    </head>

    <!-- Body page -->



    <body class="no-background">
          <div id="container" style="height:620px;">

            <div id="header">
                <div class="ui-widget" style="padding: 0 .7em; background-color: red;" >
                    <div class="ui-state-error ui-corner-all" style="padding: 0 .7em;margin-left: 100px;">
                        <p><span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span>
                        <p  style="text-align: center;">Error while connecting to the database. Please Enter the database configuration settings appropriately. if the root user has got no password, click the SAVE button to proceed. After configuration works, open the previous tab where you were working on before the error occurred, then refresh your page. Otherwise, login to start afresh. </p>
                    </div>


                </div>
            </div>
            <br/>
           

            <div id="content" style="height:500px;margin-left:320px; overflow:hidden ;">




                <!--                    <h5 align="center"><img src="images/mhc_logo.png" height="150px" alt="Health Communication System" align="centre"/></h5>-->


                <form action="updatedbpword" method="post" style="margin-left: 100px; height:340px; width:740px; background-color: lightsteelblue;">
                    <h4 align="center">Database Configuration</h4>
                    <table style="margin-left:120px;width:300px;"   cellpadding="8px" cellspacing="6px">
                        <tr>
                            <td style="text-align: right;width:250px;">Host name:   <img src="img/blguide.png" title="enter the hostname followed by a ':' then port number e.g. localhost:1433. If there is no port number, just enter the host name  e.g. localhost"/></td>
                            <td style="text-align: right">

                                <!--  username -->
                                <input id="hostname" type=text required name=hostname placeholder="e.g localhost:3306" value="localhost:1433" autofocus class="textbox"/></td>

                        </tr>
                        <tr> <td style="text-align: right;">Database : <img src="img/blguide.png" title="enter the database name e.g mhc"/></td>
                            <td style="text-align: right;"><input id="database"  type=text required name=database value="APHIAMAINDB" placeholder="e.g hei"  class="textbox"/></td>
                        </tr>

                        <tr> <td style="text-align: right;">User:   <img src="img/blguide.png" title="enter a database user name name e.g root"/></td>
                            <td style="text-align: right;"><input id="user"  type=text required name=user value="sa" placeholder="e.g sa"  class="textbox"/></td>
                        </tr>

                        <tr><td style="text-align: right;">Password:   <img src="img/blguide.png" title="enter the database password"/></td> 
                            <!--password-->
                            <td style="text-align: right;"><input id="dbpassword"  type=password  name=password placeholder="Password" class="textbox"></td>
                        </tr>
                        <tr><td style="text-align: right;">Authentication Type  <img src="img/blguide.png" title="enter the database password"/></td> 
                            <!--password-->
                            <td style="text-align: right;">
                                <select name=authentication  class="textbox" required>
                                    <option value=""></option>
                                    <option value="Windows">Windows Authentication</option>
                                    <option value="Server">Server Authentication</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: right;"> </td>
                            <td style="text-align: center;"><input type="submit" style="width:100px;height: 35px;" value="Save"/>

                            </td>
                        </tr>
                    </table>
                    <h4>
                        <%
                                if (session.getAttribute("") != null) {%>
                        <script type="text/javascript"> 
                    
                            var n = noty({text: '<%=session.getAttribute("")%>',
                                layout: 'center',
                                type: 'Success',
 
                                timeout: 1800});
                    
                        </script> <%

                                session.removeAttribute("");
                            }

                        %>
                    </h4>
                </form>
                <!--                    <h3 align="center"> <img src="images/aphia_logo.png" alt="logo" height="86px" width="270px"/></h3>-->


            </div>



            <div id="footer">
                <!--  <h2 align="left"> <img src="images/Coat of arms.JPG" alt="logo" height="76px" /></h2>-->

                <%
                    Calendar cal = Calendar.getInstance();
                    int year = cal.get(Calendar.YEAR);



                %>
                <p align="center"> &copy <a href="#" title="">OVC Filing Tracker</a> Aphia Plus | USAID <%=year%></p>
            </div>
        </div>
    </body>


</html>
