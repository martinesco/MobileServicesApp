package project.entity;

import project.Validate;
import project.entity.Invoice;
import project.entity.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MobileService {

    private String mobileNumber;
    private Service service;
    private List<Invoice> invoices;

    public MobileService(String mobileNumber, Service service) {
        this.setMobileNumber(mobileNumber);
        this.setService(service);
        this.setInvoices();
    }

    private void setMobileNumber(String mobileNumber) {
        Validate.mobileNumber(mobileNumber);
        this.mobileNumber = mobileNumber;
    }

    private void setService(Service service) {
        this.service = service;
    }

    private void setInvoices() {
        this.invoices = new ArrayList<>();

        invoices.add(new Invoice(
                this.getService().getPrice(),
                LocalDate.now(),
                LocalDate.now().plusMonths(1),
                LocalDate.now().plusMonths(1).plusDays(15)));
    }

    public Service getService() {
        return service;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
