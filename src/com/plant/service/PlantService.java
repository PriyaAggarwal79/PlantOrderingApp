package com.plant.service;

import java.util.List;

import com.plant.entity.Plant;

public interface PlantService {

	public boolean addPlant(Plant p);
	public boolean updatePlant(Plant p);
	public boolean deletePlant(String plantId);
	
	public Plant getPlantById(String PlantId);
	public List<Plant> showAllPlant();
	public List<Plant> getPlantByCategory(String plantCategory);
	public List<Plant> getPlantByType(String plantType);
	public List<Plant> getPlantBySeason(String season);
	
}
