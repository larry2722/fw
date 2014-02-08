/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月23日 下午11:07:10
 */
package org.larry.fw.showcase.sys.user.dao.jpa;

import org.larry.fw.common.dao.jpa.GenericDaoJpa;
import org.larry.fw.module.logger.Logger;
import org.larry.fw.module.logger.LoggerFactory;
import org.larry.fw.showcase.entity.User;
import org.larry.fw.showcase.sys.user.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoJpa extends GenericDaoJpa<User, Long> implements UserDao {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public User findByUsername(String username) {
		logger.debug("excution UserDaoJap.findByUsername method.");
		return null;
	}

}
