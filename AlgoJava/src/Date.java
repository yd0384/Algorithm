import java.util.Calendar;

public class Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(cal.YEAR));
		System.out.println(cal.get(cal.MONTH)+1);
		System.out.println(cal.get(cal.DATE));
	}

}
