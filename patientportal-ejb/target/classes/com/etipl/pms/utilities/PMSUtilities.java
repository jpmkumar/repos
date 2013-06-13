/**
* @Author Muthu
* @version 1.0
*
*  This is the Utilities java file,
*  it contains functions related to date,time,time zone conversion from DB to GUI and GUI to DB.
*/
package com.etipl.pms.utilities;

import java.math.BigInteger;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.etipl.pms.dto.DateStartEnd;


public class PMSUtilities {
	private static final Logger logger = LoggerFactory.getLogger(PMSUtilities.class);
	private static final String DATE_TIME_FORMAT_DB="yyyy-MM-dd k:mm";
	private static final String DATE_FORMAT_GUI="MM/dd/yyyy";
	private static final String DATETIME_FORMAT_GUI = "MM/dd/yyyy HH:mm";
	private static final String DATE_FORMAT_GUI1="MMM-dd-yyyy HH:mm";
	private static final String DATE_TIME_FORMAT_GUI="MM/dd/yyyy HH:mm";
	private static final String ONLY_DATE_FORMAT_GUI="MM/dd/yyyy";
	private static final String ONLY_TIME_FORMAT_GUI = "HH:mm";
	private static final String DAY_OF_WEEK = "EEEE";
	
	/**
	 * Gets mysql string date to GUI
	 * @param yyyy-MM-dd HH:mm:ss
	 * @return MM/dd/yyyy HH:mm
	 */
	 public static String getMysqlDatetoGUI(String dt){
		    try{
		        SimpleDateFormat formatter, FORMATTER;
		        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        String USDate=null;
		        Date date = formatter.parse(dt);
		        FORMATTER = new SimpleDateFormat(DATE_TIME_FORMAT_GUI);
		        USDate=FORMATTER.format(date);

		        return USDate;
		    } catch (ParseException e){
		    	 logger.error("There is an exception");
		          e.printStackTrace(); 
		                 return null;
		    }
	 }

	 /**
	  * Change string date format from MySQL date string to Fileman
	  * @param date
	  * @return String
	  */
	 public static String changeDateFormatfromMySQLtoFileman(String date)
	    {
			String filemandate ="";
			try {
	        String arrdatetime[] = date.split(" ");
	        String strdate = arrdatetime[0];
	        String strtime = arrdatetime[1];
	        String arrdate[]= strdate.split("\\/");
	        String month = arrdate[0];
	        String day = arrdate[1];
	        String year = arrdate[2];
	        String arrtime[] = strtime.split("\\:");
	        String hour = arrtime[0];
	        String min = arrtime[1];
	        filemandate = (Integer.parseInt(year)-1700)+""+appendZero(month)+""+appendZero(day)+"."+appendZero(hour)+appendZero(min);
	        
			}catch(ArrayIndexOutOfBoundsException ae){
				logger.info(ae.getMessage());
			}catch(Exception e){
				logger.info(e.getMessage());
			}
	        
			logger.info("final fileman format date "+filemandate);
	        
	        return filemandate;
	    }
		
	 /**
	  * Change string date format from file man to Database
	  * @param String
	  * @return java.util.Date
	  */
	 public static Date changeDateFormatfromFilemantoDatabase(String date)
	    {
			String databasedate ="";
			Date dtdate =null;
			try {
				logger.info("changing fileman to database->Date:"+date);
		        String month = date.substring(3,5);
		        String day = date.substring(5,7);
		        String year = date.substring(0,3);	        		        
		        databasedate = (Integer.parseInt(year)+1700)+"-"+appendZero(month)+"-"+appendZero(day);	        
			}catch(ArrayIndexOutOfBoundsException ae){
				logger.info(ae.getMessage());
			}catch(Exception e){
				logger.info(e.getMessage());
			}	        
			logger.info("final database format date "+databasedate);
			try{
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			    dtdate = formatter.parse(databasedate);
			}catch(Exception e){
				logger.error(e.getMessage());
			}	        
	        return dtdate;
	    }
	 
	    private static String appendZero(String str)
	    {
	        String retStr = "";
	        if(str.length()==1)
	        {
	            retStr = "0"+str;
	        }
	        else
	            retStr = str;
	        return retStr;
	    }

