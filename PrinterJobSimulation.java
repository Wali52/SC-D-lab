package task2;

class Printer {
    private int availablePages;

    public Printer(int availablePages) {
        this.availablePages = availablePages;
    }

    // Method to check and print pages
    public synchronized void printPages(int pages) throws InterruptedException {
        while (availablePages < pages) {
            System.out.println("Not enough pages. Waiting for pages to be added...");
            wait();  // Wait until enough pages are available
        }
        availablePages -= pages;
        System.out.println("Printing " + pages + " pages. Remaining pages: " + availablePages);
    }

    // Method to add pages to the printer tray
    public synchronized void addPages(int pages) {
        availablePages += pages;
        System.out.println(pages + " pages added to printer. Total pages now: " + availablePages);
        notify();  // Notify waiting threads that pages are available
    }

    public int getAvailablePages() {
        return availablePages;
    }
}

class PrintJob extends Thread {
    private Printer printer;
    private int pagesToPrint;

    public PrintJob(Printer printer, int pagesToPrint) {
        this.printer = printer;
        this.pagesToPrint = pagesToPrint;
    }

    @Override
    public void run() {
        try {
            printer.printPages(pagesToPrint);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

class PageRefiller extends Thread {
    private Printer printer;
    private int pagesToAdd;

    public PageRefiller(Printer printer, int pagesToAdd) {
        this.printer = printer;
        this.pagesToAdd = pagesToAdd;
    }

    @Override
    public void run() {
        printer.addPages(pagesToAdd);
    }
}

public class PrinterJobSimulation {
    public static void main(String[] args) throws InterruptedException {
        // Initially, the printer has 10 pages
        Printer printer = new Printer(10);

        // Job that needs to print 15 pages
        PrintJob printJob = new PrintJob(printer, 15);

        // A separate thread that adds pages to the printer tray
        PageRefiller pageRefiller = new PageRefiller(printer, 20);  // Adds 20 pages

        // Start the threads
        printJob.start();
        Thread.sleep(1000);  // Allow the print job to start and wait for pages
        pageRefiller.start();
    }
}
