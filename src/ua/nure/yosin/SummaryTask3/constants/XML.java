package ua.nure.yosin.SummaryTask3.constants;

/**
 * Holds entities declared in XSD document.
 * 
 * @author Hasan Yosin
 * 
 */
public enum XML {
	/**
	 * Element.
	 */
	DEVICES("devices"),
	/**
	 * Element.
	 */
	DEVICE("device"),
	/**
	 * Element.
	 */
	NAME("Name"),
	/**
	 * Element.
	 */
	ORIGIN("Origin"),
	/**
	 * Element.
	 */
	PRICE("Price"),
	/**
	 * Element.
	 */
	TYPES("Types"),
	/**
	 * Element.
	 */
	PORTS("ports"),
	/**
	 * Element.
	 */
	PORT("port"),
	/**
	 * Element.
	 */
	PERIPHERAL("peripheral"),
	/**
	 * Element.
	 */
	ENERGYCONSUMPTION("energyConsumption"),
	/**
	 * Element.
	 */
	COOLER("cooler"),
	/**
	 * Element.
	 */
	GROUP("group"),
	/**
	 * Element.
	 */
	IODEVICE("ioDevice"),
	/**
	 * Element.
	 */
	MULTIMEDIADEVICE("multimediaDevice"),
	/**
	 * Element.
	 */
	CRITICAL("Critical"),
	/**
	 * Attribute.
	 */
	STATUS("status"),
	/**
	 * Attribute.
	 */
	PROVIDED("provided");
	/**
	 * Value.
	 */
	private String value;

	/**
	 * Constructor.
	 * 
	 * @param value2
	 *            value
	 */
	XML(final String value2) {
		this.value = value2;
	}

	/**
	 * Determines if a name is equal to the string value wrapped by this enum
	 * element.<br/>
	 * If a SAX/StAX parser make all names of elements and attributes interned
	 * you can use
	 * 
	 * <pre>
	 * return value == name;
	 * </pre>
	 * 
	 * instead
	 * 
	 * <pre>
	 * return value.equals(name);
	 * </pre>
	 * 
	 * @param name
	 *            string to compare with value.
	 * @return value.equals(name)
	 */
	public boolean equalsTo(final String name) {
		return value.equals(name);
	}

	/**
	 * Get value.
	 * 
	 * @return String
	 */
	public final String value() {
		return value;
	}
}
