// Sajad Gholamzadehrizi

import java.util.Calendar;


public class Painting {

    private String artistName;
    private String name;
    private double price;
    private int year;

    public Painting(){
        this.artistName = "-";
        this.name = "-";
        this.price = 0;
        this.year = 0;
    }

    public Painting(String artistName, String name, double price, int year){
        this.artistName = artistName;
        this.name = name;
        this.price = price;
        this.year = year;
    }

    public void setArtistName(String artistName){
        this.artistName = artistName;
    }

    public String getArtistName(){
        return artistName;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getMinimumDiscountPrice(){
        return price - (price * 0.15);
    }

    public double getMaximumDiscountPrice(){
        return price - (price * 0.10);
    }

    public int getAge(){
        return Calendar.getInstance().get(Calendar.YEAR) - getYear();
    }


}
