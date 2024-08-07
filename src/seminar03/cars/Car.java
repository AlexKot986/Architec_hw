package seminar03.cars;

public abstract class Car {

    protected int wheels;
    protected Color color;
    protected EngineType engineType;
    protected boolean isWork;

    protected Car(int wheels, Color color, EngineType engineType) {
        this.wheels = wheels;
        this.color = color;
        this.engineType = engineType;
    }

    public EngineType getEngineTypeType() {
        return this.engineType;
    }

    public abstract void start();


    public void stop() {
        isWork = false;
    }
}
