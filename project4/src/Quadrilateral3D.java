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

    @Override
    public int compareTo(Shape shape3d) {
        if (this.getName() == shape3d.getName() && this.getId() == shape3d.getId()){
            return 0;
        } else {
            return -1;
        }
    }
}


