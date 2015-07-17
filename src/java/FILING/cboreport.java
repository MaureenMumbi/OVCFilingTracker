/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FILING;

import DBCONNECT.dbConn;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;

/**
 *
 * @author user
 */
public class cboreport extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
        try {
                  dbConn conn = new dbConn("1");
            String District[];
            String Year="";
            District=request.getParameterValues("District");
            Year=request.getParameter("Year");
            String FirstName="";
            String MiddleName="";
            String Surname="";
            String ovcid1="";
            String ovcid2="";
            int value0=0;
            int value1=0;
            String Districtid="";
            String cboid="";
            String doc="";
            String docname="";
            String cboname="";
            String districtname="";
           String distval="";
           int activeOVC=0;
           int activeHH=0;
           float activeovc=0;
           float activehh=0;
           float percent=0;
//             ^^^^^^^^^^^^^CREATE STATIC AND WRITE STATIC DATA TO THE EXCELL^^^^^^^^^^^^
             HSSFWorkbook wb=new HSSFWorkbook();
  HSSFSheet shet1=wb.createSheet();
 
//%%%%%%%%%%%%%%%%HEADER FONTS AND COLORATION%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
  
  // style header with font color yello 
  
 HSSFFont font_header=wb.createFont();
    font_header.setFontHeightInPoints((short)10);
    font_header.setFontName("Arial Black");
    font_header.setItalic(true);
    font_header.setBoldweight((short)05);
    font_header.setColor(HSSFColor.BLACK.index);
    CellStyle style_header=wb.createCellStyle();
    style_header.setFont(font_header);
    style_header.setWrapText(true);
    style_header.setFillForegroundColor(HSSFColor.YELLOW.index);
    style_header.setBorderBottom(HSSFCellStyle.BORDER_THIN);
    style_header.setBorderTop(HSSFCellStyle.BORDER_THIN);
    style_header.setBorderRight(HSSFCellStyle.BORDER_THIN);
    style_header.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    style_header.setAlignment(CellStyle.ALIGN_CENTER);   
style_header.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);


// stylex with font color blue  and backgound grey
HSSFCellStyle stylex = wb.createCellStyle();
stylex.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
stylex.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

HSSFFont fontx = wb.createFont();
fontx.setColor(HSSFColor.DARK_BLUE.index);
      stylex.setFont(fontx);
      stylex.setBorderBottom(HSSFCellStyle.BORDER_THIN);
      stylex.setBorderTop(HSSFCellStyle.BORDER_THIN);
      stylex.setBorderRight(HSSFCellStyle.BORDER_THIN);
      stylex.setBorderLeft(HSSFCellStyle.BORDER_THIN);
      stylex.setAlignment(CellStyle.ALIGN_CENTER);
      
      // gold bg color -style
    HSSFFont font=wb.createFont();
    font.setFontHeightInPoints((short)12);
    font.setFontName("Cambria");
    font.setItalic(true);
    font.setBoldweight((short)02);
    font.setColor(HSSFColor.BLACK.index);
    CellStyle style=wb.createCellStyle();
    style.setFont(font);
    style.setWrapText(true);
    style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
    style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
      style.setBorderTop(HSSFCellStyle.BORDER_THIN);
      style.setBorderRight(HSSFCellStyle.BORDER_THIN);
      style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
      
      
      
      
