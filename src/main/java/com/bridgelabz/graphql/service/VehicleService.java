package com.bridgelabz.graphql.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.graphql.model.Vehicle;
import com.bridgelabz.graphql.repository.VehicleRepository;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository ;
    public VehicleService(final VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository ;
    }
    @Transactional
    public Vehicle createVehicle(final String type,final String modelCode, final String brandName) {
        final Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
//        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        return this.vehicleRepository.save(vehicle);
    }
    @Transactional(readOnly = true)
    public List<Vehicle> getAllVehicles() {
        return this.vehicleRepository.findAll().stream().collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleRepository.findById(id);
    }
    @Transactional
	public String deleteVehicle(final int id) {
		vehicleRepository.deleteById(id);
		return "Vehicle deleted";
	}
    @Transactional
	public Vehicle updateInfo( final int id,String type, String modelCode, String brandName) {
		Optional<Vehicle> vehicleId = vehicleRepository.findById(id);
		if(vehicleId.isPresent()) {
//			Vehicle vehicle = vehicleId.get();
//			vehicle.setBrandName(brandName);
//			vehicle.setModelCode(modelCode);
//			vehicle.setType(type);
			vehicleId.get().setType(type);
			vehicleId.get().setBrandName(brandName);
			vehicleId.get().setModelCode(modelCode);
		}
		
		return this.vehicleRepository.save(vehicleId.get());
	}
}