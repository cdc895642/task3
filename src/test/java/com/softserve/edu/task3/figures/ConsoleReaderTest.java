package com.softserve.edu.task3.figures;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by cdc89 on 05.06.2017.
 */
public class ConsoleReaderTest {
    @Test
    public void ReadLine_InputString_ReturnString() throws IOException {
        //Arrange
        final String EXPECTED = "INPUT";
        ConsoleReader reader = new ConsoleReader();
        BufferedReader in = mock(BufferedReader.class);
        reader.setReader(in);
        when(in.readLine()).thenReturn("INPUT");

        //Act
        String result = reader.readLine();

        //Assert
        assertEquals(EXPECTED, result);
        reader.close();
    }

    @Test
    public void Close_ConstructorByDefaultCloseTwoTimes_NoExceptions() throws
            IOException {
        //Arrange
        ConsoleReader reader = new ConsoleReader();

        //Act
        reader.close();
        reader.close();
    }

    @Test
    public void Close_ConstructorWithParamsCloseTwoTimes_NoExceptions() throws
            IOException {
        //Arrange
        ConsoleReader reader1 = new ConsoleReader(System.in);

        //Act
        reader1.close();
        reader1.close();
    }

    @Test
    public void Close_SetReaderCloseTwoTimes_NoExceptions() throws
            IOException {
        //Arrange
        ConsoleReader reader2 = new ConsoleReader();
        BufferedReader in = mock(BufferedReader.class);
        reader2.setReader(new BufferedReader(in));

        //Act
        reader2.close();
        reader2.close();
    }
}
