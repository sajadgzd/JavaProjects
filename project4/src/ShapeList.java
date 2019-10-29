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
        for(int n = 0; n < 79; ++n)
            sb.append('-');
        sb.append("+");

        sb.append(System.lineSeparator());
        System.out.print(sb.toString());
        System.out.println("| ID   | Name    | Color   | Dimensions          | Description       |");
        System.out.print(sb.toString());

        Iterator value = setShapes.iterator();

        StringBuilder sb2 = new StringBuilder(110);
        StringBuffer sb3 = new StringBuffer();

        sb2.append(setShapes);
//        System.out.println(sb2);

        String sb4 = "";

//        for (Shape element : setShapes) {
//            sb4 += element + "\n";
//            sb4 += sb;
//            System.out.println(sb3);
//            System.out.print(sb);

            System.out.printf("%5s%n", get2DShapes());

//        }

//        System.out.println(sb4);

//        StringBuffer[] line = new StringBuffer[];
//        line = sb2.split(",");
//
//        for(int i=0; i<line.length; i++){
//            System.out.println();
//        }

//        for (Shape element : setShapes) {
//            sb3.append(element + "\n");
//            System.out.println(sb3);
//            System.out.print(sb);
//        }

//        System.out.println(sb3);

//        for (int i=0; i<sb2.length(); i++){
//            System.out.println(sb2);
//        }

//        for (Shape element : setShapes) {
////            String[] lineParts = toString(element).split("|");
////            String line = toString(setShapes);
////            sb2.append(element);
//
////            System.out.println(element);
//            System.out.println(sb2);
//            System.out.print(sb.toString());
//        }


//        while (value.hasNext()) {
//            String line = setShapes.toString();
////            String lineParts = value.next();
//            System.out.printf("%10s%n",value.next());
//            System.out.print(sb.toString());
//        }

//        for (int i = 0 ; i <setShapes.size(); i++){
//            String[] array2 =  setShapes.toArray()[i].toString().split("|");
//            System.out.println(setShapes.toArray()[i].toString());
//            System.out.print(sb.toString());
//        }
//        String all = setShapes.toString();
//        String[] splitted = all.split("|");
////        String[] newthing = splitted.split("|");
//        for (int i = 0 ; i <splitted.length; i++){
//            System.out.print(toString(splitted[i].split("|")));
//
//        }



    }


    public int getSize(){
        return setShapes.size();
    }
}
