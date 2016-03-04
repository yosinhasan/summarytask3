package ua.nure.yosin.SummaryTask3.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Hasan Yosin
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ports", propOrder = { "port" })
public class Ports {
	/**
	 * List of ports.
	 */
	@XmlElement(required = true)
	@XmlSchemaType(name = "string")
	private List<Port> port;

	/**
	 * Constructor.
	 */
	public Ports() {
		port = new ArrayList<Port>();
	}

	/**
	 * Gets the value of the port property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the port property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPort().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Port }
	 * 
	 * @return List<Port>
	 */
	public final List<Port> getPort() {
		return this.port;
	}

	/**
	 * Add new port to list.
	 * 
	 * @param newPort
	 *            new port
	 */
	public final void addPort(final Port newPort) {
		port.add(newPort);
	}

}
