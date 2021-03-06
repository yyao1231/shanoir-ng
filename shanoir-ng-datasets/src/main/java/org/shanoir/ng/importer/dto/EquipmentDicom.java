/**
 * 
 */
package org.shanoir.ng.importer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author yyao
 *
 */
public class EquipmentDicom {
	
	@JsonProperty("manufacturer")
	private String manufacturer;

	@JsonProperty("manufacturerModelName")
	private String manufacturerModelName;

	@JsonProperty("deviceSerialNumber")
	private String deviceSerialNumber;

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getManufacturerModelName() {
		return manufacturerModelName;
	}

	public void setManufacturerModelName(String manufacturerModelName) {
		this.manufacturerModelName = manufacturerModelName;
	}

	public String getDeviceSerialNumber() {
		return deviceSerialNumber;
	}

	public void setDeviceSerialNumber(String deviceSerialNumber) {
		this.deviceSerialNumber = deviceSerialNumber;
	}

}
