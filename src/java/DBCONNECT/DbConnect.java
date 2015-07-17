/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DBCONNECT;

/**
 *
 * @author user
 */
import static DBCONNECT.dbConn.issetdbcalled_file_exists;
import static DBCONNECT.dbConn.issetdbcalled_wrongpword;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class DbConnect {
	public Connection conn = null;
	private String dbName = null;
  public ResultSet rs0,rs, rs1, rs2, rs3, rs4, rs_1, rs_2, rs_3, rs_4, rs_5, rs_6, anc_sch_rs;
    public Statement st0,st, st1, st2, st3, st4, st_1, st_2, st_3, st_4, st_5, st_6, anc_scheduling_st;
    public Statement state,state1,state2,state3,state4;
    public PreparedStatement ps1,ps2,ps3;
      public  String dbsetup[] = new String[5];
          String mydrive = "";
	public DbConnect() throws ClassNotFoundException, InstantiationException, IllegalAccessException{

		this.dbName = dbName;
		try {
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=APHIAMAINDBkciu;integratedSecurity=true");//here put the new simple url.
		   URL location = dbConn.class.getProtectionDomain().getCodeSource().getLocation();
                      mydrive = location.getFile().substring(1, 2);
                    if (getdbsettings(mydrive) == true) {
                         if (dbsetup[0] != null) {
                             
                               System.out.println(dbsetup[0]+" ddd "+dbsetup[3]+" "+ dbsetup[1]);
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();  
             conn = DriverManager.getConnection("jdbc:sqlserver://" + dbsetup[0] + ";databaseName=" + dbsetup[1]+";integratedSecurity=true");//here put the new simple url.
//            System.out.println("test");
                         }
                         else{
                           if (issetdbcalled_wrongpword %2== 0) {
                        calldbjsp();
                        issetdbcalled_wrongpword ++;
                    }
                    else{
                     issetdbcalled_wrongpword ++;
                    }
                         
                         
                         }
                st_1 = conn.createStatement();
                st_2 = conn.createStatement();
                st_3 = conn.createStatement();
                st_4 = conn.createStatement();
                st_5 = conn.createStatement();
                st_6 = conn.createStatement();
                
 state=(Statement)conn.createStatement();
// state.setFetchSize(50);
 state1=(Statement)conn.createStatement();
 state2=(Statement)conn.createStatement();
 state3=(Statement)conn.createStatement();
 state4=(Statement)conn.createStatement();
              
// 	DbConnect conne = new DbConnect();String sql="select * from county ";
//                conne.rs0= conne.state.executeQuery(sql);
//                while(conne.rs0.next())
//                {
//                System.out.println(conne.rs0.getString(2));
//                }
//                
                } } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
//	public ResultSet runSql(String sql) throws SQLException {
//		Statement sta = conn.createStatement();
//		return sta.executeQuery(sql);
//	}
 
 public final boolean getdbsettings(String drive) {
        boolean worked = true;

        try {



            String dbconnpath = drive + ":/OLMIS/OLMIS/DBCONNECTION/DO_NOT_DELETE/_/_/./dbconnection.txt";

            //File file = new File("");
            // InputStream inStream = getClass().getResourceAsStream("Web-INF/classes/dbconnection.txt");  
            FileInputStream fstream = new FileInputStream(dbconnpath);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String stLine;
            //Read File Line By Line
            int count = 0;
            while ((stLine = br.readLine()) != null) {

                // Print the content on the console


                dbsetup[count] = stLine;


                if (count < 5) {
                    count++;
                }
            }
            //Close the input stream
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(dbConn.class.getName()).log(Level.SEVERE, null, ex);


            System.out.println("MY VALUE:" + issetdbcalled_file_exists);

            if (issetdbcalled_file_exists%2 == 0) {
                calldbjsp();
                issetdbcalled_file_exists++;
            }
            else{
            issetdbcalled_file_exists++;
            }

            System.out.println("MY VALUE:" + issetdbcalled_file_exists);


            System.out.println("ERROR:      FILE NOT FOUND");
            worked = false;

        }

        return worked;

    }

    public void calldbjsp() {
        try {

            //not so good for now because the host name is static


            String url = "http://localhost:8080/OVCFilingTracker/db.jsp";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
            //getdbsettings("M");
        } catch (IOException ex) {
            Logger.getLogger(dbConn.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
