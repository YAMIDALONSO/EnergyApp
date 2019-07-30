package views;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.User;
import static models.User.GAS_COST;
import static models.User.INTERNET_COST;
import static models.User.MAX_ELECTRICITY_EXPENSE;
import static models.User.WHATER_COST;
import static views.PanelOptions.ENERGY_COLOR;
import static views.PanelOptions.ENERGY_FONT;

public class PanelFooter extends JPanel {

    private JLabel jlTotalElectrodomestics;
    private JLabel jlTotalCostInGas;
    private JLabel jlTotalCostInWhater;
    private JLabel jlTotalCostInInternet;
    private JLabel jlTotalCostInElectricity;

    public PanelFooter(User user) {
        setBackground(ENERGY_COLOR);
        setLayout(new GridLayout(3, 2));
        
        jlTotalElectrodomestics = new JLabel("Total de electrodomesticos " + user.getElectrodomestics().size());
        jlTotalElectrodomestics.setFont(ENERGY_FONT);
        jlTotalElectrodomestics.setForeground(Color.WHITE);
        add(jlTotalElectrodomestics);

        jlTotalCostInElectricity = new JLabel("Le quedan " + (MAX_ELECTRICITY_EXPENSE - user.getCostForElectricity()) + " Vatios de electricidad por usar");
        jlTotalCostInElectricity.setFont(ENERGY_FONT);
        jlTotalCostInElectricity.setForeground(Color.WHITE);
        add(jlTotalCostInElectricity);
        
        jlTotalCostInGas = new JLabel("Le quedan " + (GAS_COST - user.getCostForElectricity()) + " vatios de gas por usar");
        jlTotalCostInGas.setFont(ENERGY_FONT);
        jlTotalCostInGas.setForeground(Color.WHITE);
        add(jlTotalCostInGas);
        
        jlTotalCostInInternet = new JLabel("Le quedan " + (INTERNET_COST - user.getCostForInternet()) + " Megabytes de internet por usar");
        jlTotalCostInInternet.setFont(ENERGY_FONT);
        jlTotalCostInInternet.setForeground(Color.WHITE);
        add(jlTotalCostInInternet);
        
        jlTotalCostInWhater = new JLabel("Le quedan " + (WHATER_COST - user.getCostForWhater()) + " Litros de agua por usar");
        jlTotalCostInWhater.setFont(ENERGY_FONT);
        jlTotalCostInWhater.setForeground(Color.WHITE);
        add(jlTotalCostInWhater);
    }

}
