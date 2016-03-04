/**
 * 
 */
package ua.nure.yosin.SummaryTask3.entity;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author elpai
 * 
 */
public class ProvidedStatusTest {

	/**
	 * Test method for
	 * {@link ua.nure.yosin.SummaryTask3.entity.ProvidedStatus#value()}.
	 */
	@Test
	public void testValue() {
		assertEquals(ProvidedStatus.YES, ProvidedStatus.fromValue("Yes"));
	}

	/**
	 * Test method for
	 * {@link ua.nure.yosin.SummaryTask3.entity.ProvidedStatus#fromValue(java.lang.String)}
	 * .
	 */
	@Test
	public void testFromValue() {
		try {
			ProvidedStatus pf = ProvidedStatus.fromValue("wtf");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
			return;
		}
		assertTrue(false);
	}

}
