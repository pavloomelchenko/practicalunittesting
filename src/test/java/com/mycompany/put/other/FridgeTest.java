package com.mycompany.put.other;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.mycompany.put.exceptions.NoSuchItemException;

public class FridgeTest {
	private String ANY_PRODUCT = "ANY_PRODUCT";
	private String ANY_OTHER_PRODUCT = "ANY_OTHER_PRODUCT";
	Fridge sut = new Fridge();

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void shouldAllowToPutProduct() {
		assertTrue(sut.put(ANY_PRODUCT));
	}

	@Test
	public void shouldAllowToPutSeveralProducts() {
		assertTrue(sut.put(ANY_PRODUCT));
		assertTrue(sut.put(ANY_OTHER_PRODUCT));
	}

	@Test
	public void shouldContainProductAfterPut() {
		sut.put(ANY_PRODUCT);
		assertTrue(sut.contains(ANY_PRODUCT));
	}

	@Test
	public void shouldContainSeveralProductsAfterPut() {
		sut.put(ANY_PRODUCT);
		sut.put(ANY_OTHER_PRODUCT);
		assertTrue(sut.contains(ANY_PRODUCT));
		assertTrue(sut.contains(ANY_OTHER_PRODUCT));
	}

	@Test
	public void shouldNotContainProductIfEmpty() {
		assertFalse(sut.contains(ANY_PRODUCT));
	}

	@Test
	public void shouldAllowToTakeProductAfterPut() {
		sut.put(ANY_PRODUCT);
		sut.take(ANY_PRODUCT);
	}

	@Test
	public void shouldAllowToTakeSeveralProductsAfterPutThem() {
		sut.put(ANY_PRODUCT);
		sut.put(ANY_OTHER_PRODUCT);
		sut.take(ANY_PRODUCT);
		sut.take(ANY_OTHER_PRODUCT);
	}

	@Test
	public void shouldRemoveProductWhenTake() {
		sut.put(ANY_PRODUCT);
		sut.take(ANY_PRODUCT);
		assertFalse(sut.contains(ANY_PRODUCT));
	}

	@Test
	public void shouldThrowExceptionIfTakeNonExistentProduct() {
		expectedEx.expect(NoSuchItemException.class);
		expectedEx.expectMessage(ANY_PRODUCT + " not found in the fridge");
		sut.take(ANY_PRODUCT);
	}

	@Test
	public void shouldNotPutSameProductTwice() {
		sut.put(ANY_PRODUCT);
		assertFalse(sut.put(ANY_PRODUCT));
		sut.take(ANY_PRODUCT);
		assertFalse(sut.contains(ANY_PRODUCT));
	}

}
