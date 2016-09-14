package jdbcProject;

import java.util.*;
import java.sql.*;
import java.io.FileInputStream;

public class JdbcStudent{

   
    static Connection myConn=null;
    static Statement stmt= null;
    static ResultSet rs=null;
            
    public static void main(String[] args) throws SQLException {
       
        
        try{
            
        Properties props = new Properties();
        props.load(new FileInputStream("info.properties"));
        
        String userName = props.getProperty("user");
        String passWord = props.getProperty("password");
        String url = props.getProperty("url");
            
        myConn =  DriverManager.getConnection(url, userName, passWord);    
        stmt= myConn.createStatement();
       
    

        // insert the data
        String sql="insert into student(first_name, last_name, gpa, sat_score) values('George', 'Washington', 4.0, 1600)";
        stmt.executeUpdate(sql);
        
       
        String sql1 = "SELECT * FROM student ORDER BY ID DESC LIMIT 1";
//        stmt.executeUpdate(sql2);
      
        rs= stmt.executeQuery(sql1);
        
        while(rs.next()){
        	System.out.println("First Name      "   + "Last Name");
            System.out.printf("%s          %s" , rs.getString("first_name"), rs.getString("last_name") );
        }
              

        }catch(Exception exc){
            
            exc.printStackTrace();
        }finally{
            
            myClose(myConn, stmt, rs);
            
        }
            
        
    }
    
    public static void myClose(Connection con, Statement tsmt, ResultSet rs) throws SQLException{
         if(con != null)
             con.close();
         if(stmt != null)
             stmt.close();
         if(rs != null)
             rs.close();
    }
    
    public static String select()
    {
    			
    		return "select * from tiy2.student";
    }

}