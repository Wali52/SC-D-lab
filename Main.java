package main;
import java.util.Date;

// Interface for common functions
interface CommonFunctions {
    void searchTicket();
    void bookTicket();
    void cancelTicket();
    void makePayment();
    void fillDetails();
}

// Customer class with attributes and methods
class Customer {
    private String customerId;
    private String name;
    private String address;
    private int phNo;
    private int age;

    // Constructor
    public Customer(String customerId, String name, String address, int phNo, int age) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.phNo = phNo;
        this.age = age;
    }

    // Method to add customer details
    public void addDetails() {
        System.out.println("Adding details for customer: " + name);
    }

    // Method to modify customer details
    public void modifyDetails() {
        System.out.println("Modifying details for customer: " + name);
    }

    // Getters
    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPhNo() {
        return phNo;
    }

    public int getAge() {
        return age;
    }
}

// Agent class implementing CommonFunctions interface
class Agent implements CommonFunctions {
    private int id;
    private String name;

    // Constructor
    public Agent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Implementation of common functions
    public void searchTicket() {
        System.out.println("Agent " + name + " is searching for tickets.");
    }

    public void bookTicket() {
        System.out.println("Agent " + name + " is booking a ticket.");
    }

    public void cancelTicket() {
        System.out.println("Agent " + name + " is canceling a ticket.");
    }

    public void makePayment() {
        System.out.println("Agent " + name + " is making a payment.");
    }

    public void fillDetails() {
        System.out.println("Agent " + name + " is filling details.");
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Ticket class with ticket details
class Ticket {
    private String source;
    private String destination;
    private Date dateOfJourney;
    private Date time;
    private String busNo;
    private String seatNo;

    // Constructor
    public Ticket(String source, String destination, Date dateOfJourney, Date time, String busNo, String seatNo) {
        this.source = source;
        this.destination = destination;
        this.dateOfJourney = dateOfJourney;
        this.time = time;
        this.busNo = busNo;
        this.seatNo = seatNo;
    }

    // Display ticket details
    public void displayTicketInfo() {
        System.out.println("Ticket Details:");
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Date of Journey: " + dateOfJourney);
        System.out.println("Time: " + time);
        System.out.println("Bus No: " + busNo);
        System.out.println("Seat No: " + seatNo);
    }

    // Getters
    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDateOfJourney() {
        return dateOfJourney;
    }

    public Date getTime() {
        return time;
    }

    public String getBusNo() {
        return busNo;
    }

    public String getSeatNo() {
        return seatNo;
    }
}

// Refund class to process refunds
class Refund {
    private float amount;
    private String customerId;

    // Constructor
    public Refund(float amount, String customerId) {
        this.amount = amount;
        this.customerId = customerId;
    }

    // Method to process refund
    public void refundAmount() {
        System.out.println("Processing refund of amount $" + amount + " for customer ID: " + customerId);
    }

    // Getters
    public float getAmount() {
        return amount;
    }

    public String getCustomerId() {
        return customerId;
    }
}

// BookingCounter class
class BookingCounter {
    // BookingCounter attributes and methods can be added here as needed
    public void processBooking(Customer customer, Ticket ticket, Agent agent) {
        System.out.println("Processing booking for customer " + customer.getName() + " by agent " + agent.getName());
        ticket.displayTicketInfo();
    }
}

// Main class to test the program
public class Main {
    public static void main(String[] args) {
        // Sample customer
        Customer customer = new Customer("C001", "John", "123 Main St", 1234567890, 30);
        customer.addDetails();

        // Sample agent
        Agent agent = new Agent(101, "Agent Smith");
        agent.bookTicket();

        // Sample ticket
        Ticket ticket = new Ticket("CityA", "CityB", new Date(), new Date(), "B1", "S1");

        // Sample refund
        Refund refund = new Refund(150.50f, customer.getCustomerId());
        refund.refundAmount();

        // Booking process
        BookingCounter bookingCounter = new BookingCounter();
        bookingCounter.processBooking(customer, ticket, agent);
    }
}
