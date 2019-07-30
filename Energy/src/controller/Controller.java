package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import models.EnergySaver;
import models.User;
import org.json.simple.parser.ParseException;
import persistence.JSONManager;
import views.DialogAddElectrodomestics;
import views.DialogGeneralSing;
import views.WindowEnergySaver;
import static views.WindowEnergySaver.SING_IN_TEXT;
import static views.WindowEnergySaver.SING_UP_TEXT;

public class Controller implements ActionListener {

    private JSONManager jSONManager;
    private WindowEnergySaver windowEnergySaver;
    private DialogGeneralSing generalSing;
    private DialogAddElectrodomestics electrodomestics;
    private EnergySaver energySaver;

    public Controller() {
        windowEnergySaver = new WindowEnergySaver(this);
        windowEnergySaver.setVisible(true);
        generalSing = new DialogGeneralSing(windowEnergySaver, this);
        electrodomestics = new DialogAddElectrodomestics(windowEnergySaver, this);
        jSONManager = new JSONManager();
        try {
            energySaver = new EnergySaver(jSONManager.readUserList());
        } catch (IOException | ParseException ex) {
            energySaver = new EnergySaver();
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Events.valueOf(e.getActionCommand())) {
            case EXTEND:
                extend();
                break;
            case CONTRACT:
                contract();
                break;
            case SHOW_SING_IN:
                showSingIn();
                break;
            case SING_IN:
                singIn();
                break;
            case SING_UP:
                singUp();
                break;
            case END_SING_IN:
                endSingIn();
                break;
            case SHOW_SING_UP:
                showSingUp();
                break;
            case SHOW_ELECTRODOMESTICS:
                showElectrodomestics();
                break;
            case POWER_ON:
                turnOn(((JComponent) e.getSource()).getName());
                break;
            case POWER_OFF:
                powerOff(((JComponent) e.getSource()).getName());
                break;
            case DISCONNECT:
                disconect(((JComponent) e.getSource()).getName());
                break;
            case SHOW_HOME:
                showHome();
                break;
            case ENABLE_ECO:
                enableEco();
                break;
            case DISABLE_ECO:
                disableEco();
                break;
            case SING_OUT:
                singOut();
                break;
        }
    }

    private void extend() {
        windowEnergySaver.extend();
    }

    private void contract() {
        windowEnergySaver.contract();
    }

    private void showSingIn() {
        generalSing.setButtonProperties(SING_IN_TEXT, Events.SING_IN.toString());
        generalSing.setVisible(true);
    }

    private void singIn() {
        generalSing.setVisible(false);
        electrodomestics.setVisible(true);
    }

    private void singUp() {
        if (energySaver.isUserAndPasword(generalSing.getNick(), generalSing.getPassword())) {
            windowEnergySaver.singUp(this);
            generalSing.setVisible(false);
            showElectrodomestics();
        } else {
            generalSing.showErrorData();
        }
    }

    private void endSingIn() {
        User user = energySaver.createUser(generalSing.getNick(), generalSing.getPassword(), electrodomestics.getElectrodomestics());
        energySaver.addUser(user);
        try {
            jSONManager.writeJson(energySaver.getUsers());
        } catch (IOException ex) {
            System.out.println("Error al escribir el Archivo");
        }
        electrodomestics.setVisible(false);
    }

    private void showSingUp() {
        generalSing.setButtonProperties(SING_UP_TEXT, Events.SING_UP.toString());
        generalSing.setVisible(true);
    }

    private void showElectrodomestics() {
        windowEnergySaver.showElectrodomestics(energySaver.getActiveUser().getElectrodomestics(), this);
    }

    private void turnOn(String name) {
        energySaver.getActiveUser().turnOnHouseAppliance(name);
        windowEnergySaver.turnOn(name);
    }

    private void powerOff(String name) {
        energySaver.getActiveUser().turnOffHouseAppliance(name);
        windowEnergySaver.turnOff(name);
    }

    private void disconect(String name) {
        energySaver.getActiveUser().disconnectHouseAppliance(name);
        windowEnergySaver.disconnect(name);
    }

    private void showHome() {
        windowEnergySaver.showHome(energySaver.getActiveUser());
    }

    private void enableEco() {
        energySaver.getActiveUser().enableEco();
        windowEnergySaver.enableEcoMode();
    }

    private void disableEco() {
        energySaver.getActiveUser().disableEco();
        windowEnergySaver.disableEcoMode();
    }

    private void singOut() {
        windowEnergySaver.singOut();
    }
}
