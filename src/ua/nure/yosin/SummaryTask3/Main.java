package ua.nure.yosin.SummaryTask3;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import ua.nure.yosin.SummaryTask3.controller.DOMController;
import ua.nure.yosin.SummaryTask3.controller.SAXController;
import ua.nure.yosin.SummaryTask3.controller.STAXController;
import ua.nure.yosin.SummaryTask3.entity.Devices;
import ua.nure.yosin.SummaryTask3.util.Sorter;

/**
 * Entry point for SummaryTask3.
 * 
 * @author Hasan Yosin
 * 
 */
public class Main {
	/**
	 * Usage.
	 */
	public static void usage() {
		System.out.println("Usage:\njava -jar ST3.jar xmlFileName");
		System.out.println("java ua.nure.hasan.SummaryTask3.Main xmlFileName");
	}

	/**
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(final String[] args) {
		if (args.length != 1) {
			usage();
			return;
		}

		String xmlFileName = args[0];
		System.out.println("Input ==> " + xmlFileName);

		// //////////////////////////////////////////////////////
		// DOM
		// //////////////////////////////////////////////////////

		// get
		DOMController domController = new DOMController(xmlFileName);
		try {
			domController.parse(true);
			Devices devices = domController.getDevices();

			// sort (case 1)
			Sorter.sortDevicesByName(devices);

			// save
			String outputXmlFile = "output.dom.xml";
			DOMController.saveToXML(devices, outputXmlFile);

			// //////////////////////////////////////////////////////
			// SAX
			// //////////////////////////////////////////////////////

			// get
			System.out.println("Output ==> " + outputXmlFile);
			SAXController saxController = new SAXController(xmlFileName);
			saxController.parse(true);
			devices = saxController.getDevices();

			// sort (case 2)
			Sorter.sortDevicesByOrigin(devices);

			// save
			outputXmlFile = "output.sax.xml";

			// other way:
			DOMController.saveToXML(devices, outputXmlFile);
			System.out.println("Output ==> " + outputXmlFile);

			// //////////////////////////////////////////////////////
			// StAX
			// //////////////////////////////////////////////////////

			// get
			STAXController staxController = new STAXController(xmlFileName);
			staxController.parse();

			devices = staxController.getDevices();

			// sort (case 3)
			Sorter.sortDevicesByPrice(devices);

			// save
			outputXmlFile = "output.stax.xml";
			DOMController.saveToXML(devices, outputXmlFile);
			System.out.println("Output ==> " + outputXmlFile);

		} catch (ParserConfigurationException e) {
			System.err.println(e.getMessage());
		} catch (SAXException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (TransformerException e) {
			System.err.println(e.getMessage());
		} catch (XMLStreamException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Constructor.
	 */
	protected Main() {

	}

}