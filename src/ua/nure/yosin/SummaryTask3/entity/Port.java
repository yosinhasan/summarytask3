package ua.nure.yosin.SummaryTask3.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * @author Hasan Yosin
 *
 */
@XmlType(name = "Port")
@XmlEnum
public enum Port {
	/**
	 * Com port.
	 */
    COM,
    /**
	 * USB port.
	 */
    USB,
    /**
	 * LPT port.
	 */
    LPT;
    /**
     * Get value of port.
     * @return String
     */
    public final String value() {
        return name();
    }
    /**
     * Get port by value.
     * @param v value
     * @return Port
     */
    public static Port fromValue(final String v) {
        return valueOf(v);
    }

}
