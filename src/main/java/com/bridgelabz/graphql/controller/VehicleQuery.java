package com.bridgelabz.graphql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bridgelabz.graphql.model.Vehicle;
import com.bridgelabz.graphql.service.VehicleService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;


@Component
public class VehicleQuery implements GraphQLQueryResolver {
    @Autowired
    private VehicleService vehicleService;
    public List<Vehicle> getVehicles() {
        return this.vehicleService.getAllVehicles();
    }
    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleService.getVehicle(id);
    }
}