// for border with no font color
     CellStyle style_border=wb.createCellStyle();
      style_border.setBorderBottom(HSSFCellStyle.BORDER_THIN);
      style_border.setBorderTop(HSSFCellStyle.BORDER_THIN);
      style_border.setBorderRight(HSSFCellStyle.BORDER_THIN);
      style_border.setBorderLeft(HSSFCellStyle.BORDER_THIN);
      
     HSSFFont font1=wb.createFont();
        font1.setFontHeightInPoints((short)18);
        font1.setFontName("Cambria");
        font1.setBoldweight((short)7);
        font1.setColor(HSSFColor.BLACK.index);
      
      CellStyle style_border1=wb.createCellStyle();
      style_border1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
      style_border1.setBorderTop(HSSFCellStyle.BORDER_THIN);
      style_border1.setBorderRight(HSSFCellStyle.BORDER_THIN);
      style_border1.setBorderLeft(HSSFCellStyle.BORDER_THIN);
      style_border1.setFont(font);
      style_border1.setAlignment(CellStyle.ALIGN_CENTER);
      style_border1.setVerticalAlignment(CellStyle.ALIGN_LEFT);
      
      
 
   
  HSSFRow rw1=shet1.createRow(1);
   rw1.setHeightInPoints(30);
   for (int y = 0; y < 11; ++y) {
                  HSSFCell  cell=rw1.createCell(y);
                    cell.setCellStyle(stylex);
                       
                        if (y == 0) {
                         cell.setCellValue("CBO FILING TRACKER REPORT" +"( "+Year +")");
                         
                        }
                    }
 shet1.addMergedRegion(new CellRangeAddress(1,1,0,11));
  
  
    shet1.setColumnWidth(0, 4500);
    shet1.setColumnWidth(1, 8500); 
    shet1.setColumnWidth(2, 5000);
    shet1.setColumnWidth(3, 5000);
    shet1.setColumnWidth(4, 5000);
    shet1.setColumnWidth(5, 5000);
    shet1.setColumnWidth(6, 5000);
    shet1.setColumnWidth(7, 5000);
    shet1.setColumnWidth(8, 5000); 
    shet1.setColumnWidth(9, 5000);
    shet1.setColumnWidth(10, 5000);
    shet1.setColumnWidth(11, 5000);
    shet1.setColumnWidth(12, 5000);
    shet1.setColumnWidth(13, 5000);
    shet1.setColumnWidth(14, 5000);
    shet1.setColumnWidth(15, 5000);
    shet1.setColumnWidth(16, 5000);
    shet1.setColumnWidth(17, 4000);
    shet1.setColumnWidth(18, 4000);
    shet1.setColumnWidth(19, 4200);
    shet1.setColumnWidth(20, 4200);
    shet1.setColumnWidth(21, 4200);
    shet1.setColumnWidth(22, 4200);

  
      

//  Merge the cells
//  shet1.addMergedRegion(new CellRangeAddress(1,1,1,3));
            
   HSSFRow rw4=shet1.createRow(2);
    rw4.setHeightInPoints(40);
   HSSFRow rw6=shet1.createRow(3);
    rw6.setHeightInPoints(25);
//    rw4.setRowStyle(style);
//    
//  
//    rw6.setRowStyle(style);
// 
    
   
// rw4.createCell(1).setCellValue("Number");
    HSSFCell cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15,cell16;
   // cells fo row 2 
    cell1=rw4.createCell(0);
   cell2=rw4.createCell(1);
 
   cell4=rw4.createCell(3);


 
 cell1.setCellValue("DISTRICT"); 
 cell1.setCellStyle(style);
 cell2.setCellValue("CBO"); 
cell2.setCellStyle(style);


    cell6=rw6.createCell(0);
     cell6.setCellValue("Status"); 
     cell6.setCellStyle(style);
    cell7=rw6.createCell(1);
    cell7.setCellValue(""); 
    cell7.setCellStyle(style);
  shet1.addMergedRegion(new CellRangeAddress(3,3,0,1));
int rowcount=3;
int doccounter=4; 
int doccounter1=4; 
int columcounter=3;
String cboids="";
   int mergecounter=2;
   
                 cell3=rw4.createCell(2);
                  cell3.setCellValue("ACTIVE OVC"); 
                  cell3.setCellStyle(style);
                 cell3=rw4.createCell(3);
                  cell3.setCellValue("ACTIVE HH"); 
                  cell3.setCellStyle(style);
                  
                    cell6=rw6.createCell(2);
         cell6.setCellValue("");
        cell6.setCellStyle(stylex);
                    cell6=rw6.createCell(3);
         cell6.setCellValue("");
        cell6.setCellStyle(stylex);
