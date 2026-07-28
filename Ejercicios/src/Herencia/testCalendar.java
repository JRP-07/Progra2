package Herencia;

import java.util.Calendar;

public class testCalendar {
    static void main(){
        Calendar hoy  = Calendar.getInstance();
        System.out.println("Fecha Actual: " + hoy.getTime() + "  ms: " + hoy.getTimeInMillis());

        
        Calendar custom = Calendar.getInstance();

        custom.setTimeInMillis(1);
        System.out.println("La primera fecha de Calendar: " + custom.getTime());

        custom.setTimeInMillis(Long.MAX_VALUE);
        System.out.println("La ultima fecha de calendar: " + custom.getTime());
    }
}
