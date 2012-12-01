/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MAPPER;

import java.sql.Connection;
import java.sql.ResultSet;
import util.SQL_Connection;
/**
 *
 * @author Lucifer
 */
public class MAPPERDB{
    
    public static int ExecuteQueryString(String querystring)
    {
	Connection conn=SQL_Connection.GetConnection();
	int n=SQL_Connection.ExecuteQueryString(querystring);
	SQL_Connection.Close_Connection(conn);
	return n;
    }
    public static ResultSet getResultSet(String querystring)
    {
	Connection conn=SQL_Connection.GetConnection();
	ResultSet rs=SQL_Connection.getResultSet(querystring);
	SQL_Connection.Close_Connection(conn);
	return rs;
    }
    
}
