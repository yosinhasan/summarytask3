package ua.nure.yosin.SummaryTask3.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Hasan Yosin
 * 
 */
@XmlType(name = "ProvidedStatus")
@XmlEnum
public enum ProvidedStatus {
	/**
	 * Status.
	 */
	@XmlEnumValue("Yes")
	YES("Yes"),
	/**
	 * Status.
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
	ProvidedStatus(final String v) {
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
	 * @return ProvidedStatus
	 */
	public static ProvidedStatus fromValue(final String v) {
		for (ProvidedStatus c : ProvidedStatus.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
