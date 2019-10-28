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

    @Override
    public int compareTo(Shape shape2d) {
        if (this.getId() == shape2d.getId() && this.getColor().equals(shape2d.getColor()) && this.getName().equals(shape2d.getName())
                && this.getDescription().equals(shape2d.getDescription()) && this.width == width){
            return 0;
        } else {
            return -1;
        }
    }
}
