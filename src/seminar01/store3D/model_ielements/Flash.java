package seminar01.store3D.model_ielements;

public class Flash {
    private Point3D location;
    private Angle3D angle;
    private Color color;
    private Float power;
    private boolean isWork = false;

    public Flash(Point3D location, Color color, Float power) {
        this.location = location;
        this.angle = new Angle3D(location);
        this.color = color;
        this.power = power;
    }

    public Flash(Point3D location)
    {
        this(location, Color.white, 50f);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPower(Float power) {
        this.power = power;
    }

    public void rotate(double alfa, double beta)
    {
        this.angle.rotate(alfa, beta);
    }

    public void flashOn() {
        isWork = true;
    }
    public void flashOff() {
        isWork = false;
    }
    public boolean getIsWork() {
        return isWork;
    }

    public void move(Point3D point)
    {
        this.location = point;
        this.angle = new Angle3D(point);
    }
}
