public class OrderSummary implements Order {
    private OrderCalculator orderCalculator;
    private OrderPlacer orderPlacer;
    private InvoiceGenerator invoiceGenerator;
    private EmailNotifier emailNotifier;

    public OrderSummary(OrderCalculator orderCalculator, OrderPlacer orderPlacer,
                        InvoiceGenerator invoiceGenerator, EmailNotifier emailNotifier) {
        this.orderCalculator = orderCalculator;
        this.orderPlacer = orderPlacer;
        this.invoiceGenerator = invoiceGenerator;
        this.emailNotifier = emailNotifier;
    }

    @Override
    public void processOrder(OrderInfo orderInfo) {
        double total = orderCalculator.calculateTotal(orderInfo.getPrice(), orderInfo.getQuantity());
        System.out.println("Order total: $" + total);

        orderPlacer.placeOrder(orderInfo.getCustomerName(), orderInfo.getAddress());

        invoiceGenerator.generateInvoice(orderInfo.getInvoiceFileName());
        emailNotifier.sendEmailNotification(orderInfo.getEmail());
    }
}
