package com.mycompany.put.other;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.Arrays;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

public class UserListTest {
	UserList userList = new UserList();
	
	@Test
	public void anEmptyListOfUsersIsReturnedIfNoUsersHaveBeenAdded() {
		assertTrue(userList.getUsers().isEmpty());
	}
	
	@Test
	public void oneUserIsReturnedIfOnlyOneHasBeenAdded(){
		User user = mock(User.class);
		userList.addUser(user);
		assertTrue(CollectionUtils.isEqualCollection(Arrays.asList(user), userList.getUsers()));
	}
	
	@Test
	public void twoUsersAreReturnedIfTwoHaveBeenAdded(){
		User user = mock(User.class);
		User user2 = mock(User.class);
		userList.addUser(user);
		userList.addUser(user2);
		assertTrue(CollectionUtils.isEqualCollection(Arrays.asList(user, user2), userList.getUsers()));
	}
}

