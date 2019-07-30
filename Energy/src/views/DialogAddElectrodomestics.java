package views;

import controller.Events;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.HouseApplianceConstant;
import static views.PanelOptions.ENERGY_COLOR;
import static views.PanelOptions.ENERGY_FONT;
import static views.WindowEnergySaver.TITLE;

public class DialogAddElectrodomestics extends JDialog {

    private static final String CHECKED_HOUSE_APPLIANCE = "Seleccione sus electrodomesticos";
    private static final String END_SING_UP = "Finalizar Registro";

    private JLabel jlElectrodomestic;
    private JButton jbFinishSingUp;
    private ArrayList<CheckBoxHouseAppliance> electrodomestics;
    private JPanel jpHouseAppliance;

    public DialogAddElectrodomestics(JFrame frame, ActionListener controller) {
        super(frame, true);
        setTitle(TITLE);
        setSize(900, 600);
        setLocationRelativeTo(frame);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(Color.WHITE);

        jlElectrodomestic = new JLabel(CHECKED_HOUSE_APPLIANCE);
        jlElectrodomestic.setFont(ENERGY_FONT);
        jlElectrodomestic.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(jlElectrodomestic);

        electrodomestics = new ArrayList<>();
        addElectrodomestics();
        add(jpHouseAppliance);

        jbFinishSingUp = new JButton(END_SING_UP);
        jbFinishSingUp.setFont(ENERGY_FONT);
        jbFinishSingUp.setForeground(ENERGY_COLOR);
        jbFinishSingUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbFinishSingUp.setBackground(Color.WHITE);
        jbFinishSingUp.setAlignmentX(Component.CENTER_ALIGNMENT);
        jbFinishSingUp.addActionListener(controller);
        jbFinishSingUp.setActionCommand(Events.END_SING_IN.toString());
        add(jbFinishSingUp);
    }

    private void addElectrodomesticsToList() {
        for (int i = 0; i < HouseApplianceConstant.values().length; i++) {
            electrodomestics.add(new CheckBoxHouseAppliance(HouseApplianceConstant.values()[i]));
        }
    }

    private void addElectrodomestics() {
        addElectrodomesticsToList();
        jpHouseAppliance = new JPanel();
        jpHouseAppliance.setLayout(new GridLayout(6, electrodomestics.size()/6, 9, 9));
        jpHouseAppliance.setBackground(ENERGY_COLOR);
        for (CheckBoxHouseAppliance electrodomestic : electrodomestics) {
            jpHouseAppliance.add(electrodomestic);
        }
    }

    public ArrayList<HouseApplianceConstant> getElectrodomestics() {
        ArrayList<HouseApplianceConstant> houseApplianceList = new ArrayList<>();
        for (CheckBoxHouseAppliance electrodomestic : electrodomestics) {
            if (electrodomestic.isSelected()) {
                houseApplianceList.add(electrodomestic.getApplianceConstant());
            }
        }
        
        return houseApplianceList;
    }
}