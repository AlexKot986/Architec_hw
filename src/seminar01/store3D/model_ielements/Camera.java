package seminar01.store3D.model_ielements;

public class Camera {
    private Point3D location;
    private Angle3D angle;

    public Camera(Point3D location) {
        this.location = location;
        this.angle = new Angle3D(location);
    }

    public void rotate(double alfa, double beta)
    {
        this.angle.rotate(alfa, beta);
    }
    public void move(Point3D point)
    {
        this.location = point;
        this.angle = new Angle3D(point);
    }
}
