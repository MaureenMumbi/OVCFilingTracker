/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FILING;

import DBCONNECT.dbConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class saveFileInfo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    HttpSession session;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            session = request.getSession();
              dbConn conn = new dbConn("1");
            int counter=0;
            String counts=request.getParameter("counts");
            counter=Integer.parseInt(request.getParameter("counts"));
            String year="";
            
                    Date date= new Date();
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String formattedDate = formatter.format(date);
            year=  session.getAttribute("Year").toString();
            /* TODO outpu;t your page here. You may use following sample code. */
          String ovcid="";
          String ovcdocid="";
          String status="";
          String action="";
          String ovcfilingid="";
          int count =0;
           String newstatus=""; 

        System.out.println("cc "+counter +"  "+counts);
           for(int z=1;z<=counter;z++){
                 for(int i=1;i<=8;i++){
                     count++;  
                        if(request.getParameter("OVCID"+i+""+z)!="" && request.getParameter("OVCID"+i+""+z)!=null ){
          ovcid= request.getParameter("OVCID"+i+""+z);}
                        
                           if(request.getParameter("ovcdocid"+i+""+z)!="" && request.getParameter("ovcdocid"+i+""+z)!=null ){
          ovcdocid= request.getParameter("ovcdocid"+i+""+z);}
         
          
      
       if(request.getParameter("status"+i+""+z)!="" && request.getParameter("status"+i+""+z)!=null ){
       status= request.getParameter("status"+i+""+z);
          
       }
       else{
        status="0"; }
       System.out.println("aaa   "+status +"___"+newstatus); 
       
          if(request.getParameter("action"+i+""+z)!="" && request.getParameter("action"+i+""+z)!=null ){
          action= request.getParameter("action"+i+""+z);}
          
             if(request.getParameter("ovcfilingid"+i+""+z)!="" && request.getParameter("ovcfilingid"+i+""+z)!=null ){
          ovcfilingid= request.getParameter("ovcfilingid"+i+""+z);}
//        if(status!=null && !status.equals("")){
           System.out.println(ovcid+" "+ovcdocid+" "+status);
           if(action.equals("insert")){
            System.out.println("b4 documentid"+ovcdocid);   
if(ovcdocid.equals("3")){
            String insert="insert into ovcfiling (ovcfilingid,ovcid,ovcdocid,value,Year,timestamp) values ('"+uniqueid().trim()+"','"+ovcid+"','"+ovcdocid+"','"+status+"','"+year+"','"+formattedDate+"') ";
 System.out.println("after documentid1     "+insert);
            conn.state.executeUpdate(insert);
               System.out.println("after documentid1        "+ovcdocid);   
}
else{
     String insert="insert into ovcfiling (ovcfilingid,ovcid,ovcdocid,value,Year,timestamp) values ('"+uniqueid().trim()+"','"+ovcid+"','"+ovcdocid+"','"+status+"','','"+formattedDate+"') ";
 System.out.println("after documentid2     "+insert);
  System.out.println("after documentid2        "+ovcdocid);   
            conn.state.executeUpdate(insert);

}
 session.setAttribute("saved", "<font color=\"green\"><b>Saved Successfully.</b></font>");

}
           
           
           else{
             if(ovcdocid.equals("3")){
           String update="update ovcfiling set ovcid='"+ovcid+"',ovcdocid='"+ovcdocid+"',value='"+status+"', year='"+year+"',timestamp='"+formattedDate+"' where ovcfilingid='"+ovcfilingid+"' ";
          System.out.println(update);
           conn.state.executeUpdate(update);  
                 
             }
             else{
            String update="update ovcfiling set ovcid='"+ovcid+"',ovcdocid='"+ovcdocid+"',value='"+status+"', year='',timestamp='"+formattedDate+"' where ovcfilingid='"+ovcfilingid+"' ";
          System.out.println(update);
           conn.state.executeUpdate(update);
           
       }
//          }
           System.out.println(count);
       session.setAttribute("saved", "<font color=\"green\"><b>Updated Successfully.</b></font>");      
}
          

                 }}
          response.sendRedirect("selectParameters.jsp");
        
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
        } catch (SQLException ex) {
            Logger.getLogger(saveFileInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
        } catch (SQLException ex) {
            Logger.getLogger(saveFileInfo.class.getName()).log(Level.SEVERE, null, ex);
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




//====================random id functions================================
public String uniqueid() {

Calendar cal1 = Calendar.getInstance();

int year1 = cal1.get(Calendar.YEAR);
int month1 = cal1.get(Calendar.MONTH) + 1;
int date1 = cal1.get(Calendar.DAY_OF_MONTH);
int hour1 = cal1.get(Calendar.HOUR_OF_DAY);
int min1 = cal1.get(Calendar.MINUTE);
int sec1 = cal1.get(Calendar.SECOND);
int milsec = cal1.get(Calendar.MILLISECOND);


return generateRandomNumber(800, 8000) + year1 + "" + month1 + "" + date1 + hour1 + min1 + sec1 + milsec;
}

public int generateRandomNumber(int start, int end) {
Random random = new Random();
long fraction = (long) ((end - start + 1) * random.nextDouble());
return ((int) (fraction + start));
}
//==========================================================================

}
