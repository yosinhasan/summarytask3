package ua.nure.yosin.SummaryTask3.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Hasan Yosin
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "device" })
@XmlRootElement(name = "devices")
public class Devices {
	/**
	 * List of devices.
	 */
	@XmlElement(required = true)
	private List<Device> device;
	/**
	 * Constructor.
	 */
	public Devices() {
		device = new ArrayList<Device>();
	}

	/**
	 * Gets the value of the device property.
	 * 
	 * @return List<Device>
	 */
	public final List<Device> getDevice() {
		return this.device;
	}

	/**
	 * Add device to devices list.
	 * 
	 * @param newDevice
	 *            new device
	 */
	public final void addDevice(final Device newDevice) {
		device.add(newDevice);
	}

}
