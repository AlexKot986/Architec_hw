package seminar01.store3D;

import seminar01.store3D.in_memory_model.ModelStore;
import seminar01.store3D.in_memory_model.Observer1;
import seminar01.store3D.model_ielements.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ModelStore store = new ModelStore();
        store.registerModelChanger(new Observer1());

        Poligon p1 = new Poligon(new Point3D(1, 2, 3), new Point3D(4, 5, 6));
        Poligon p2 = new Poligon(new Point3D(10, 10, 10), new Point3D(20, 20, 20));
        List<Poligon> poligons = new ArrayList<>();
        poligons.add(p1);
        poligons.add(p2);

        PoligonalModel poligonalModel = new PoligonalModel(poligons);
        store.addModel(poligonalModel);

        List<PoligonalModel> models = new ArrayList<>();
        models.add(poligonalModel);

        Camera camera1 = new Camera(new Point3D(50, 50, 50));
        camera1.rotate(45, 45);
        Camera camera2 = new Camera(new Point3D(-50, -50, -50));

        List<Camera> cameras = new ArrayList<>();
        cameras.add(camera1);
        cameras.add(camera2);

        Flash flash1 = new Flash(new Point3D(60, 60, 60));
        flash1.rotate(30, 20);
        Flash flash2 = new Flash(new Point3D(70, 70, 70));
        flash2.rotate(45, 180);

        Scene scene1 = new Scene(models, cameras);
        scene1.addFlash(flash1);
        scene1.addFlash(flash2);

        int[] indxFlashes = new int[]{1,0};
        scene1.method2(indxFlashes);
        scene1.method1(1);


        /*Angle3D an = new Angle3D(new Point3D(0f, 0f, 0f));

        System.out.println(an);

        an.rotate(225, 180);
        System.out.println("rotate --->");
        System.out.println(an);

         */
    }
}
