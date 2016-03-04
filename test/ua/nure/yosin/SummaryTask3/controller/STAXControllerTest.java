/**
 * 
 */
package ua.nure.yosin.SummaryTask3.controller;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.xml.sax.SAXException;

import ua.nure.yosin.SummaryTask3.constants.Constants;
import ua.nure.yosin.SummaryTask3.entity.Devices;

/**
 * @author Hasan Yosin
 *
 */
public class STAXControllerTest {
	
	/**
	 * Test method for {@link ua.nure.yosin.SummaryTask3.controller.STAXController#STAXController(java.lang.String)}.
	 */
	@Test
	public void testSTAXController() {
		STAXController staxContr = new STAXController(Constants.VALID_XML_FILE);
		try {
			staxContr.parse();
		} catch (Exception e) {
			assertFalse(true);
		}
	}

	
	/**
	 * Test method for {@link ua.nure.yosin.SummaryTask3.controller.STAXController#getDevices()}.
	 */
	@Test
	public void testGetDevices() {
		STAXController staxContr = new STAXController(Constants.VALID_XML_FILE);
		try {
			staxContr.parse();
		} catch (Exception e) {
			assertFalse(true);
			return;
		}
		Devices devices = staxContr.getDevices();
		if (devices.getDevice().isEmpty()) {
			assertFalse(false);
		}
	}
}
