import java.util.Scanner;

public class TestPainting {

    public static void main(String[] args) {

        System.out.println("TESTING BEGINS:\n");

        Painting painting1 = new Painting();

        painting1.setArtistName("Mark Rothko");
        painting1.setName("No. 6(Violet, Green and Red");
        painting1.setPrice(186000000);
        painting1.setYear(1951);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value for artistName?\t");
        String artistName = scanner.nextLine();
        System.out.print("Enter value for name?\t");
        String name = scanner.nextLine();
        System.out.print("Enter value for price?\t");
        double price = scanner.nextDouble();
        System.out.print("Enter value for year?\t");
        int year = scanner.nextInt();
        
        scanner.close();

        Painting painting2 = new Painting();
        painting2.setArtistName("Paul Cezanne");
        painting2.setName("The Card Players");
        painting2.setPrice(300000000);
        painting2.setYear(1892);

        System.out.printf("%24s: %s%n", "Artist Name", painting2.getArtistName() );
        System.out.printf("%24s: %s%n", "Name", painting2.getName() );
        System.out.printf("%24s: %,.2f%n", "Price", painting2.getPrice() );
        System.out.printf("%24s: %d%n", "Year", painting2.getYear() );
        System.out.printf("%24s: %d%n", "Age", painting2.getAge() );
        System.out.printf("%24s: %,.2f - %,.2f%n", "Discounted Price Range", painting2.getMaximumDiscountPrice(), painting2.getMinimumDiscountPrice() );


    }
}
