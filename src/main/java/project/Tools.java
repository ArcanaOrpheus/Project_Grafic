package project;

import java.util.Calendar;
import java.util.Date;

public class Tools {
	public static Date sumarDies(Date dataInici, int dies) {
        Calendar cal = Calendar.getInstance(); 
        cal.setTime(dataInici); 
        cal.add(Calendar.DATE, dies);
        return cal.getTime();
	}
}
