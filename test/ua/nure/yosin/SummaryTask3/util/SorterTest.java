/**
 * 
 */
package ua.nure.yosin.SummaryTask3.util;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import ua.nure.yosin.SummaryTask3.constants.Constants;
import ua.nure.yosin.SummaryTask3.controller.DOMController;
import ua.nure.yosin.SummaryTask3.entity.Devices;

/**
 * @author elpai
 * 
 */
public class SorterTest {
	private DOMController domController = new DOMController(
			Constants.VALID_XML_FILE);
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	@Before
	public void parseDom() {
		try {
			domController.parse(false);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link ua.nure.yosin.SummaryTask3.util.Sorter#sortDevicesByOrigin(ua.nure.yosin.SummaryTask3.entity.Devices)}
	 * .
	 */
	@Test
	public void testSortDevicesByOrigin() {
		Devices devices = domController.getDevices();
		Sorter.sortDevicesByOrigin(devices);
		String origin = devices.getDevice().get(0).getOrigin();
		assertEquals("China", origin);
	}

	/**
	 * Test method for
	 * {@link ua.nure.yosin.SummaryTask3.util.Sorter#sortDevicesByName(ua.nure.yosin.SummaryTask3.entity.Devices)}
	 * .
	 */
	@Test
	public void testSortDevicesByName() {
		Devices devices = domController.getDevices();
		System.out.println(devices.getDevice());
		Sorter.sortDevicesByName(devices);
		String name = devices.getDevice().get(0).getName();
		assertEquals("Device 1", name);
	}

	/**
	 * Test method for
	 * {@link ua.nure.yosin.SummaryTask3.util.Sorter#sortDevicesByPrice(ua.nure.yosin.SummaryTask3.entity.Devices)}
	 * .
	 */
	@Test
	public void testSortDevicesByPrice() {
		Devices devices = domController.getDevices();
		Sorter.sortDevicesByPrice(devices);
		Integer price = devices.getDevice().get(0).getPrice();
		assertEquals(new Integer(400), price);		
	}
	/**
	 * Test method for {@link ua.nure.yosin.SummaryTask3.util.Sorter#Sorter()}.
	 */
	@Test
	public void testSorter() {
		Sorter sorter = new Sorter();
		domController = new DOMController(Constants.INVALID_XML_FILE);
		try {
			domController.parse(true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}

	}

}
