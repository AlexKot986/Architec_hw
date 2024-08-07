package seminar03.fuelstations;

public class GasStationPro extends FuelStation {

    @Override
    public void fuel(IFuel o, int value) {
        if (o instanceof IFuelPro) {
            int fuelToFull = ((IFuelPro) o).getFuelTankCapacity() - ((IFuelPro) o).getFuelAmount();
            if (fuelToFull == 0) {
                System.out.println(o.getClass().getSimpleName() + " в баке " + ((IFuelPro) o).getFuelAmount() + " топлива" +
                        " в заправке не нуждается!");
            } else if (value > fuelToFull) {
                o.setFuelAmount(fuelToFull);
                System.out.println(o.getClass().getSimpleName() + " заправлена на " + fuelToFull +
                        ", в баке " +  ((IFuelPro) o).getFuelAmount() + " топлива" +
                        "\nвыша сдача " + (value - fuelToFull) + " топлива!");
            } else {
                o.setFuelAmount(value);
                System.out.println(o.getClass().getSimpleName() + " заправлена на " + (fuelToFull) +
                        ", в баке " + ((IFuelPro) o).getFuelAmount() + " топлива!");
            }
        }
        else
            o.setFuelAmount(value);
    }
}
