package seminar01.store3D.model_ielements;

public class Poligon {
    private Point3D pointA, pointB;

    public Point3D getPointA() {
        return pointA;
    }

    public Point3D getPointB() {
        return pointB;
    }

    public Poligon(Point3D pointA, Point3D pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }
}
