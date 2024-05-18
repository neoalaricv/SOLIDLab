public class OrderSummary implements Order {
    private OrderCalculator orderCalculator;
    private OrderPlacer orderPlacer;
    private InvoiceGenerator invoiceGenerator;
    private EmailSender emailSender;

    public OrderSummary(OrderCalculator orderCalculator, OrderPlacer orderPlacer,
                          InvoiceGenerator invoiceGenerator, EmailSender emailSender) {
        this.orderCalculator = orderCalculator;
        this.orderPlacer = orderPlacer;
        this.invoiceGenerator = invoiceGenerator;
        this.emailSender = emailSender;
    }

    @Override
    public void processOrder(OrderInfo orderInfo) {
        double total = orderCalculator.calculateTotal(orderInfo.getPrice(), orderInfo.getQuantity());
        System.out.println("Order total: $" + total);

        orderPlacer.placeOrder(orderInfo.getCustomerName(), orderInfo.getAddress());

        invoiceGenerator.generateInvoice(orderInfo.getInvoiceFileName());
        emailSender.sendEmailNotification(orderInfo.getEmail());
    }
}
