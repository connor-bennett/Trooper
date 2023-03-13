import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public abstract class Trooper {
    private static String unit;
    private int number;
    protected String trooperKind;
    protected double trooperMarch;
    protected double marchSpeed;
    protected double marchModifier;

    protected Trooper() {
        this("AA", 0);
    }

    public Trooper(String unit, int number) {
        this.unit = unit;
        this.number = number;
        marchSpeed = 5;
    }

    public static void addToUnit(HashMap<String, List<Trooper>> units, Trooper t) {
        String unit = t.getUnit();

        if (t == null) {
            return;
        }
        if (units.containsKey(unit)) {
            units.get(unit).add(t);
        }else{
            List<Trooper> troopers = new ArrayList<>();
            troopers.add(t);
            units.put(unit, troopers);
        }


    }

    public boolean attack(Trooper target, int roll) {
//        StormTrooper Section
        if (target.equals(this) || roll == 1) {
            System.out.println(this.toString() + " Is targeting itself ");
            System.out.println(this.toString() + "rolled a " + roll + " and hurt itself in the confusion");
            return true;
        }
        if (this instanceof StormTrooper) {
            if (target instanceof RebelTrooper) {
                System.out.println("rolled a " + roll + " against the rebel scum");
                return (roll > 10 && (roll % 2) == 0);
            }
            if (target instanceof StormTrooper) {
                System.out.println("No treason in the ranks!");
                return false;
            } else {
                System.out.println("Acceptable collateral damage!");
                return (roll > 10 || (roll % 2) == 0);
            }
        }

//        RebelTrooper Section
        if (this instanceof RebelTrooper) {
            if (target instanceof RebelTrooper) {
                System.out.println("Imperial Spy!");
                return false;
            }
            if (target instanceof StormTrooper) {
                System.out.println("rolled a " + roll + " against the imperial scum");
                return roll > 5 || (roll % 2) > 0;
            } else {
                System.out.println("Rebels target an innocent bystander");
                return (roll >= 18 && (roll % 2) == 0);
            }
        }
        else{
            return false;
        }
    }
//    Abstract method no body in main class
    public abstract double march(double duration);

    @Override
    public String toString() {
        return getUnit() + getNumber() +": ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trooper trooper)) return false;
        return getNumber() == trooper.getNumber() && Double.compare(trooper.getTrooperMarch(), getTrooperMarch()) == 0 && Double.compare(trooper.getMarchSpeed(), getMarchSpeed()) == 0 && getUnit().equals(trooper.getUnit()) && getTrooperKind().equals(trooper.getTrooperKind());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUnit(), getNumber(), getTrooperKind(), getTrooperMarch(), getMarchSpeed());
    }

    public static String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTrooperKind() {
        return trooperKind;
    }

    public void setTrooperKind(String trooperKind) {
        this.trooperKind = trooperKind;
    }

    public double getTrooperMarch() {
        return trooperMarch;
    }

    public void setTrooperMarch(double trooperMarch) {
        this.trooperMarch = trooperMarch;
    }

    public double getMarchSpeed() {
        return marchSpeed;
    }

    public void setMarchSpeed(double marchSpeed) {
        this.marchSpeed = marchSpeed;
    }

    public static void main(String[] args){
        HashMap<String, List<Trooper>> units = new HashMap<>();
        RebelTrooper luke = new RebelTrooper("Blue", 5, "Luke");
        StormTrooper finn = new StormTrooper("jooo", 2187);
        RebelTrooper mark = new RebelTrooper("Blue", 5, "Mark");
        RebelTrooper joe = new RebelTrooper("FN", 4, "Joe");

        System.out.println("luke" + luke.getUnit());
        System.out.println("finn" + finn.getUnit());

        luke.addToUnit(units, luke);
        finn.addToUnit(units, finn);
        mark.addToUnit(units, mark);
        joe.addToUnit(units, joe);
        System.out.println(units);

    }
}
