package seminar03.cars;

import seminar03.fuelstations.IFuel;
import seminar03.washstations.IDirty;

public class SportCar extends Car implements IFuel, IDirty {

    public SportCar(int wheels, Color color, int fuelTankCapacity) {
        super(wheels, color, fuelTankCapacity);
        this.engineType = EngineType.GASOLINE;
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
    public void fuel(int fuelCount) {
        if (this.fuelAmount < this.fuelTankCapacity) {
            int value = this.fuelTankCapacity - this.fuelAmount;
            if (value > fuelCount)
                this.fuelAmount += fuelCount;
            else
                this.fuelAmount = this.fuelTankCapacity;
        }
        else
            System.out.println(this.getClass().getSimpleName() + " в заправке не нуждается");

    }

    @Override
    public int getFuelAmount() {
        return this.fuelAmount;
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
