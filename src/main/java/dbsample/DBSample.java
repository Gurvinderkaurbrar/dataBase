package dbsample;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c0665336
 */

import java.sql.*;
import java.util.logging.Level;

public class DBSample {
   private static Connection getConnection() throws SQLException {
       try {
           Class.forName("com.mysql.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           java.util.logging.Logger.getLogger(DBSample.class.getName()).log(Level.SEVERE, null, ex);
       }
      
     
      
      String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
      String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
       String username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
        String password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
        String name ="dbsample";
        String url ="jdbc:mysql://" +host + ":" + port + "/" +name;
        
           return DriverManager.getConnection(url, username, password);
       
        
   } 
   public static String getTable(){
       String output ="";
       try {
           Connection conn = getConnection();
           Statement stmt=conn.createStatement();
           ResultSet rs= stmt.executeQuery("SELECT * FROM PEOPLE");
           while(rs.next()){
             output +="<h1>"+rs.getString("name")+ "</h1>";
              output +="<p>"+rs.getString("bio")+ "</p>";
             
           }
           conn.close();
       } catch (SQLException ex) {
           output = "SQl Exception:" +ex.getMessage();
       }
       return output;
   }
}
