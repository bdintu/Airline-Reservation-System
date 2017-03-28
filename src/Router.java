package ars;

import static ars.Main.scanner;
import static ars.Main.router;

public class Router {

    public static int router_size = 12;
    protected RouterInfo[] router_info = new RouterInfo[router_size];
    private int routerID;

    public Router() {
        generateRouter();
        clear();
    }
    
    public static int main(){

        router.printRouterAll();

        System.out.println("----------------------------------------");
        System.out.println("Press select number of route(0-11) and Enter");
        System.out.println("----------------------------------------");
        router.setRouterID(scanner.nextInt());

        if (router.isNotRouter()) {
            return 1;
        }

        return 2;
    }
    
    public void clear() {
        routerID = -1;
    }
    
    public void setRouterID(int routerID){
        this.routerID = routerID;
    }
    
    public int getRouterID(){
        return routerID;
    }
    
    public String getFrom(){
        return router_info[routerID].getFrom();
    }
    
    public String getTo(){
        return router_info[routerID].getTo();
    }

    public boolean isNotRouter(){
        int i = routerID;
        if( i<0 || i>=router_size ){
            System.out.println("No have router");
            return true;
        }
        return false;
    }

    public void printRouterAll() {
        System.out.println("----------------------------------------");
        System.out.println("All route");
        System.out.println("----------------------------------------");
        for (int i = 0; i < router_size; i++) {
            System.out.println(router_info[i].toString());
        }
    }
    
    public void generateRouter(){

        router_info[0] = new RouterInfo(0, "BKK", "CNX");
        router_info[1] = new RouterInfo(1, "BKK", "CEI");
        router_info[2] = new RouterInfo(2, "BKK", "KKC");
        router_info[3] = new RouterInfo(3, "BKK", "UBP");
        router_info[4] = new RouterInfo(4, "BKK", "HDY");
        router_info[5] = new RouterInfo(5, "BKK", "HKT");

        int k = router_size / 2;
        for (int i = k; i < router_size; i++) {
            router_info[i] = new RouterInfo(i, router_info[i - k].getTo(), router_info[i - k].getFrom());
        }
    }
}