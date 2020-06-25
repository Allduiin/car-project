package project.car.sevice.impl;

import java.util.List;
import project.car.exceptions.CarCanNotDoException;
import project.car.model.Car;
import project.car.model.CarWheel;
import project.car.sevice.CarService;

public class CarServiceImpl implements CarService {

    @Override
    public float getRealMaxSpeed(Car car) {
        List<CarWheel> wheels = car.getWheels();
        if (car.getPassengersInside() == 0 || car.getWheels().size() == 0) {
            return 0;
        }
        float minTire = wheels.get(0).getTireState();
        for (int i = 1; i < wheels.size(); i++) {
            minTire = Math.min(minTire, wheels.get(i).getTireState());
        }
        return car.getMaxSpeed() * minTire;
    }

    @Override
    public void changeSpeed(long speed, Car car) {
        if (speed > 0 && speed < getRealMaxSpeed(car)) {
            car.setCurrentSpeed(speed);
        } else {
            throw new CarCanNotDoException("Speed to change do not meet the credentials");
        }
    }
}
