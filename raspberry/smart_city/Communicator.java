import java.io.*;
import java.util.Vector;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

//Singleton
import javax.inject.Singleton;
// Sql
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Properties;


@Path("/busServer")
@Singleton
public class Communicator {
    Storage databaseDriver = new Storage();

    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "COMMUNIC:   Connection stablished correctly.";
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getBusStopList")
    public BusStop getBusStopList(){
        System.out.println("COMMUNIC:    Sending bus stop list...");
        Vector<BusStop> busStopList = new Vector<BusStop>();
        String selectedBusId = "1";
        /*try {
            ResultSet result = databaseDriver.selectBusStopsByBusId(selectedBusId);
            if (result.next()){
                BusStop busStop = new BusStop();
                busStop.setBusStopId(result.getString("bus_stop_id"));	
	       	busStop.setBusStopName(result.getString("bus_stop_name"));
	       	busStop.setBusStopLocation(result.getString("bus_stop_location"));
		busStop.setBusId(result.getString("bus_id"));
	        busStop.setBusName(result.getString("bus_name"));
                busStopList.add(busStop);
		System.out.println(busStop);
		return busStop;
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} catch (Exception e) {
	    e.printStackTrace();
	}*/  
	return new BusStop();          
	//return busStopList;
    }


    @POST
    @Path("sendStopRequest")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String sendStopRequest(String message) {

        String response = "-1";
        System.out.println("COMMUNIC:    Sendingdd stop request...");
        try {
            System.out.println("COMMUNIC:    Calling python script python" + message);
            
            Process proc = Runtime.getRuntime().exec(new String[] {"python", "-c", "import cliente; cliente.main("+message+")"});
            response = "1";
        }catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("COMMUNIC:    Problem calling python script.");
            response = "-1";
        }
        return response;
    }


    /*
    @POST
    @Path("sendConfiguration")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String sendConfiguration(RoomConfiguration newConfiguration) 
        System.out.println("COMMUNIC:    Rest server receiving configuration...");
	
        String response = //applyAirChanges(newConfiguration) + applyLightChanges(newConfiguration) +
                          //applyShadeChanges(newConfiguration) +
                           storeConfiguration(newConfiguration);

        if (response.equals("1111")){
            System.out.println("COMMUNIC:    Changes completed!");	                                                             
        }
        else{
            System.out.println("COMMUNIC:    Something was wrong.");
        }
        return String.valueOf(response);
    }

    @POST
    @Path("sendRatings")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String sendRatings(RoomConfiguration conf) {
        int newWeatherRating = conf.getUserWeatherRating();
        int newLuminosityRating = conf.getUserLuminosityRating();
        int newNoiseRating = conf.getUserNoiseRating();
        String newAppUser = "none".toString();
	int isUserOrSystem = 1;
	int newTimeInterval = -1;
        System.out.println("COMMUNIC:    Received user ratings: "+ newWeatherRating + " - " + newLuminosityRating + " - " + newNoiseRating);

        Storage databaseDriver = new Storage();
        String response = String.valueOf(databaseDriver.addLearning(-1, -1, -1, -1, -1, -1, newWeatherRating, newLuminosityRating, newNoiseRating, isUserOrSystem, newTimeInterval, newAppUser));
        return String.valueOf(response);
    }

    public String applyLightChanges(RoomConfiguration newConfiguration){
        //SmartThingsDriver smartSwitch = new SmartThingsDriver();
        // get values 
        int newLightOn = newConfiguration.getRoomLightOn();
        String lightOn = newLightOn==1 ? "On" : "Off";
	    System.out.println("COMMUNIC:    Light changes-> Light: " + lightOn);

        System.out.print("COMMUNIC:    applying light changes...");
        // Request the WEMO to react using the user request
        String executionStatus = "0";
        if (newLightOn==1){
                try {
                    //wemoControl.SwitchOn();
                    smartSwitch.turnLightsOn();
		    //wemoStatus = true;
                    System.out.println("COMMUNIC:    Light    OK!");	
                    executionStatus = "1";
                }
                catch(Exception e){
		    System.out.println("COMMUNIC:    Light    FAILED!");
                    //e.printStackTrace();
                }
        }
        else if (newLightOn==0){
                try {
                    //wemoControl.SwitchOff();
                    smartSwitch.turnLightsOff();
                    //wemoStatus = false;
                    System.out.println("COMMUNIC:    Light    OK!");	
                    executionStatus = "1";
                }
                catch(Exception e){
                    System.out.println("COMMUNIC:    Light    FAILED!");
                    //e.printStackTrace();
                }
        }
        else{
            System.out.println("COMMUNIC:    Light    Unexpected value.");
        }
        return executionStatus;
    }
*/
}
	