	 /**
	  * Gets GUI string date format(MM/dd/yyyy HH:mm) by converting the date/time with time zone 
	  * @param yyyy-MM-dd HH:mm
	  * @param MMM dd, yyyy hh:mm:ss a
	  * @return MM/dd/yyyy HH:mm
	  */
	 public static String convertDateTimefromDBToGui(Object result, String timezone){
		    try{
		    	
		    	DateFormat formatter= DateFormat.getDateTimeInstance();
		    	TimeZone tz = TimeZone.getTimeZone(timezone);
		    	formatter.setTimeZone(tz);
		    	String strresult = result+"";
		    	String arr[] = strresult.split("\\.");
		    	
		    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date date = sdf.parse(arr[0]);
				
		    	
		    	String d1 = formatter.format(date);

		    	SimpleDateFormat sdf2 = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a");
		    	date = sdf2.parse(d1);
		    	boolean daylight = tz.inDaylightTime(date);
				if(daylight){
					date = getDayLight(date);
				}
		    	
		    	SimpleDateFormat sdf3 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		    	String strdate = sdf3.format(date);

		        return strdate;
		    } 
		    catch (ParseException e)
		    {
		    	 logger.error("There is an exception");
		         e.printStackTrace(); 
              return null;
		    }
	 }
	 
	 /**
	  * Gets GUI string date format(MM/dd/yyyy HH:mm) by converting the date & time with time zone
	  * @param yyyy-MM-dd HH:mm
	  * @param time
	  * @param MMM dd, yyyy hh:mm:ss a
	  * @return MM/dd/yyyy HH:mm
	  */
	 public static String convertDateAndTimeFromDBToGUI(Object resdate, Object time , String timezone){
		    try{
		    	
		    	TimeZone tz = TimeZone.getTimeZone(timezone);
		    	
		    	DateFormat formatter= DateFormat.getDateTimeInstance();
		    	formatter.setTimeZone(tz);
		    	String strresult = resdate+" "+time;
		    	String arr[] = strresult.split("\\.");
		    	
		    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date date = sdf.parse(arr[0]);
								
				boolean daylight = tz.inDaylightTime(date);
		    	
				if(daylight){
					date = getDayLight(date);					
				}				
				
		    	String d1 = formatter.format(date);		    	
		    	
		    	SimpleDateFormat sdf2 = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a");
		    	date = sdf2.parse(d1);
				
		    	SimpleDateFormat sdf3 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		    	String strdate = sdf3.format(date);
				
				return strdate;
		    } 
		    catch (ParseException e)
		    {
		    	 logger.error("There is an exception");
		         e.printStackTrace(); 
           return null;
		    }
	 }
	

	 /**
	  * Gets GUI only date string format(MM/dd/yyyy) from DB(yyyy-MM-dd)
	  * @param yyyy-MM-dd
	  * @return MM/dd/yyyy
	  */
	 public static String getMysqlOnlyDatetoGUI(String dt){
		    try{
		        SimpleDateFormat formatter, FORMATTER;
		        formatter = new SimpleDateFormat("yyyy-MM-dd");
		        String USDate=null;

		        Date date = formatter.parse(dt);
		        FORMATTER = new SimpleDateFormat(ONLY_DATE_FORMAT_GUI);

		        USDate=FORMATTER.format(date);

		        return USDate;
		    } catch (ParseException e){
		    	 logger.error("There is an exception");
		          e.printStackTrace(); 
		                 return null;
		    }
	 }

	 /**
	  * Gets GUI only time string format(HH:mm) from DB
	  * @param HH:mm
	  * @return HH:mm
	  */
	 public static String getMysqlOnlyTimetoGUI(String dt){
		    try{
		        SimpleDateFormat formatter, FORMATTER;
		        formatter = new SimpleDateFormat("HH:mm");
		        String USDate=null;

		        Date date = formatter.parse(dt);
		        FORMATTER = new SimpleDateFormat(ONLY_TIME_FORMAT_GUI);

		        USDate=FORMATTER.format(date);

		        return USDate;
		    } catch (ParseException e){
		    	 logger.error("There is an exception");
		          e.printStackTrace(); 
		                 return null;
		    }
	 }
	 
	
	 
