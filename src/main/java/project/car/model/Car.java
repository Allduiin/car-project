package project.car.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import project.car.exceptions.CarCanNotDoException;

public class Car {
    private final LocalDateTime dateOfCreation;
    private final EngineType engineType;
    private final long maxSpeed;
    private final float acceleration;
    private final long capacity;
    private long passengersInside;
    private long currentSpeed;
    private final List<CarWheel> wheels;
    private final List<CarDoor> doors;

    public Car(LocalDateTime dateOfCreation, EngineType engineType,
               long maxSpeed, float acceleration, long capacity) {
        this.dateOfCreation = dateOfCreation;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.capacity = capacity;
        this.wheels = new ArrayList<>();
        this.doors = new ArrayList<>();
    }

    public void addPassenger() {
        if (passengersInside != capacity) {
            passengersInside++;
        } else {
            throw new CarCanNotDoException("There no capacity inside car");
        }
    }

    public void removePassenger() {
        if (passengersInside != 0) {
            passengersInside--;
        } else {
            throw new CarCanNotDoException("There no passengers inside car");
        }
    }

    public void addWheelsToCar(long amount) {
        if (amount < 0) {
            throw new CarCanNotDoException("Car can't add negative count of wheels");
        }
        for (int i = 0; i < amount; i++) {
            wheels.add(new CarWheel());
        }
    }

    public void removeWheels() {
        wheels.clear();
    }

    public float getRealMaxSpeed() {
        if (passengersInside == 0 || wheels.size() == 0) {
            return 0;
        }
        float minTire = wheels.get(0).getTireState();
        for (int i = 1; i < wheels.size(); i++) {
            minTire = Math.min(minTire, wheels.get(i).getTireState());
        }
        return maxSpeed * minTire;
    }

    public void changeSpeed(long speed) {
        if (speed > 0 && speed < getRealMaxSpeed()) {
            currentSpeed = speed;
        } else {
            throw new CarCanNotDoException("Speed to change do not meet the credentials");
        }
    }

    public CarWheel getWheelById(int id) {
        return wheels.get(id);
    }

    public CarDoor getDoorById(int id) {
        return doors.get(id);
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public long getCapacity() {
        return capacity;
    }

    public long getPassengersInside() {
        return passengersInside;
    }

    public void setPassengersInside(long passengersInside) {
        this.passengersInside = passengersInside;
    }

    public long getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(long currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public List<CarWheel> getWheels() {
        return wheels;
    }

    public List<CarDoor> getDoors() {
        return doors;
    }

    public enum EngineType {
        R3, R4, V4, V6, V8, V10, V12, W12, VR6
    }
}
