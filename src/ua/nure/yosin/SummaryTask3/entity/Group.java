package ua.nure.yosin.SummaryTask3.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * @author Hasan Yosin
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Group", propOrder = {
    "ioDevice",
    "multimediaDevice"
})
public class Group {
	/**
	 * Input output device.
	 */
    @XmlElement(required = true)
    private Provided ioDevice;
    /**
     * Multimedia device.
     */
    @XmlElement(required = true)
    private Provided multimediaDevice;

    /**
     * Gets the value of the ioDevice property.
     * 
     * @return
     *     possible object is
     *     {@link Provided }
     *     
     */
    public final Provided getIoDevice() {
        return ioDevice;
    }

    /**
     * Sets the value of the ioDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Provided }
     *     
     */
    public final void setIoDevice(final Provided value) {
        this.ioDevice = value;
    }

    /**
     * Gets the value of the multimediaDevice property.
     * 
     * @return
     *     possible object is
     *     {@link Provided }
     *     
     */
    public final Provided getMultimediaDevice() {
        return multimediaDevice;
    }

    /**
     * Sets the value of the multimediaDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Provided }
     *     
     */
    public final void setMultimediaDevice(final Provided value) {
        this.multimediaDevice = value;
    }

}
