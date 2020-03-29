package CodeLean.Java1_16;

public class Point3D extends Point2D {
    private int z;

    public Point3D() {
        //nothing [nó sẽ tự thêm Point2D()]
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s,%s)", super.getX(), super.getY(), z);
    }
}