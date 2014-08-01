import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.TimeZone;
/*
 * Author: Derek Zhu
 * Date Time: 1/08/2014 4pm
    
    Develop a small application to read a CSV with a UTC datetime, latitude and longitude columns and append the 
	timezone the vehicle is in and the localised datetime. See example of CSV input and output below. We will then 
	run this over several test files with several rows of data.
	
	Input
	2013-07-10 02:52:49,-44.490947,171.220966 
	
	Output 
	2013-07-10 02:52:49,-44.490947,171.220966,Pacific/Auckland,2013-07-10 14:52:49

 * */
public class Solution {
	public static boolean _DEBUG_ = false;
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		String input;
		while((input = in.readLine()) != null ){
			try {
				System.out.println(calculate(input));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	// for every entry:
	static String calculate(String input) throws ParseException{
		String[] inputs = input.split(",");
		
		// declare the format
		// UTC time
		Calendar calendarUTC = new GregorianCalendar();
		Calendar calendarOut = new GregorianCalendar();
		calendarUTC.setTimeZone(TimeZone.getTimeZone("UTC"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		// parse the parts to string
		String DateTimeStr = inputs[0];
		String Latitude = inputs[1];
		String Longitude = inputs[2];
	
		
        calendarUTC.setTime(sdf.parse(DateTimeStr));
        String timestampStr = "" + calendarUTC.getTime().getTime() / 1000;
        
        
        String request = "https://maps.googleapis.com/maps/api/timezone/xml?location="+Latitude+","+Longitude+"&timestamp="+timestampStr+"&sensor=false";
        // <?xml version="1.0" encoding="UTF-8"?><TimeZoneResponse> <status>OK</status> <raw_offset>43200.0000000</raw_offset> <dst_offset>3600.0000000</dst_offset> <time_zone_id>Pacific/Auckland</time_zone_id> <time_zone_name>New Zealand Daylight Time</time_zone_name></TimeZoneResponse>
        String xmltext = get_xml_server_reponse(request);
        
        // Error Check:
        if (xmltext.contains("<status>ZERO_RESULTS</status>")){
        	System.err.println("Error, Server responed with status: ZERO_RESULTS");
        	return null;
        }
        // parse xmltext
        String time_zone_id = getStringFromXML(xmltext, "time_zone_id");
        String offsetStr = getStringFromXML(xmltext, "raw_offset");
        Long raw_offset_long = (long) (Double.parseDouble(offsetStr) * 1000);
        
        calendarOut.setTimeZone(TimeZone.getTimeZone(time_zone_id));
        calendarOut.setTimeInMillis(calendarUTC.getTimeInMillis() + raw_offset_long); //  2013-07-10 02:52:49,-44.490947,171.220966
        return input + "," + time_zone_id + "," + sdf.format(calendarOut.getTime());
	}
	static String getStringFromXML(String str, String mark){
		int start = str.indexOf("<" + mark + ">") + ("<" + mark + ">").length();
		int end = str.indexOf("</" + mark + ">");
		return str.substring(start, end);
	}
	// http://stackoverflow.com/questions/6567923/timezone-conversion
	static String get_xml_server_reponse(String server_url){
	    URL xml_server = null;
	    String xmltext = "";
	    InputStream input;
	    try {
	        xml_server = new URL(server_url);
	        try {
	            input = xml_server.openConnection().getInputStream();
	            final BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	            final StringBuilder sBuf = new StringBuilder();

	            String line = null;
	            try {
	                while ((line = reader.readLine()) != null) 
	                {
	                    sBuf.append(line);
	                }
	               } 
	            catch (IOException e) 
	              {
	                    if (_DEBUG_)System.out.println((e.getMessage() + "XML parser, stream2string 1"));
	              } 
	            finally {
	                try {
	                    input.close();
	                    }
	                catch (IOException e) 
	                {
	                	if (_DEBUG_)System.out.println(e.getMessage() + "XML parser, stream2string 2");
	                }
	            }
	            xmltext =  sBuf.toString();
	        } catch (IOException e1) {
	                e1.printStackTrace();
	            }
	        } catch (MalformedURLException e1) {
	          e1.printStackTrace();
	        }
	     return  xmltext;
	  }   
	
}
