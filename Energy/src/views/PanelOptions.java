package views;

import controller.Events;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOptions extends JPanel {

    private static final String EXTEND_PATH = "/data/Extend.png";
    public static final Color ENERGY_COLOR = Color.decode("#32c001");
    public static final Color BACKGROUND_COLOR = Color.decode("#232525");
    private static final String HOME_ICON = "/data/Home.png";
    private static final String ELECTRO_ICON = "/data/Electro.png";
    private static final String ECO_ICON = "/data/Eco.png";
    private static final String SING_OUT_ICON = "/data/SingOut.png";
    public static final Font ENERGY_FONT = new Font("Times New Roman", Font.BOLD, 26);

    private JButton jbExtend;
    private JButton jbHome;
    private JButton jbElectrodomestics;
    private JButton jbEcoMode;
    private JButton jbSingOut;

    public PanelOptions(ActionListener controller) {
        setLayout(new GridLayout(0, 1));
        jbExtend = new JButton(getIcon(EXTEND_PATH));
        jbExtend.setAlignmentX(Component.BOTTOM_ALIGNMENT);
        jbExtend.setBackground(ENERGY_COLOR);
        jbExtend.setForeground(Color.WHITE);
        jbExtend.setFont(ENERGY_FONT);
        jbExtend.setFocusable(false);
        jbExtend.setBorderPainted(false);
        jbExtend.addActionListener(controller);
        jbExtend.setActionCommand(Events.EXTEND.toString());
        add(jbExtend);

        jbHome = new JButton(getIcon(HOME_ICON));
        jbHome.setBackground(ENERGY_COLOR);
        jbHome.setFocusable(false);
        jbHome.setBorderPainted(false);
        jbHome.setForeground(Color.WHITE);
        jbHome.setFont(ENERGY_FONT);
        jbHome.addActionListener(controller);
        jbHome.setActionCommand(Events.SHOW_HOME.toString());
        add(jbHome);

        jbElectrodomestics = new JButton(getIcon(ELECTRO_ICON));
        jbElectrodomestics.setBackground(ENERGY_COLOR);
        jbElectrodomestics.setFocusable(false);
        jbElectrodomestics.setBorderPainted(false);
        jbElectrodomestics.setForeground(Color.WHITE);
        jbElectrodomestics.setFont(ENERGY_FONT);
        jbElectrodomestics.addActionListener(controller);
        jbElectrodomestics.setActionCommand(Events.SHOW_ELECTRODOMESTICS.toString());
        add(jbElectrodomestics);

        jbEcoMode = new JButton(getIcon(ECO_ICON));
        jbEcoMode.setBackground(ENERGY_COLOR);
        jbEcoMode.setFocusable(false);
        jbEcoMode.setBorderPainted(false);
        jbEcoMode.setForeground(Color.WHITE);
        jbEcoMode.setFont(ENERGY_FONT);
        jbEcoMode.addActionListener(controller);
        jbEcoMode.setActionCommand(Events.ENABLE_ECO.toString());
        add(jbEcoMode);

        jbSingOut = new JButton(getIcon(SING_OUT_ICON));
        jbSingOut.setBackground(ENERGY_COLOR);
        jbSingOut.setFocusable(false);
        jbSingOut.setBorderPainted(false);
        jbSingOut.setForeground(Color.WHITE);
        jbSingOut.setFont(ENERGY_FONT);
        jbSingOut.addActionListener(controller);
        jbSingOut.setActionCommand(Events.SING_OUT.toString());
        add(jbSingOut);
    }

    public ImageIcon getIcon(String icon) {
        Image iiNewSize = new ImageIcon(getClass().getResource(icon)).getImage();
        Image newPhoto = iiNewSize.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        return new ImageIcon(newPhoto);
    }

    public void extend() {
        jbExtend.setText("Contraer");
        jbExtend.setActionCommand(Events.CONTRACT.toString());
        jbHome.setText("Inicio");
        jbEcoMode.setText("Modo Eco");
        jbElectrodomestics.setText("Electrodomesticos");
        jbSingOut.setText("Cerrar Sesión");
    }

    public void contract() {
        jbExtend.setText("");
        jbExtend.setActionCommand(Events.EXTEND.toString());
        jbHome.setText("");
        jbEcoMode.setText("");
        jbElectrodomestics.setText("");
        jbSingOut.setText("");
    }

    public void showElectrodomestics() {
        jbElectrodomestics.setBackground(BACKGROUND_COLOR);
        jbExtend.setBackground(ENERGY_COLOR);
        jbHome.setBackground(ENERGY_COLOR);
        jbSingOut.setBackground(ENERGY_COLOR);
    }

    public void showHome() {
        jbHome.setBackground(BACKGROUND_COLOR);
        jbExtend.setBackground(ENERGY_COLOR);
        jbElectrodomestics.setBackground(ENERGY_COLOR);
        jbSingOut.setBackground(ENERGY_COLOR);
    }

    public void enableEcoMode() {
        jbEcoMode.setBackground(Color.RED);
        jbEcoMode.setActionCommand(Events.DISABLE_ECO.toString());
    }

    public void disableEcoMode() {
        jbEcoMode.setBackground(ENERGY_COLOR);
        jbEcoMode.setActionCommand(Events.ENABLE_ECO.toString());
    }

    public void showStats() {
        jbHome.setBackground(ENERGY_COLOR);
        jbExtend.setBackground(ENERGY_COLOR);
        jbElectrodomestics.setBackground(ENERGY_COLOR);
        jbSingOut.setBackground(ENERGY_COLOR);
    }
}
