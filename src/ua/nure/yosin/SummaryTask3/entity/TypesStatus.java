package ua.nure.yosin.SummaryTask3.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * @author Hasan Yosin
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypesStatus")
public class TypesStatus {
	/**
	 * Status.
	 */
    @XmlAttribute(name = "status", required = true)
    private Status status;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public final Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public final void setStatus(final Status value) {
        this.status = value;
    }

}
