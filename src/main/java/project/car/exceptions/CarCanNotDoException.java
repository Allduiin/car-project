package project.car.exceptions;

public class CarCanNotDoException extends RuntimeException {
    public CarCanNotDoException(String message) {
        super(message);
    }
}
