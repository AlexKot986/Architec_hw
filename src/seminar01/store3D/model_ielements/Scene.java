package seminar01.store3D.model_ielements;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    private static int counter = 0;
    private int id;
    private List<PoligonalModel> models;
    private List<Flash> flashes;
    private List<Camera> cameras;


    public Scene(List<PoligonalModel> models, List<Camera> cameras) {
        this.id = ++counter;
        this.models = models;
        this.cameras = cameras;
        this.flashes = new ArrayList<>();
    }

    public void addFlash(Flash flash)
    {
        this.flashes.add(flash);
    }
    public void addCamera(Camera camera)
    {
        this.cameras.add(camera);
    }
    public void addPoligonalModel(PoligonalModel model)
    {
        this.models.add(model);
    }
    public void method1(int indx)
    {
        if (indx < cameras.size())
        {
            System.out.println(cameras.get(indx).getClass().getSimpleName() + " №" + (indx + 1) + " takes a picture!");
        }
        else
        {
            System.out.println(cameras.get(0).getClass().getSimpleName() + " №" + (indx + 1)+ " takes a picture!");
        }
    }
    public void method2(int[] flashes) {
        if (this.flashes.size() < 1) {
            System.out.println("Scene has no flash");
            return;
        }
        else {
            for (var flash : this.flashes) {
                flash.flashOff();
            }
            for (int indx : flashes) {
                if (indx < this.flashes.size()){
                    this.flashes.get(indx).flashOn();
                }
            }
        }
    }
}
