import java.util.Iterator;
import java.util.TreeSet;

public class ShapeList {

    TreeSet<Shape2D> setShapes2D;
    TreeSet<Shape3D> setShapes3D;

//    TreeSet<Shape> setShapes;

    public ShapeList(){
        this.setShapes2D = new TreeSet<>();
        this.setShapes3D = new TreeSet<>();
    }
    public boolean add(Shape shape) throws Exception {
        if (setShapes2D.contains(shape) || setShapes3D.contains(shape)){
            throw new Exception();
        } else {
            if(shape instanceof Shape3D){
                setShapes3D.add((Shape3D) shape);
            }
            else {
                setShapes2D.add((Shape2D) shape);
            }

            return true;
        }
    }

    public TreeSet<Shape2D> get2DShapes(){
        return setShapes2D;
    }
    public TreeSet<Shape3D> get3DShapes(){
        return setShapes3D;
    }

    public void printFormatted(){
        StringBuilder sb = new StringBuilder(110);
        sb.append("+");
        for(int n = 0; n < 79; ++n)
            sb.append('-');
        sb.append("+");

        sb.append(System.lineSeparator());
        System.out.print(sb);
        System.out.println("| ID   | Name    | Color   | Dimensions          | Description       |");
        System.out.print(sb);

        for (Shape3D element : setShapes3D) {
            System.out.printf("%5s%n", element);
            System.out.print(sb);
        }
        for (Shape2D element : setShapes2D) {
            System.out.printf("%5s%n", element);
            System.out.print(sb);
        }
//        TreeSet<Shape> setShapes = new TreeSet<>();
//
//        for(Shape2D element : setShapes2D){
//            setShapes.add(element);
//        }
//        for (Shape3D element: setShapes3D){
//            setShapes.add(element);
//        }
//        for (Shape element: setShapes){
//            System.out.println(element);
//            System.out.print(sb);
//        }

    }

    public int getSize(){
        return setShapes2D.size() + setShapes3D.size();
    }
}