	/**
	 * Get java.util.Date from string TimeStamp
	 * @param tStampDate
	 * @return yyyy-MM-dd k:mm
	 */
	public static java.util.Date getDateFromStringTimeStamp(String tStampDate)
	{
		
		if(tStampDate == null || tStampDate.isEmpty()) {
			return null;
		}
		Date date = null;
		
		DateFormat formatter ; 
	          formatter = new SimpleDateFormat(DATE_TIME_FORMAT_DB);
	          try {
	              date = (Date)formatter.parse(tStampDate);
	              
	          }
	          catch(ParseException e) {
	        	  logger.error("There is an exception");
	        	  date = null;
	          }
	        return date;
	}
	/**
	 * Gets java.util.Date from Date TimeStamp
	 * @param java.util.date
	 * @return yyyy-MM-dd k:mm
	 */
	public static Date getDateFromDateTimeStamp(Date date)
	{	
		if(date == null) {
			return null;
		}
		DateFormat formatter ; 
	    formatter = new SimpleDateFormat(DATE_TIME_FORMAT_DB);
	    try {
	              date = (Date)formatter.parse(formatter.format(date));
	              
	    }catch(ParseException e) {
	    	 logger.error("There is an exception");
	        	  date = null;
	    }
	    return date;
	}
	
	/**
	 * Gets string date from date time stamp of appointment. 
	 * @param java.util.date
	 * @return yyyy-MM-dd k:mm
	 */
	public static String getDateFromDateTimeStamp_appointment(Date date)
	{	
		if(date == null) {
			return null;
		}
		DateFormat formatter ;
		String strdate;
	    formatter = new SimpleDateFormat(DATE_TIME_FORMAT_DB);
	    try {
	              strdate = formatter.format(date);
	    }catch(Exception e) {
	    	 logger.error("There is an exception");
	    	strdate = null;
	    	e.printStackTrace();
	    }
	    return strdate;
	}
	
	public static String getDateFromDateTimeStamp_appointment1(Date date)
	{	
		if(date == null) {
			return null;
		}
		DateFormat formatter ;
		String strdate;
	    formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    try {
	              strdate = formatter.format(date);
	    }catch(Exception e) {
	    	 logger.error("There is an exception");
	    	strdate = null;
	    	e.printStackTrace();
	    }
	    return strdate;
	}
	
	/**
	 * 
	 * @param java.util.date
	 * @return yyyy-MM-dd HH:mm
	 */
	public static String getDateFromDateTimeStamp_showapp(Date date)
	{	
		if(date == null) {
			return null;
		}
		DateFormat formatter ;
		String strdate;
	    formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    try {
	        strdate = formatter.format(date);
	    }catch(Exception e) {
	    	 logger.error("There is an exception");
	    	strdate = null;
	    	e.printStackTrace();
	    }
	    return strdate;
	}
	
	/**
	 * 
	 * @param java.util.date
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static Date getHibernateDateFormat(Date date)
	{
		
		if(date == null) {
			return null;
		}
		DateFormat formatter ; 
	          formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	          try {
	              String strDate = formatter.format(date);
	              date = formatter.parse(strDate);
	              
	          }
	          catch(ParseException e) {
	        	  logger.error("There is an exception");
	        	  date = null;
	          }
	        return date;
	}
	
	
	/**
	 * Get GUI string date to string Mysql
	 * @param MM/dd/yyyy
	 * @return yyyy-MM-dd
	 */
	
	public static String getGUIDatetoMysql(String dt){
	    try{
	            String mysqlDate=null;
	            SimpleDateFormat parseStringtoDate,dateFormat;
	            parseStringtoDate= new SimpleDateFormat("MM/dd/yyyy");
	           
	            Date date = parseStringtoDate.parse(dt);
	            dateFormat= new SimpleDateFormat("yyyy-MM-dd");
	            mysqlDate = dateFormat.format(date);
	            
	            return mysqlDate;
	    }catch(Exception e){
	    	 logger.error("There is an exception");
	    	e.printStackTrace();
	    		return null;
	    }
	    }
	
