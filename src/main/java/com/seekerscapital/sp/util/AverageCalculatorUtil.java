package com.seekerscapital.sp.util;
import java.util.List;
import org.slf4j.Logger;
/**
 * @author Ramesh
 * @since 1.0
 * @version Revision History
 * 
 *<pre>
 * --------------------------------------------------------
 * Version |By            |Date          |Modification
 * -------------------------------------------------------- 
 * 1.0     |Ramesh       |2018-04-08    |Create
 * </pre>
 */

/**
 * AverageCalculatorUtil 
 * 
 * @author Ramesh
 */
public class AverageCalculatorUtil {
	
	private static Logger log = LoggerUtil.getServiceLogger();
	public AverageCalculatorUtil() {
		
	}
	public int getAveragePrice(List<Integer> prices){
		LoggingUtil.logEnteringMethod("AverageCalculatorUtil", "getAveragePrice", log);
		int averageValue = 0;
		if(!prices.isEmpty()) {
		    for (Integer mark : prices) {
		    	averageValue += mark;
		    }
		    return averageValue / prices.size();
		  }
		LoggingUtil.logExitingMethod("AverageCalculatorUtil", "getAveragePrice", log);
		  return averageValue;
		  
	}

}
