/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月23日 下午9:51:40
 */
package org.larry.fw.showcase.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.larry.fw.common.repository.support.SimpleBaseRepositoryFactoryBean;
import org.larry.fw.module.logger.Logger;
import org.larry.fw.module.logger.LoggerFactory;
import org.larry.fw.showcase.entity.User;
import org.larry.fw.showcase.sys.user.exception.UserNotExistsException;
import org.larry.fw.showcase.sys.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class ShiroDbRealm extends AuthorizingRealm {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	public ShiroDbRealm(ApplicationContext context) {
		super();
		context.getBeansOfType(SimpleBaseRepositoryFactoryBean.class);
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername().trim();
		logger.debug("login username is: " + username);
		String password = StringUtils.EMPTY;
		if (upToken.getPassword() != null) {
			password = new String(upToken.getPassword());
		}
		
		validate(username, password);
		User user = userService.getByUserName(username);
		
		return null;
	}

	private void validate(String username, String password) {
		throw new UserNotExistsException();
	}

}