package views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import models.HouseApplianceConstant;
import static views.PanelOptions.ENERGY_COLOR;

public class CheckBoxHouseAppliance extends JCheckBox {

    private HouseApplianceConstant applianceConstant;

    public CheckBoxHouseAppliance(HouseApplianceConstant constant) {
        applianceConstant = constant;
        setText(constant.getName());
        setBackground(ENERGY_COLOR);
        setForeground(Color.WHITE);
        setFont(new Font("Lucida Bright", Font.PLAIN, 22));
    }

    public String getHouseApplianceName() {
        return getText();
    }

    public HouseApplianceConstant getApplianceConstant() {
        return applianceConstant;
    }
}