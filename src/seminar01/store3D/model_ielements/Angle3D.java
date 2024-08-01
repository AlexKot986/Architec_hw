package seminar01.store3D.model_ielements;

public class Angle3D {

    private Point3D startPoint;
    private Point3D endPoint;
    private float radius = 10f;

    public Angle3D(Point3D point) {
        this.startPoint = point;
        this.endPoint = new Point3D(startPoint.getX() + radius, startPoint.getY(), startPoint.getZ());
    }

    public void rotate(double angleOfAxisY, double angleOfAxisZ)
    {
        double radAlfa = angleOfAxisY * Math.PI / 180;
        double radBeta = angleOfAxisZ * Math.PI / 180;

        double x = startPoint.getX() + (Math.round(radius * Math.cos(radAlfa) * Math.cos(radBeta)) * 100) / 100;
        double y = startPoint.getY() + (Math.round(radius * Math.cos(radAlfa) * Math.sin(radBeta)) * 100) / 100;
        double z = startPoint.getZ() + (Math.round(radius * Math.sin(radAlfa)) * 100) / 100;

        endPoint = new Point3D(x, y, z);
    }

    @Override
    public String toString() {
        return "x:" + endPoint.getX() + "\ny:" + endPoint.getY() + "\nz:" + endPoint.getZ();
    }
}
