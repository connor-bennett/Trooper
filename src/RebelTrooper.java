public class RebelTrooper extends Trooper {
    private String name = "Rebel";
    private static int soldierCount = 0;

    public RebelTrooper(String unit, int number, String name) {
        super(unit, number);
        this.name = name;
        this.soldierCount = soldierCount + 1;
        trooperKind = "pilot";
        marchModifier = 0.75;
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
