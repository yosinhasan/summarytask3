package ua.nure.yosin.SummaryTask3.util;

import java.util.Collections;
import java.util.Comparator;

import ua.nure.yosin.SummaryTask3.entity.Device;
import ua.nure.yosin.SummaryTask3.entity.Devices;

/**
 * Contains static methods for sorting.
 * 
 * @author Hasan Yosin
 * 
 */
public class Sorter {
	/**
	 * Sorts devices by price.
	 */
	public static final Comparator<Device>
	SORT_DEVICES_BY_PRICE = new Comparator<Device>() {

		@Override
		public int compare(final Device o1, final Device o2) {
			Integer dev1 = o1.getPrice();
			Integer dev2 = o2.getPrice();
			return dev1.compareTo(dev2);
		}
	};
	/**
	 * Sorts devices by name.
	 */
	public static final Comparator<Device>
SORT_DEVICES_BY_NAME = new Comparator<Device>() {

		@Override
		public int compare(final Device o1, final Device o2) {
			String dev1 = o1.getName();
			String dev2 = o2.getName();
			return dev1.compareTo(dev2);
		}
	};
	/**
	 * Sorts devices by country name.
	 */
	public static final Comparator<Device> 
	SORT_DEVICES_BY_ORIGIN = new Comparator<Device>() {

		@Override
		public int compare(final Device o1, final Device o2) {
			String dev1 = o1.getOrigin();
			String dev2 = o2.getOrigin();
			return dev1.compareTo(dev2);
		}
	};

	/**
	 * These methods take Devices object and sort it with according comparator.
	 * 
	 * @param devices
	 *            devices
	 */

	public static final void sortDevicesByOrigin(final Devices devices) {
		Collections.sort(devices.getDevice(), SORT_DEVICES_BY_ORIGIN);
	}

	/**
	 * These methods take Devices object and sort it with according comparator.
	 * 
	 * @param devices
	 *            devices
	 */
	public static final void sortDevicesByName(final Devices devices) {
		Collections.sort(devices.getDevice(), SORT_DEVICES_BY_NAME);
	}

	/**
	 * These methods take Devices object and sort it with according comparator.
	 * 
	 * @param devices
	 *            devices
	 */
	public static final void sortDevicesByPrice(final Devices devices) {
		Collections.sort(devices.getDevice(), SORT_DEVICES_BY_PRICE);
	}

	/**
	 * Constructor.
	 */
	protected Sorter() {

	}
}