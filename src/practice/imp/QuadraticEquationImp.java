package practice.imp;

import practice.entity.QuadraticEquation;

import java.util.Scanner;

public class QuadraticEquationImp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuadraticEquation equation = new QuadraticEquation();
        equation.inputData(scanner);
        equation.getDiscriminant();
    }
}
