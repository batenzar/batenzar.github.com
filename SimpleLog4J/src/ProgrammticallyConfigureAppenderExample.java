import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

/*
 * CodeIntializeLog4J
 * 
 * Revision $Revision$ $Date$
 * Author: mahitorn_k
 * 
 * Copyright (c) 2009-2014 NoMagic, Inc. All Rights Reserved.
 */

/**
 * @author mahitorn_k (mahitorn_k@nomagicasia.com)
 */
public class ProgrammticallyConfigureAppenderExample {

	private static final Logger LOGGER = Logger.getLogger(ProgrammticallyConfigureAppenderExample.class);

	public static void main(String[] args) {
		// This is the root logger provided by log4j
		Logger rootLogger = Logger.getRootLogger();
		rootLogger.setLevel(Level.DEBUG);

		// Define log pattern layout
		PatternLayout layout = new PatternLayout("%d{ISO8601} [%t] %-5p %c %x - %m%n");

		// Add console appender to root logger
		rootLogger.addAppender(new ConsoleAppender(layout));
		try {
			// Define file appender with layout and output log file name
			RollingFileAppender fileAppender = new RollingFileAppender(layout, "demoApplication.log");

			// Add the appender to root logger
			rootLogger.addAppender(fileAppender);
		} catch (IOException e) {
			System.out.println("Failed to add appender !!");
		}
		// Let verify the log messages
		LOGGER.info("Welcome to www.HowToDoInJava.com");
		LOGGER.debug("Welcome to www.HowToDoInJava.com");
		LOGGER.error("Welcome to www.HowToDoInJava.com");
		LOGGER.fatal("Welcome to www.HowToDoInJava.com");
	}
}
