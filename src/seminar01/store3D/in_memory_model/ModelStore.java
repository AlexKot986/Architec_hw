package seminar01.store3D.in_memory_model;

import seminar01.store3D.model_ielements.Camera;
import seminar01.store3D.model_ielements.Flash;
import seminar01.store3D.model_ielements.PoligonalModel;
import seminar01.store3D.model_ielements.Scene;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger {

    private List<IModelChangedObserver> observers = new ArrayList<>();

    private List<PoligonalModel> models = new ArrayList<>();
    private List<Flash> flashes = new ArrayList<>();
    private List<Scene> scenes = new ArrayList<>();
    private List<Camera> cameras = new ArrayList<>();

    public void addModel(PoligonalModel poligonalModel)
    {
        this.models.add(poligonalModel);
        notifyChange();
    }

    @Override
    public void notifyChange() {
        for (IModelChangedObserver observer : observers) {
            observer.applyUpdateModel();
        }
    }

    @Override
    public void registerModelChanger(IModelChangedObserver o) {
        observers.add(o);
    }

    @Override
    public void removeModelChanger(IModelChangedObserver o) {
        observers.remove(o);
    }
}
