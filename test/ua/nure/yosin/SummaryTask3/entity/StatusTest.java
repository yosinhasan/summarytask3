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
public class StatusTest {

	/**
	 * Test method for {@link ua.nure.yosin.SummaryTask3.entity.Status#fromValue(java.lang.String)}.
	 */
	@Test
	public void testFromValue() {
		try {
			Status pf = Status.fromValue("wtf");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
			return;
		}
		assertTrue(false);
	}

}
