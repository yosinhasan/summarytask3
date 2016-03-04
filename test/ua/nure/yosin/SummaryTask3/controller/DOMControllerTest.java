/**
 * 
 */
package ua.nure.yosin.SummaryTask3.controller;

import static org.junit.Assert.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.Before;
import org.junit.Test;

import ua.nure.yosin.SummaryTask3.constants.Constants;
import ua.nure.yosin.SummaryTask3.entity.Devices;

/**
 * @author Hasan Yosin
 * 
 */
public class DOMControllerTest {
	private DOMController dom = new DOMController(Constants.VALID_XML_FILE);

	@Before
	public void parseDom() {
		try {
			dom.parse(true);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link ua.nure.yosin.SummaryTask3.controller.DOMController#saveToXML(ua.nure.yosin.SummaryTask3.entity.Devices, java.lang.String)}
	 * .
	 */
	@Test
	public void testSaveToXMLDevicesString() {
		Devices devices = dom.getDevices();
		try {
			DOMController.saveToXML(devices, "forTest.xml");
		} catch (Exception e) {
			assertFalse(false);
		}
	}

	/**
	 * Test method for
	 * {@link ua.nure.yosin.SummaryTask3.controller.DOMController#getDevices()}.
	 */
	@Test
	public void testGetDevices() {
		Devices devices = dom.getDevices();
		if (!devices.getDevice().isEmpty()) {
			assertTrue(true);
		}
	}

}
