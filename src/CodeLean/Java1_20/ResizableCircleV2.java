package CodeLean.Java1_20;

public class ResizableCircleV2 extends CircleV2 implements Resizable {
    public ResizableCircleV2(double radius) {
        super(radius);
    }

    @Override
    public String toString() {
        return "ResizableCircleV2{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public void resize(int percent) {

    }
}
