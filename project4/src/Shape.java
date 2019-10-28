
import java.util.Comparator;
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

    @Override
    public String toString(){
        return id + " | " + name + " | " + getColor() + " | ";
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Color getColor(){
        return color;
    }
    public String getDescription(){
        return description;
    }
}
