/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月23日 下午11:06:26
 */
package com.aicent.fw.showcase.sys.user.dao;

import com.aicent.fw.common.repository.GenericDao;
import com.aicent.fw.showcase.entity.User;

public interface UserDao extends GenericDao<User, Long> {

	User findByUsername(String username);

}
