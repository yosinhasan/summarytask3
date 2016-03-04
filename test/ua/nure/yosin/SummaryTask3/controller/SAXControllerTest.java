/**
 * 
 */
package ua.nure.yosin.SummaryTask3.controller;

import static org.junit.Assert.*;
import org.junit.Test;

import ua.nure.yosin.SummaryTask3.constants.Constants;
import ua.nure.yosin.SummaryTask3.entity.Devices;

/**
 * @author Hasan Yosin
 * 
 */
public class SAXControllerTest {
	private SAXController sax = new SAXController(Constants.VALID_XML_FILE);


	/**
	 * Test method for
	 * {@link ua.nure.yosin.SummaryTask3.controller.SAXController#getDevices()}.
	 */
	@Test
	public void testGetDevices() {
		try {
			sax.parse(true);
			Devices devices = sax.getDevices();
		} catch (Exception ex) {
			assertFalse(true);
			return;
		}
		assertTrue(true);
	}
	/**
	 * Test method 
	 */
	@Test
	public void test() {
		sax = new SAXController(Constants.INVALID_XML_FILE);
		try {
			sax.parse(false);
		} catch (Exception ex) {
			assertFalse(false);
			return;
		}
		assertTrue(false);
	}

	/**
	 * Test method for
	 * {@link ua.nure.yosin.SummaryTask3.controller.SAXController#setDevices(ua.nure.yosin.SummaryTask3.entity.Devices)}
	 * .
	 */
	@Test
	public void testSetDevices() {
		Devices devices = new Devices();
		sax.setDevices(devices);
		assertTrue(true);
	}

}