	/**
	 * Get GUI string date time to Mysql string date time
	 * @param yyyy-MM-dd HH:mm
	 * @return yyyy-MM-dd HH:mm
	 */
	public static String getGUIDateTimeFromMySQL(String dt){
	    try{
	    		
	    		String mysqlDate=null;
	            SimpleDateFormat parseStringtoDate,dateFormat;
	            parseStringtoDate= new SimpleDateFormat("yyyy-MM-dd HH:mm");
	           
	            Date date = parseStringtoDate.parse(dt);
	            dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm");
	            mysqlDate = dateFormat.format(date);
	            
	          return mysqlDate;
	    }catch(Exception e){e.printStackTrace();
	    		return null;
	    }
	    }
	
	/**
	 * Get Mysql string date time from string date and time zone
	 * @param yyyy-MM-dd HH:mm
	 * @return yyyy-MM-dd HH:mm
	 */
	public static String getDateTimeFromMySQL(String dt, String timezone){
	    try{
	    		DateFormat formatter= DateFormat.getDateTimeInstance();
	    		formatter.setTimeZone(TimeZone.getTimeZone(timezone));
	            String mysqlDate=null;
	            SimpleDateFormat parseStringtoDate,dateFormat,afterConvertDate;
	            parseStringtoDate= new SimpleDateFormat("yyyy-MM-dd HH:mm");
	            afterConvertDate=new SimpleDateFormat("MMM dd, yyyy HH:mm:ss aa");
	           
	            Date d = parseStringtoDate.parse(dt);
	            String d1 = formatter.format(d);
	            
	            Date date = afterConvertDate.parse(d1);
	            dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm");
	            mysqlDate = dateFormat.format(date);
	            
	            System.out.println("Converted Date Time : " + mysqlDate);

	            return mysqlDate;
	    }catch(Exception e){e.printStackTrace();
	    		return null;
	    }
	    }
	/**
	 * 
	 * @param String MM/dd/yyyy
	 * @return java.util.date 
	 */
	public static Date getDatefromStringDate(String strdate){
	    try{
	            SimpleDateFormat parseStringtoDate;
	            parseStringtoDate= new SimpleDateFormat("MM/dd/yyyy");
	            Date date = parseStringtoDate.parse(strdate);
	            return date;
	    }catch(Exception e){
	    	 logger.error("There is an exception");
	    	e.printStackTrace();
	    		return null;
	    }
	    }
	
	/**
	 * 
	 * @param java.util.Date
	 * @return MM/dd/yyyy HH:mm
	 */
public static String getStringDateTimeFromDate(Date date) {	
		
		if(date == null) {
			return null;
		}
		SimpleDateFormat parseDatetoString;
        parseDatetoString = new SimpleDateFormat(DATE_TIME_FORMAT_GUI);
        String strdate = parseDatetoString.format(date);

	    return strdate;
}

	/**
	 * This method will convert a sql date to MM/dd/yyyy format.
	 * 
	 * @param date
	 *            Date coming from database.
	 * @return Date formatted to MM/dd/yyyy format.
	 */
	public static String getStringDateOnlyFromDate(Date date) {

		if (date == null) {
			return null;
		}
		SimpleDateFormat parseDatetoString;
		parseDatetoString = new SimpleDateFormat(ONLY_DATE_FORMAT_GUI);
		String strdate = parseDatetoString.format(date);

		return strdate;
	}

	/**
	 * This method will convert a sql date to HH:mm format. Will pick only the
	 * time from the date.
	 * 
	 * @param date
	 *            Date coming from the database.
	 * @return Time from the incoming date in the format HH:mm
	 */
	public static String getStringTimeOnlyFromDate(Date date) {

		if (date == null) {
			return null;
		}
		SimpleDateFormat parseDatetoString;
		parseDatetoString = new SimpleDateFormat(ONLY_TIME_FORMAT_GUI);
		String strdate = parseDatetoString.format(date);

		return strdate;
	}
	
	/**
	 * This method will give back the Day name from the date.
	 * 
	 * @param date
	 *            Date from the database.
	 * @return Day name for e.g. Sunday etc.
	 */
	public static String getDayOfWeekFromDate(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat parseDatetoString;
		parseDatetoString = new SimpleDateFormat(DAY_OF_WEEK);
		String strdate = parseDatetoString.format(date);

		return strdate;
	}
	
