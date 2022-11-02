package peaksoft.dao;

import peaksoft.entity.Car;

import java.util.List;

public interface CarDao {
   public void saveCar(Car car);
   public Car getCarById(Long id);
   public List<Car> getCarsByPersonId(Long id);
   public List<Car> getCarsByPersonName(String name);
   public List<Car> getAllCars();
   public void deleteCarById(Long id);

}
