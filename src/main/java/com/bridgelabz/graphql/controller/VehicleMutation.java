package com.bridgelabz.graphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bridgelabz.graphql.model.Vehicle;
import com.bridgelabz.graphql.service.VehicleService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class VehicleMutation implements GraphQLMutationResolver {
    @Autowired
    private VehicleService vehicleService;
    
    public Vehicle createVehicle(final String type, final String modelCode, final String brandName) {
        return this.vehicleService.createVehicle(type, modelCode, brandName);
    }
    
    public String deleteVehicle(final int id) {
        return this.vehicleService.deleteVehicle(id);
    }
    
    public Vehicle updateInfo( final int id,final String type, final String modelCode, final String brandName) {
        return this.vehicleService.updateInfo(id,type, modelCode, brandName);
    }
    
    
}