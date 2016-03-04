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
@XmlType(name = "Provided")
public class Provided {
	/**
	 * Provided status.
	 */
    @XmlAttribute(name = "provided", required = true)
    private ProvidedStatus provided;

    /**
     * Gets the value of the provided property.
     * 
     * @return
     *     possible object is
     *     {@link ProvidedStatus }
     *     
     */
    public final ProvidedStatus getProvided() {
        return provided;
    }

    /**
     * Sets the value of the provided property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProvidedStatus }
     *     
     */
    public final void setProvided(final ProvidedStatus value) {
        this.provided = value;
    }

}
