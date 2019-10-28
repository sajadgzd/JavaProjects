import java.util.Iterator;
import java.util.TreeSet;

public class ShapeList {

    TreeSet<Shape> setShapes;

    public ShapeList(){
        this.setShapes = new TreeSet<>();
    }

    public boolean add(Shape shape) throws Exception {
        if (setShapes.contains(shape)){
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
        StringBuilder sb = new StringBuilder(110);
        sb.append("+");
        for(int n = 0; n < 80; ++n)
            sb.append('-');
        sb.append("+");

        sb.append(System.lineSeparator());
        System.out.print(sb.toString());
        System.out.println("| ID   | Name    | Color   | Dimensions          | Description       |");
        System.out.print(sb.toString());

        Iterator value = setShapes.iterator();
        while (value.hasNext()) {
                System.out.printf("%s%n",value.next());
                System.out.print(sb.toString());
        }

    }

    public int getSize(){
        return setShapes.size();
    }
}
