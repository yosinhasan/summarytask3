package ua.nure.yosin.SummaryTask3.entity;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * @author Hasan Yosin
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Types", propOrder = {

})
public class Types {
	/**
	 * Ports.
	 */
    private Ports ports;
    /**
     * TypesStatus.
     */
    private TypesStatus peripheral;
    /**
     * Energy consumption.
     */
    @XmlSchemaType(name = "nonNegativeInteger")
    private BigInteger energyConsumption;
    /**
     * Cooler.
     */
    private Provided cooler;
    /**
     * Group.
     */
    private Group group;

    /**
     * Gets the value of the ports property.
     * 
     * @return
     *     possible object is
     *     {@link Ports }
     *     
     */
    public final Ports getPorts() {
        return ports;
    }

    /**
     * Sets the value of the ports property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ports }
     *     
     */
    public final void setPorts(final Ports value) {
        this.ports = value;
    }

    /**
     * Gets the value of the peripheral property.
     * 
     * @return
     *     possible object is
     *     {@link TypesStatus }
     *     
     */
    public final TypesStatus getPeripheral() {
        return peripheral;
    }

    /**
     * Sets the value of the peripheral property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypesStatus }
     *     
     */
    public final void setPeripheral(final TypesStatus value) {
        this.peripheral = value;
    }

    /**
     * Gets the value of the energyConsumption property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public final BigInteger getEnergyConsumption() {
        return energyConsumption;
    }

    /**
     * Sets the value of the energyConsumption property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public final void setEnergyConsumption(final BigInteger value) {
        this.energyConsumption = value;
    }

    /**
     * Gets the value of the cooler property.
     * 
     * @return
     *     possible object is
     *     {@link Provided }
     *     
     */
    public final Provided getCooler() {
        return cooler;
    }

    /**
     * Sets the value of the cooler property.
     * 
     * @param value
     *     allowed object is
     *     {@link Provided }
     *     
     */
    public final void setCooler(final Provided value) {
        this.cooler = value;
    }

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link Group }
     *     
     */
    public final Group getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link Group }
     *     
     */
    public final void setGroup(final Group value) {
        this.group = value;
    }

}
