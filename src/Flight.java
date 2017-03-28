package ars;

import static ars.Main.scanner;
import static ars.Main.mainMode;
import static ars.Main.router;
import static ars.Main.flight;

public class Flight extends Router {

    public static int flight_seat = 5;
    public static int flight_per_router = 4;
    public static int flight_size = Router.router_size * flight_per_router * 7;
    public static FlightInfo[] flight_info = new FlightInfo[flight_size];

    private int flightIndex;
    private int peopleAmount;

    public Flight() {
        clear();
        generate();
   }
    
    public static int main(){
        
        flight.printByRouter();

        System.out.println("----------------------------------------");
        System.out.println("Press select Flight ID and Enter");
        System.out.println("----------------------------------------");
        flight.setFlightID(scanner.next());

        if (flight.isNotFlight()) {
            return 2;
        }

        if(mainMode==1){

            System.out.println("----------------------------------------");
            System.out.println("Press amount of seat");
            System.out.println("----------------------------------------");
            flight.setPeopleAmount(scanner.nextInt());

        }else if(mainMode==2){
            flight.setPeopleAmount(1);
        }
        
        if (flight.isNotSeat()) {
            return 2;
        }
        
        /*System.out.println("----------------------------------------");
        System.out.print("Confirm a reservation file ");
        System.out.println(flight_info[flight.getFlight()].getFlightID());
        System.out.println("Press key 1 to comfirm");
        System.out.println("----------------------------------------");
        if(scanner.nextInt()!=1){
            return 2;
        }*/
        
        return 3;
    

        /*System.out.println("----------------------------------------");
        System.out.println("prees key 1 when you want flight back");
        System.out.println("----------------------------------------");
        if (scanner.nextInt() == 1) {

            router.setRouterID((router.getRouterID() + ars.Router.router_size / 2) % ars.Router.router_size);
            flight.printByRouter();

            //Select Flight Out
            System.out.println("----------------------------------------");
            System.out.println("Select Flight back no. ");
            System.out.println("----------------------------------------");
            flight.setFlightID(scanner.next());
            
            if (flight.isNotFlight()) {
                return 2;
            }

            if (flight.isNotSeat()) {
                return 2;
            }

            ticket.main();
            ticket.clear();
        }
        return 3;*/
    }
    
    public void clear() {
        flightIndex = -1;
        peopleAmount = 0;
    }
    
