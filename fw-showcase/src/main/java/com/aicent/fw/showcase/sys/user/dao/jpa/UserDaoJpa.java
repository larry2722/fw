/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月23日 下午11:07:10
 */
package com.aicent.fw.showcase.sys.user.dao.jpa;

import org.springframework.stereotype.Repository;

import com.aicent.fw.common.repository.jpa.GenericDaoJpa;
import com.aicent.fw.modules.logger.Logger;
import com.aicent.fw.modules.logger.LoggerFactory;
import com.aicent.fw.showcase.entity.User;
import com.aicent.fw.showcase.sys.user.dao.UserDao;

@Repository
public class UserDaoJpa extends GenericDaoJpa<User, Long> implements UserDao {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public User findByUsername(String username) {
		logger.debug("excution UserDaoJap.findByUsername method.");
		return null;
	}

}
