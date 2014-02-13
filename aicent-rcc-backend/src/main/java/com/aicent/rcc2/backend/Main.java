/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月26日 下午5:28:32
 */
package com.aicent.rcc2.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aicent.fw.modules.logger.Level;
import com.aicent.fw.modules.logger.Logger;
import com.aicent.fw.modules.logger.LoggerFactory;

public class Main {
	
	private final static Logger logger = LoggerFactory.getLogger(Main.class);

	private static ClassPathXmlApplicationContext context = null;
	
	enum Command {
		END(0, "end"),
		HELP(1, "help"),
		
		// about log manage
		SHOW_LOG_LEVEL(2, "show log level"), 
		
		CHANGE_LOG_LEVEL_TO_DEBUG(3, "change log level to debug"), 
		
		CHAGE_LOG_LEVEL_TO_INFO(4, "change log level to info"),
		
		CHAGE_LOG_LEVEL_TO_WARN(5, "change log level to warn"),
		
		CHANGE_LOG_LEVEL_TO_ERROR(6, "change log level to error"), 
		;
		
		private int num;
		private String description;
		
		Command(int num, String description) {
			this.num = num;
			this.description = description;
		}
		
		private int getNum() {
			return this.num;
		}
		
		private String getDescription() {
			return this.description;
		}
		
		public static Command getCommand(int num) {
			for (Command c : Command.values()) {
				if (c.getNum() == num) {
					return c;
				}
			}
			return null;
		}
		
		public static Command getCommand(String line) {
			try {
				if (StringUtils.isBlank(line)) {
					return null;
				}
				int num = Integer.parseInt(line);
				return getCommand(num);
			} catch (Exception e) {
				return null;
			}
		}
		
		public static String getCommandString() {
			StringBuffer sb = new StringBuffer();
			for (Command c : Command.values()) {
				sb.append(c.getDescription()+ "("+c.num+") \r\n");
			}
			return sb.toString();
		}
		
	}
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext(new String[] {"classpath:META-INF/configuration/spring-config.xml"});
		context.start();
		
		handleCommand();
	}

	private static void handleCommand()  {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			String line = Command.HELP.num + "";
			while (true) {
				Command command = Command.getCommand(line);
				if (command == null) {
					command = Command.HELP;
				} else if (command == Command.END) {
					break;
				} 
				switch (command) {
				case HELP:
					System.out.println("====================================================");
					System.out.println(Command.getCommandString());
					System.out.println("====================================================");
					break;
				case SHOW_LOG_LEVEL:
					System.out.println("Current log level is: " + LoggerFactory.getLevel());
					break;
				case CHANGE_LOG_LEVEL_TO_DEBUG:
					LoggerFactory.setLevel(Level.DEBUG);
					System.out.println("Current log level is: " + LoggerFactory.getLevel());
					break;
				case CHAGE_LOG_LEVEL_TO_INFO:
					LoggerFactory.setLevel(Level.INFO);
					System.out.println("Current log level is: " + LoggerFactory.getLevel());
					break;
				case CHAGE_LOG_LEVEL_TO_WARN: 
					LoggerFactory.setLevel(Level.WARN);
					System.out.println("Current log level is: " + LoggerFactory.getLevel());
					break;
				case CHANGE_LOG_LEVEL_TO_ERROR: 
					LoggerFactory.setLevel(Level.ERROR);
					System.out.println("Current log level is: " + LoggerFactory.getLevel());
					break;
				default:
					break;
				}
				line = br.readLine();
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				isr.close();
				br.close();
			} catch (IOException e) {
				logger.error("close stream error!");
				e.printStackTrace();
			}
			System.exit(0);
		}
	}

}
