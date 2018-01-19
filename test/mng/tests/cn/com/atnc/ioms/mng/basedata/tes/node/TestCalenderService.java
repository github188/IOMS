package mng.tests.cn.com.atnc.ioms.mng.basedata.tes.node;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import test.cn.com.atnc.common.MyBaseTransationalTest;


public class TestCalenderService extends MyBaseTransationalTest {	
	/*@Test
	public void updateCalendar() {
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());		
	}
	*/
	
	public static void main(String[] args)
	{
		Calendar c = Calendar.getInstance();
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  // DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);  
	       // Create our Gregorian Calendar.  
	       //GregorianCalendar cal = new GregorianCalendar();  
	  
	       // Set the date and time of our calendar  
	       // to the system&s date and time  
	       //cal.setTime(new Date());  
	       System.out.println("System Date: " +df.format(c.getTime()));  
	}

/*	public static int timeCompare(String time1, String time2) {
        int result = 1;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(df.parse(time1));
            c2.setTime(df.parse(time2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        result = c1.compareTo(c2);
        return result;
    }*/
}
