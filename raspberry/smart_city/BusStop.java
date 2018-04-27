public class BusStop{
    private String busStopId;
    private String busStopName;
    private String busStopLocation;
    private String busId;
    private String busName;

    public BusStop(){
        this.busStopId = "";
        this.busStopName = "";
        this.busStopLocation = "";
        this.busId = "";
        this.busName = "";
    }

    void setBusStopId(String busStopId){
        this.busStopId = busStopId;
    }
    void setBusStopName(String busStopName){
        this.busStopName = busStopName;
    }
    void setBusStopLocation(String busStopLocation){
        this.busStopLocation = busStopLocation;
    }
    void setBusId(String busId){
        this.busId = busId;
    }
    void setBusName(String busName){
        this.busName = busName;
    }

    @Override
    public String toString(){
	    return  "BusStop [busStopId =" + busStopId +
                ", busStopName =" + busStopName +
                ", busStopLocation =" + busStopLocation +
                ", busId =" + busId +
                ", busName =" + busName + "]";
   }
}
