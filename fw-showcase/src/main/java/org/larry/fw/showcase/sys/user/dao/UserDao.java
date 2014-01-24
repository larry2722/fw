/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月24日 下午5:06:26
 */
package org.larry.fw.showcase.sys.user.dao;

import org.larry.fw.common.dao.GenericDao;
import org.larry.fw.showcase.entity.User;

public interface UserDao extends GenericDao<User, Long> {

	User findByUsername(String username);

}
