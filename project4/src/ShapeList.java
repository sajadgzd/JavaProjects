import java.util.Iterator;
import java.util.TreeSet;

public class ShapeList {

    TreeSet<Shape> setShapes;
    TreeSet<Shape2D> setShapes2D;
    TreeSet<Shape3D> setShapes3D;

    public ShapeList(){
        this.setShapes = new TreeSet<>();
        this.setShapes2D = new TreeSet<>();
        this.setShapes3D = new TreeSet<>();
    }
    public boolean add(Shape shape) throws Exception {
        if(shape instanceof Shape3D){
            if (setShapes.contains(shape)){
                throw new Exception();
            } else {
                setShapes.add(shape);
                setShapes3D.add((Shape3D) shape);
                return true;
            }
        } else {
            if (setShapes.contains(shape)){
                throw new Exception();
            } else {
                setShapes.add(shape);
                setShapes2D.add((Shape2D) shape);
                return true;
            }
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

        for (Shape element: setShapes){
            System.out.println(element);
            System.out.print(sb);
        }

    }

    public int getSize(){
        return setShapes.size();
    }
}
