package com.softserve.edu.task3.figures;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by cdc89 on 04.06.2017.
 */
public class TriangleProviderTest {
    @Test
    public void IsEnd_ProceedOneTimes_Return() {
        //Arrange
        final int EXPECTED_TIMES = 4;
        ConsoleReader reader = mock(ConsoleReader.class);
        when(reader.readLine()).thenReturn("a,2,3,4", "y", "b,3,4,5", "n");
        TriangleProvider triangleProvider = new TriangleProvider(reader,
                System.out);

        //Act
        triangleProvider.execute();

        //Assert
        verify(reader, times(EXPECTED_TIMES)).readLine();
    }

    @Test
    public void IsEnd_NoProceed_Return() {
        //Arrange
        final int EXPECTED_TIMES = 2;
        ConsoleReader reader = mock(ConsoleReader.class);
        when(reader.readLine()).thenReturn("b,3,4,5", "n");
        TriangleProvider triangleProvider = new TriangleProvider(reader,
                System.out);

        //Act
        triangleProvider.execute();

        //Assert
        verify(reader, times(EXPECTED_TIMES)).readLine();
    }

    @Test
    public void Execute_FirstSmaller_SortDescending() {
        //Arrange
        String firstTriangleStr = "a,2,3,4.0";
        Triangle firstTriangle = new Triangle("a", 2, 3, 4.0);
        String secondTriangleStr = "b,3.0,4,5.0";
        Triangle secondTriangle = new Triangle("b", 3.0, 4, 5.0);
        List<Triangle> expected = new ArrayList<>();
        expected.add(firstTriangle);
        expected.add(secondTriangle);
        expected.sort((x, y) -> Double.compare(y.getArea(), x.getArea()));
        ConsoleReader reader = mock(ConsoleReader.class);
        when(reader.readLine()).thenReturn(firstTriangleStr, "y",
                secondTriangleStr, "n");
        TriangleProvider triangleProvider = new TriangleProvider(reader,
                System.out);

        //Act
        triangleProvider.execute();
        List<Triangle> result = triangleProvider.getTriangles();

        //Assert
        assertEquals(expected, result);
    }

    @Test
    public void Execute_FirstBigger_SortDescending() {
        //Arrange
        String firstTriangleStr = "b,3.0,4,5.0";
        Triangle firstTriangle = new Triangle("b", 3.0, 4, 5.0);
        String secondTriangleStr = "a,2,3,4.0";
        Triangle secondTriangle = new Triangle("a", 2, 3, 4.0);
        List<Triangle> expected = new ArrayList<>();
        expected.add(firstTriangle);
        expected.add(secondTriangle);
        expected.sort((x, y) -> Double.compare(y.getArea(), x.getArea()));
        ConsoleReader reader = mock(ConsoleReader.class);
        when(reader.readLine()).thenReturn(firstTriangleStr, "y",
                secondTriangleStr, "n");
        TriangleProvider triangleProvider = new TriangleProvider(reader,
                System.out);

        //Act
        triangleProvider.execute();
        List<Triangle> result = triangleProvider.getTriangles();

        //Assert
        assertEquals(expected, result);
    }

    @Test
    public void Execute_EqualArea_SortDescending() {
        //Arrange
        String firstTriangleStr = "b,3.0,4,5.0";
        Triangle firstTriangle = new Triangle("b", 3.0, 4, 5.0);
        String secondTriangleStr = "a,2,3,4.0";
        Triangle secondTriangle = new Triangle("a", 2, 3, 4.0);
        String thirdTriangleStr = "c,3.0,4,5.0";
        Triangle thirdTriangle = new Triangle("c", 3.0, 4, 5.0);
        List<Triangle> expected = new ArrayList<>();
        expected.add(firstTriangle);
        expected.add(secondTriangle);
        expected.add(thirdTriangle);
        expected.sort((x, y) -> Double.compare(y.getArea(), x.getArea()));
        ConsoleReader reader = mock(ConsoleReader.class);
        when(reader.readLine()).thenReturn(firstTriangleStr, "y",
                secondTriangleStr, "y", thirdTriangleStr, "n");
        TriangleProvider triangleProvider = new TriangleProvider(reader,
                System.out);

        //Act
        triangleProvider.execute();
        List<Triangle> result = triangleProvider.getTriangles();

        //Assert
        assertEquals(expected, result);
    }
}
