/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月20日 下午11:07:18
 */
package org.larry.fw.common.utils;

import java.net.URL;
import java.security.CodeSource;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import org.larry.fw.module.logger.Logger;
import org.larry.fw.module.logger.LoggerFactory;

public class Version {
	
	private Version() {}

	private static final Logger logger = LoggerFactory.getLogger(Version.class);

	private static final String VERSION = getVersion(Version.class, "1.0.0");

	static {
		Version.checkDuplicate(Version.class);
	}
	
	public static String getVersion() {
		return VERSION;
	}

	private static void checkDuplicate(Class<?> clazz) {
		checkDuplicate(clazz, false);
	}

	private static String getVersion(Class<?> clazz, String defaultVersion) {
		try {
			String version = clazz.getPackage().getImplementationVersion();
			if (isBlank(version)) {
				version = clazz.getPackage().getSpecificationVersion();
			}
			if (isBlank(version)) {
				CodeSource codeSource = clazz.getProtectionDomain().getCodeSource();
				if (null == codeSource) {
					logger.info("No codeSource for class " + clazz.getName() + " wen getVersion, use default version " + defaultVersion);
				} else {
					String file = codeSource.getLocation().getFile();
					if (file != null && file.length() > 0 && file.endsWith(".jar")) {
	                    file = file.substring(0, file.length() - 4);
	                    int i = file.lastIndexOf('/');
	                    if (i >= 0) {
	                        file = file.substring(i + 1);
	                    }
	                    i = file.indexOf("-");
	                    if (i >= 0) {
	                        file = file.substring(i + 1);
	                    }
	                    while (file.length() > 0 && ! Character.isDigit(file.charAt(0))) {
	                        i = file.indexOf("-");
	                        if (i >= 0) {
	                            file = file.substring(i + 1);
	                        } else {
	                            break;
	                        }
	                    }
	                    version = file;
	                }
				}
			}
			return isNotBlank(version) ? version : defaultVersion;
		} catch (Throwable e) {
			 logger.error("return default version, ignore exception " + e.getMessage(), e);
			 return defaultVersion;
		}
	}

	private static void checkDuplicate(Class<?> clazz, boolean failOnError) {
		checkDuplicate(clazz.getName().replace(".", "/") + ".class", failOnError);
	}

	private static void checkDuplicate(String path, boolean failOnError) {
		try {
			Enumeration<URL> urls = Version.class.getClassLoader().getResources(path);
			Set<String> files = new HashSet<String>();
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				if (null != url) {
					String file = url.getFile();
					if (isNotBlank(file)) {
						files.add(file);
					}
				}
			}
			
			if (files.size() > 1) {
				String error = "Duplicate class " + path + " in " + files.size() + " jar " + files;
				if (failOnError) {
					throw new IllegalStateException(error);
				} else {
					logger.error(error);
				}
			}
		} catch (Throwable e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	private static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
	
	private static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }
}
