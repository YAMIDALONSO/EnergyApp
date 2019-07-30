package views;

import controller.Events;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.HouseAppliance;
import models.HouseApplianceConstant;
import static views.PanelOptions.BACKGROUND_COLOR;
import static views.PanelOptions.ENERGY_COLOR;
import static views.PanelOptions.ENERGY_FONT;

public class CardHouseAppliance extends JPanel {

    private static final String POWER_ON = "Encender";
    private static final String POWER_OFF = "Apagar";
    private static final String DISCONECT = "Desenchufar";

    private JLabel jlIcon;
    private JLabel jlName;
    private JLabel jlCost;
    private JLabel jlMode;
    private JLabel jlStatus;
    private JButton jbDisconect;
    private JButton jbPower;

    private HouseAppliance houseAppliance;
    
    public CardHouseAppliance(HouseAppliance houseAppliance, HouseApplianceConstant houseApplianceConstant, ActionListener controller) {
        setBackground(ENERGY_COLOR);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setName(houseApplianceConstant.getName());

        this.houseAppliance = houseAppliance;
        
        jlIcon = new JLabel(getIcon(houseApplianceConstant.getIcon()));
        add(jlIcon);

        jlName = new JLabel(houseApplianceConstant.getName());
        jlName.setFont(ENERGY_FONT);
        jlName.setForeground(Color.WHITE);
        add(jlName);

        jlCost = new JLabel(ELECTRICITY_EXPENSIVE + houseAppliance.calculateElectricityExpense());
        jlCost.setFont(ENERGY_FONT);
        jlCost.setForeground(Color.WHITE);
        add(jlCost);

        jlMode = new JLabel(houseAppliance.getMode());
        jlMode.setFont(ENERGY_FONT);
        jlMode.setForeground(Color.WHITE);
        add(jlMode);

        jlStatus = new JLabel(houseAppliance.getStatus());
        jlStatus.setFont(ENERGY_FONT);
        jlStatus.setForeground(Color.WHITE);
        add(jlStatus);

        JPanel jp = new JPanel();
        jp.setBackground(ENERGY_COLOR);

        jbPower = new JButton(getPutToStatus(houseAppliance.isInStandBye()));
        jbPower.setBackground(Color.WHITE);
        jbPower.setForeground(ENERGY_COLOR);
        jbPower.setFont(ENERGY_FONT);
        jbPower.setName(houseApplianceConstant.getName());
        jbPower.addActionListener(controller);
        jbPower.setActionCommand(Events.POWER_ON.toString());
        jp.add(jbPower);

        jbDisconect = new JButton(DISCONECT);
        jbDisconect.setBackground(Color.WHITE);
        jbDisconect.setForeground(ENERGY_COLOR);
        jbDisconect.setFont(ENERGY_FONT);
        jbDisconect.setName(houseApplianceConstant.getName());
        jbDisconect.addActionListener(controller);
        jbDisconect.setActionCommand(Events.DISCONNECT.toString());
        jp.add(jbDisconect);

        add(jp);
    }
    private static final String ELECTRICITY_EXPENSIVE = "Costo de Electricidad: ";

    public ImageIcon getIcon(String icon) {
        Image iiNewSize = new ImageIcon(getClass().getResource(icon)).getImage();
        Image newPhoto = iiNewSize.getScaledInstance(140, 140, Image.SCALE_SMOOTH);
        return new ImageIcon(newPhoto);
    }

    public void tunrOn() {
        jbPower.setText(POWER_OFF);
        jbPower.setBackground(BACKGROUND_COLOR);
        jbPower.setActionCommand(Events.POWER_OFF.toString());
        jlCost.setText(ELECTRICITY_EXPENSIVE + houseAppliance.getHouseApplianceConstant().getElectricityExpense());
        jlMode.setText(houseAppliance.getMode());
        jlStatus.setText(houseAppliance.getStatus());
    }
    
    public String getHouseAppliance(){
        return jbPower.getName();
    }

    public void turnOff() {
        jbPower.setText(POWER_ON);
        jbPower.setBackground(Color.WHITE);
        jbPower.setActionCommand(Events.POWER_ON.toString());
        jlCost.setText(ELECTRICITY_EXPENSIVE + houseAppliance.getHouseApplianceConstant().getElectricityExpense());
        jlMode.setText(houseAppliance.getMode());
        jlStatus.setText(houseAppliance.getStatus());
    }

    public void disconnect() {
        jbPower.setText(POWER_ON);
        jbPower.setBackground(Color.WHITE);
        jbPower.setActionCommand(Events.POWER_ON.toString());
        jlCost.setText(ELECTRICITY_EXPENSIVE + houseAppliance.getHouseApplianceConstant().getElectricityExpense());
        jlMode.setText(houseAppliance.getMode());
        jlStatus.setText(houseAppliance.getStatus());
    }
    
    private String getPutToStatus(boolean inStandBye){
        if (!inStandBye) {
            return POWER_ON;
        }else{
            return POWER_OFF;
        }
    }
            
}