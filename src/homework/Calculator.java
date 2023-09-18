package homework;

public class Calculator {
    private double numberA;
    private double numberB;

    public Calculator() {
    }

    public Calculator(double numberA, double numberB) {
        this.numberA = numberA;
        this.numberB = numberB;
    }

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }

    public double add() {
        return numberA + numberB;
    }

    public double sub() {
        return numberA - numberB;
    }

    public double multi() {
        return numberA * numberB;
    }

    public double div() {
        return numberA/numberB;
    }
}