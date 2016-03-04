package ua.nure.yosin.SummaryTask3.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Hasan Yosin
 * 
 */
@XmlType(name = "Status")
@XmlEnum
public enum Status {
	/**
	 * Status.
	 */
	@XmlEnumValue("Yes")
	YES("Yes"),
	/**
	 * No.
	 */
	@XmlEnumValue("No")
	NO("No");
	/**
	 * Value.
	 */
	private final String value;

	/**
	 * Constructor.
	 * 
	 * @param v
	 *            value
	 */
	Status(final String v) {
		value = v;
	}

	/**
	 * Get value.
	 * 
	 * @return String
	 */
	public final String value() {
		return value;
	}

	/**
	 * Get status by value.
	 * 
	 * @param v
	 *            value
	 * @return Status
	 */
	public static Status fromValue(final String v) {
		for (Status c : Status.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
