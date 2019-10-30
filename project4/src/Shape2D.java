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

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public String getDimensions(){
        return "$" + height + ":" + width;
    }

    public int compareTo(Shape shape2d){
//        System.out.println("HEY:" + this.getHeight()  * this.getWidth() + "   //is equal to " + shape2d.area() );
//        System.out.println("HEY:" + this.getName() + " is equal to: " + shape2d.getName());
        if ((this.getName()).equals(shape2d.getName()) && (this.height  * this.width) == shape2d.area() &&
                (2 * (width + height)) == shape2d.perimeter()) {
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
