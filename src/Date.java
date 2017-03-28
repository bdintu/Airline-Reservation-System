package ars;

public class Date {
    public static String getDay(int date) {
        String[] day = {"Sunday", "Monday", "Tuesday", "Wednesday", "Whursday", "Friday", "Saturday"};
        return day[date];
    }

    public static String getHour(int time) {
        if(time / 60 <10) {
            return "0" + Integer.toString(time / 60) + ":" + Integer.toString(time % 60);
        }
        return Integer.toString(time / 60) + ":" + Integer.toString(time % 60);
    }

    public static int getInt(String time) {
        char[] charHour = { time.charAt(0), time.charAt(1) };
        String strHour = new String(charHour);
        int hour = Integer.parseInt( strHour );
        
        char[] charMin = { time.charAt(3), time.charAt(4) };
        String strMin = new String(charMin);
        int min = Integer.parseInt( strMin );

        return hour * 60 + min;
    }
}