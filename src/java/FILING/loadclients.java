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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author user
 */
public class loadclients extends HttpServlet {

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
        session= request.getSession();
        String cboid="";
        try {
               dbConn conn = new dbConn("1");
             String chwid="";int doccount=0;String Year="";
     chwid= request.getParameter("chwid"); 
     cboid= request.getParameter("cboid"); 

   
     System.out.println("ccc "+cboid);
     Year= request.getParameter("year"); 
       System.out.println(chwid +" bbb  "+Year);
   
            /* TODO output your page here. You may use following sample code. */
          String view="";
          JSONObject jsonobj = new JSONObject();
                       
           System.out.println("Database before is "+conn.dbsetup[1]);
          view+="   <thead>" +
"                                <tr >" +
"                                    <th style=\"width:180px;\">OVC Full Name</th>" ;

          
            
            String getTableHeaders="select * from ovcdocuments where ovcdocid!='3' AND DocumentName!=''";
                             conn.rs2 = conn.state2.executeQuery(getTableHeaders);
                              while(conn.rs2.next()){
                  System.out.println(conn.rs2.getString(1) +"_____"+conn.rs2.getString(2));
                           
        view+="<th>"+ conn.rs2.getString("DocumentName")+""
//                + " <input name=\"Custodians\" type=\"checkbox\" value=\"All\" class=\"checkall\">"
                + "</th>" ;
                                
                             }
            String getTableHeaders1="select * from ovcdocuments where ovcdocid='3'";
                             conn.rs2 = conn.state2.executeQuery(getTableHeaders1);
                              while(conn.rs2.next()){
                  System.out.println(conn.rs2.getString(1) +"_____"+conn.rs2.getString(2));
                           
        view+="<th>"+ conn.rs2.getString("DocumentName")+""
//                + " <input name=\"Custodians\" type=\"checkbox\" value=\"All\" class=\"checkall\">"
                + "</th>" ;
                                
                             }
view+=" </tr>" +
"</thead>" +
" <tbody>" ;

 int counter=0;   
String getentries="select * from Clientdetails WHERE Volunteerid ='"+chwid+"' and Cbo='"+cboid+"' ";
System.out.println("~~~~  "+getentries);
conn.rs = conn.state.executeQuery(getentries); 
while(conn.rs.next()){       
counter++;
view+=" <tr id=\"row"+counter+"\"><td> <label class=\"control-label\">"+ conn.rs.getString("FirstName") +" "+conn.rs.getString("MiddleName")+" "+conn.rs.getString("SurName") +"</label> </td>" ;



  String getdocid="select * from ovcdocuments where ovcdocid!='3' AND DocumentName!=''";
                             conn.rs3 = conn.state3.executeQuery(getdocid);
                             if(conn.rs3.next()){


   
  String checkifexists="select * from ovcfiling where ovcid='"+conn.rs.getString("OVCID")+"' and ovcdocid!='3'   order by ovcdocid ";
System.out.println("aaa "+checkifexists);
  conn.rs4= conn.state4.executeQuery(checkifexists);
  for(int z=1;z<=8;z++){
       if(z!=3){
  if(conn.rs4.next()==true){
      doccount++;
    
         System.out.println("aaa   "+conn.rs4.getString("ovcdocid"));
      if(conn.rs4.getString("value").equals("1")){
 view+="<td> <input type=\"hidden\" value=\""+conn.rs4.getString("ovcfilingid")+"\" name=\"ovcfilingid"+z+""+counter+"\"><input type=\"hidden\" value=\"update\" name=\"action"+z+""+counter+"\"><input  type=\"hidden\" name=\"OVCID"+z+""+counter+"\"  value="+conn.rs.getString("OVCID")+" ><input  type=\"hidden\" name=\"ovcdocid"+z+""+counter+"\"  value="+conn.rs4.getString("ovcdocid")+" ><input type=\"checkbox\" checked name=\"status"+z+""+counter+"\" id=\"status"+z+""+counter+"\" value=\"1\" class=\"styled\" >" ;
      }
      else{
    view+="<td> <input type=\"hidden\" value=\""+conn.rs4.getString("ovcfilingid")+"\" name=\"ovcfilingid"+z+""+counter+"\"><input type=\"hidden\" value=\"update\" name=\"action"+z+""+counter+"\"><input  type=\"hidden\" name=\"OVCID"+z+""+counter+"\"  value="+conn.rs.getString("OVCID")+" ><input  type=\"hidden\" name=\"ovcdocid"+z+""+counter+"\"  value="+conn.rs4.getString("ovcdocid")+" ><input type=\"checkbox\" name=\"status"+z+""+counter+"\" id=\"status"+z+""+counter+"\"  value=\"1\" class=\"styled\" >" ;
 
      }
  }
  //}
  view+="</td>";
      }

  }
  
   String checkifexists1="select * from ovcfiling where ovcid='"+conn.rs.getString("OVCID")+"' and ovcdocid!='3' ";
    conn.rs2= conn.state2.executeQuery(checkifexists1);
    if(conn.rs2.next()==false){
      for(int z=1;z<=8;z++){ 
          if(z!=3){
view+=
"<td><input type=\"hidden\" value=\"insert\" name=\"action"+z+""+counter+"\"><input  type=\"hidden\" name=\"OVCID"+z+""+counter+"\"  value="+conn.rs.getString("OVCID")+" ><input  type=\"hidden\" name=\"ovcdocid"+z+""+counter+"\"  value="+z+" ><input type=\"checkbox\"  id=\"status"+z+""+counter+"\" name=\"status"+z+""+counter+"\" value=\"1\" class=\"styled\" ></td>" ;
      }}
      }

System.out.println(doccount +"__________ "+counter);

                              }
                             
                             
                             // for education
                             
                             
                             
  String getdocid1="select * from ovcdocuments where ovcdocid='3'";
                             conn.rs3 = conn.state3.executeQuery(getdocid1);
                             if(conn.rs3.next()){
//counter++;

   
  String checkifexists="select * from ovcfiling where ovcid='"+conn.rs.getString("OVCID")+"' and year='"+Year+"' and ovcdocid='3'";
  System.out.println("hhh "+checkifexists);
  conn.rs4= conn.state4.executeQuery(checkifexists);
int z=3;
  if(conn.rs4.next()==true){
      doccount++;

      if(conn.rs4.getString("value").equals("1")){
 view+="<td> <input type=\"hidden\" value=\""+conn.rs4.getString("ovcfilingid")+"\" name=\"ovcfilingid"+z+""+counter+"\"><input type=\"hidden\" value=\"update\" name=\"action"+z+""+counter+"\"><input  type=\"hidden\" name=\"OVCID"+z+""+counter+"\"  value="+conn.rs4.getString("ovcid")+" ><input  type=\"hidden\" name=\"ovcdocid"+z+""+counter+"\"  value="+conn.rs4.getString("ovcdocid")+"  ><input type=\"checkbox\" checked name=\"status"+z+""+counter+"\" id=\"status"+z+""+counter+"\" value=\"1\" class=\"styled\" >" ;
      }
      else{
    view+="<td> <input type=\"hidden\" value=\""+conn.rs4.getString("ovcfilingid")+"\" name=\"ovcfilingid"+z+""+counter+"\"><input type=\"hidden\" value=\"update\" name=\"action"+z+""+counter+"\"><input  type=\"hidden\" name=\"OVCID"+z+""+counter+"\"  value="+conn.rs4.getString("ovcid")+" ><input  type=\"hidden\" name=\"ovcdocid"+z+""+counter+"\" value="+conn.rs4.getString("ovcdocid")+"  ><input type=\"checkbox\" name=\"status"+z+""+counter+"\" id=\"status"+z+""+counter+"\"  value=\"1\" class=\"styled\" >" ;
 
      }
  //}
  view+="</td>";
      

  }
  
   String checkifexists1="select * from ovcfiling where ovcid='"+conn.rs.getString("OVCID")+"' and year='"+Year+"' and ovcdocid='3'";
    conn.rs2= conn.state2.executeQuery(checkifexists1);
    if(conn.rs2.next()==false){
    int x=3;
view+=
"<td><input type=\"hidden\" value=\"insert\" name=\"action"+x+""+counter+"\"><input  type=\"hidden\" name=\"OVCID"+x+""+counter+"\"  value="+conn.rs.getString("OVCID")+" ><input  type=\"hidden\" name=\"ovcdocid"+x+""+counter+"\"  value=\"3\" ><input type=\"checkbox\"  id=\"status"+x+""+counter+"\" name=\"status"+x+""+counter+"\" value=\"1\" class=\"styled\" ></td>" ;
      }
      

System.out.println(doccount +"B__________ "+counter);

                              }
   view+= ""+
      "</tr>" ;                        
}
view+="</tbody>";

view+=
        "          <table>      <tr> <div class=\"form-actions\">" +
"	                                        <button class=\"btn btn-primary\" type=\"submit\">Submit</button>" +

"	                                    </div>" +
"        <input  type=\"hidden\" value=\""+counter+"\" name=\"counts\" >                    </tr>" +
"                         </table> ";



try{
    jsonobj.put("view", view);
    out.println(jsonobj);
}
finally
{out.close();
}
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
            Logger.getLogger(loadclients.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(loadclients.class.getName()).log(Level.SEVERE, null, ex);
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
