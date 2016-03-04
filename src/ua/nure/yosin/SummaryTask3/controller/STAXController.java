package ua.nure.yosin.SummaryTask3.controller;

import java.io.IOException;
import java.math.BigInteger;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

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
 * Controller for StAX parser.
 * 
 * @author Hasan Yosin
 * 
 */
public class STAXController extends DefaultHandler {

	/**
	 * Xml file name.
	 */
	private String xmlFileName;
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
	 * STAX constructor.
	 * 
	 * @param xmlFileName2
	 *            xml filename
	 */
	public STAXController(final String xmlFileName2) {
		this.xmlFileName = xmlFileName2;
	}

	/**
	 * Parses XML document with StAX (based on event reader). There is no
	 * validation during the parsing.
	 * 
	 * @throws ParserConfigurationException
	 *             ParserConfiguration exception.
	 * @throws SAXException
	 *             SAXException.
	 * @throws IOException
	 *             IOException.
	 * @throws XMLStreamException
	 *             XMLStream exception.
	 */
	public final void parse() throws ParserConfigurationException,
			SAXException, IOException, XMLStreamException {

		// current element name holder
		String currentElement = null;

		XMLInputFactory factory = XMLInputFactory.newInstance();

		factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);

		XMLEventReader reader = factory.createXMLEventReader(new StreamSource(
				xmlFileName));

		while (reader.hasNext()) {
			XMLEvent event = reader.nextEvent();

			// skip any empty content
			if (event.isCharacters() && event.asCharacters().isWhiteSpace()) {
				continue;
			}

			// handler for start tags
			if (event.isStartElement()) {
				StartElement startElement = event.asStartElement();
				currentElement = startElement.getName().getLocalPart();
				if (XML.DEVICES.equalsTo(currentElement)) {
					devices = new Devices();
				}
				if (XML.DEVICE.equalsTo(currentElement)) {
					device = new Device();
				}
				if (XML.TYPES.equalsTo(currentElement)) {
					types = new Types();
				}
				if (XML.PORTS.equalsTo(currentElement)) {
					ports = new Ports();
				}
				if (XML.PERIPHERAL.equalsTo(currentElement)) {
					Attribute attribute = startElement
							.getAttributeByName(new QName(XML.STATUS.value()));
					if (attribute != null) {
						TypesStatus st = new TypesStatus();
						st.setStatus(Status.fromValue(attribute.getValue()));
						types.setPeripheral(st);
					}
				}
				if (XML.COOLER.equalsTo(currentElement)) {
					Attribute attribute = startElement
							.getAttributeByName(new QName(XML.PROVIDED.value()));
					if (attribute != null) {
						Provided provided = new Provided();
						provided.setProvided(ProvidedStatus.fromValue(attribute
								.getValue()));
						types.setCooler(provided);
					}
				}
				if (XML.GROUP.equalsTo(currentElement)) {
					group = new Group();
				}
				if (XML.IODEVICE.equalsTo(currentElement)) {
					Attribute attribute = startElement
							.getAttributeByName(new QName(XML.PROVIDED.value()));
					if (attribute != null) {
						Provided provided = new Provided();
						provided.setProvided(ProvidedStatus.fromValue(attribute
								.getValue()));
						group.setIoDevice(provided);
					}
				}
				if (XML.MULTIMEDIADEVICE.equalsTo(currentElement)) {
					Attribute attribute = startElement
							.getAttributeByName(new QName(XML.PROVIDED.value()));
					if (attribute != null) {
						Provided provided = new Provided();
						provided.setProvided(ProvidedStatus.fromValue(attribute
								.getValue()));
						group.setMultimediaDevice(provided);
					}
				}

			}

			// handler for contents
			if (event.isCharacters()) {
				Characters characters = event.asCharacters();
				String elementText = characters.getData();
				if (XML.NAME.equalsTo(currentElement)) {
					device.setName(elementText);
				}
				if (XML.ORIGIN.equalsTo(currentElement)) {
					device.setOrigin(elementText);
				}
				if (XML.PRICE.equalsTo(currentElement)) {
					device.setPrice(Integer.parseInt(elementText));
				}
				if (XML.CRITICAL.equalsTo(currentElement)) {
					device.setCritical(Status.fromValue(elementText));
				}
				if (XML.PORT.equalsTo(currentElement)) {
					ports.addPort(Port.fromValue(elementText));
				}
				if (XML.ENERGYCONSUMPTION.equalsTo(currentElement)) {
					types.setEnergyConsumption(new BigInteger(elementText));
				}
			}

			// handler for end tags
			if (event.isEndElement()) {
				EndElement endElement = event.asEndElement();
				String localName = endElement.getName().getLocalPart();

				if (XML.DEVICE.equalsTo(localName)) {
					devices.addDevice(device);
					device = null;
				}
				if (XML.TYPES.equalsTo(localName)) {
					device.setTypes(types);
					types = null;
				}
				if (XML.PORTS.equalsTo(localName)) {
					types.setPorts(ports);
					ports = null;
				}
				if (XML.GROUP.equalsTo(localName)) {
					types.setGroup(group);
					group = null;
				}
			}
		}
		reader.close();
	}

	/**
	 * @return the devices
	 */
	public final Devices getDevices() {
		return devices;
	}
}