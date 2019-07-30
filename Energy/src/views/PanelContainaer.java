package views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import models.HouseAppliance;
import models.User;

public class PanelContainaer extends JPanel {

    private PanelOptions options;
    private PanelElectrodomestics panelElectrodomestics;
    private PanelHome panelHome;

    public PanelContainaer(ActionListener controller) {
        setLayout(new BorderLayout());
        options = new PanelOptions(controller);
        add(options, BorderLayout.LINE_START);
    }

    public void extend() {
        options.extend();
    }

    public void contract() {
        options.contract();
    }

    public void showElectrodomestics(ArrayList<HouseAppliance> houseApplianceList, ActionListener controller) {
        removeAll();
        add(options, BorderLayout.LINE_START);
        panelElectrodomestics = new PanelElectrodomestics(houseApplianceList, controller);
        JScrollPane jsp = new JScrollPane(panelElectrodomestics);
        options.showElectrodomestics();
        add(jsp);
        revalidate();
    }

    public void turnOn(String houseAppliance) {
        panelElectrodomestics.turnOn(houseAppliance);
    }

    public void turnOff(String houseAppliance) {
        panelElectrodomestics.turnOff(houseAppliance);
    }

    public void disconect(String name) {
        panelElectrodomestics.disconnect(name);
    }

    public void showHome(User user) {
        removeAll();
        add(options, BorderLayout.LINE_START);
                panelHome = new PanelHome(user);
        add(panelHome);
        
        options.showHome();
        revalidate();
    }

    public void disableEcoMode() {
        panelHome.disableEcoMode();
        panelElectrodomestics.disableEcoMode();
        options.disableEcoMode();
    }

    public void enableEcoMode() {
        panelHome.enableEcoMode();
        panelElectrodomestics.enableEcoMode();
        options.enableEcoMode();
    }
}
