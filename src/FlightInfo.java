package ars;

class FlightInfo extends RouterInfo{

    private RouterInfo router;
    private String flightID;
    private int seat;
    private int day;
    private int timeIn;
    private int timeOut;

    public FlightInfo(RouterInfo router, String flightID, int day, String timeIn, String timeOut) {
        super(router.routerID, router.from, router.to);
        this.router = router;
        this.flightID = flightID;
        this.day = day;
        this.timeIn = Date.getInt(timeIn);
        this.timeOut = Date.getInt(timeOut);
        this.seat = 0;
    }

    public void addSeat() {
        seat++;
    }

    public void delSeat() {
        seat--;
    }

    public int getSeat() {
        return seat;
    }
    
    public RouterInfo getRouterInfo(){
        return router;
    }

    public String getFlightID() {
        return flightID;
    }

    public int getDay() {
        return day;
    }

    public int getTimeIn() {
        return timeIn;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public String toString() {
        return " Flight ID " + flightID + ", From " + router.from + ", To " + router.to + ", Date " + Date.getDay(day) + " Time " + Date.getHour(timeIn) + " -> " + Date.getHour(timeOut) + ", Available " + (5-seat) + " seat.";
    }
}