public class Client {

    private static boolean someCondition;

    public static void main(String[] args) {
        TotalCalculator totalCalculator = new OrderTotalCounter();
        OrderPlacer orderPlacer = new OrderPlacerInt();
        InvoiceGenerator invoiceGenerator = new InvoiceGeneratorInt();
        EmailNotifier emailNotifier = new EmailNotifierInt();

        Order order = new Order(totalCalculator, orderPlacer, invoiceGenerator, emailNotifier);

        order.calculateTotal(10.0, 2);
        order.placeOrder("John Doe", "123 Main St");

        if (someCondition) {
            order.generateInvoice("order_123.pdf");
            order.sendEmailNotification("johndoe@example.com");
        }
    }
}