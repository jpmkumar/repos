/**
 * @author Muthu
 *
 * This file contains the methods related to date, time conversion from GUI to Mysql and to GUI.
 *
 */
package com.etipl.pms.Utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PMSGUIUtilities {
	private static final Logger logger = LoggerFactory
			.getLogger(PMSGUIUtilities.class);
	private static final String DATETIME_FORMAT_GUI = "MM/dd/yyyy HH:mm";
	private static final String DATE_FORMAT_GUI = "MM/dd/yyyy";
	private static final String DATE_FORMAT_GUI1 = "MMM-dd-yyyy HH:mm";

	/**
	 * Get java.util.Date time from string
	 * @param str
	 * @return java.util.Date
	 */
	public static java.util.Date getDateTimeFromString1(String str) {

		if (str == null || str.isEmpty()) {
			return null;
		}
		Date date = null;
		DateFormat formatter;
		formatter = new SimpleDateFormat(DATE_FORMAT_GUI1);
		try {
			date = (Date) formatter.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			date = null;
		}
		logger.info("Date:" + date);
		return date;
	}
	/**
	 * Gets java.util.Date time from string for DB
	 * @param str
	 * @return java.util.Date
	 */
	public static java.util.Date getDateTimeFromStringForDB(String str) {

		if (str == null || str.isEmpty()) {
			return null;
		}
		Date date = null;
		DateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = (Date) formatter.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			date = null;
		}
		logger.info("Date:" + date);
		return date;
	}

	/**
	 * Gets java.util.Date time from string
	 * @param str
	 * @return java.util.Date
	 */
	public static Date getDateTimeFromString2(String strdate) {

		Date date = null;
		try {
			SimpleDateFormat parseStringtoDate;
			parseStringtoDate = new SimpleDateFormat("MM/dd/yyyy HH:mm");
			date = parseStringtoDate.parse(strdate);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return date;
	}

	/**
	 * Gets string time from java.util.Date
	 * @param str
	 * @return java.util.Date
	 */
	public static String getTimeFromDate(Date date) {

		if (date == null) {
			return null;
		}
		DateFormat formatter;
		String strdate;
		formatter = new SimpleDateFormat("HH:mm");
		try {
			strdate = formatter.format(date);
		} catch (Exception e) {
			logger.error("There is an exception");
			strdate = null;
			e.printStackTrace();
		}
		return strdate;
	}

	/**
	 * Gets java.util.Date  time from string
	 * @param str
	 * @return java.util.Date
	 */
	public static java.util.Date getDateTimeFromString(String str) {

		if (str == null || str.isEmpty()) {
			return null;
		}
		Date date = null;
		DateFormat formatter;
		formatter = new SimpleDateFormat(DATETIME_FORMAT_GUI);
		try {
			date = (Date) formatter.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			date = null;
		}
		logger.info("Date:" + date);
		return date;
	}

	/**
	 * Gets java.util.Date from string
	 * @param str
	 * @return java.util.Date
	 */
	public static java.util.Date getDateFromString(String str) {

		if (str == null || str.isEmpty()) {
			return null;
		}
		Date date = null;
		DateFormat formatter;
		formatter = new SimpleDateFormat(DATE_FORMAT_GUI);
		try {
			date = (Date) formatter.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			date = null;
		}
		logger.info("Date:" + date);
		return date;
	}

	public static String getMysqlOnlyDatetoGUI(String dt) {
		try {
			SimpleDateFormat formatter, FORMATTER;
			formatter = new SimpleDateFormat("yyyy-MM-dd");
			String USDate = null;

			Date date = formatter.parse(dt);
			FORMATTER = new SimpleDateFormat(DATE_FORMAT_GUI);

			USDate = FORMATTER.format(date);

			return USDate;
		} catch (ParseException e) {
			logger.error("There is an exception");
			e.printStackTrace();
			return null;
		}
	}

	public static String getMysqlDate(String dt) {
		try {
			SimpleDateFormat formatter, FORMATTER;
			formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
			String USDate = null;

			Date date = formatter.parse(dt);
			FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			USDate = FORMATTER.format(date);

			return USDate;
		} catch (ParseException e) {
			logger.error("There is an exception");
			e.printStackTrace();
			return null;
		}
	}

	public static String getMysqlGUIDate(String dt) {
		try {
			SimpleDateFormat formatter, FORMATTER;
			formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String USDate = null;

			Date date = formatter.parse(dt);
			FORMATTER = new SimpleDateFormat("MM/dd/yyyy HH:mm");

			USDate = FORMATTER.format(date);

			return USDate;
		} catch (ParseException e) {
			logger.error("There is an exception");
			e.printStackTrace();
			return null;
		}
	}
}
