import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VRUI {
	private static Scanner scanner = new Scanner(System.in) ;

	private List<Customer> customers = new ArrayList<Customer>() ;

	private List<Video> videos = new ArrayList<Video>() ;

	public static void main(String[] args) {
		VRUI ui = new VRUI() ;

		boolean quit = false ;
		while ( ! quit ) {
			int command = ui.showCommand() ;
			switch ( command ) {
				case 0: quit = true ; break ;
				case 1: ui.listCustomers() ; break ;
				case 2: ui.listVideos() ; break ;
				case 3: ui.registerCustomer() ; break ;
				case 4: ui.registerVideo(); ; break ;
				case 5: ui.rentVideo() ; break ;
				case 6: ui.returnVideo() ; break ;
				case 7: ui.getCustomerReport() ; break;
				case 8: ui.clearRentals() ; break ;
				case -1: ui.init() ; break ;
				default: break ;
			}
		}
		System.out.println("Bye");
	}

	public void clearRentals() {
		String customerName = getUserInput("Enter customer name: ");

		Customer foundCustomer = getCustomer(customerName);

		if ( foundCustomer == null ) {
			System.out.println("No customer found") ;
		} else {
			System.out.println(foundCustomer.listInformation());
			foundCustomer.clearRentals();
		}
	}

	public void returnVideo() {
		String customerName = getUserInput("Enter customer name: ");

		Customer foundCustomer = getCustomer(customerName);
		if ( foundCustomer == null ) return ;

		String videoTitle = getUserInput("Enter video title to return: ");

		foundCustomer.returnVideo(videoTitle);
	}

	private Customer getCustomer(String customerName) {
		Customer foundCustomer = null;
		for (Customer customer : customers) {
			if (customer.getName().equals(customerName)) {
				foundCustomer = customer;
				break;
			}
		}
		return foundCustomer;
	}

	private void init() {
		Customer james = new Customer("James") ;
		Customer brown = new Customer("Brown") ;
		customers.add(james) ;
		customers.add(brown) ;

		Video v1 = new Video("v1", Video.CD, Video.REGULAR, new Date()) ;
		Video v2 = new Video("v2", Video.DVD, Video.NEW_RELEASE, new Date()) ;
		videos.add(v1) ;
		videos.add(v2) ;

		Rental r1 = new Rental(v1) ;
		Rental r2 = new Rental(v2) ;

		james.addRental(r1) ;
		james.addRental(r2) ;
	}

	public void listVideos() {
		System.out.println("List of videos");

		for ( Video video: videos ) {
			System.out.println("Price code: " + video.getPriceCode() +"\tTitle: " + video.getTitle()) ;
		}
		System.out.println("End of list");
	}

	public void listCustomers() {
		System.out.println("List of customers");
		for ( Customer customer: customers ) {
			System.out.println(customer.listInformation());
		}
		System.out.println("End of list");
	}

	public void getCustomerReport() {
		String customerName = getUserInput("Enter customer name: ");

		Customer foundCustomer = getCustomer(customerName);

		if ( foundCustomer == null ) {
			System.out.println("No customer found") ;
		} else {
			String result = foundCustomer.getReport() ;
			System.out.println(result);
		}
	}

	public void rentVideo() {
		String customerName = getUserInput("Enter customer name: ");
		Customer foundCustomer = getCustomer(customerName);
		if ( foundCustomer == null ) return ;

		String videoTitle = getUserInput("Enter video title to rent: ");
		Video foundVideo = getVideo(videoTitle);
		if (foundVideo == null) return;

		foundCustomer.rentVideo(foundVideo);
	}

	private Video getVideo(String videoTitle) {
		Video foundVideo = null ;
		for ( Video video: videos ) {
			if ( video.getTitle().equals(videoTitle) && video.isRented() == false ) {
				foundVideo = video ;
				break ;
			}
		}

		return foundVideo;
	}

	private String getUserInput(String s) {
		System.out.println(s);
		return scanner.next();
	}

	public void registerCustomer() {
		String name = getUserInput("Enter customer name: ");
		customers.add(new Customer(name)) ;
	}

	public void registerVideo() {
		String title = getUserInput("Enter video title to register: ");

		System.out.println("Enter video type( 1 for VHD, 2 for CD, 3 for DVD ):") ;
		int videoType = scanner.nextInt();

		System.out.println("Enter price code( 1 for Regular, 2 for New Release ):") ;
		int priceCode = scanner.nextInt();

		Date registeredDate = new Date();
		Video video = new Video(title, videoType, priceCode, registeredDate) ;
		videos.add(video) ;
	}

	public int showCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. List customers");
		System.out.println("\t 2. List videos");
		System.out.println("\t 3. Register customer");
		System.out.println("\t 4. Register video");
		System.out.println("\t 5. Rent video");
		System.out.println("\t 6. Return video");
		System.out.println("\t 7. Show customer report");
		System.out.println("\t 8. Show customer and clear rentals");

		int command = scanner.nextInt() ;

		return command ;

	}
}