ArrayList docidarray=new ArrayList();
      String getdocname="select * from ovcdocuments WHERE DocumentName!=''";
              conn.rs3= conn.state3.executeQuery(getdocname);
              while(conn.rs3.next()){
                  docidarray.add(conn.rs3.getString(1));
                  System.out.println(conn.rs3.getString(2));
                  docname=conn.rs3.getString(2);
                  cell3=rw4.createCell(doccounter1);
                  cell3.setCellValue(docname); 
                  cell3.setCellStyle(style);
  
                  
         cell6=rw6.createCell(doccounter1);
         cell6.setCellValue("Available");
        cell6.setCellStyle(stylex);
          
//           cell5=rw6.createCell(doccounter1);
//          cell5.setCellValue("Not Available"); 
//          cell5.setCellStyle(stylex);
        doccounter1++;
        
         System.out.println("mergecounter b4"+mergecounter);
//      shet1.addMergedRegion(new CellRangeAddress(2,2,2,3));
//      shet1.addMergedRegion(new CellRangeAddress(2,2,4,5));
//      shet1.addMergedRegion(new CellRangeAddress(2,2,6,7));
//      shet1.addMergedRegion(new CellRangeAddress(2,2,8,9));
//      shet1.addMergedRegion(new CellRangeAddress(2,2,10,11));
//      shet1.addMergedRegion(new CellRangeAddress(2,2,12,13));
//      shet1.addMergedRegion(new CellRangeAddress(2,2,14,15));
//      shet1.addMergedRegion(new CellRangeAddress(2,2,16,17));
//      shet1.addMergedRegion(new CellRangeAddress(2,2,18,19));
//      shet1.addMergedRegion(new CellRangeAddress(2,2,20,21));

     
       System.out.println("mergecounter after"+mergecounter);  
       // mergecounter++;
       
        //shet1.addMergedRegion(new CellRangeAddress(2,2,doccounter1,doccounter1++));
              }
              
              System.out.println("lll "+doccounter1);
           int rowcounter=4;   
          int counter=0; 
          int countercopy=4;
              HSSFRow rw5=null;
   for(int j=0;j<District.length;j++){
               String getcboCOUNT= "select * from CBO where DistrictID='"+District[j]+"' Order by DistrictID ";
                      conn.rs2 = conn.state2.executeQuery(getcboCOUNT);
                      while(conn.rs2.next()){
                 
                          counter++;
                        rowcount++;
                          rw5=shet1.createRow(rowcount);
   for(int i=2; i<doccounter1;i++){
     System.out.println("mm "+i);
        cell5=rw5.createCell(i);
        cell5.setCellValue(""); 
        cell5.setCellStyle(style_border1); 
       

              }
                           
                            cell2=rw5.createCell(1);
                             cell2.setCellValue(conn.rs2.getString(2));
                             cell2.setCellStyle(style_border);
           
//            cell5=rw5.createCell(rowcount);
//        cell6=rw5.createCell(rowcounter++);
//        cell5.setCellValue("x"); 
//        cell6.setCellValue("y");
                                   System.out.println("rowcount "+rowcount +" lll   "+counter+" rowcounter "+rowcounter );
                                     
                     
  rw5.setHeightInPoints(25);

//   cell3=rw5.createCell(2);
                        String getDistrict ="select * from District where DistrictID='"+District[j]+"' Order by DistrictID ";
                   conn.rs4 = conn.state4.executeQuery(getDistrict);
                   while(conn.rs4.next()){
                   districtname=conn.rs4.getString("District");
                      cell1=rw5.createCell(0);
                     cell1.setCellValue(districtname);
                     cell1.setCellStyle(style_border1);
                    
                   } 
           doccounter=4;
            System.out.println("doccount "+doccounter );
            
          String getdocname1="select * from ovcdocuments";
//          conn.rs3 = conn.state.executeQuery(getdocname1);
//          while(conn.rs3.next()){
          String getData="select "
                  + "SUM(CASE WHEN ovcfiling.value='1' THEN 1 ELSE 0 END) AS COUNT1, "
                  + "SUM(CASE WHEN ovcfiling.value='0' THEN 1 ELSE 0 END) AS COUNT0,"
                  + "Clientdetails.Cbo,"
                  + "ovcfiling.ovcdocid,Clientdetails.District,"
                  + "count(Clientdetails.OVCID),"
                  + "count(DISTINCT(Clientdetails.HouseHoldheadID))"
                  + " from ovcfiling,Clientdetails  "
                  + "WHERE Clientdetails.District ='"+District[j]+"' and "
                  + "Clientdetails.Cbo='"+conn.rs2.getString(1)+"' and Clientdetails.Exited='1' and  "
                  + " (Year='"+Year+"' OR Year='') AND  Clientdetails.OVCID = ovcfiling.ovcid "
                  + "group by ovcfiling.ovcdocid,Clientdetails.Cbo,Clientdetails.District  Order by  ovcfiling.ovcdocid,District ";
          System.out.println("aaaaa  "+getData);
               conn.rs = conn.state.executeQuery(getData);
         while(conn.rs.next()){
            
              value1= conn.rs.getInt(1);
             value0= conn.rs.getInt(2);
             cboid= conn.rs.getString(3);
             doc= conn.rs.getString(4);
             Districtid= conn.rs.getString(5);
             activeOVC= conn.rs.getInt(6);
             activeHH= conn.rs.getInt(7);

              int a=0;
             for(int i=0;i<docidarray.size();i++){
                   System.out.println("hh "+docidarray.get(i) +"  "+doc);

                   if(docidarray.get(i).equals(doc)){
                      System.out.println(doc+"lll"+docidarray.get(i));
                       int cellcount=i+2;
                        activeovc= activeOVC;
                         activehh=activeHH;
                      
                       if( doc.equals("8") ) {
                         percent=value1/activehh*100;
                        }
                        else{
                           percent=value1/activeovc*100;
                        }
                         cell7=rw5.createCell(2);
                             cell8=rw5.createCell(3);
             
      
                           cell5=rw5.createCell(doccounter);
//                             cell6=rw5.createCell(doccounter);
                              cell5.setCellValue(Math.round(percent)+"%");  
//                              cell6.setCellValue(value0); 
                              
                              //FOR ACTICE OVCs
                              cell7.setCellValue(activeOVC);  
                              cell7.setCellStyle(style_border);  
                              //FOR ACTICE hhs
                              cell8.setCellValue(activeHH);  
                              cell8.setCellStyle(style_border);  
                              
                              cell5.setCellStyle(style_border); 
                              
                              cell6.setCellStyle(style_border);
                                System.out.println("****a  "+doc +" "+doccounter);
                              
                           if( doc.equals("2") ) {
                              
                                  // System.out.println("****i  "+doc +" "+doccounter);
                               doccounter++; 
//                                 doccounter++; 
                                 System.out.println("am in2");
                                  System.out.println("****b  "+doc +" "+doccounter);
                           } if(doc.equals("3")){
                                 
                               doccounter--;
                             //  doccounter--; 
//                                doccounter--; 
                                System.out.println("****f  "+doc +" "+doccounter);
                                cell5=rw5.createCell(doccounter++);
                                   cell5.setCellStyle(style_border); 
                                 cell5.setCellValue(Math.round(percent)+"%"); 
                                cell6=rw5.createCell(doccounter);
//                                   cell6.setCellStyle(style_border); 
//                                cell6.setCellValue(value0);
                               System.out.println("****b  "+doc +" "+doccounter);
                               
                                doccounter--; 
                           }
//                           else if(!doc.equals("4") && !docidarray.get(i).equals("4")){
//                                doccounter++; 
//                                 doccounter++; 
//                            System.out.println("****c  "+doc +" "+doccounter);
//                           }
                          
                       

                              
              doccounter++;    
              }

                   
                 
                   
                   
               }
           
         }
            doccounter=2;
//               String getcbo= "select * from CBO where cboid='"+cboid+"'";
//                      conn.rs2 = conn.state2.executeQuery(getcbo);
//                      while(conn.rs2.next()){
//                    
//                            cell2=rw5.createCell(1);
//                             cell2.setCellValue(conn.rs2.getString(2));
//                          
//                                   System.out.println("rowcount "+rowcount );
//                                     
//                      }
                     

 //}

                  System.out.println("aaaaaa   "+districtname+"__"+ cboname +"____"+ docname +"___"+value1 +"__"+value0 ); 
              
       
       
        
      
         }
   //}
   // end of while loop
         if(distval.equals("")){
//     totalvalue= countercopy+counter;
                     System.out.println(countercopy+" counter "+counter +"  "+rowcount);
                            distval=districtname;
                               System.out.println(countercopy+" nnnn "+counter+" "+rowcount);
                              
                            if(counter>countercopy){
                           
                            shet1.addMergedRegion(new CellRangeAddress(countercopy,rowcount,0,0));
                             countercopy=rowcount;
                                //cell1.setCellValue(districtname);
                           }
                            
                             System.out.println(countercopy+" nnn "+counter +" "+rowcount +"  "+distval);
                                      }
     // cell1.setCellValue(districtname);
 
             if(!distval.equals(districtname) && !distval.equals("")){
                            distval=districtname;
                             //  cell1.setCellValue(districtname);    
                             shet1.addMergedRegion(new CellRangeAddress(countercopy+1,rowcount,0,0));
                              countercopy=rowcount;   
                         
//
                            
     System.out.println(counter +"@@@@1 "+rowcount+"__"+countercopy);
    System.out.println(distval +"@@@@1 "+districtname); 
   }
    System.out.println(counter +"@@@@ "+rowcount);
     //shet1.addMergedRegion(new CellRangeAddress(counter,rowcount,0,0));
    System.out.println(distval +"@@@@ "+districtname);
   
   } // end of for loop 

//                      int totalvalue=countercopy+counter;
// System.out.println(counter+" hhhh "+countercopy);
//                      if(counter>countercopy){
//                 shet1.addMergedRegion(new CellRangeAddress(countercopy,totalvalue-1,0,0));
//               
//                 countercopy=counter;
//             }
// System.out.println("aaaaaannnn   "+districtname+"__"+ cboname +"____"+ doc +"___"+value1 +"__"+value0 ); 

      // write it as an excel attachment
ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=CBO_FILING_TRACKER_REPORT_FOR_"+Year+".xls");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();  } 
        finally {
//            out.close();
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
            Logger.getLogger(cboreport.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cboreport.class.getName()).log(Level.SEVERE, null, ex);
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