	/**
	 * This method will convert a GUI date to Database Date.
	 * 
	 * @param date
	 *            String in format MM/dd/yyyy
	 * @return String in format yyyy-MM-dd
	 */
	public static String getSqlDateFromGui(String date) {
		if (date == null) {
			return null;
		}
		String[] dateFields = date.split("/");
		String formattedDate = dateFields[2]+"-"+dateFields[0]+"-"+dateFields[1];
		return formattedDate;
	}
	
	/**
	 * 
	 * @param java.util.Date
	 * @return MMM-dd-yyyy HH:mm
	 */
public static String getStringDateTimeFromDate1(Date date) {	
	
	if(date == null) {
		return null;
	}
	SimpleDateFormat parseDatetoString;
    parseDatetoString = new SimpleDateFormat(DATE_FORMAT_GUI1);
    String strdate = parseDatetoString.format(date);

    return strdate;
}

/**
 * 
 * @param java.util.Date
 * @return MM/dd/yyyy
 */
public static String getStringDateFromDate(Date date) {	
	
	if(date == null) {
		return null;
	}
	SimpleDateFormat parseDatetoString;
    parseDatetoString = new SimpleDateFormat(DATE_FORMAT_GUI);
    String strdate = parseDatetoString.format(date);

    return strdate;
}
	


public static Date getDayLight(Date date){

	Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(Calendar.HOUR_OF_DAY, -1);
    return c.getTime();

}
/**
 * 
 * @param date
 * @param tzone
 * @return yyyy-MM-dd HH:mm z
 */
public static Date convertdatefromGuiToDb(String date, String tzone){
    try{
    	TimeZone  timezone = TimeZone.getTimeZone(tzone);
		String offset  =  PMSUtilities.getOffSet(timezone);
		String frmdate = date+" "+offset;
		 logger.info("offset :"+offset);				
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm z");  
		Date dateFirst = sdf.parse(frmdate);
				
		 logger.info("d :"+dateFirst);
		return dateFirst;
    } 
    catch (ParseException e)
    {	 logger.error("There is an exception");
         e.printStackTrace(); 
      return null;
    }
}

public static Date convertdatefromGuiToDb2(String date, String tzone){
    try{
    	 TimeZone  timezone = TimeZone.getTimeZone(tzone);
		String offset  =  PMSUtilities.getOffSet(timezone);
		String frmdate = date+" "+offset;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm z");  
		Date dateFirst = sdf.parse(frmdate);
		return dateFirst;
    } 
    catch (ParseException e)
    {	 logger.error("There is an exception");
         e.printStackTrace(); 
      return null;
    }
}

	public static Date addDateStartTime(Date date){
	    try{
	            SimpleDateFormat parseStringtoDate;
	            parseStringtoDate= new SimpleDateFormat("MM/dd/yyyy");
	            String strdate = parseStringtoDate.format(date);
	            parseStringtoDate= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	            date = parseStringtoDate.parse(strdate+" 00:00:00");
	       }catch(Exception e){e.printStackTrace();
	    		return null;
	    }
	    return date;
	    }
	
	public static Date addDateEndTime(Date date){
		
	    try{
	    	 SimpleDateFormat parseStringtoDate;
	            parseStringtoDate= new SimpleDateFormat("MM/dd/yyyy");
	            String strdate = parseStringtoDate.format(date);
	            parseStringtoDate= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	            date = parseStringtoDate.parse(strdate+" 23:59:59");	            
	    }catch(Exception e){e.printStackTrace();
	    		return null;
	    }
	    return date;
	    }

	
	public static Date addStringStartTime(String strdate){
		Date date=null;
	    try{
	            SimpleDateFormat parseStringtoDate;
	            parseStringtoDate= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	            date = parseStringtoDate.parse(strdate+" 00:00:00");
	            
	    }catch(Exception e){
	    	 logger.error("There is an exception");
	    	e.printStackTrace();
	    		return null;
	    }
	    return date;
	    }
	
