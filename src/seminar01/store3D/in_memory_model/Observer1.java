package seminar01.store3D.in_memory_model;

public class Observer1 implements IModelChangedObserver{
    @Override
    public void applyUpdateModel() {
        System.out.println("Была добавлена новая полигональная модель - observer#1");
    }
}
