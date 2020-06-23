package project.car.model;

public class CarDoor {
    private DoorState doorState;
    private WindowState windowState;

    public CarDoor() {
        this.doorState = DoorState.CLOSED;
        this.windowState = WindowState.CLOSED;
    }

    public void openDoor() {
        doorState = DoorState.OPEN;
    }

    public void closeDoor() {
        doorState = DoorState.CLOSED;
    }

    public void changeDoorState() {
        doorState = (doorState == DoorState.CLOSED) ? DoorState.OPEN : DoorState.CLOSED;
    }

    public void openWindow() {
        windowState = WindowState.OPEN;
    }

    public void closeWindow() {
        windowState = WindowState.CLOSED;
    }

    public void changeWindowState() {
        windowState = (windowState == WindowState.CLOSED) ? WindowState.OPEN : WindowState.CLOSED;
    }

    public DoorState getDoorState() {
        return doorState;
    }

    public void setDoorState(DoorState doorState) {
        this.doorState = doorState;
    }

    public WindowState getWindowState() {
        return windowState;
    }

    public void setWindowState(WindowState windowState) {
        this.windowState = windowState;
    }

    public enum DoorState {
        CLOSED, OPEN
    }

    public enum WindowState {
        CLOSED, OPEN
    }

    @Override
    public String toString() {
        return "CarDoor{"
                + "doorState = " + doorState
                + ", windowState = " + windowState
                + '}';
    }
}
