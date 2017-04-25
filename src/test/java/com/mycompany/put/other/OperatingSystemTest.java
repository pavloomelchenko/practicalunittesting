package com.mycompany.put.other;

import static com.mycompany.put.other.OperatingSystemAssert.assertThat;

import org.junit.Test;

public class OperatingSystemTest {

	@Test
	public void testUsingCustomMatcher() {
		OperatingSystem linux = new LinuxRedHat();
		assertThat(linux).is64bit().wasReleasedIn(2012).hasVersion("11.0453522");
	}
}
