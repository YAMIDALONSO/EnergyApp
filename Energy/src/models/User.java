package models;

import java.util.ArrayList;

public class User {

    public static final int MAX_ELECTRICITY_EXPENSE = 108000;
    public static final int WHATER_COST = 2400;
    public static final int GAS_COST = 5050;
    public static final int INTERNET_COST = 1024;

    private String name;
    private String password;
    private ArrayList<HouseApplianceConstant> houseAppliances;
    private ArrayList<HouseAppliance> electrodomestics;

    public User(String name, String password, ArrayList<HouseApplianceConstant> houseAppliances) {
        this.name = name;
        this.password = password;
        this.houseAppliances = houseAppliances;
        electrodomestics = new ArrayList<>();
        for (HouseApplianceConstant houseAppliance : houseAppliances) {
            electrodomestics.add(new HouseAppliance(houseAppliance));
        }
    }

    public double getCostForWhater() {
        double costForWhater = 0;
        for (HouseApplianceConstant houseAppliance : houseAppliances) {
            costForWhater += houseAppliance.getWhaterCost();
        }
        return costForWhater;
    }

    public double getCostForGas() {
        double costForGas = 0;
        for (HouseApplianceConstant houseAppliance : houseAppliances) {
            costForGas += houseAppliance.getGasCost();
        }
        return costForGas;
    }

    public double getCostForInternet() {
        double costForInternet = 0;
        for (HouseApplianceConstant houseAppliance : houseAppliances) {
            costForInternet += houseAppliance.getInternetCost();
        }
        return costForInternet;
    }

    public double getCostForElectricity() {
        double costForElectricity = 0;
        for (HouseApplianceConstant houseAppliance : houseAppliances) {
            costForElectricity += houseAppliance.getElectricityExpense();
        }
        return costForElectricity;
    }

    public void turnOnHouseAppliance(String houseAppliance) {
        for (int i = 0; i < electrodomestics.size(); i++) {
            if (electrodomestics.get(i).getHouseApplianceConstant().getName().equals(houseAppliance)) {
                electrodomestics.get(i).powerOn();
            }
        }
    }

    public void turnOffHouseAppliance(String houseAppliance) {
        for (int i = 0; i < electrodomestics.size(); i++) {
            if (electrodomestics.get(i).getHouseApplianceConstant().getName().equals(houseAppliance)) {
                electrodomestics.get(i).powerOff();
            }
        }
    }

    public void disconnectHouseAppliance(String houseAppliance) {
        for (int i = 0; i < electrodomestics.size(); i++) {
            if (electrodomestics.get(i).getHouseApplianceConstant().getName().equals(houseAppliance)) {
                electrodomestics.get(i).disconnect();
            }
        }
    }

    public int countAppliancesInUse() {
        int appliancesInUse = 0;
        for (int i = 0; i < electrodomestics.size(); i++) {
            if (electrodomestics.get(i).isInStandBye() || electrodomestics.get(i).isTurnOn()) {
                appliancesInUse++;
            }
        }
        return appliancesInUse;
    }

    public String getName() {
        return name;
    }

    public ArrayList<HouseApplianceConstant> getHouseAppliances() {
        return houseAppliances;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<HouseAppliance> getElectrodomestics() {
        return electrodomestics;
    }

    public void enableEco() {
        for (HouseAppliance houseAppliance : electrodomestics) {
            if (houseAppliance.isTurnOn()) {
                houseAppliance.disconnect();
            }
        }
    }

    public void disableEco() {
        for (HouseAppliance houseAppliance : electrodomestics) {
            if (houseAppliance.isInStandBye()) {
                houseAppliance.powerOff();
            }
        }
    }
}
