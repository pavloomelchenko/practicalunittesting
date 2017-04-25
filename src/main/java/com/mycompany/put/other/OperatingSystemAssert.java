package com.mycompany.put.other;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

/**
 * Custom matcher (just like hamcrest matchers)
 * 
 * @author Pavlo Omelchenko
 *
 */
public class OperatingSystemAssert
		extends GenericAssert<OperatingSystemAssert, OperatingSystem> {

	protected OperatingSystemAssert(OperatingSystem actual) {
		super(OperatingSystemAssert.class, actual);
	}

	// to use custom matcher you have to implement that
	public static OperatingSystemAssert assertThat(OperatingSystem s) {
		return new OperatingSystemAssert(s);
	}

	public OperatingSystemAssert is64bit() {
		String errorMessage = "Expected operating system to be 64 bit";
		Assertions.assertThat(actual.getNbOfBits())
				.overridingErrorMessage(errorMessage).isEqualTo(64);
		return this;
	}

	public OperatingSystemAssert wasReleasedIn(int i) {
		Assertions.assertThat(actual.getReleaseYear()).isEqualTo(i);
		return this;
	}

	public OperatingSystemAssert hasVersion(String version) {
		Assertions.assertThat(actual.getVersion()).isEqualTo(version);
		return this;
	}

}
