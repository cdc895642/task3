package com.softserve.edu.task3;

import com.softserve.edu.task3.figures.TriangleProvider;

import java.text.ParseException;

/**
 * entry point
 */
public class App 
{
    public static void main( String[] args ) throws ParseException {
        TriangleProvider triangleProvider=new TriangleProvider();
        triangleProvider.execute();
    }
}
