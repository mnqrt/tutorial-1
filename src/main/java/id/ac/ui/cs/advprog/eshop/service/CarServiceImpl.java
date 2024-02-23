package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car create(Car car){
        carRepository.create(car);
        return car;
    }

    @Override
    public List<Car> findAll(){
        List<Car> allCar = new ArrayList<>();
        return carRepository.findAll();
    }

    @Override
    public Car findById(String carId){
        Car car = carRepository.findById(carId);
        return car;
    }

    @Override
    public void update (String carId, Car car){
        carRepository.edit(car);
    }

    @Override
    public void deleteCarById(String carId) {
        carRepository.delete(carId);
    }
}