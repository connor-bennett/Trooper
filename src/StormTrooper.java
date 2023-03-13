public class StormTrooper extends Trooper {
    private String name = "";
    private static int soldierCount = 0;

    public StormTrooper(String unit, int number) {
        super(unit, number);
        this.name = name;
        soldierCount = soldierCount + 1;
        trooperKind = "StormTrooper";
        marchModifier = 1.10;
    }

    public String toString(){
        return getName() + "(" + super.toString() + getTrooperKind();
    }

    @Override
    public double march(double duration){
        return marchSpeed * duration * marchModifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getSoldierCount() {
        return soldierCount;
    }

    public void setSoldierCount(int soldierCount) {
        this.soldierCount = soldierCount;
    }
}
