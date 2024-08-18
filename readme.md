****Overview****
The code implements a movie ticket booking system using an object-oriented approach, its a console based application. It consists of several classes and interfaces that manage shows, seats, bookings, and revenue calculation. Here’s a brief explanation of the design made in the code:
Key Classes and Interfaces:

**1. SeatCategory Enum:**
   - Represents different categories of seats with associated costs.
   - The categories are `PLATINUM`, `GOLD`, and `SILVER`, each with a different cost.

**2. ShowRepository Interface:**
   - Defines methods for accessing and updating seat information for a specific show.
   - Includes `getSeatsForShow(int showNumber)` and `updateSeats(int showNumber, Map<String, SeatCategory> seats)`.

**3. ShowRepositoryImpl Class**:
   - Implements `ShowRepository`.
   - Manages the storage and initialization of seat data for different shows.
   - Initializes three shows with predefined seat allocations.

**4. Booking Class:**
   - Handles the processing of booking costs, including the calculation of various taxes (Service Tax, Swachh Bharat Cess, Krishi Kalyan Cess).
   - Manages the total revenue generated from bookings.

**5. Show Class:**
   - Manages the seats for a specific show.
   - Allows booking of seats and calculates the total cost based on the seats booked.
   - Removes booked seats from availability.

**6. ShowService Class:**
   - Acts as a mediator between the `ShowRepository` and `Booking` classes.
   - Provides methods to display available seats, book seats, and print booking summaries.
   - Handles the logic of seat booking, including checking availability and updating seat data.

**7. MovieBookingSystem Class:**
   - The main entry point for the application.
   - Interacts with the user, allowing them to choose a show, book seats, and display booking summaries.
   - Uses a `Scanner` for input and interacts with `ShowService` to perform operations.

****Design and Flow****

**1. Initialization:**
   - `ShowRepositoryImpl` is initialized with three shows, each having a predefined set of seats with associated categories.

**2. Booking Flow:**
   - The user is prompted to enter a show number.
   - Available seats for the selected show are displayed.
   - The user selects seats to book.
   - The `ShowService` class checks if the seats are available, calculates the cost, and processes the booking.
   - The booking is confirmed, and the total cost including taxes is displayed.
   - The system updates the available seats for the show.

**3. Tax Calculation:**
   - `Booking` class calculates Service Tax (14%), Swachh Bharat Cess (0.5%), and Krishi Kalyan Cess (0.5%) on the total cost of the booked seats.

**4. Error Handling:**
   - Custom exceptions like `SeatAlreadyBookedException` and `InvalidInputException` are used to handle specific error cases (e.g., booking unavailable seats, invalid show numbers).
