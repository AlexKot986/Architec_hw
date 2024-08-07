package seminar03.fuelstations;

public class GasStation extends FuelStation {

    @Override
    public void fuel(IFuel o, int value) {
        o.setFuelAmount(value);
        System.out.println(o.getClass().getSimpleName() + " заправлен на " + value + " топлива!");
    }
}
