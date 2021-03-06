package org.shanoir.ng.importer.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author atouboul
 *
 */
public class Serie {
	
	@JsonProperty("selected")
	private Boolean selected;

	@JsonProperty("seriesInstanceUID")
	private String seriesInstanceUID;

	@JsonProperty("modality")
	private String modality;

	@JsonProperty("protocolName")
	private String protocolName;

	@JsonProperty("seriesDescription")
	private String seriesDescription;
	
	@JsonProperty("sequenceName")
	private String sequenceName;

	@JsonProperty("seriesDate")
	private Date seriesDate;

	@JsonProperty("seriesNumber")
	private Integer seriesNumber;

	@JsonProperty("numberOfSeriesRelatedInstances")
	private Integer numberOfSeriesRelatedInstances;

	@JsonProperty("sopClassUID")
	private String sopClassUID;

	@JsonProperty("equipment")
	private EquipmentDicom equipment;

	@JsonProperty("isCompressed")
	private Boolean isCompressed;

	@JsonProperty("isSpectroscopy")
	private Boolean isSpectroscopy;
	
	@JsonProperty("isEnhancedMR")
	private Boolean isEnhancedMR;

	@JsonProperty("isMultiFrame")
	private Boolean isMultiFrame;

	@JsonProperty("multiFrameCount")
	private Integer multiFrameCount;

	@JsonProperty("nonImages")
	private List<Object> nonImages;

	@JsonProperty("nonImagesNumber")
	private Integer nonImagesNumber;

	@JsonProperty("images")
	private List<Image> images;

	@JsonProperty("imagesNumber")
	private Integer imagesNumber;

	@JsonProperty("datasets")
	private List<Dataset> datasets;

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public String getSeriesInstanceUID() {
		return seriesInstanceUID;
	}

	public void setSeriesInstanceUID(String seriesInstanceUID) {
		this.seriesInstanceUID = seriesInstanceUID;
	}

	public String getModality() {
		return modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}

	public String getProtocolName() {
		return protocolName;
	}

	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}

	public String getSeriesDescription() {
		return seriesDescription;
	}

	public void setSeriesDescription(String seriesDescription) {
		this.seriesDescription = seriesDescription;
	}

	public Date getSeriesDate() {
		return seriesDate;
	}

	public void setSeriesDate(Date seriesDate) {
		this.seriesDate = seriesDate;
	}

	public Integer getSeriesNumber() {
		return seriesNumber;
	}

	public void setSeriesNumber(Integer seriesNumber) {
		this.seriesNumber = seriesNumber;
	}

	public Integer getNumberOfSeriesRelatedInstances() {
		return numberOfSeriesRelatedInstances;
	}

	public void setNumberOfSeriesRelatedInstances(Integer numberOfSeriesRelatedInstances) {
		this.numberOfSeriesRelatedInstances = numberOfSeriesRelatedInstances;
	}

	public String getSopClassUID() {
		return sopClassUID;
	}

	public void setSopClassUID(String sopClassUID) {
		this.sopClassUID = sopClassUID;
	}

	public EquipmentDicom getEquipment() {
		return equipment;
	}

	public void setEquipment(EquipmentDicom equipment) {
		this.equipment = equipment;
	}

	public Boolean getIsCompressed() {
		return isCompressed;
	}

	public void setIsCompressed(Boolean isCompressed) {
		this.isCompressed = isCompressed;
	}

	public Boolean getIsMultiFrame() {
		return isMultiFrame;
	}

	public void setIsMultiFrame(Boolean isMultiFrame) {
		this.isMultiFrame = isMultiFrame;
	}

	public List<Object> getNonImages() {
		return nonImages;
	}

	public void setNonImages(List<Object> nonImages) {
		this.nonImages = nonImages;
	}

	public Integer getNonImagesNumber() {
		return nonImagesNumber;
	}

	public void setNonImagesNumber(Integer nonImagesNumber) {
		this.nonImagesNumber = nonImagesNumber;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Integer getImagesNumber() {
		return imagesNumber;
	}

	public void setImagesNumber(Integer imagesNumber) {
		this.imagesNumber = imagesNumber;
	}

	public List<Dataset> getDatasets() {
		return datasets;
	}

	public void setDatasets(List<Dataset> datasets) {
		this.datasets = datasets;
	}

	public Integer getMultiFrameCount() {
		return multiFrameCount;
	}

	public void setMultiFrameCount(Integer multiFrameCount) {
		this.multiFrameCount = multiFrameCount;
	}

	public Boolean getIsSpectroscopy() {
		return isSpectroscopy;
	}

	public void setIsSpectroscopy(Boolean isSpectroscopy) {
		this.isSpectroscopy = isSpectroscopy;
	}
	
	public Boolean getIsEnhancedMR() {
		return isEnhancedMR;
	}

	public void setIsEnhancedMR(Boolean isEnhancedMR) {
		this.isEnhancedMR = isEnhancedMR;
	}

	public String getSequenceName() {
		return sequenceName;
	}

	public void setSequenceName(String sequenceName) {
		this.sequenceName = sequenceName;
	}
	
}