	public static Date addStringEndTime(String strdate){
		
		Date date=null;
	    try{
	            SimpleDateFormat parseStringtoDate;
	            parseStringtoDate= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	            date = parseStringtoDate.parse(strdate+" 23:59:59");
	          
	    }catch(Exception e){
	    	 logger.error("There is an exception");
	    	e.printStackTrace();
	    		return null;
	    }
	    return date;
	    }
	
	
	/**
	 * 
	 * @param java.util.Date
	 * @return yyyy-MM-dd
	 */
	
	public static String getStringDatefromDate(Date date){
	    try{
	    	if(date == null) {
				return null;
			}	    	
	            SimpleDateFormat parseDatetoString;
	            parseDatetoString = new SimpleDateFormat("yyyy-MM-dd");
	            String strdate = parseDatetoString.format(date);
	            return strdate;
	    }catch(Exception e){
	    	 logger.error("There is an exception");
	    	e.printStackTrace();
	    		return null;
	    }
	    }
	
	
	/**
	 * 
	 * @param String MM/dd/yyyy
	 * @return java.util.Date
	 */
	
	public static java.util.Date getDateFromString(String str) {
		if(str == null || str.isEmpty()) {
			return null;
		}
		 Date date = null;
		DateFormat formatter ; 
		
		   formatter = new SimpleDateFormat(DATE_FORMAT_GUI);
	          try {
	              date = (Date)formatter.parse(str);
	          }
	          catch(ParseException e) {
	        	  date = null;
	          }
	        return date;
	}	
	
	/**
	 * 
	 * @return current date and time yyyy-MM-dd HH:mm:ss
	 */
	public static java.util.Date getCurrentDateTime(){
		Date date = null;
		try{
		   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  date = new Date();
		    logger.info(dateFormat.format(date));
	 		Calendar cal = Calendar.getInstance();
		   String str = dateFormat.format(cal.getTime());
		   date = (Date) dateFormat.parse(str);
		    logger.info(dateFormat.format(cal.getTime()));
		   
		}catch(Exception e){
			 logger.error("There is an exception");
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 
	 * @return current date MM/dd/yyyy
	 */
	public static String getCurrentDate(){
		Date date = null;
		String currdate  = null;
		try{
		   DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		   date = new Date();
		   currdate = dateFormat.format(date);
		   
		}catch(Exception e){
			 logger.error("There is an exception");
			e.printStackTrace();
		}
		return currdate;
	}
	
	public static DateStartEnd getStartAndEndDateOfMonth(Date date){
			DateStartEnd dse=new DateStartEnd();
			Calendar c = Calendar.getInstance();
	        c.setTime(date);	        
	        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));	          
	        dse.setStartDate(c.getTime());	        
	        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
	        dse.setEndDate(c.getTime());
			return dse;		
	}	

	public static DateStartEnd getStartAndEndDateOfWeek(Date date){
		DateStartEnd dse=new DateStartEnd();
		Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        dse.setStartDate(c.getTime());
        c.add(Calendar.DATE, 6);
        dse.setEndDate(c.getTime());
		return dse;
	
	}
	
	public static String getToTime(String fromTime,String duration){
		String toTime = null;
		try{
			String[] secMts = fromTime.split("\\:");
			int defaultMts = 60;
			
			if(60 == Integer.parseInt(duration)){
				toTime = String.valueOf(Integer.parseInt(secMts[0])+1)+":"+String.valueOf(secMts[1]);
			}else{				
				int x = defaultMts - Integer.parseInt(secMts[1]);
				String mts = String.valueOf(Integer.parseInt(duration)-x); 
				toTime = String.valueOf(Integer.parseInt(secMts[0])+1)+":"+mts;
			}			
		}catch(Exception e){
			 logger.error("There is an exception");
			e.printStackTrace();
		}
		
		 logger.info("toTime:"+toTime);
		
		return toTime;
	}	
	
