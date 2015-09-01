/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FILING;

import DBCONNECT.dbConn;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maureen
 */
public class login extends HttpServlet {

    String uname, pass, error_login, nextPage, current_time;
    String computername;
    MessageDigest m;
    HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException, SQLException, Exception {


     dbConn conn = new dbConn("1");
            System.out.println("Database before is "+conn.dbsetup[1]);

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DATE);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        String yr, mnth, dater, hr, mn, sc, action = "";
        yr = Integer.toString(year);
        mnth = Integer.toString(month);
        dater = Integer.toString(date);
        hr = Integer.toString(hour);
        mn = Integer.toString(min);
        sc = Integer.toString(sec);
        session = request.getSession();

//____________________COMPUTER NAME____________________________________
        computername = InetAddress.getLocalHost().getHostName();
        System.out.println("Computer name " + computername);
        session.setAttribute("computer_name", computername);





//current_time=sc+"-"+mn+"-"+hr+"-"+dater+"-"+mnth+"-"+yr;

//current_time=yr+"-"+mnth+"-"+dater+"-"+hr+":"+mn+":"+sc;

//        current_time = yr + "-" + mnth + "-" + dater + "-" + hr + ":" + mn + ":" + sc;
//        //get username and password
//
        uname = request.getParameter("username");

        pass = request.getParameter("password");

//evashelmith
System.out.println(uname+"vvv"+pass);
String  usernames="";
String pwds="";

String getuser="select * from users ";
conn.rs= conn.state.executeQuery(getuser);
while(conn.rs.next()){
 usernames =conn.rs.getString("Username");
 pwds=conn.rs.getString("Password");
System.out.println(usernames +" mmm "+pwds);
}


     decryptor myEncryptor= new decryptor();
    String stringToEncrypt=pass;
        String encrypted=myEncryptor.encrypt(pass);
        
//        String decrypted=myEncryptor.decrypt(encrypted);
//        
//        System.out.println(encrypted+"f------f"+decrypted);

 
        //encrypt password

//        m = MessageDigest.getInstance("MD5");
//        m.update(pass.getBytes(), 0, pass.length());
//        String pw = new BigInteger(1, m.digest()).toString(16);


        //connection to database class instance


        //query for checking user existance in the database
      
//
String trialdate="";
String key="";
String dateToday="";
String status="";
Date mydate;

    Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        mydate = new Date();
       dateToday = formatter.format(mydate);

//System.out.println("worked up to here 1;");


  String select1 = "select * from Users";
        conn.rs = conn.state.executeQuery(select1);

        // System.out.println("username:"+uname+"  Password :"+pw );


        while (conn.rs.next()) {
            if (conn.rs.getString("Username").equalsIgnoreCase(uname) && conn.rs.getString("Password").equals(encrypted)) {

                error_login = null;
              
     
                    nextPage = "selectParameters.jsp";

                 
                   System.out.println("entered");
                  
                    session.setAttribute("username", conn.rs.getString("Username"));
                    session.setAttribute("level", conn.rs.getString("AllowDelete"));
                   

                 
                    
                   
                    break;
               





            }//end of first if
            else {

       

                nextPage = "index.jsp";

                error_login = "<b><font color=\"red\">wrong username and or password</font></b>";

                System.out.println(">>" + nextPage);

            }



        }
//
//System.out.println(nextPage);
//
//
        session.setAttribute("error_login", error_login);
        response.sendRedirect(nextPage);


    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {               
            processRequest(request, response);
        }  catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
       
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {        
            processRequest(request, response);
        }catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}