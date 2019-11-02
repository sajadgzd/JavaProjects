import java.awt.Color;

public abstract class Shape3D extends Shape2D {

    public final double length;

    public Shape3D(int id, String name, String description, Color color,
                   double height, double width, double length){
        super(id, name, description, color, height, width);
        this.length = length;
    }

    @Override
    public String getDimensions(){
        return super.getDimensions() + ":" + length;
    }

    public int compareTo(Shape shape3d){
        if ((this.getName()).equals(shape3d.getName())
                && this.getDimensions().equals(shape3d.getDimensions())
        ) {
                return 0;
            } else {
                return -1;
        }
    }

    @Override
    public String toString(){
        return  "| " + getId() + " | " + getName() + "  | " + getColor() + "   | " + getDimensions() + "      | " + getDescription()
                + "       |";
    }


}