	public static Date changeDateTimeAccordingtoFacilityTimeZone(String facilityTimzone, Date datetime){
		datetime = changeDateTimeAccordingtoTimeZone(facilityTimzone, "UTC", datetime);
		return datetime;
	}
	
	
	public static Date changeDateTimeAccordingtoTimeZone(String srctimezone, String desttimezone, Date newdate ){
         String str_date="03-May-13 19:42";
		  logger.info("new date :"+newdate);
        try{
 
        DateFormat formatternew = null ; 
        
        formatternew = new SimpleDateFormat("dd-MMM-yy HH:mm");
        newdate = formatternew.parse(str_date);
        
        DateFormat formatter= DateFormat.getDateTimeInstance();
         logger.info("formatter's timezone (local timezone): "+formatter.getTimeZone());
         formatter.setTimeZone(TimeZone.getTimeZone(srctimezone));
         
          logger.info("formatter's timezone (gamt): "+formatter.getTimeZone());
         str_date = formatter.format(newdate);
          logger.info("source time zone "+str_date);
         
         formatter.setTimeZone(TimeZone.getTimeZone(desttimezone));
         str_date = formatter.format(newdate);
          logger.info("destination str_date "+str_date);
         
        }catch(Exception e){
        	 logger.error("There is an exception");
            e.printStackTrace();
        }
         return getDateFromStringTimeStamp(str_date);
    }

	public static boolean isDST(TimeZone timezone){
        int offsetofdst = timezone.getDSTSavings();
        boolean dst=false;
        if(offsetofdst==0){
            dst=false;
        }else {
            dst=true;
        }
        return dst;
    }
    
    public static String getOffSet(TimeZone timezone){
        int offset = timezone.getOffset(Calendar.ZONE_OFFSET);
         int hours = 0, min=0;
        String finalstring="";
        hours = (offset)/(1000*60*60);
        int remainder = (offset)%(1000*60*60);
        min = remainder/(60*1000);
        String strhours="",strmin="";
        strhours=hours+"";
        strmin=min+"";
        
        if(hours>=0){
            if(strhours.length()==1){
                finalstring="+0"+strhours;
            }
            else{
                finalstring="+"+strhours+"";
            }
        }else{
             if(strhours.length()==2){
                finalstring=strhours.substring(0,1)+"0"+strhours.substring(1,strhours.length());
            }
            else{
                finalstring=strhours;
            }
        }
        if(min>=0){
            if(strmin.length()==1){
                finalstring+="0"+strmin;
            }else{
                finalstring+=strmin;
            }
        }else{
             if(strmin.startsWith("-")){
                finalstring+=strmin.substring(1,strmin.length());
            }
            else{
                finalstring+=strmin;
            }
        }    
             return finalstring;
   }
    /**
     * 
     * @param Date and time String
     * @return MM/dd/yyyy HH:mm
     */
	public static java.util.Date getDateTimeFromString(String str) {	
		
		if(str == null || str.isEmpty()) {
			return null;
		}
		 Date date = null;
		DateFormat formatter ; 
	          formatter = new SimpleDateFormat(DATETIME_FORMAT_GUI);
	          try {
	              date = (Date)formatter.parse(str);
	          }
	          catch(ParseException e) {
	        	  e.printStackTrace();
	        	  date = null;
	          }
	           logger.info("Date:"+date);
	        return date;
	}
	
	
public static java.util.Date getDateTimeFromObject(Object str) {	
		
		String strresult = str+"";
		logger.info("date is : "+strresult);
		String arr[] = strresult.split("\\.");
		logger.info("date arr : "+arr[0]);
		Date date = null;
		DateFormat formatter ; 
	          formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	          try {
	              date = (Date)formatter.parse(arr[0]);
	          }
	          catch(ParseException e) {
	        	  e.printStackTrace();
	        	  date = null;
	          }
	           logger.info("Date:"+date);
	        return date;
	}

/**
 * This method is used to encrypt(MD5 encryption) the password for the user prior to saving in the database.
 * @param password string to encrypt
 * @return encrypted Password
 */
public static String hashPassword(String password) {
    String hashword = null;
    try {
    	logger.info("password metfod:"+password);
        MessageDigest md5 = MessageDigest.getInstance("MD5");            
        md5.update(password.getBytes());
        BigInteger hash = new BigInteger(1, md5.digest());
        hashword = hash.toString(16);
        logger.info("has password:"+hashword);
    }catch (Exception e) {
        e.printStackTrace();
     }	        
    return hashword;
}
}
