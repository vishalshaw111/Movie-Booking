import com.controller.MovieBookingSystem;
import com.dao.ShowRepositoryImpl;
import com.dao.ShowRepository;
import com.service.Booking;
import com.exception.SeatAlreadyBookedException;
import com.service.ShowService;

/*
For detailed instructions, please refer to the README file.
It contains all the necessary guidelines and information for submitting and working with this project.
 */

public class Start {

    public static void main(String[] args) throws SeatAlreadyBookedException {
        ShowRepository showRepository = new ShowRepositoryImpl();
        Booking booking = new Booking();
        ShowService showService = new ShowService(showRepository, booking);
        MovieBookingSystem system = new MovieBookingSystem(showService);
        system.startBooking();
    }
}
