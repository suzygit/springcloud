package com.cloud.cloud.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateUtils {

	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String MMDD = "MMdd";
	public static final String HH_MM_SS = "HH:mm:ss";
	public static final String YYYYMMDDHHmmss = "yyyyMMddHHmmss";
	public static final String YYMMDD = "yyMMdd";

	/**
	 * yyyy-MM-ddTHH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String getEcdsDateString(Date date) {
		return new StringBuffer(getDateString(date)).append("T").append(getTimeString(date)).toString();
	}

	/**
	 * YYYY_MM_DD
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateString(Date date) {
		return formatDate(YYYY_MM_DD, date);
	}
	
	public static String getYYMMDDString(Date date) {
		return formatDate(YYMMDD, date);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateTimeString(Date date) {
		return formatDate(YYYY_MM_DD_HH_MM_SS, date);
	}

	public static String getTimeString(Date date) {
		return formatDate(HH_MM_SS, date);
	}

	/**
	 * 日期格式化
	 * 
	 * @param strFormat
	 *            格式化的样式
	 * @param c
	 *            待格式化的日期
	 * @return String 格式化后的字符串
	 **/
	public static String formatDate(String strFormat, Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(strFormat);
		return formatter.format(date);
	}

	public static String formatDate(Date date, String strFormat) {
		SimpleDateFormat formatter = new SimpleDateFormat(strFormat);
		return formatter.format(date);
	}

	public static String formatDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(YYYY_MM_DD);
		return formatter.format(date);
	}

	public static Date formatString(String date, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static Date formatString(String date) {
		SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD);
		try {
			return format.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @param date
	 *            yyyy-MM-dd
	 * @return
	 * @throws ParseException
	 */
	public static Date getStringDate(String date) {
		return formatString(date, YYYY_MM_DD);
	}

	/**
	 * 
	 * @param date
	 *            yyyy-MM-dd HH:mm:ss
	 * @return
	 * @throws ParseException
	 */
	public static Date getStringDateTime(String date) {
		return formatString(date, YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * 
	 * @param date
	 *            yyyy-MM-ddTHH:mm:ss
	 * @return
	 * @throws ParseException
	 */
	public static Date getStringEcdsDate(String date) throws ParseException {
		String replace = date.replace("T", " ");
		return formatString(replace, YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * YYYYMMDDHHmmss
	 * 
	 * @param date
	 * @return
	 */
	public static String getDS(Date date) {
		return formatDate(YYYYMMDDHHmmss, date);
	}

	/**
	 * 得到后几天
	 * 
	 * @param tsDate
	 *            日期
	 */

	public static Date getNextDate(Date tsDate, int nDay) {
		if (null == tsDate) {
			return null;
		}
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(tsDate);
		calendar.add(Calendar.DATE, nDay);
		Date resDate = calendar.getTime();
		return new Date(resDate.getTime());
	}

	/**
	 * 得到前几天
	 * 
	 * @param tsDate
	 *            日期
	 */

	public static Date getUpDate(Date tsDate, int nDay) {
		if (null == tsDate) {
			return null;
		}
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(tsDate);
		calendar.add(Calendar.DATE, -1 * nDay);
		Date resDate = calendar.getTime();
		return new Date(resDate.getTime());
	}

	/**
	 * 日期差天数
	 * 
	 * @param begin_date
	 * @param end_date
	 * @return
	 * @throws Exception
	 */
	public static Long getIntervalDay(Date begin_date, Date end_date) throws Exception {
		long day = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		if (begin_date != null) {
			String begin = sdf.format(begin_date);
			begin_date = sdf.parse(begin);
		}
		if (end_date != null) {
			String end = sdf.format(end_date);
			end_date = sdf.parse(end);
		}
		day = (end_date.getTime() - begin_date.getTime()) / (24 * 60 * 60 * 1000);
		return day;
	}

	/**
	 * 日期差天数
	 * 
	 * @param begin_date
	 * @param end_date
	 * @return
	 * @throws Exception
	 */
	public static Long getIntervalDay(String begin_date, String end_date) throws Exception {
		return getIntervalDay(getStringDate(begin_date), getStringDate(end_date));
	}

	/**
	 * 将Date类转换为XMLGregorianCalendar
	 * 
	 * @param date
	 * @return
	 */
	public static XMLGregorianCalendar dateToXmlDate(String dateStr) {
		Date date = null;
		if (dateStr.equals("")) {
			return null;
		}
		if (dateStr.length() == 8 && dateStr.indexOf(":") != -1) {
			date = DateUtils.formatString(dateStr, HH_MM_SS);
		} else if (dateStr.length() <= 10) {
			date = DateUtils.getStringDate(dateStr);
		} else {
			date = DateUtils.getStringDateTime(dateStr);
		}
		if (date == null)
			return null;

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		DatatypeFactory dtf = null;
		try {
			dtf = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
		}
		XMLGregorianCalendar dateType = dtf.newXMLGregorianCalendar();
		dateType.setYear(cal.get(Calendar.YEAR));
		// 由于Calendar.MONTH取值范围为0~11,需要加1
		dateType.setMonth(cal.get(Calendar.MONTH) + 1);
		dateType.setDay(cal.get(Calendar.DAY_OF_MONTH));
		dateType.setHour(cal.get(Calendar.HOUR_OF_DAY));
		dateType.setMinute(cal.get(Calendar.MINUTE));
		dateType.setSecond(cal.get(Calendar.SECOND));
		return dateType;
	}

	/**
	 * 将XMLGregorianCalendar转换为Date
	 * 
	 * @param cal
	 * @return
	 */
	public static String xmlDate2Date(XMLGregorianCalendar cal) {
		if (null == cal)
			return null;
		Date date = cal.toGregorianCalendar().getTime();
		String sss = DateUtils.getDateTimeString(date);
		if (sss.indexOf(" 00:00:00") != -1) {
			sss = sss.replaceAll(" 00:00:00", "");
		}else if(sss.indexOf("1970-01-01 ") != -1){
			sss = sss.replaceAll("1970-01-01 ", "");
		}
		return sss;
	}

	public static String getBizDateTime(Date bizDate) {
		String value = DateUtils.formatDate("yyyy-MM-dd", bizDate);
		String time = DateUtils.formatDate("HH:mm:ss", new Date());
		return value + " " + time;
	}
}
