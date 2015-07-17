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
public class childdetailsreport extends HttpServlet {

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
            String District="";
            District=request.getParameter("District");
              String Year="";
              Year=request.getParameter("Year");
              String chw="";
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
           String chwval="";
           String docid="";
//             ^^^^^^^^^^^^^CREATE STATIC AND WRITE STATIC DATA TO THE EXCELL^^^^^^^^^^^^
             HSSFWorkbook wb=new HSSFWorkbook();
  HSSFSheet shet1=wb.createSheet();
 int cbocount=3;
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
                         cell.setCellValue("OVC DOCUMENT DETAILS REPORT");
                         
                        }
                    }
 shet1.addMergedRegion(new CellRangeAddress(1,1,0,11));
  
  
    shet1.setColumnWidth(0, 9000);
    shet1.setColumnWidth(1, 9000); 
    shet1.setColumnWidth(2, 9000);
    shet1.setColumnWidth(3, 9000);
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


  
      

//  Merge the cells
//  shet1.addMergedRegion(new CellRangeAddress(1,1,1,3));
            
   HSSFRow rw4=shet1.createRow(2);
    rw4.setHeightInPoints(50);
   HSSFRow rw6=shet1.createRow(3);
    rw6.setHeightInPoints(25);
//    rw4.setRowStyle(style);
//    
//  
//    rw6.setRowStyle(style);
// 
    
   
// rw4.createCell(1).setCellValue("Number");
    HSSFCell cell1 ,cell0,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15,cell16;
   // cells fo row 2 
    cell0=rw4.createCell(0);
    cell1=rw4.createCell(1);
   cell2=rw4.createCell(2);
 
   cell4=rw4.createCell(3);


 
 cell0.setCellValue("CBO"); 
 cell0.setCellStyle(style);
 
 cell1.setCellValue("CHW"); 
 cell1.setCellStyle(style);
 
 cell2.setCellValue("OVCID"); 
 cell2.setCellStyle(style);
 
  cell4.setCellValue("FULLNAME"); 
cell4.setCellStyle(style);


