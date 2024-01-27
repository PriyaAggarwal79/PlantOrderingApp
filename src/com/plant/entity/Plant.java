package com.plant.entity;

public class Plant {

	private String plantId;
	private String plantName;
	private String plantType;
	private String plantCategory;
	private String season;
	private Double price;
	private Integer quantityInStock;
	public Plant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Plant(String plantId, String plantName, String plantType, String plantCategory, String season,
			Double price, Integer quantityInStock) {
		super();
		this.plantId = plantId;
		this.plantName = plantName;
		this.plantType = plantType;
		this.plantCategory = plantCategory;
		this.season = season;
		this.price = price;
		this.quantityInStock = quantityInStock;
	}

	@Override
	public String toString() {
		return "\nPlantId :" + plantId + "\nPlantName :" + plantName + "\nPlantType : " + plantType
				+ "\nPlant Category :" + plantCategory + "\nSeason : " + season  + "\nPrice : " + price
				+ "\nQuantityInStock : " + quantityInStock + "\n";
	}

	public String getPlantId() {
		return plantId;
	}

	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getPlantType() {
		return plantType;
	}

	public void setPlantType(String plantType) {
		this.plantType = plantType;
	}

	public String getPlantCategory() {
		return plantCategory;
	}

	public void setPlantCategory(String plantCategory) {
		this.plantCategory = plantCategory;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	
	
}
