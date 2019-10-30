
import java.awt.Color;

public abstract class Shape implements Comparable<Shape> {

    private final int id;
    private final String name;
    private final String description;
    private Color color;

    public Shape(int id, String name, String description, Color color){
        this.id = id;
        this.name = name;
        this.description = description;
        this.color = color;
    }

    public abstract double area();
    public abstract double perimeter();

//    public abstract double getHeight();
//    public abstract double getWidth();
//    public abstract double getLength();

    public abstract String getDimensions();

    @Override
    public String toString(){
        return "| " + id + " | " + name + "   | " + getColor() + "  | ";
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getColor(){
        String colorName = "";
        if(color.getRed() == 0 && color.getGreen() == 0 && color.getBlue() == 0){
            colorName = "Black";
        } else if(color.getRed() == 255 && color.getGreen() == 255 && color.getBlue() == 255){
            colorName = "White";
        } else if (color.getRed() == 255 && color.getGreen() == 0 && color.getBlue() == 0) {
            colorName = "Red";
        } else if (color.getBlue() == 255 && color.getGreen() == 0 && color.getRed() == 0) {
            colorName = "Blue";
        } else if (color.getGreen() == 255 && color.getRed() == 0 && color.getBlue() == 0) {
            colorName = "Green";
        }
        return colorName;
    }
    public String getDescription(){
        return description;
    }
}