ArrayList docidarray=new ArrayList();
int rowcount=3;
int doccounter=3; 
int doccounter1=4; 
int columcounter=3;
String cboids="";
   int mergecounter=2;         
      String getdocname="select * from ovcdocuments WHERE DocumentName!=''";
              conn.rs3= conn.state3.executeQuery(getdocname);
              while(conn.rs3.next()){
                 
                  System.out.println(conn.rs3.getString(2));
                  docname=conn.rs3.getString(2);
                  cell3=rw4.createCell(doccounter1);
                  cell3.setCellValue(docname); 
                  cell3.setCellStyle(style);
  docidarray.add(conn.rs3.getString(1));
    doccounter1++;
              }

              
              System.out.println("lll "+doccounter1);
           int rowcounter=4;   
          int counter=0; 
          int countercopy=3;
          int countercopy1=3;
              HSSFRow rw5=null;
  
               String getcboCOUNT= "select * from CBO where DistrictID='"+District+"' Order by DistrictID ";
                      conn.rs2 = conn.state2.executeQuery(getcboCOUNT);
                      while(conn.rs2.next()){
                 counter++;
                 System.out.println("bb b "+conn.rs2.getString(2));
                                   System.out.println("rowcount "+rowcount +" lll   "+counter+" rowcounter "+rowcounter );
                                       
            


            
            System.out.println("doccount "+doccounter );
            
            
           String getData="select "
                  + "ovcfiling.value,Clientdetails.FirstName, Middlename,SurName,ovcfiling.OVCID"
                  + " , Clientdetails.Cbo,"
                  + "ovcfiling.ovcdocid,Clientdetails.District,Clientdetails.Volunteerid "
                  + " from ovcfiling,Clientdetails  "
                  + "WHERE Clientdetails.District ='"+District+"' and Clientdetails.Cbo='"+conn.rs2.getString(1)+"' "
                   + "and Clientdetails.OVCID = ovcfiling.ovcid and (Year='"+Year+"' OR Year='') "
                  + "group by Clientdetails.FirstName, Middlename,Surname,ovcfiling.OVCID,Clientdetails.Volunteerid,ovcfiling.value,ovcfiling.ovcdocid,Clientdetails.Cbo,Clientdetails.District  "
                   + "Order by  Clientdetails.Volunteerid,ovcfiling.OVCID,ovcfiling.ovcdocid";
          System.out.println("aaaaa  "+getData);
               conn.rs = conn.state.executeQuery(getData);
         while(conn.rs.next()){
             
            
         value1= conn.rs.getInt(1);
             FirstName= conn.rs.getString(2);
             MiddleName= conn.rs.getString(3);
             Surname= conn.rs.getString(4);
             ovcid1= conn.rs.getString(5);
//                String getcbo= "select * from CBO where CBOID='"+cboid+"' ";
//                System.out.println("aaa "+getcbo);
//                conn.rs_1= conn.state4.executeQuery(getcbo);
//                while(conn.rs_1.next()){
////                   
//                    cbocount++;
//                cboname=conn.rs_1.getString("CBO");
//                System.out.println("aaab  "+cboname);
//                }
            cboname= conn.rs2.getString(2);
             cboid= conn.rs.getString(6);
             docid= conn.rs.getString(7); 
        String getchw= "select * from CHW where CHWID='"+conn.rs.getString(9)+"' ";
        conn.rs3 = conn.state3.executeQuery(getchw);
        while(conn.rs3.next()){
           chw= conn.rs3.getString("FirstName") +" "+conn.rs3.getString("MiddleName")+" "+conn.rs3.getString("Surname") +" "+ conn.rs3.getString("CBOID");
        }
          

       // fro holding ovc id 
              
                    
             // to create rows         
       if(docid.equals("1")){
        rw5=shet1.createRow(rowcount);
        rw5.setHeightInPoints(25);
        
          for(int i=2; i<doccounter1;i++){
     System.out.println("mm "+i);
        cell5=rw5.createCell(i);
        cell5.setCellValue(""); 
        cell5.setCellStyle(style_border1); 
       

              } 
        rowcount++;
        cbocount++;
       }
              
           
                      cell1=rw5.createCell(0);
                      cell1.setCellValue(cboname);
                      cell1.setCellStyle(style_border1);
                      cell1=rw5.createCell(1);
                      cell1.setCellValue(chw);
                      cell1.setCellStyle(style_border1);
                      cell1=rw5.createCell(2);
                      cell1.setCellValue(ovcid1);
                      cell1.setCellStyle(style_border1);
                       cell1=rw5.createCell(3);
                      cell1.setCellValue(FirstName+" "+MiddleName+" "+Surname);
                      cell1.setCellStyle(style_border1);
       
    
        for(int i=0;i<docidarray.size();i++){
                   System.out.println("hh "+docidarray.get(i));
                      if(rw5==null){
                    rw5=shet1.createRow(rowcount);
                                    }
                   if(docidarray.get(i).equals(docid)){
                       int cellcount=i+4;
                      cell2=rw5.createCell(cellcount );
                      cell2.setCellValue(value1);
                      cell2.setCellStyle(style_border1);
                   
                   
//                    if( docid.equals("3") ) {
//                           System.out.println("am in2");
//                           System.out.println("****a  "+docid +" "+cellcount);
//                           cellcount++; 
//                           } 
                       System.out.println("****b  "+docid +" "+cellcount);
                   }
               }
//                      cell3=rw5.createCell(2);
//                      cell3.setCellValue(docid);
//                      cell3.setCellStyle(style_border1);
                     
             System.out.println(FirstName+" "+ovcid1+"  "+value1 +"___"+doccounter +"_____"+rowcount);
if(docid.equals("10")){
//     rowcount++;
        doccounter=2;
}
                  if(chwval.equals("")){
                          chwval=chw;
          
                     System.out.println(countercopy+" nnnna "+rowcount);
//                                        shet1.addMergedRegion(new CellRangeAddress(countercopy,rowcount-1,0,0));
//                                        countercopy=rowcount; 
                                     System.out.println(countercopy+" nnnnb "+rowcount +"  "+chwval);
                                      }

 
             if(!chwval.equals(chw) && !chwval.equals("")){
                            chwval=chw;
                        
                        System.out.println(countercopy+" nnna"+rowcount +"  "+chwval);
                           
                              shet1.addMergedRegion(new CellRangeAddress(countercopy,rowcount-2,1,1));
                              countercopy=rowcount-1;
                               System.out.println(countercopy+" nnnb  "+rowcount +"  "+chwval);

   }
             String cboval="";
               if(cboval.equals("")){
              cboval= cboname;
            
//                shet1.addMergedRegion(new CellRangeAddress(countercopy1,cbocount-1,0,0));
//                countercopy1=cbocount;
            
            }
             if(!cboval.equals(cboname) && !cboval.equals("")){
                            cboval=cboname;
                        
                        System.out.println(countercopy1+" nnna"+cbocount +"  "+chwval);
                           
                              shet1.addMergedRegion(new CellRangeAddress(countercopy1,cbocount-2,0,0));
                              countercopy1=cbocount-1;
                               System.out.println(countercopy1+" nnnb  "+rowcount +"  "+cboval);

   }
//             
//              if(monthval.equals("")){
//              monthval= months;
//              System.out.println("88"+monthval +"___"+months);
//                System.out.println("88"+monthcopy1);
//                System.out.println("88"+counter1);
//                cell31.setCellValue(""+months+ " ("+conn.rs3.getInt(5)+")");
//                shet2.addMergedRegion(new CellRangeAddress(monthcopy_1,counter1-1,1,1));
//                monthcopy1=counter1;
//            
//            }
//          if(!monthval.equals("") && !monthval.equals(months)){
//                 monthval= months;
//                System.out.println("!!!"+monthval +"___"+months);
//                System.out.println("!!!"+monthcopy_1);
//                System.out.println("!!!!"+counter1);
////                cell31.setCellValue(months);
////              shet1.addMergedRegion(new CellRangeAddress(monthcopy,counter-1,1,1));
//                monthcopy_1=counter1;
//               
//            }
            
//       if(rowcount>countercopy)  {      
//       
//         shet1.addMergedRegion(new CellRangeAddress(countercopy,rowcount-1,0,0));
//                              countercopy=rowcount;
//       }  
         }
         if(rowcount>countercopy)  {               
         shet1.addMergedRegion(new CellRangeAddress(countercopy,rowcount-1,1,1));
                              countercopy=rowcount;
         }
         if(cbocount>countercopy1)  {               
         shet1.addMergedRegion(new CellRangeAddress(countercopy1,cbocount-1,0,0));
                              countercopy1=cbocount;
         }
 //}

                  System.out.println("aaaaaa   "+districtname+"__"+ cboname +"____"+ docname +"___"+value1 +"__"+value0 ); 
              
       
       
        
             }  
//   // end of while loop
                 
         

ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=CBO_Details_Report_"+Year+".xls");
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
