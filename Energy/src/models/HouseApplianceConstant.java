package models;

public enum HouseApplianceConstant {
    TV("Televisor", 0, 1, 0, 200, "/data/Tv.png"), STEREO("Equipo de Sonido", 0, 0, 0, 200, "/data/Stereo.png"),
    VIDEOGAME_CONSOLE("Consola de videojuegos", 0, 2, 0, 240, "/data/VideoGame.png"), COMPUTER("Computador", 0, 2, 0, 160, "/data/Computer.png"),
    PHONE("Celular", 0, 0.4, 0, 160, "/data/CellPhone.png"), GRIDDLE("Plancha", 1, 0, 0, 200, "/data/Griddle.png"),
    VACUUM_CLEANER("Aspiradora", 0, 0, 0, 240, "/data/VacuumCleaner.png"), FAN("Ventilador", 0, 0, 0, 120, "/data/Fan.png"),
    STOVE("Estufa", 0, 0, 50, 20, "/data/Stove.png"), MICROWAVE("Microondas", 0, 0, 0, 210, "/data/Microwave.png"),
    FRIDGE("Refrigerador", 2, 0, 0, 400, "/data/Fridge.png"), DRYER("Secador", 0, 0, 0, 100, "/data/Dryer.png"),
    WASHING_MACHINE("Lavadora", 11, 0, 0, 400, "/data/WMachine.png"), DISHWASHER("Lavaplatos", 8, 0, 0, 200, "/data/DWasher.png"),
    BATHROOM_SHOWER("Ducha", 140, 0, 0, 1500, "/data/BShower.png"), BLENDER("Licuadora", 1.4, 0, 0, 340, "/data/Blender.png"),
    PRINTER("Impresora", 0, 0.2, 0, 160, "/data/Printer.png");

    private String name;
    private double whaterCost;
    private double internetCost;
    private int gasCost;
    private int electricityExpense;
    private String icon;

    private HouseApplianceConstant(String name, double whaterCost, double internetCost, int gasCost, int electricityExpense, String icon) {
        this.name = name;
        this.whaterCost = whaterCost;
        this.internetCost = internetCost;
        this.gasCost = gasCost;
        this.electricityExpense = electricityExpense;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public double getWhaterCost() {
        return whaterCost;
    }

    public double getInternetCost() {
        return internetCost;
    }

    public int getGasCost() {
        return gasCost;
    }

    public int getElectricityExpense() {
        return electricityExpense;
    }

    public String getIcon() {
        return icon;
    }
}
