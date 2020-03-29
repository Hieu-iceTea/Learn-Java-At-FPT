package CodeLean.Java1_17;

public class Point3D extends Point2D {
    private float z;

    public Point3D() {
        //nothing
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        return new float[] {super.getX(), super.getY(), this.z};
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s,%s)", super.getX(), super.getY(), z);
    }
}
