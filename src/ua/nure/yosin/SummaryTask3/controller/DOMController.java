package ua.nure.yosin.SummaryTask3.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
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
 * Controller for DOM parser.
 * 
 * @author Hasan Yosin
 * 
 */
public class DOMController {
	/**
	 * Xml file name.
	 */
	private String xmlFileName;

	/**
	 * Main container.
	 */
	private Devices devices;

	/**
	 * Constructor.
	 * 
	 * @param xmlFileName2
	 *            xml filename
	 */
	public DOMController(final String xmlFileName2) {
		this.xmlFileName = xmlFileName2;
	}

	/**
	 * Parses XML document.
	 * 
	 * @param validate
	 *            If true validate XML document against its XML schema.
	 * @throws ParserConfigurationException
	 *             parser exception
	 * @throws SAXException
	 *             sax exception
	 * @throws IOException
	 *             ioexception
	 */
	public final void parse(final boolean validate)
			throws ParserConfigurationException, SAXException, IOException {

		// obtain DOM parser
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// set properties for Factory

		// XML document contains namespaces
		dbf.setNamespaceAware(true);

		// make parser validating
		if (validate) {
			// turn validation on
			dbf.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);

			// turn on xsd validation
			dbf.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
		}

		DocumentBuilder db = dbf.newDocumentBuilder();

		// set error handler
		db.setErrorHandler(new DefaultHandler() {
			@Override
			public void error(final SAXParseException e) throws SAXException {
				// throw exception if XML document is NOT valid
				throw e;
			}
		});

		// parse XML document
		Document document = db.parse(xmlFileName);

		// get root element
		Element root = document.getDocumentElement();

		// create container
		devices = new Devices();

		// obtain device nodes
		NodeList deviceNodes = root.getElementsByTagName(XML.DEVICE.value());

