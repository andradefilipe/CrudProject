package com.fsa.hibernate.model;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

	@Test
	public void testNewUserHasUuid() {
		Phone phone = new Phone("31", "4354546");

		List<Phone> phones = new ArrayList<>();
		phones.add(phone);

		User user = new User("UserName", "UserEmail", "UserPassword", phones);

		Assert.assertThat(user.getId(), not(nullValue()));
		Assert.assertThat(user.getPhones(), contains(phone));
	}

}
