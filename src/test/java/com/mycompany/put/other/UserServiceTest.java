package com.mycompany.put.other;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import com.mycompany.put.other.SecurityService;
import com.mycompany.put.other.User;
import com.mycompany.put.other.UserDAO;
import com.mycompany.put.other.UserServiceImpl;

public class UserServiceTest {
	private static final String SAMPLE_STRING = "123";
	@Test
	public void verifyThatTheUserGetsHisNewPassword() throws Exception{
		UserDAO dao = mock(UserDAO.class);
		SecurityService security = mock(SecurityService.class);
		User user = mock(User.class);
		UserServiceImpl userService = new UserServiceImpl(dao, security);
		
		doReturn(SAMPLE_STRING).when(security).md5(anyString());
		doReturn(SAMPLE_STRING).when(user).getPassword();
		
		userService.assignPassword(user);
		
		verify(user).setPassword(anyString());
		verify(dao).updateUser(user);
	}
}
