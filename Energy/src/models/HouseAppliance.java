package models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HouseAppliance {

    private static final String TURN_OFF = "APAGADO";
    private static final String STAND_BYE = "CONECTADO";
    private static final String TURN_ON = "ENCENDIDO";
    public static final String ECO_MODE = "Modo Eco";
    public static final String NORMAL_MODE = "Modo Normal";

    private final HouseApplianceConstant applianceConstant;
    private LocalDate on;
    private LocalDate off;
    private boolean isTurnOn;
    private boolean isStandBye;
    private double whaterCost;
    private double internetCost;
    private int gasCost;
    private int electricityExpense;

    public HouseAppliance(HouseApplianceConstant houseApplianceConstant) {
        off = LocalDate.now();
        on = LocalDate.now();
        applianceConstant = houseApplianceConstant;
        whaterCost = houseApplianceConstant.getWhaterCost();
        internetCost = houseApplianceConstant.getInternetCost();
        gasCost = houseApplianceConstant.getGasCost();
        electricityExpense = houseApplianceConstant.getElectricityExpense();
    }

    public double calculateWhaterCost() {
        return whaterCost += (on.until(off, ChronoUnit.DAYS)) * applianceConstant.getWhaterCost();
    }

    public double calculateInternetCost() {
        return internetCost += (on.until(off, ChronoUnit.DAYS)) * applianceConstant.getInternetCost();
    }

    public double calculateGasCost() {
        return gasCost += (on.until(off, ChronoUnit.DAYS)) * applianceConstant.getGasCost();
    }

    public double calculateElectricityExpense() {
        return electricityExpense += (on.until(off, ChronoUnit.DAYS)) * applianceConstant.getElectricityExpense();
    }

    public void powerOn() {
        on = LocalDate.now();
        isTurnOn = true;
        isStandBye = false;
    }

    public void powerOff() {
        off = LocalDate.now();
        isTurnOn = false;
        isStandBye = true;
    }

    public void disconnect() {
        off = LocalDate.now();
        isStandBye = false;
        isTurnOn = false;
    }

    public boolean isTurnOn() {
        return isTurnOn;
    }

    public HouseApplianceConstant getHouseApplianceConstant() {
        return applianceConstant;
    }

    public String getStatus() {
        String status = TURN_OFF;
        if (isTurnOn) {
            status = TURN_ON;
        } else if (isStandBye) {
            status = STAND_BYE;
        }
        return status;
    }

    public String getMode() {
        String mode = NORMAL_MODE;
        if (isStandBye) {
            mode = ECO_MODE;
            electricityExpense += 40;
            gasCost += 0;
            internetCost += 20;
            whaterCost += 0;
        } else if (!isTurnOn) {
            electricityExpense += 0;
            gasCost += 0;
            internetCost += 0;
            whaterCost += 0;
            mode = "";
        }
        return mode;
    }

    public boolean isInStandBye() {
        return isStandBye;
    }
}
