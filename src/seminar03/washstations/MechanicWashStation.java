package seminar03.washstations;

public class MechanicWashStation extends WashStation{

    private IWash mechanicWasher;

    public MechanicWashStation(IWash mechanicWasher) {
        this.mechanicWasher = mechanicWasher;
    }

    @Override
    public void wash(IDirty o) {
        mechanicWasher.wash(o);
    }
}