		// process device nodes
		for (int j = 0; j < deviceNodes.getLength(); j++) {
			Device device = getDevice(deviceNodes.item(j));
			// add device to container
			devices.addDevice(device);
		}
	}

	/**
	 * Extracts device object from the device XML node.
	 * 
	 * @param qNode
	 *            Device node.
	 * @return Device object.
	 */
	private Device getDevice(final Node qNode) {
		Device device = new Device();
		Element qElement = (Element) qNode;
		// set name
		Node qtNode = qElement.getElementsByTagName(XML.NAME.value()).item(0);
		device.setName(qtNode.getTextContent());
		// set origin
		qtNode = qElement.getElementsByTagName(XML.ORIGIN.value()).item(0);
		device.setOrigin(qtNode.getTextContent());
		// set price
		qtNode = qElement.getElementsByTagName(XML.PRICE.value()).item(0);
		device.setPrice(Integer.parseInt(qtNode.getTextContent()));
		// set critical
		qtNode = qElement.getElementsByTagName(XML.CRITICAL.value()).item(0);
		device.setCritical(Status.fromValue(qtNode.getTextContent()));
		device.setTypes(getTypes(qElement.getElementsByTagName(
				XML.TYPES.value()).item(0)));

		return device;
	}

	/**
	 * Extracts types object from the types XML node.
	 * 
	 * @param qNode
	 *            Types node.
	 * @return Types object.
	 */
	public final Types getTypes(final Node qNode) {
		Types types = new Types();
		Element qElement = (Element) qNode;

		// set energy consumption
		Node qtNode = qElement.getElementsByTagName(
				XML.ENERGYCONSUMPTION.value()).item(0);
		types.setEnergyConsumption(new BigInteger(qtNode.getTextContent()));
		// set cooler
		types.setCooler(getProvided(qElement.getElementsByTagName(
				XML.COOLER.value()).item(0)));
		// set peripheral
		TypesStatus st = new TypesStatus();
		Element statusElem = (Element) qElement.getElementsByTagName(
				XML.PERIPHERAL.value()).item(0);
		st.setStatus(Status.fromValue(statusElem.getAttribute("status")));
		types.setPeripheral(st);
		// set Ports
		types.setPorts(getPorts(qElement
				.getElementsByTagName(XML.PORTS.value()).item(0)));
		// set Group
		types.setGroup(getGroup(qElement
				.getElementsByTagName(XML.GROUP.value()).item(0)));
		return types;
	}

	/**
	 * Extracts group object from the group XML node.
	 * 
	 * @param qNode
	 *            Group node.
	 * @return Group object.
	 */
	public final Group getGroup(final Node qNode) {
		Group group = new Group();
		Element elem = (Element) qNode;
		group.setIoDevice(getProvided(elem.getElementsByTagName(
				XML.IODEVICE.value()).item(0)));
		group.setMultimediaDevice(getProvided(elem.getElementsByTagName(
				XML.MULTIMEDIADEVICE.value()).item(0)));
		return group;
	}

	/**
	 * Extracts Ports object from the ports XML node.
	 * 
	 * @param qNode
	 *            Ports node.
	 * @return Ports object.
	 */
	public final Ports getPorts(final Node qNode) {
		Ports ports = new Ports();
		Element portsElem = (Element) qNode;
		NodeList portNodeList = portsElem
				.getElementsByTagName(XML.PORT.value());
		for (int i = 0; i < portNodeList.getLength(); i++) {
			Port port = getPort(portNodeList.item(i));
			ports.addPort(port);
		}
		return ports;
	}

	/**
	 * Extracts port object from the port XML node.
	 * 
	 * @param qNode
	 *            port node.
	 * @return Port object.
	 */
	public final Port getPort(final Node qNode) {
		Element elem = (Element) qNode;
		return Port.fromValue(elem.getTextContent());

	}

	/**
	 * Extracts provided object from the element in types XML node.
	 * 
	 * @param qNode
	 *            provided node.
	 * @return Provided object.
	 */

	public final Provided getProvided(final Node qNode) {
		Element providedElem = (Element) qNode;
		String providedStatus = providedElem.getAttribute("provided");
		Provided provided = new Provided();
		provided.setProvided(ProvidedStatus.fromValue(providedStatus));
		return provided;
	}

	/**
	 * Creates and returns DOM of the Devices container.
	 * 
	 * @param devices
	 *            Devices object.
	 * @return Document
	 * @throws ParserConfigurationException
	 *             Parser exception.
	 */
	public static Document getDocument(final Devices devices)
			throws ParserConfigurationException {

		// obtain DOM parser
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// set properties for Factory

		// XML document contains namespaces
		dbf.setNamespaceAware(true);

		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.newDocument();

		// create root element
		Element tElement = document.createElement(XML.DEVICES.value());

		// add root element
		document.appendChild(tElement);
		for (Device device : devices.getDevice()) {
			// add device
			Element dElement = document.createElement(XML.DEVICE.value());
			tElement.appendChild(dElement);
			// add name
			Element nElement = document.createElement(XML.NAME.value());
			nElement.setTextContent(device.getName());
			dElement.appendChild(nElement);
			// add origin
			Element oElement = document.createElement(XML.ORIGIN.value());
			oElement.setTextContent(device.getOrigin());
			dElement.appendChild(oElement);
			// add price
			Element pElement = document.createElement(XML.PRICE.value());
			pElement.setTextContent(String.valueOf(device.getPrice()));
			dElement.appendChild(pElement);
			// add Types
			Element typesElement = document.createElement(XML.TYPES.value());
			dElement.appendChild(typesElement);
			// add Ports
			Element portsElement = document.createElement(XML.PORTS.value());
			typesElement.appendChild(portsElement);
			// add Port
			for (Port port : device.getTypes().getPorts().getPort()) {
				Element portElement = document.createElement(XML.PORT.value());
				portElement.setTextContent(port.value());
				portsElement.appendChild(portElement);
			}
			// add peripheral
			Element periphalElement = document.createElement(XML.PERIPHERAL
					.value());
			periphalElement.setAttribute(XML.STATUS.value(), device.getTypes()
					.getPeripheral().getStatus().value());
			typesElement.appendChild(periphalElement);
			// add energyConsumption
			Element ecElement = document.createElement(XML.ENERGYCONSUMPTION
					.value());
			ecElement.setTextContent(String.valueOf(device.getTypes()
					.getEnergyConsumption()));
			typesElement.appendChild(ecElement);
			// add cooler
			Element coolerElement = document.createElement(XML.COOLER.value());
			coolerElement.setAttribute(XML.PROVIDED.value(), device.getTypes()
					.getCooler().getProvided().value());
			typesElement.appendChild(coolerElement);
			// add group
			Element groupElement = document.createElement(XML.GROUP.value());
			typesElement.appendChild(groupElement);
			// add ioDevice
			Element ioElement = document.createElement(XML.IODEVICE.value());
			ioElement.setAttribute(XML.PROVIDED.value(), device.getTypes()
					.getGroup().getIoDevice().getProvided().value());
			groupElement.appendChild(ioElement);
			// add multimedia
			Element mmElement = document.createElement(XML.MULTIMEDIADEVICE
					.value());
			mmElement.setAttribute(XML.PROVIDED.value(), device.getTypes()
					.getGroup().getMultimediaDevice().getProvided().value());
			// add critical
			Element criticalElement = document.createElement(XML.CRITICAL
					.value());
			criticalElement.setTextContent(device.getCritical().value());
			dElement.appendChild(criticalElement);
		}
		return document;
	}

	/**
	 * Saves Test object to XML file.
	 * 
	 * @param devices
	 *            Devices object to be saved.
	 * @param xmlFileName
	 *            Output XML file name.
	 * @throws ParserConfigurationException
	 *             parser configuration exception
	 * @throws TransformerException
	 *             transformer exception
	 */
	public static void saveToXML(final Devices devices, 
			final String xmlFileName)
			throws ParserConfigurationException, TransformerException {
		// Test -> DOM -> XML
		saveToXML(getDocument(devices), xmlFileName);
	}

	/**
	 * Save DOM to XML.
	 * 
	 * @param document
	 *            DOM to be saved.
	 * @param xmlFileName
	 *            Output XML file name.
	 * @throws TransformerException
	 *             Transformer exception.
	 */
	public static void saveToXML(final Document document,
			final String xmlFileName) throws TransformerException {

		StreamResult result = new StreamResult(new File(xmlFileName));

		// set up transformation
		TransformerFactory tf = TransformerFactory.newInstance();
		javax.xml.transform.Transformer t = tf.newTransformer();
		t.setOutputProperty(OutputKeys.INDENT, "yes");

		// run transformation
		t.transform(new DOMSource(document), result);
	}
	/**
	 * @return the devices
	 */
	public final Devices getDevices() {
		return devices;
	}
}
