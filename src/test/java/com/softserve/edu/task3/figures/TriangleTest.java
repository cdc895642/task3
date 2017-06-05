package com.softserve.edu.task3.figures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdc89 on 04.06.2017.
 */
public class TriangleTest {
    @Test(expected = IllegalArgumentException.class)
    public void InputValidation_ZeroSide_ThrowException() {
        Triangle triangle=new Triangle("a",0.0,2,3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void InputValidation_NegativeSide_ThrowException() {
        Triangle triangle=new Triangle("a",1.2,2.3,-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void InputValidation_Side1TooBig_ThrowException() {
        Triangle triangle=new Triangle("a",12,2.3,1.2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void InputValidation_Side2TooBig_ThrowException() {
        Triangle triangle=new Triangle("a",1.2,23,1.2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void InputValidation_Side3TooBig_ThrowException() {
        Triangle triangle=new Triangle("a",1.2,2.3,12);
    }

    @Test
    public void Equals_EqualTriangles_ReturnTrue() {
        //Arrange
        Triangle first = new Triangle("a", 1.5, 1.2, 2.6);
        Triangle second = new Triangle("a", 2.6, 1.5, 1.2);

        //Act
        boolean equal = first.equals(second);

        //Assert
        assertTrue(equal);
    }

    @Test
    public void Equals_NotEqualTriangles_ReturnFalse() {
        //Arrange
        Triangle first = new Triangle("a", 1.51, 1.2, 2.6);
        Triangle second = new Triangle("a", 2.6, 1.5, 1.2);

        //Act
        boolean equal = first.equals(second);

        //Assert
        assertFalse(equal);
    }

    @Test
    public void HashCode_EqualTriangles_ReturnEqualInt() {
        //Arrange
        Triangle first = new Triangle("a", 1.5, 1.2, 2.6);
        Triangle second = new Triangle("a", 2.6, 1.5, 1.2);

        //Act
        int firstHash = first.hashCode();
        int secondHash = second.hashCode();

        //Assert
        assertEquals(firstHash, secondHash);
    }

    @Test
    public void GetArea_EqualTriangles_ReturnEqualArea() {
        //Arrange
        Triangle first = new Triangle("a", 1.5, 1.2, 2.6);
        Triangle second = new Triangle("b", 2.6, 1.5, 1.2);

        //Act
        double firstArea = first.getArea();
        double secondArea = second.getArea();

        //Assert
        assertEquals(firstArea, secondArea,0.000000001);
    }

    @Test
    public void GetArea_FirstTriangleBigger_FirstBiggerTrue() {
        //Arrange
        Triangle first = new Triangle("a", 1.51, 1.2, 2.6);
        Triangle second = new Triangle("b", 2.6, 1.5, 1.2);

        //Act
        double firstArea = first.getArea();
        double secondArea = second.getArea();

        //Assert
        assertTrue(firstArea>secondArea);
    }
}
