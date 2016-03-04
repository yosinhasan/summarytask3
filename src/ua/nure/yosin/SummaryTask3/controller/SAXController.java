package ua.nure.yosin.SummaryTask3.controller;

import java.io.IOException;
import java.math.BigInteger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ua.nure.yosin.SummaryTask3.constants.Constants;
import ua.nure.yosin.SummaryTask3.constants.XML;
import ua.nure.yosin.SummaryTask3.entity.Device;
import ua.nure.yosin.SummaryTask3.entity.Devices;
import ua.nure.yosin.SummaryTask3.entity.Group;
import ua.nure.yosin.SummaryTask3.entity.Port;
import ua.nure.yosin.SummaryTask3.entity.Ports;
import ua.nure.yosin.SummaryTask3.entity.Provided;
import ua.nure.yosin.SummaryTask3.entity.ProvidedStatus;
import ua.nure.yosin.SummaryTask3.entity.Status;
import ua.nure.yosin.SummaryTask3.entity.Types;
import ua.nure.yosin.SummaryTask3.entity.TypesStatus;

/**
 * Controller for SAX parser.
 * 
 * @author Hasan Yosin
 * 
 */
public class SAXController extends DefaultHandler {
	/**
	 * Xml file name.
	 */
	private String xmlFileName;
	/**
	 * Current element.
	 */
	private String currentElement;
	/**
	 * Main container.
	 */
	private Devices devices;
	/**
	 * Device.
	 */
	private Device device;
	/**
	 * Types.
	 */
	private Types types;
	/**
	 * Ports.
	 */
	private Ports ports;
	/**
	 * Group.
	 */
	private Group group;

	/**
	 * Sax construtor.
	 * 
	 * @param xmlFileName2
	 *            xml filename
	 */
	public SAXController(final String xmlFileName2) {
		this.xmlFileName = xmlFileName2;
	}

	/**
	 * Parses XML document.
	 * 
	 * @param validate
	 *            If true validate XML document against its XML schema. With
	 *            this parameter it is possible make parser validating.
	 * @throws ParserConfigurationException
	 *             ParserConfiguration exception.
	 * @throws SAXException
	 *             SAXException.
	 * @throws IOException
	 *             IOException.
	 * 
	 */
	public final void parse(final boolean validate)
			throws ParserConfigurationException, SAXException, IOException {

		// obtain sax parser factory
		SAXParserFactory factory = SAXParserFactory.newInstance();

		// XML document contains namespaces
		factory.setNamespaceAware(true);

		// set validation
		if (validate) {
			factory.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);
			factory.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON,
					true);
		}

		SAXParser parser = factory.newSAXParser();
		parser.parse(xmlFileName, this);
	}

	@Override
	public final void startElement(final String uri, final String localName,
			final String qName, final Attributes attributes)
			throws SAXException {

		currentElement = localName;
		if (XML.DEVICES.equalsTo(currentElement)) {
			devices = new Devices();
			return;
		}
		if (XML.DEVICE.equalsTo(currentElement)) {
			device = new Device();
			return;
		}
		if (XML.TYPES.equalsTo(currentElement)) {
			types = new Types();
			return;
		}
		if (XML.PORTS.equalsTo(currentElement)) {
			ports = new Ports();
		}
		if (XML.PERIPHERAL.equalsTo(currentElement)) {
			TypesStatus st = new TypesStatus();
			st.setStatus(Status.fromValue(attributes.getValue("status")));
			types.setPeripheral(st);
			return;
		}
		if (XML.COOLER.equalsTo(currentElement)) {
			Provided provided = new Provided();
			provided.setProvided(ProvidedStatus.fromValue(attributes
					.getValue("provided")));
			types.setCooler(provided);
			return;
		}
		if (XML.GROUP.equalsTo(currentElement)) {
			group = new Group();
			return;
		}
		if (XML.IODEVICE.equalsTo(currentElement)) {
			Provided provided = new Provided();
			provided.setProvided(ProvidedStatus.fromValue(attributes
					.getValue("provided")));
			group.setIoDevice(provided);
			return;
		}
		if (XML.MULTIMEDIADEVICE.equalsTo(currentElement)) {
			Provided provided = new Provided();
			provided.setProvided(ProvidedStatus.fromValue(attributes
					.getValue("provided")));
			group.setMultimediaDevice(provided);
			return;
		}

	}

	@Override
	public final void characters(final char[] ch, final int start,
			final int length) throws SAXException {

		String elementText = new String(ch, start, length).trim();

		// return if content is empty
		if (elementText.isEmpty()) {
			return;
		}
		if (XML.NAME.equalsTo(currentElement)) {
			device.setName(elementText);
			return;
		}
		if (XML.ORIGIN.equalsTo(currentElement)) {
			device.setOrigin(elementText);
			return;
		}
		if (XML.PRICE.equalsTo(currentElement)) {
			device.setPrice(Integer.parseInt(elementText));
			return;
		}
		if (XML.CRITICAL.equalsTo(currentElement)) {
			device.setCritical(Status.fromValue(elementText));
			return;
		}
		if (XML.PORT.equalsTo(currentElement)) {
			ports.addPort(Port.fromValue(elementText));
		}
		if (XML.ENERGYCONSUMPTION.equalsTo(currentElement)) {
			types.setEnergyConsumption(new BigInteger(elementText));
		} 

	}

	@Override
	public final void endElement(final String uri, final String localName,
			final String qName) throws SAXException {
		if (XML.DEVICE.equalsTo(localName)) {
			devices.addDevice(device);
			device = null;
			return;
		}
		if (XML.TYPES.equalsTo(localName)) {
			device.setTypes(types);
			types = null;
			return;
		}
		if (XML.PORTS.equalsTo(localName)) {
			types.setPorts(ports);
			ports = null;
			return;
		}
		if (XML.GROUP.equalsTo(localName)) {
			types.setGroup(group);
			group = null;
			return;
		}
	}

	/**
	 * @return the devices
	 */
	public final Devices getDevices() {
		return devices;
	}

	/**
	 * @param devices2
	 *            the devices to set
	 */
	public final void setDevices(final Devices devices2) {
		this.devices = devices2;
	}
}