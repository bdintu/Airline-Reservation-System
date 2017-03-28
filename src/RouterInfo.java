package ars;

public class RouterInfo {

    protected int routerID;
    protected String from;
    protected String to;
    
    public RouterInfo(){
        this(-1, "", "");
    }

    public RouterInfo(int routerID, String from, String to) {
        this.routerID = routerID;
        this.from = from;
        this.to = to;
    }
    
    public int getRouterID(){
        return routerID;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
    
    public String toString() {
        return " Route ID : " + routerID + ", From " + from + " to " + to + ".";
    }
}