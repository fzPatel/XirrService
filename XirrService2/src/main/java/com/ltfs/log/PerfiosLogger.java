package com.ltfs.log;
import org.apache.log4j.Logger;

public class PerfiosLogger {

final static Logger logger = Logger.getLogger(PerfiosLogger.class);
	
	public static void logInfo(String info){
		logger.info("\n----------------------------------------------------------------------");
		logger.info(info);
		logger.info("\n----------------------------------------------------------------------\n");
	}
	
	public static void logerror(String err){
		logger.error("\n----------------------------------------------------------------------");
		logger.error(err);
		logger.error("\n----------------------------------------------------------------------\n");
	}
	
	public static void error(String err,Exception e){
		logger.error("\n----------------------------------------------------------------------");
		logger.error(err,e);
		logger.error("\n----------------------------------------------------------------------\n");
	}
}
