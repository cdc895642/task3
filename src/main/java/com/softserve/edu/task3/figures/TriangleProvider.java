package com.softserve.edu.task3.figures;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

/**
 * communicate with user to get the result
 * Created by cdc89 on 25.05.2017.
 */
public class TriangleProvider {
    private List<Triangle> triangles;

    /**
     * read data about triangles from console and than sort them
     */
    public void execute() {
        boolean end = false;
        triangles =new ArrayList<>();
        while (!end) {
            System.out.println("Insert info about triangle (format : name, side1, side2, side3)  " +
                    ":");
            Triangle triangle = getTriangle();
            triangles.add(triangle);
            end = isEnd();
        }
        printSortedList();
    }

    private void printSortedList() {
        triangles.sort((firstTriangle,secondTriangle)->Double.compare(secondTriangle
                .getArea(),firstTriangle.getArea()));
        triangles.forEach(System.out::println);
    }

    private boolean isEnd() {
        System.out.println("Do you want to proceed ?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }

    private Triangle getTriangle() {
        final int NAME_INDEX=0;
        final int FIRST_SIDE_INDEX=1;
        final int SECOND_SIDE_INDEX=2;
        final int THIRD_SIDE_INDEX=3;

        Scanner scanner = new Scanner(System.in);
        Triangle triangle = null;
        String input = scanner.nextLine();
        String[] triangleData=input.split(",");
        String name=triangleData[NAME_INDEX].trim();
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.ENGLISH);
        try {
            double side1 = numberFormat.parse(triangleData[FIRST_SIDE_INDEX].trim()).doubleValue
                    ();
            double side2 = numberFormat.parse(triangleData[SECOND_SIDE_INDEX].trim()).doubleValue();
            double side3 = numberFormat.parse(triangleData[THIRD_SIDE_INDEX].trim()).doubleValue();
            triangle =new Triangle(name,side1,side2,side3);
        } catch (ParseException | IllegalArgumentException e) {
            System.out.println("Inserted incorrect value! Please try again !");
            triangle = getTriangle();
        }
        return triangle;
    }
}
