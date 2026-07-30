package Herencia;

import java.util.Calendar;
import java.util.Locale;

public class testCalendar {
    static void main(){
        Calendar hoy  = Calendar.getInstance();
        System.out.println("Fecha Actual: " + hoy.getTime() + "  ms: " + hoy.getTimeInMillis());

        
        Calendar custom = Calendar.getInstance();

        custom.setTimeInMillis(1);
        System.out.println("La primera fecha de Calendar: " + custom.getTime());

        custom.setTimeInMillis(Long.MAX_VALUE);
        System.out.println("La ultima fecha de calendar: " + custom.getTime());

        custom.set(2006, Calendar.FEBRUARY, 3);
        System.out.println("Fecha de cumpleaños Alex: "+custom.getTime());

        //Comparar fechas
        if(custom.before(hoy)){
            System.out.println("Si paso antes");
        } if (hoy.after(custom)){
            System.out.println("Si, hoy es despues del cumpleaños de Alex");
        } if(hoy.getTimeInMillis()>= custom.getTimeInMillis()) {
            System.out.println("Si, hoy es despues del cumpleaños de Alex");
        }

        //Valores individuales
        System.out.println("Dia:" + custom.get(Calendar.DATE));
        System.out.println("Semana del año:" + custom.get(Calendar.WEEK_OF_YEAR));
        int month = custom.get(Calendar.MONTH);
        System.out.println("Mes:" + month);

        custom.add(Calendar.YEAR, 5);
        System.out.println("Custom de 5 años mas: " + custom.getTime());
        custom.add(Calendar.MONTH, -10);
        System.out.println("Custom de 10 meses antes: " + custom.getTime());

        String mestxt=custom.getDisplayName(Calendar.MONTH, Calendar.LONG,Locale.forLanguageTag("es"));
        System.out.println("Mes: " + mestxt);

    }
}
