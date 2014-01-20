/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月20日 下午10:13:29
 */
package org.larry.fw.module.datasource;

public class DatasourceProvider {
	
	private static final ThreadLocal<AvailableDataSources> datasourceHolder = new ThreadLocal<AvailableDataSources>();

	public static void setDataSource(final AvailableDataSources customerType) {
		datasourceHolder.set(customerType);
	}

	public static AvailableDataSources getDataSource() {
		return datasourceHolder.get();
	}

	public static void clearDataSource() {
		datasourceHolder.remove();
	}
}
