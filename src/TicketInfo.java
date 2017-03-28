package ars;
import static ars.Main.flight;

public class TicketInfo{

    private String name;
    private int flightIndex;
    
    public TicketInfo() {
        this("", -1);
    }

    public TicketInfo( String name, int flightIndex){
        this.name = name;
        this.flightIndex = flightIndex;
    }
    
    public String getName() {
        return name;
    }

    public int getFlightIndex() {
        return flightIndex;
    }
    
    public String toString(){
        return "Name " + name + " Flight Index " + flight.flight_info[flightIndex].getFlightID();
    }
}