package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.Topic;
import org.example.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {
    private CarRepository carRepository;

    public org.example.model.Topic createCar(Topic dto){
        return carRepository.save(
                org.example.model.Topic.builder()
                        .color(dto.getColor())
                        .productionDate(dto.getProductionDate())
                        .build());
    }

    public List<org.example.model.Topic> findCars(){
        return carRepository.findAll();
    }

    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }
}
