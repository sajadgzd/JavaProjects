import java.awt.Color;

public class Quadrilateral extends Shape2D {
    public Quadrilateral(int id, String name, String description, Color color,
                         double height, double width){
        super(id, name, description, color, height, width);
    }

    public double area(){
        return width * height;
    }
    public double perimeter(){
        return 2 * (width + height);
    }

}
