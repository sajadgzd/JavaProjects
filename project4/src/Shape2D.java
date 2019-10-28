import java.awt.Color;

public abstract class Shape2D extends Shape{
    public final double height;
    public final double width;

    public Shape2D(int id, String name, String description, Color color,
                   double height, double width){
        super(id, name, description, color);
        this.height = height;
        this.width = width;
    }

    public String getDimensions(){
        return "$" + height + ":" + width;
    }

    public int compareTo(Shape2D shape2d){
        if (this.getName() == shape2d.getName() && this.height == shape2d.height
            && this.width == shape2d.width){
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString(){
        return super.toString() + getDimensions() + "      | " + getDescription() + "       |";
    }

}
