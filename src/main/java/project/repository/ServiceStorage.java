package project.repository;

import project.entity.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceStorage {

    private List<Service> services;

    public ServiceStorage(){
        this.setServices();
    }

    private void setServices() {
        this.services = new ArrayList<>();

        services.add(new Service("Koledno chudo",19.99, "Neogranicheni","100",10000,1000,100,"Udvoeni sms-si"));
        services.add(new Service("Standart",12.99, "3000","0",3500,0,0,""));
        services.add(new Service("Baba & Dedo",8.99, "500","0",0,0,0,""));
        services.add(new Service("Smart Baba & Dedo",11.99, "600","0",2000,0,0,""));
        services.add(new Service("Mega",8.99, "Neogranicheni","1000",20000,5000,500,"Za loyalni klienti s namalenie 15%"));
    }

    public List<Service> getServices() {
        return services;
    }
}
