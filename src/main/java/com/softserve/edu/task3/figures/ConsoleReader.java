package com.softserve.edu.task3.figures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by cdc89 on 03.06.2017.
 * use for input data from user
 */
public class ConsoleReader {
    private BufferedReader reader;

    /**
     * set stream for user input
     *
     * @param in stream for user input
     */
    public ConsoleReader(InputStream in) {
        reader = new BufferedReader(new InputStreamReader(in));
    }

    public ConsoleReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    /**
     * close opened reader
     *
     * @throws IOException
     */
    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }

    /**
     * read string from user
     *
     * @return string from user
     */
    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
