package util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


//import java.sql.Statement;
//import java.sql.Connection;
import java.sql.*;
//import com.microsoft.sqlserver.jdbc.SQLServerDriver;
/**
 *
 * @author Bumblebee
 */
public class SQL_Connection {
    public static Connection GetConnection()
    {
        try{
	    /*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    Connection connect=DriverManager.getConnection("jdbc:odbc:QLNV");
	    return connect;
	    * 
	    */
	    Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
	    Connection connect=DriverManager.getConnection("jdbc:jtds:sqlserver://localhost;databaseName=QLBANHANG;instance=SQLExpress");
	    //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	    //Connection connect=DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLExpress;databaseName=javatuan3;integratedSecurity=true;");
	    return connect;
	    //return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    public static int ExecuteQueryString(String querystring)
    {
        try{
            Statement st= GetConnection().createStatement();
            st.executeUpdate(querystring);
	    return 1;
        }
        catch(Exception ex)
        {
            //ex.printStackTrace();
        }
        return -1;
    }
    public static ResultSet getResultSet(String querystring)
    {
        try{
            Statement st= GetConnection().createStatement();
            ResultSet rs= st.executeQuery(querystring);
            return rs;
        }
        catch(Exception ex)
        {
            //ex.printStackTrace();
            return null;
        }
    }
    public static void Close_Connection(Connection conn)
    {
        try
        {conn.close();}
        catch(Exception ex)
        {}
    }
}