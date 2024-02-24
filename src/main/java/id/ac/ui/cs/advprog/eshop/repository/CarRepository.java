package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class CarRepository implements RepositoryInterface<Car> {
    static int id = 0;
    private List<Car> carData = new ArrayList<>();

    public Car create(Car car){
        if (car.getCarId() == null){
            UUID uuid = UUID.randomUUID();
            car.setCarId(uuid.toString());
        }
        carData.add(car);
        return car;
    }

    public List<Car> findAll(){
        return carData;
    }

    public Car findById(String id){
        for (Car car: carData){
            if (car.getCarId().equals(id)){
                return car;
            }
        }
        return null;
    }

    public Car edit(Car updatedCar){
        for (int i=0; i<carData.size(); i++){
            Car car = carData.get(i);
            if(car.getCarId().equals(updatedCar.getCarId())){
                car.setCarName(updatedCar.getCarName());
                car.setCarColor(updatedCar.getCarColor());
                car.setCarQuantity(updatedCar.getCarQuantity());
                return updatedCar;
            }
        }
        return null;
    }

    public boolean delete (String carId) {
        boolean carExist = false;
        List<Car> carIterator = findAll();
        for (Car car : carIterator){
            String currentCarId = car.getCarId();
            if (currentCarId.equals(carId)) {
                carExist = true;
                carIterator.remove(car);
            }
        }
        return carExist;
    }
}
