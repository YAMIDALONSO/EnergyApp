package views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import models.HouseAppliance;

public class PanelElectrodomestics extends JPanel {

    private ArrayList<CardHouseAppliance> electrodomestics;

    public PanelElectrodomestics(ArrayList<HouseAppliance> houseApplianceList, ActionListener controller) {
        setLayout(new GridLayout(houseApplianceList.size() / 2, 2, 7, 7));

        electrodomestics = new ArrayList<>();
        for (HouseAppliance houseAppliance : houseApplianceList) {
            electrodomestics.add(new CardHouseAppliance(houseAppliance, houseAppliance.getHouseApplianceConstant(), controller));

        }

        for (CardHouseAppliance cardHouseAppliance : electrodomestics) {
            add(cardHouseAppliance);
        }
    }

    public void turnOn(String houseAppliance) {
        for (int i = 0; i < electrodomestics.size(); i++) {
            if (houseAppliance.equals(electrodomestics.get(i).getHouseAppliance())) {
                electrodomestics.get(i).tunrOn();
            }
        }
    }

    public void turnOff(String houseAppliance) {
        for (CardHouseAppliance electrodomestic : electrodomestics) {
            if (electrodomestic.getHouseAppliance().equals(houseAppliance)) {
                electrodomestic.turnOff();
            }
        }
    }

    public void disconnect(String name) {
        for (CardHouseAppliance electrodomestic : electrodomestics) {
            if (electrodomestic.getHouseAppliance().equals(name)) {
                electrodomestic.disconnect();
            }
        }
    }

    public void enableEcoMode() {
        for (CardHouseAppliance electrodomestic : electrodomestics) {
            electrodomestic.disconnect();
        }
    }

    public void disableEcoMode() {
        for (CardHouseAppliance electrodomestic : electrodomestics) {
            electrodomestic.turnOff();
        }
    }
}
