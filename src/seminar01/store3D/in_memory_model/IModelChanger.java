package seminar01.store3D.in_memory_model;

public interface IModelChanger {
    void notifyChange();
    void registerModelChanger(IModelChangedObserver o);
    void removeModelChanger(IModelChangedObserver o);
}
