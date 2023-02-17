import java.util.*;

public class MovieDriver {

	public static void main(String[] args) {
		// Create objects & variables
		boolean completeFlag = false;
		
		do {
			
			// Create objects & variables
			Scanner stdin = new Scanner(System.in);
			Movie mov = new Movie();
			
			// Get title from user
			System.out.print("Input a movie title: ");
			String t = stdin.nextLine();
			mov.setTitle(t);
			
			// Get rating from user
			System.out.print("Input a rating for the above movie: ");
			String r = stdin.nextLine();
			mov.setRating(r);
			
			// Get number of tickets sold from user
			System.out.print("Input the number of tickets sold at the theater: ");
			int n = stdin.nextInt();
			mov.setSoldTickets(n);
			
			// Display the information
			System.out.print("\n\n" + mov.toString());
			
			// Prompt for repeat
			System.out.print("\nDo you want to enter another? (y or n) ");
			char i = stdin.next().charAt(0);
			if (i == 'n') {
				completeFlag = true;
			}
			System.out.println();
			
		} while (completeFlag == false);
		
	}

}
