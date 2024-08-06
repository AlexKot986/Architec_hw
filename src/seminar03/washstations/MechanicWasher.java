package seminar03.washstations;

public class MechanicWasher implements IWash {
    @Override
    public void wash(IDirty o) {
        if (o.isDirty()){
            o.setDirty(false);
            System.out.println(o.getClass().getSimpleName() + " вымыт!");
        }
        else
            System.out.println(o.getClass().getSimpleName() + " не нуждается в мойке!");
    }
}
