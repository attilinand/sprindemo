package com.lohith.springDemo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarsController {


    @Autowired
    CarRepository carRepository;
    
    @GetMapping(value ="/getcars" )
    public String getAllCars() {
    	
    	StringBuffer retBuf = new StringBuffer();

        List<Cars> carList = (List<Cars>) carRepository.findAll();
    	
        if (carList != null) {
            for (Cars car : carList) {
                retBuf.append("name = ");
                retBuf.append(car.getName());
                retBuf.append(", manufactre = ");
                retBuf.append(car.getManufacture_name());
                retBuf.append(", model = ");
                retBuf.append(car.getModel());
                retBuf.append("\r\n");
            }
        }

        if (retBuf.length() == 0) {
            retBuf.append("No record find.");
        } else {
            retBuf.insert(0, "<pre>");
            retBuf.append("</pre>");
        }

        return retBuf.toString();
    }
    
    @PostMapping(path ="/add")
    public String createCar(@Valid @RequestBody Cars car) {
    	carRepository.save(car);
    	String result = "car added";
        return result;
    }
    
    @GetMapping(path ="/getid/{id}")
    public Iterable<Cars> getCarById(@PathVariable(value = "id") Iterable<Integer> carId) {
        return carRepository.findAllById(carId);
    }
    
    @PutMapping(path ="/update/{id}")
    public Cars updateCar(@PathVariable(value = "id") Integer carId,
                                            @Valid @RequestBody Cars carDetails) {

    	Cars car = carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", carId));

        car.setName(carDetails.getName());
        car.setModel(carDetails.getModel());
        car.setColor(carDetails.getColor());
        car.setManufacture_name(carDetails.getManufacture_name());
        car.setManufacture_year(carDetails.getManufacture_year());

        Cars updatedCar = carRepository.save(car);
        return updatedCar;
    }

}
