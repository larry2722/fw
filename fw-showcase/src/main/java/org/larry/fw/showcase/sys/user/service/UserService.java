/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月23日 下午8:27:34
 */
package org.larry.fw.showcase.sys.user.service;

import org.larry.fw.common.service.BaseService;
import org.larry.fw.showcase.entity.User;

public interface UserService extends BaseService<User, Long> {

	User getByUserName(String username);

}
