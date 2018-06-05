package hibernateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String getDateToSrtring(Date date) {
		
		 SimpleDateFormat formatter2=new SimpleDateFormat("dd/MM/yyyy");
	        String dateToString=formatter2.format(date);
	        return dateToString;
	}
	public static Date getStringToDate(String StringDate) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        Date date = formatter.parse(StringDate);
       return date;

	} 
	public static void compareTwoDates(Date date1,Date date2) {
		if (date1.compareTo(date2) > 0) {
            System.out.println("Date1 is after Date2");
        } else if (date1.compareTo(date2) < 0) {
            System.out.println("Date1 is before Date2");
        } else if (date1.compareTo(date2) == 0) {
            System.out.println("Date1 is equal to Date2");
        } else {
            System.out.println("How to get here?");
        }
		}
}
