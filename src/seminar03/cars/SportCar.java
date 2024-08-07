package seminar03.cars;

import seminar03.fuelstations.IFuelPro;
import seminar03.washstations.IDirty;

public class SportCar extends Car implements IFuelPro, IDirty {

    private int fuelTankCapacity;
    private int fuelAmount;
    private boolean isDirty;

    public SportCar(int wheels, Color color, int fuelTankCapacity) {
        super(wheels, color, EngineType.GASOLINE);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void start() {
        if (this.fuelAmount > 0) {
            this.isWork = true;
            System.out.println(this.getClass().getSimpleName() + " работает!");
        }
        else
            System.out.println("Без топлива не работает fuelAmount = " + this.fuelAmount);
    }

    @Override
    public int getFuelAmount() {
        return this.fuelAmount;
    }

    @Override
    public void setFuelAmount(int value) {
        int fuelToFull = this.fuelTankCapacity - this.fuelAmount;
        if (value > fuelToFull) {
            this.fuelAmount += fuelToFull;
        }
        else
            this.fuelAmount += value;
    }

    @Override
    public int getFuelTankCapacity() {
        return this.fuelTankCapacity;
    }

    @Override
    public boolean isDirty() {
        return this.isDirty;
    }

    @Override
    public void setDirty(boolean dirty) {
        this.isDirty = dirty;
    }


}
