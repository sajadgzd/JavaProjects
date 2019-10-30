import java.awt.Color;

public class Quadrilateral3D extends Shape3D{
    public Quadrilateral3D(int id, String name, String description, Color color,
                         double height, double width, double length){
        super(id, name, description, color, height, width, length);
    }

    public double area(){
        return width * height;
    }
    public double perimeter(){
        return 2 * (width * height + width * length + length * height);
    }

//    public double getLength() {
//        return length;
//    }
//
//    public double getWidth(){
//        return width;
//    }
//    public double getHeight(){
//        return height;
//    }

}


