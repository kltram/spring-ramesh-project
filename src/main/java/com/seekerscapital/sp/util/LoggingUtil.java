package com.seekerscapital.sp.util;
import org.slf4j.Logger;
/**
 * This class handles the handles loggers. 
 * @author Ramesh
 */

public class LoggingUtil {
	private static final String ENTER = "Entering ";
	private static final String EXIT = "Exiting ";
	
	public static void logEnteringMethod(final String className, final String methodName, final Logger log) {
		log.info(ENTER + className + "." + methodName);
	}

	public static void logEnteringMethodDebug(final String className, final String methodName, final Logger log) {
		log.debug(ENTER + className + "." + methodName);
	}

	public static void logExitingMethod(final String className, final String methodName, final Logger log) {
		log.info(EXIT + className + "." + methodName);
	}

	public static void logExitingMethodDebug(final String className, final String methodName, final Logger log) {
		log.debug(EXIT + className + "." + methodName);
	}
}
