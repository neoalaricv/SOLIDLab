public class Order {
    private TotalCalculator totalCalculator;
    private OrderPlacer orderPlacer;
    private InvoiceGenerator invoiceGenerator;
    private EmailNotifier emailNotifier;

    public Order(TotalCalculator totalCalculator, OrderPlacer orderPlacer, InvoiceGenerator invoiceGenerator, EmailNotifier emailNotifier) {
        this.totalCalculator = totalCalculator;
        this.orderPlacer = orderPlacer;
        this.invoiceGenerator = invoiceGenerator;
        this.emailNotifier = emailNotifier;
    }

    public void calculateTotal(double price, int quantity) {
        totalCalculator.calculateTotal(price, quantity);
    }

    public void placeOrder(String customerName, String address) {
        orderPlacer.placeOrder(customerName, address);
    }

    public void generateInvoice(String fileName) {
        invoiceGenerator.generateInvoice(fileName);
    }

    public void sendEmailNotification(String email) {
        emailNotifier.sendEmailNotification(email);
    }
}
