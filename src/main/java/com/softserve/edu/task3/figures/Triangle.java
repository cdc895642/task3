package com.softserve.edu.task3.figures;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

/**
 * represent triangle
 * Created by cdc89 on 25.05.2017.
 */
public class Triangle {
    private final double side1;
    private final double side2;
    private final double side3;
    private double area;
    private String name;

    public Triangle(String name, double side1, double side2, double side3) {
        inputValidation(side1, side2, side3);
        this.name = name;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        setArea();
    }

    @Override
    public String toString() {
        return String.format("[%s]: %s cm", name, area);
    }

    private void inputValidation(double side1, double side2, double side3) {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalArgumentException("triangle sides incorrect");
        }
        if (side1 >= (side2 + side3)) {
            throw new IllegalArgumentException("triangle sides incorrect");
        }
        if (side2 >= (side1 + side3)) {
            throw new IllegalArgumentException("triangle sides incorrect");
        }
        if (side3 >= (side1 + side2)) {
            throw new IllegalArgumentException("triangle sides incorrect");
        }
    }

    private void setArea() {
        double p = (side1 + side2 + side3) / 2;
        area = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    /**
     * get triangle area
     *
     * @return triangle area
     */
    public double getArea() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Triangle)) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        double[] sides = new double[]{side1, side2, side3};
        double[] objectSides = new double[]{triangle.side1, triangle.side2,
                triangle.side3};
        Arrays.sort(sides);
        Arrays.sort(objectSides);
        final double DELTA = 0.000000001;
        for (int x = 0; x < sides.length; x++) {
            if (Math.abs(sides[x] - objectSides[x]) > DELTA) {
                return false;
            }
        }
        return Objects.equals(name, triangle.name);
    }

    @Override
    public int hashCode() {
        final int SCALE = 9;
        BigDecimal bdSide1 = BigDecimal.valueOf(side1).setScale(SCALE,
                BigDecimal
                        .ROUND_HALF_UP);
        BigDecimal bdSide2 = BigDecimal.valueOf(side2).setScale(SCALE,
                BigDecimal
                        .ROUND_HALF_UP);
        BigDecimal bdSide3 = BigDecimal.valueOf(side3).setScale(SCALE,
                BigDecimal
                        .ROUND_HALF_UP);
        return bdSide1.hashCode() + bdSide2.hashCode() + bdSide3.hashCode()
                + Objects.hash(name);
    }
}
