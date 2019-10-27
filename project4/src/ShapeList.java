import java.util.TreeSet;

public class ShapeList {

    TreeSet<Shape> setShapes;

    public ShapeList(){
        this.setShapes = new TreeSet<>();
    }

    public boolean add(Shape shape) throws Exception {
        if (setShapes.contains(shape)){
            System.err.println("Duplicate object");
            throw new Exception();
        } else {
            setShapes.add(shape);
            return true;
        }
    }

    public TreeSet<Shape2D> get2DShapes(){
        TreeSet<Shape2D> new2DSet = new TreeSet<>();
        for(Shape ref: setShapes){
            if(ref instanceof Shape2D){
                new2DSet.add((Shape2D) ref);
            }
        }
        return new2DSet;
    }

    public TreeSet<Shape3D> get3DShapes(){
        TreeSet<Shape3D> new3DSet = new TreeSet<>();
        for(Shape ref: setShapes){
            if(ref instanceof Shape3D){
                new3DSet.add((Shape3D) ref);
            }
        }
        return new3DSet;
    }

    public void printFormatted(){
        for (Shape element : setShapes) {
            System.out.println(element);
        }
//        System.out.println(setShapes);
    }

    public int getSize(){
        return setShapes.size();
    }
}
