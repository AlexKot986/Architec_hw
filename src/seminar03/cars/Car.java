package seminar03.cars;

public abstract class Car {

    protected int wheels;
    protected Color color;
    protected EngineType engineType;
    protected boolean isDirty;
    protected boolean isWork;
    protected int fuelTankCapacity;
    protected int fuelAmount;

    protected Car(int wheels, Color color, int fuelTankCapacity) {
        this.wheels = wheels;
        this.color = color;
        this.fuelTankCapacity = fuelTankCapacity;
        this.fuelAmount = 0;
    }

    public EngineType getFuelType() {
        return this.engineType;
    }

    public abstract void start();

    public int getFuelAmount() {
        return this.fuelAmount;
    }

    public void stop() {
        isWork = false;
    }
}
