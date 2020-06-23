package project.car.sevice;

import project.car.model.Car;

public interface CarService {
    float getRealMaxSpeed(Car car);

    void changeSpeed(long speed, Car car);
}
