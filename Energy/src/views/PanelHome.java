package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import static models.HouseAppliance.ECO_MODE;
import static models.HouseAppliance.NORMAL_MODE;
import models.User;
import static views.PanelOptions.ENERGY_COLOR;
import static views.PanelOptions.ENERGY_FONT;
import static views.WindowEnergySaver.TITLE;

public class PanelHome extends JPanel {

    public static final CompoundBorder ENERGY_BORDER = new CompoundBorder(BorderFactory.createMatteBorder(40, 40, 40, 40, Color.WHITE), BorderFactory.createMatteBorder(4, 4, 4, 4, ENERGY_COLOR));
    private static final String LT_USED = " Litros Usados";
    private static final String MB_USED = " Megas Usadas";
    private static final String APPLIANCES_IN_USE = " Electrodomesticos en Uso";
    private static final String USED_WHATS = " Vatios Usados";

    private JPanel jpHeader;
    private JLabel jlUser;
    private JLabel jlElectrodomestics;
    private JLabel jlMode;
    private JLabel jlElectricity;
    private JLabel jlGas;
    private JLabel jlWhater;
    private JLabel jlInternet;
    private PanelFooter footer;

    public PanelHome(User user) {
        setLayout(new BorderLayout());

        jpHeader = new JPanel();
        JLabel jl = new JLabel(TITLE);
        jl.setFont(ENERGY_FONT);
        jl.setForeground(Color.WHITE);

        jpHeader.add(jl);
        jpHeader.setBackground(ENERGY_COLOR);
        add(jpHeader, BorderLayout.PAGE_START);

        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(2, 2, 4, 4));

        jlUser = new JLabel("Nombre de Usuario: " + user.getName());
        jlUser.setFont(ENERGY_FONT);
        jlUser.setForeground(ENERGY_COLOR);
        jlUser.setAlignmentX(Component.CENTER_ALIGNMENT);
        jlUser.setBorder(ENERGY_BORDER);
        
        jp.add(jlUser);

        jlElectrodomestics = new JLabel(user.countAppliancesInUse() + APPLIANCES_IN_USE);
        jlElectrodomestics.setFont(ENERGY_FONT);
        jlElectrodomestics.setForeground(ENERGY_COLOR);
        jlElectrodomestics.setAlignmentX(Component.CENTER_ALIGNMENT);
        jlElectrodomestics.setBorder(ENERGY_BORDER);

        jp.add(jlElectrodomestics);

        jlMode = new JLabel(NORMAL_MODE);
        jlMode.setFont(ENERGY_FONT);
        jlMode.setForeground(Color.BLACK);
        jlMode.setAlignmentX(Component.CENTER_ALIGNMENT);
        jlMode.setBorder(ENERGY_BORDER);

        jp.add(jlMode);

        jlElectricity = new JLabel(user.getCostForElectricity() + USED_WHATS);
        jlElectricity.setFont(ENERGY_FONT);
        jlElectricity.setForeground(ENERGY_COLOR);
        jlElectricity.setAlignmentX(Component.CENTER_ALIGNMENT);
        jlElectricity.setBorder(ENERGY_BORDER);

        jp.add(jlElectricity);

        jlGas = new JLabel(user.getCostForGas() + USED_WHATS);
        jlGas.setFont(ENERGY_FONT);
        jlGas.setForeground(ENERGY_COLOR);
        jlGas.setAlignmentX(Component.CENTER_ALIGNMENT);
        jlGas.setBorder(ENERGY_BORDER);

        jp.add(jlGas);

        jlWhater = new JLabel(user.getCostForWhater() + LT_USED);
        jlWhater.setFont(ENERGY_FONT);
        jlWhater.setForeground(ENERGY_COLOR);
        jlWhater.setAlignmentX(Component.CENTER_ALIGNMENT);
        jlWhater.setBorder(ENERGY_BORDER);

        jp.add(jlWhater);
        
        jlInternet = new JLabel(user.getCostForInternet() + MB_USED);
        jlInternet.setFont(ENERGY_FONT);
        jlInternet.setForeground(ENERGY_COLOR);
        jlInternet.setAlignmentX(Component.CENTER_ALIGNMENT);

        jp.add(jlInternet);

        jp.setBackground(Color.WHITE);
        
        JScrollPane jsp = new JScrollPane(jp);
        add(jsp, BorderLayout.CENTER);

        footer = new PanelFooter(user);
        add(footer, BorderLayout.PAGE_END);
    }
    

    public void enableEcoMode() {
        jlMode.setText(ECO_MODE);
        jlMode.setForeground(ENERGY_COLOR);
    }

    public void disableEcoMode() {
        jlMode.setText(NORMAL_MODE);
        jlMode.setForeground(Color.BLACK);
    }
}