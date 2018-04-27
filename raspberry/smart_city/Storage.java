import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
	
public class Storage {	
    private static ConnectMySQL instance = ConnectMySQL.getInstance();
    private static Statement stmt = null;

    // Description : Returns all the users that have registered a specific device type 
	public static ResultSet selectBusStopsByBusId(String busId) throws SQLException {
		ResultSet response = null;
		try{
			String query = "{call select_bus_stop_by_bus_id(?)}";
			CallableStatement stmt = instance.conn.prepareCall(query);
			stmt.setString(1, busId); 
			stmt.executeQuery();
			response = stmt.getResultSet();
		} catch (SQLException e) {
			System.out.println("STORAG:    failed to create a connection object.");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("STORAG:    another error.");
			e.printStackTrace();
		}
		return response;	
	}


}


