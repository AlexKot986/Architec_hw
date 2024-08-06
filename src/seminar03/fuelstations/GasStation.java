package seminar03.fuelstations;

public class GasStation extends FuelStation {

    @Override
    public void fuel(IFuel o, int value) {
        int fuelToFull = o.getFuelTankCapacity() - o.getFuelAmount();
        if (fuelToFull > value) {
            o.fuel(value);
            System.out.println(o.getClass().getSimpleName() + " заправлена на " + value +
                    ", в баке " + o.getFuelAmount() + " топлива!");
        } else {
            o.fuel(fuelToFull);
            System.out.println(o.getClass().getSimpleName() + " заправлена на " + (fuelToFull) +
                    ", в баке " + o.getFuelAmount() + " топлива!");
        }
    }
}
