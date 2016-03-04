package ua.nure.yosin.SummaryTask3.entity;

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
@XmlType(name = "Device", propOrder = { "name", "origin", "price", "types",
		"critical" })
public class Device {
	/**
	 * Name.
	 */
	@XmlElement(name = "Name", required = true)
	private String name;
	/**
	 * Origin.
	 */
	@XmlElement(name = "Origin", required = true)
	private String origin;
	/**
	 * Price.
	 */
	@XmlElement(name = "Price")
	@XmlSchemaType(name = "nonNegativeInteger")
	private int price;
	/**
	 * Types.
	 */
	@XmlElement(name = "Types", required = true)
	private Types types;
	/**
	 * Critical.
	 */
	@XmlElement(name = "Critical", required = true)
	@XmlSchemaType(name = "string")
	private Status critical;

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public final String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public final void setName(final String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the origin property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public final String getOrigin() {
		return origin;
	}

	/**
	 * Sets the value of the origin property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public final void setOrigin(final String value) {
		this.origin = value;
	}

	/**
	 * Gets the value of the price property.
	 * 
	 * @return int
	 */
	public final int getPrice() {
		return price;
	}

	/**
	 * Sets the value of the price property.
	 * 
	 * @param value
	 *            price
	 */
	public final void setPrice(final int value) {
		this.price = value;
	}

	/**
	 * Gets the value of the types property.
	 * 
	 * @return possible object is {@link Types }
	 * 
	 */
	public final Types getTypes() {
		return types;
	}

	/**
	 * Sets the value of the types property.
	 * 
	 * @param value
	 *            allowed object is {@link Types }
	 * 
	 */
	public final void setTypes(final Types value) {
		this.types = value;
	}

	/**
	 * Gets the value of the critical property.
	 * 
	 * @return possible object is {@link Status }
	 * 
	 */
	public final Status getCritical() {
		return critical;
	}

	/**
	 * Sets the value of the critical property.
	 * 
	 * @param value
	 *            allowed object is {@link Status }
	 * 
	 */
	public final void setCritical(final Status value) {
		this.critical = value;
	}

	@Override
	public final String toString() {
		return "\nName: " + getName() + "\n" + "Origin " + getOrigin() + "\n"
				+ "Price " + getPrice();
	}

}
