package project.entity;

import project.InvoiceStatus;
import project.Validate;

import java.time.LocalDate;

public class Invoice {

    private InvoiceStatus invoiceStatus;
    private double price;
    private LocalDate from;
    private LocalDate to;
    private LocalDate deadline;

    public Invoice(double price, LocalDate from, LocalDate to, LocalDate deadline) {
        this.setInvoiceStatus();
        this.setPrice(price);
        this.setFrom(from);
        this.setTo(to);
        this.setDeadline(deadline);
    }

    private void setInvoiceStatus() {
        this.invoiceStatus = InvoiceStatus.NOT_PAID;
    }

    private void setPrice(double price) {
        Validate.price(price);
        this.price = price;
    }

    private void setFrom(LocalDate from) {
        this.from = from;
    }

    private void setTo(LocalDate to) {
        this.to = to;
    }

    private void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return String.format(" ## Invoice status: %s%n ## Price: %.2f%n ## From date: %s%n ## To date: %s%n ## Deadline for payment: %s",
                this.getInvoiceStatus(),
                this.getPrice(),
                this.getFrom(),
                this.getTo(),
                this.getDeadline());
    }
}
