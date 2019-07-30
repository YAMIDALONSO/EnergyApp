package models;

import java.util.ArrayList;

public class EnergySaver {

    private ArrayList<User> users;
    private User activeUser;

    public EnergySaver() {
        this.users =  new ArrayList<>();
    }

    public EnergySaver(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User createUser(String name, String password, ArrayList<HouseApplianceConstant> electrodomestics) {
        return new User(name, password, electrodomestics);
    }

    public boolean isUserAndPasword(String user, String password) {
        boolean isUserAndPassword = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(user) && users.get(i).getPassword().equals(password)) {
                setActiveUser(users.get(i));
                isUserAndPassword = true;
            }
        }
        return isUserAndPassword;
    }
    
    public ArrayList<User> getUsers() {
        return users;
    }

    public User getActiveUser() {
        return activeUser;
    }

    private void setActiveUser(User ActiveUser) {
        this.activeUser = ActiveUser;
    }
}