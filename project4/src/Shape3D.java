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
//        System.out.println("HEY for 3D:" + this.length * this.width * this.height + "  is equal to " + shape3d.area());
//        System.out.println("HEY for 3D:" + this.getName() + " is equal to: " + shape3d.getName());
        if ((this.getName()).equals(shape3d.getName())
//                && (this.width * this.height) == shape3d.area()
//            && (2 * (width * height + width * length + length * height)) == shape3d.perimeter()
//            && this.height == shape3d.getHeight() && this.width == shape3d.getWidth() && this.length == shape3d.getLength()
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
