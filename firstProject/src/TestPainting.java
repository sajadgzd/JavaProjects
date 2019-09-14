import java.util.Scanner;

public class TestPainting {

    public static void main(String[] args) {
	// write your code here
        System.out.println("TESTING BEGINS:\n");

        Painting painting = new Painting();

        painting.setArtistName("Mark Rothko");
        painting.setName("No. 6(Violet, Green and Red");
        painting.setPrice(186000000);
        painting.setYear(1951);

        Scanner scanner = new Scanner(System.in);



        System.out.println(painting.getArtistName());
    }
}