    public int getFlightInfoIndex(String flightID) {
        for (int i = 0; i < flight_size; i++) {
            if (flight_info[i].getFlightID().toLowerCase().equals(flightID.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
    public void setFlightID(String flightID) {
        flightIndex = getFlightInfoIndex(flightID);
    }
    
    public void setPeopleAmount(int peopleAmount) {
        this.peopleAmount = peopleAmount;
    }
    
    public int getPeopleAmount() {
        return peopleAmount;
    }
    
    public int getFlight() {
        return flightIndex;
    }

    public boolean isNotFlightIn() {
        if (flightIndex == -1) {
            System.out.println("No have flight");
            return true;
        }
        return false;
    }

    public boolean isNotSeat() {
        if (flight_info[flightIndex].getSeat() + peopleAmount > flight_seat) {
            System.out.println("Maximum number of people choose a new file.");
            return true;
        }
        return false;
    }
    
    public boolean isNotFlight() {
        if (flightIndex == -1) {
            System.out.println("No have flight");
            return true;
        }
        return false;
    }

    public void addSeat() {
        flight_info[flightIndex].addSeat();
    }

    public void delSeat() {
        flight_info[flightIndex].delSeat();
    }

    public void printByRouter() {
        
        int k = router.getRouterID();
        
        System.out.println("----------------------------------------");
        System.out.println("Router ID " + k + ", " + router.getFrom() + " -> " + router.getTo());
        System.out.println("----------------------------------------");

        int count = 0;

        for (int i = 0; i < flight_size; i++) {
            if (flight_info[i].getRouterID() == k && flight_info[i].getSeat() < flight_seat) {
                System.out.println(flight_info[i].toString());
                ++count;
            }
        }
        
        if(count==0){
            System.out.println("Flight is empty");
        }
    }

    public void printFlightAll() {
        System.out.println("----------------------------------------");
        System.out.println("All Flight");
        System.out.println("----------------------------------------");
        for (int i = 0; i < flight_size; i++) {
            System.out.print(i + ") ");
            System.out.println(flight_info[i].toString());
        }
        System.out.println("----------------------------------------");
    }
    
   private void generate() {

        flight_info[0] = new FlightInfo(router_info[0], "TG2168", 0, "07:30", "08.15");
        flight_info[1] = new FlightInfo(router_info[0], "TG2170", 0, "11:30", "12.15");
        flight_info[2] = new FlightInfo(router_info[0], "TG2172", 0, "15:30", "16.15");
        flight_info[3] = new FlightInfo(router_info[0], "TG2174", 0, "19:30", "20.15");
        
        flight_info[4] = new FlightInfo(router_info[1], "TG2230", 0, "08:45", "10:15");
        flight_info[5] = new FlightInfo(router_info[1], "TG2232", 0, "12:45", "14:15");
        flight_info[6] = new FlightInfo(router_info[1], "TG2234", 0, "16:45", "18:15");
        flight_info[7] = new FlightInfo(router_info[1], "TG2236", 0, "20:45", "22:15");
        
        flight_info[8] = new FlightInfo(router_info[2], "TG2340", 0, "06:55", "07:55");
        flight_info[9] = new FlightInfo(router_info[2], "TG2342", 0, "10:55", "11:55");
        flight_info[10] = new FlightInfo(router_info[2], "TG2344", 0, "14:55", "15:55");
        flight_info[11] = new FlightInfo(router_info[2], "TG2346", 0, "18:55", "19:55");
        
        flight_info[12] = new FlightInfo(router_info[3], "TG2420", 0, "07:40", "08.45");
        flight_info[13] = new FlightInfo(router_info[3], "TG2422", 0, "11:40", "12.45");
        flight_info[14] = new FlightInfo(router_info[3], "TG2424", 0, "15:40", "16.45");
        flight_info[15] = new FlightInfo(router_info[3], "TG2426", 0, "19:40", "20.45");
        
        flight_info[16] = new FlightInfo(router_info[4], "TG2560", 0, "06:15", "07:40");
        flight_info[17] = new FlightInfo(router_info[4], "TG2562", 0, "10:15", "11:40");
        flight_info[18] = new FlightInfo(router_info[4], "TG2564", 0, "14:15", "15:40");
        flight_info[19] = new FlightInfo(router_info[4], "TG2566", 0, "18:15", "19:40");
        
        flight_info[20] = new FlightInfo(router_info[5], "TG2678", 0, "06:30", "07:55");
        flight_info[21] = new FlightInfo(router_info[5], "TG2680", 0, "10:30", "11:55");
        flight_info[22] = new FlightInfo(router_info[5], "TG2682", 0, "14:30", "15:55");
        flight_info[23] = new FlightInfo(router_info[5], "TG2684", 0, "18:30", "19:55");
        
        flight_info[24] = new FlightInfo(router_info[6], "TG2169", 0, "07:30", "08.15");
        flight_info[25] = new FlightInfo(router_info[6], "TG2171", 0, "11:30", "12.15");
        flight_info[26] = new FlightInfo(router_info[6], "TG2173", 0, "15:30", "16.15");
        flight_info[27] = new FlightInfo(router_info[6], "TG2175", 0, "19:30", "20.15");
        
        flight_info[28] = new FlightInfo(router_info[7], "TG2131", 0, "08:45", "10:15");
        flight_info[29] = new FlightInfo(router_info[7], "TG2133", 0, "12:45", "14:15");
        flight_info[30] = new FlightInfo(router_info[7], "TG2135", 0, "16:45", "18:15");
        flight_info[31] = new FlightInfo(router_info[7], "TG2137", 0, "20:45", "22:15");
        
        flight_info[32] = new FlightInfo(router_info[8], "TG2041", 0, "06:55", "07:55");
        flight_info[33] = new FlightInfo(router_info[8], "TG2043", 0, "10:55", "11:55");
        flight_info[34] = new FlightInfo(router_info[8], "TG2045", 0, "14:55", "15:55");
        flight_info[35] = new FlightInfo(router_info[8], "TG2047", 0, "18:55", "19:55");
        
        flight_info[36] = new FlightInfo(router_info[9], "TG2021", 0, "07:40", "08.45");
        flight_info[37] = new FlightInfo(router_info[9], "TG2023", 0, "11:40", "12.45");
        flight_info[38] = new FlightInfo(router_info[9], "TG2025", 0, "15:40", "16.45");
        flight_info[39] = new FlightInfo(router_info[9], "TG2027", 0, "19:40", "20.45");
        
        flight_info[40] = new FlightInfo(router_info[10], "TG2261", 0, "06:15", "07:40");
        flight_info[41] = new FlightInfo(router_info[10], "TG2263", 0, "10:15", "11:40");
        flight_info[42] = new FlightInfo(router_info[10], "TG2265", 0, "14:15", "15:40");
        flight_info[43] = new FlightInfo(router_info[10], "TG2267", 0, "18:15", "19:40");
        
        flight_info[44] = new FlightInfo(router_info[11], "TG2279", 0, "06:30", "07:55");
        flight_info[45] = new FlightInfo(router_info[11], "TG2281", 0, "10:30", "11:55");
        flight_info[46] = new FlightInfo(router_info[11], "TG2283", 0, "14:30", "15:55");
        flight_info[47] = new FlightInfo(router_info[11], "TG2285", 0, "18:30", "19:55");
        
        int index = 48;
        int ilovekmitl = 2312;
        for(int day=1; day<7; day++){
            for(int rout = 0; rout < 12; rout ++ ){
                for (int i=0; i<4; i++){
                    flight_info[index++] = new FlightInfo(router_info[rout], "TG"+ilovekmitl++, day, Date.getHour(flight_info[index%48].getTimeIn()), Date.getHour(flight_info[index%48].getTimeOut()));
                }
                
            }
        }
    }

    /*private void generateFlightDay() {
        int i = 5;
        
        char[] charHour = { time.charAt(0), time.charAt(1),time.charAt(2),time.charAt(1),time.charAt(1) };
        String strHour = new String(charHour);
        int hour = Integer.parseInt( strHour );
        
        flight_info[i] = new FlightInfo( 
                flight_info[i].getRouterInfo()
                , "TG2168"
                , 0
                , "06:30"
                , "07:55"
        );
        
    }
    
    private void generateFlightOut(){
        int i = 6;
        //for(int i=6; i<flight_size; i++){
        //    flight_info[i] = new FlightInfo(router_info[ flight_info[ flight_size/2 + i].getRouterID ], "TG2168", 0, "07:30", "08.15");
        //}
        
    }*/
}
