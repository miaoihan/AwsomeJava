package DateNumber;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Demo03 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
//		设定生日，String
		String birthday = "2015-05-30";
		
//		将String类型转换为日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(birthday);
		
//		对日期进行计算
		Date spec = prepareBirthdayDay(date);
		
//		将计算后的结果，转换为String类型，输出
		String s2 = sdf.format(spec);
		System.out.println(birthday + "提前2周的周六为：" + s2);
	}
	
	/**
	 * 传入1个日期，计算出该日期的2个星期前的 周六的日期
	 * @param birthdayDate 传入的日期
	 * @return 2周前的周六的日期
	 */
	public static Date prepareBirthdayDay(Date birthdayDate){
		Calendar cal = new GregorianCalendar();
		cal.setTime(birthdayDate); //接收传入的date日期，转换为Calendar
		cal.add(Calendar.WEEK_OF_MONTH, -2);//提前2周
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);//调整为当前星期的周六
		return cal.getTime();
	
		
	}
	

}