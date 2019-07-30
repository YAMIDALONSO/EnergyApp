package views;

import controller.Events;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import models.HouseAppliance;
import models.User;
import static views.PanelOptions.ENERGY_COLOR;
import static views.PanelOptions.ENERGY_FONT;

public class WindowEnergySaver extends JFrame {

    public static final String TITLE = "AHORRADOR DE ENERGIA";
    private static final String ICON = "/data/Icon.png";
    private static final String BACKGROUND_IMAGE = "/data/Background.jpg";
    public static final String SING_UP_TEXT = "Iniciar Sesión";
    public static final String SING_IN_TEXT = "Registrarse";

    private JButton jbSingIn;
    private JButton jbSingUp;
    private PanelContainaer containaer;

    public WindowEnergySaver(ActionListener controller) {
        setTitle(TITLE);
        setIconImage(new ImageIcon(getClass().getResource(ICON)).getImage());
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setBackground(Color.WHITE);
        setContentPane(new JLabel(new ImageIcon(getClass().getResource(BACKGROUND_IMAGE))));
        setLayout(new FlowLayout(FlowLayout.CENTER, 400, 0));

        jbSingIn = new JButton(SING_IN_TEXT);
        jbSingIn.setFont(ENERGY_FONT);
        jbSingIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbSingIn.setBackground(ENERGY_COLOR);
        jbSingIn.setForeground(Color.WHITE);
        jbSingIn.addActionListener(controller);
        jbSingIn.setActionCommand(Events.SHOW_SING_IN.toString());
        add(jbSingIn, FlowLayout.LEFT);

        jbSingUp = new JButton(SING_UP_TEXT);
        jbSingUp.setFont(ENERGY_FONT);
        jbSingUp.setForeground(ENERGY_COLOR);
        jbSingUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbSingUp.setBackground(Color.WHITE);
        jbSingUp.addActionListener(controller);
        jbSingUp.setActionCommand(Events.SHOW_SING_UP.toString());
        add(jbSingUp);
    }

    public void singUp(ActionListener controller) {
        getContentPane().removeAll();
        setLayout(new BorderLayout());
        containaer = new PanelContainaer(controller);
        add(containaer);
        revalidate();
    }

    public void extend() {
        containaer.extend();
    }

    public void contract() {
        containaer.contract();
    }

    public void showElectrodomestics(ArrayList<HouseAppliance> houseApplianceList, ActionListener controller) {
        containaer.showElectrodomestics(houseApplianceList, controller);
        revalidate();
    }

    public void turnOn(String houseAppliance) {
        containaer.turnOn(houseAppliance);
    }

    public void turnOff(String houseAppliance) {
        containaer.turnOff(houseAppliance);
    }

    public void disconnect(String name) {
        containaer.disconect(name);
    }

    public void showHome(User user) {
        containaer.showHome(user);
        revalidate();
    }

    public void enableEcoMode() {
        containaer.enableEcoMode();
        revalidate();
    }

    public void disableEcoMode() {
        containaer.disableEcoMode();
        revalidate();
    }

    public void singOut() {
        getContentPane().removeAll();

        setBackground(Color.WHITE);
        setContentPane(new JLabel(new ImageIcon(getClass().getResource(BACKGROUND_IMAGE))));
        setLayout(new FlowLayout(FlowLayout.CENTER, 400, 0));

        add(jbSingIn);
        add(jbSingUp);
        
        revalidate();
    }
}