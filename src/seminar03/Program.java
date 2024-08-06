package seminar03;

import seminar03.cars.Color;
import seminar03.cars.SportCar;
import seminar03.fuelstations.FuelStation;
import seminar03.fuelstations.GasStation;
import seminar03.washstations.MechanicWashStation;
import seminar03.washstations.MechanicWasher;

public class Program {
    public static void main(String[] args) {
        FuelStation gasStation = new GasStation();

        SportCar sportCar = new SportCar(4, Color.RED, 40);
        sportCar.start();
        gasStation.fuel(sportCar, 50);
        sportCar.start();
        gasStation.fuel(sportCar, 10);

        MechanicWasher mechanicWasher = new MechanicWasher();
        MechanicWashStation mechanicWashStation = new MechanicWashStation(mechanicWasher);

        mechanicWashStation.wash(sportCar);
        sportCar.setDirty(true);
        mechanicWashStation.wash(sportCar);


    }
}
