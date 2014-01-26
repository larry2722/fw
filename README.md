larry.li spring framework
==
<per>

	/**
	 * Copyright:   Copyright (c) 2014
	 * Company:     LuckyStar Common Freamwork
	 * @author:     Larry.Li  
	 * @version:    v1.0.0
	 * @email:		libin2722@sohu.com
	 * QQ:			33614814
	 * @Blog:		http://www.blogjava.net/libin2722
	 */
	
	1、使用maven命令创建数据库： mvn db:create
	
	2、多数据源配置，支持动态路由数据源
		TransactionAwareDataSourceRouterProxy extends TransactionAwareDataSourceProxy
		
	2014.1.24 工程拆分：
		1). fw-common
			公共模块和工具类
		2). fw-core
			核心框架
		3). fw-extension-log
			日志管理，以后需要使用自动发现机制暴露Rest或者JMX，来在线控制日志级别以及数据文件位置、格式等，而该插件仍然是一个Jar
			@see <a href="http://java.sun.com/j2se/1.5.0/docs/guide/jar/jar.html#Service%20Provider">JDK5.0的自动发现机制实现</a>
		4). fw-showcase
		5). fw-codegen
			用来生成基本项目框架结构，可采用读取数据库或者读取实体类模式生成，Dao、Service、Controller、Jsp
			
	changelog:
		2014.1.24:
			1. 添加异常基类、ResponseStatus
		2014.1.26:
			1. 多数据源配置
			2. GenericDaoJpa、BaseServiceImpl
			3. 定时任务
</per>