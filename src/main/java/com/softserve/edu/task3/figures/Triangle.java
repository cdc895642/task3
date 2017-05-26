package com.softserve.edu.task3.figures;

/**
 * represent triangle
 * Created by cdc89 on 25.05.2017.
 */
public class Triangle
{
    private double side1;
    private double side2;
    private double side3;
    private double area;
    private String name;

    public Triangle(String name, double side1, double side2, double side3){
        inputValidation(side1,side2,side3);
        this.name=name;
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
        setArea();
    }

    @Override
    public String toString(){
        return String.format("[%s]: %s cm",name,area);
    }

    private void inputValidation(double side1, double side2, double side3){
        if (side1<=0 || side2<=0 || side3 <=0){
            throw new IllegalArgumentException("triangle sides incorrect");
        }
        if (side1 >=(side2 + side3)){
            throw new IllegalArgumentException("triangle sides incorrect");
        }
        if (side2 >=(side1 + side3)){
            throw new IllegalArgumentException("triangle sides incorrect");
        }
        if (side3 >=(side1 + side2)){
            throw new IllegalArgumentException("triangle sides incorrect");
        }
    }

    private void setArea(){
        double p=(side1+side2+side3)/2;
        area=Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }

    /**
     * get triangle area
     * @return triangle area
     */
    public double getArea(){
        return area;
    }
}
