package com.softserve.edu.task3.figures;

import java.io.IOException;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * communicate with user to get the result
 * Created by cdc89 on 25.05.2017.
 */
public class TriangleProvider {
    private List<Triangle> triangles;
    private ConsoleReader consoleReader;
    private PrintStream out;

    public TriangleProvider(ConsoleReader consoleReader, PrintStream out) {
        this.consoleReader = consoleReader;
        this.out = out;
    }

    public List<Triangle> getTriangles() {
        return triangles;
    }

    private void closeReader() {
        if (consoleReader != null) {
            try {
                consoleReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * read data about triangles from console and than sort them
     */
    public void execute() {
        boolean end = false;
        triangles = new ArrayList<>();
        while (!end) {
            out.println("Insert info about triangle (format : name, "
                    + "side1, side2, side3)  " +
                    ":");
            Triangle triangle = getTriangle();
            triangles.add(triangle);
            end = isEnd();
        }
        printSortedList();
        closeReader();
    }

    private void printSortedList() {
        triangles.sort((firstTriangle, secondTriangle) -> Double.compare
                (secondTriangle
                        .getArea(), firstTriangle.getArea()));
        triangles.forEach(out::println);
    }

    private boolean isEnd() {
        out.println("Do you want to proceed ?");
        String input = consoleReader.readLine();
        if (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }

    private Triangle getTriangle() {
        final int NAME_INDEX = 0;
        final int FIRST_SIDE_INDEX = 1;
        final int SECOND_SIDE_INDEX = 2;
        final int THIRD_SIDE_INDEX = 3;

        //Scanner scanner = new Scanner(System.in);
        Triangle triangle;
        String input = consoleReader.readLine();
        String[] triangleData = input.split(",");
        String name = triangleData[NAME_INDEX].trim();
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale
                .ENGLISH);
        try {
            double side1 = numberFormat.parse(triangleData[FIRST_SIDE_INDEX]
                    .trim()).doubleValue
                    ();
            double side2 = numberFormat.parse(triangleData[SECOND_SIDE_INDEX]
                    .trim()).doubleValue();
            double side3 = numberFormat.parse(triangleData[THIRD_SIDE_INDEX]
                    .trim()).doubleValue();
            triangle = new Triangle(name, side1, side2, side3);
        } catch (ParseException | IllegalArgumentException e) {
            out.println("Inserted incorrect value! Please try again !");
            triangle = getTriangle();
        }
        return triangle;
    }
}
