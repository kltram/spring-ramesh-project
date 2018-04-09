package com.seekerscapital.sp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * This class handles the handles loggers. 
 * @author Ramesh
 */

public class LoggerUtil {
	private static String SERVICE = "SERVICE";
	public static Logger getServiceLogger(){
		return LoggerFactory.getLogger(SERVICE);
	}

}
