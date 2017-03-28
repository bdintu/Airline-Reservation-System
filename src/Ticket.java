package ars;
import java.util.ArrayList;

import static ars.Main.scanner;
import static ars.Main.mainMode;
import static ars.Main.flight;
import static ars.Main.ticket;

public class Ticket {

    protected ArrayList<TicketInfo> ticket_info;
    private String name;
    
    public Ticket(){
        ticket_info = new ArrayList<TicketInfo>();
        clear();
    }
    
    public static int main() {
        System.out.println("----------------------------------------");
        System.out.println("Enter your name");
        System.out.println("----------------------------------------");
        
        if(mainMode==1){
            for (int i = 0; i < flight.getPeopleAmount(); i++) {
                System.out.println("No. " + i+1 + " of " + flight.getPeopleAmount() + " ");
                ticket.setName(scanner.next());
                ticket.addTicket();
            }    
        } else if(mainMode==2){
            ticket.addTicket();
        }

        System.out.println("Booking a Ticket Success");
        return 0;
    }
    
    public void clear(){
        name = "";
    }
    
    public int getTicketInfoIndex(){
        for (int i = 0; i < ticket_info.size(); i++) {
            if( ticket_info.get(i).getName().toLowerCase().equals(ticket.getName().toLowerCase() ) ){
                return i;
            }
        }
        return -1;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void addTicket(){
        ticket_info.add( new TicketInfo(name, flight.getFlight()));
        flight.addSeat();
    }
    
    public void delTicket(){
        for (int i = 0; i < ticket_info.size(); i++) {
            if( ticket_info.get(i).getName().equals(ticket.getName())   ){
                if (ticket_info.get(i).getFlightIndex() == flight.getFlight()){
                    ticket_info.remove(i);
                    flight.delSeat();
                }
            }
        }
        System.out.println("Cancle a Ticket Success");
    }
    
    public boolean isNotTicket(){
        int i  = getTicketInfoIndex();
        if(i==-1){
            return true;
        }
        return false;
    }
    
    public void printTicket(){
        for (int i = 0; i < ticket_info.size(); i++) {
            if( ticket_info.get(i).getName().toLowerCase().equals(ticket.getName().toLowerCase() ) ){
                System.out.println(ticket_info.get(i).toString());
            }
        }
    }
    
    public void printTicketAll(){
        System.out.println("----------------------------------------");
        System.out.println("All Ticket");
        System.out.println("----------------------------------------");
        for (int i = 0; i < ticket_info.size(); i++) {
            System.out.println(ticket_info.get(i).toString());
        }
        System.out.println("----------------------------------------");
    }
}
