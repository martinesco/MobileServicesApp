package project.entity;

import project.Validate;

public class Service {

    private String name;
    private double price;
    private String minutesToBulgaria;
    private String minutesToAbroad;
    private int mbInternetToBulgaria;
    private int mbInternetToAbroad;
    private int sms;
    private String extras;

    public Service() {
    }

    public Service(String name, double price, String minutesToBulgaria, String minutesToAbroad, int mbInternetToBulgaria, int mbInternetToAbroad, int sms, String extras) {
        this.setName(name);
        this.setPrice(price);
        this.setMinutesToBulgaria(minutesToBulgaria);
        this.setMinutesToAbroad(minutesToAbroad);
        this.setMbInternetToBulgaria(mbInternetToBulgaria);
        this.setMbInternetToAbroad(mbInternetToAbroad);
        this.setSms(sms);
        this.setExtras(extras);
    }

    private void setName(String name) {
        Validate.name(name);
        this.name = name;
    }

    private void setPrice(double price) {
        Validate.price(price);
        this.price = price;
    }

    private void setMinutesToBulgaria(String minutesToBulgaria) {
        Validate.serviceMinutes(minutesToBulgaria);
        this.minutesToBulgaria = minutesToBulgaria;
    }

    private void setMinutesToAbroad(String minutesToAbroad) {
        Validate.serviceMinutes(minutesToAbroad);
        this.minutesToAbroad = minutesToAbroad;
    }

    private void setMbInternetToBulgaria(int mbInternetToBulgaria) {
        Validate.serviceInternet(mbInternetToBulgaria);
        this.mbInternetToBulgaria = mbInternetToBulgaria;
    }

    private void setMbInternetToAbroad(int mbInternetToAbroad) {
        Validate.serviceInternet(mbInternetToAbroad);
        this.mbInternetToAbroad = mbInternetToAbroad;
    }

    private void setSms(int sms) {
        Validate.sms(sms);
        this.sms = sms;
    }

    private void setExtras(String extras) {
        this.extras = extras;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getMinutesToBulgaria() {
        return minutesToBulgaria;
    }

    public String getMinutesToAbroad() {
        return minutesToAbroad;
    }

    public int getMbInternetToBulgaria() {
        return mbInternetToBulgaria;
    }

    public int getMbInternetToAbroad() {
        return mbInternetToAbroad;
    }

    public int getSms() {
        return sms;
    }

    public String getExtras() {
        return extras;
    }

    @Override
    public String toString() {
        return String.format(" # Service name: %s%n # Price per month: %.2f%n # Minutes to Bulgaria: %s%n # Minutes to Abroad: %s%n # MB Internet: %s%n # MB Internet Roaming: %s%n # SMS: %s%n # Extras:%s",
                this.getName(),
                this.getPrice(),
                this.getMinutesToBulgaria(),
                this.getMinutesToAbroad(),
                this.getMbInternetToBulgaria(),
                this.getMbInternetToAbroad(),
                this.getSms(),
                this.getExtras());


    }
}
