public class Cat extends Display implements Action, Tick {
    private String name;
    private int nextAction;

    private int satiety;
    private int health;
    private int clean;
    private int fatigue;
    private int intimacy;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void initiate() {

    }
}
