public class Client {
    public static void main(String[] args) {
        OrderCalculator orderCalculator = new OrderCalculator();
        OrderPlacer orderPlacer = new OrderPlacer();
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        EmailNotifier emailNotifier = new EmailNotifier();

        Order orderProcessor = new OrderSummary(orderCalculator, orderPlacer, invoiceGenerator, emailNotifier);

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setPrice(6.0);
        orderInfo.setQuantity(4);
        orderInfo.setCustomerName("Neyow");
        orderInfo.setAddress("Hollywood");
        orderInfo.setInvoiceFileName("invoice.jpg");
        orderInfo.setEmail("neo.villanueva@neu.edu.ph");

        orderProcessor.processOrder(orderInfo);
    }
}
