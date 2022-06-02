package com.szekalski.michal.mysnake;

import javafx.collections.FXCollections;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.ToDoubleBiFunction;

public class HighScore {

    public static HighScore instance = new HighScore();
    public static String fileName = "HighScore.txt";

    private List<Integer> highScoreList;
    private DateTimeFormatter dateTimeFormatter;

    private HighScore() {
        dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public static HighScore getInstance() {
        return instance;
    }

    public void saveHighScore (Set<HighScoreItem> scoreSet) throws IOException {
        Path path = Paths.get(fileName);
        BufferedWriter bufferedWriter = Files.newBufferedWriter(path);
        try {
            Iterator<HighScoreItem> iterator = scoreSet.iterator();
            while(iterator.hasNext()) {
                HighScoreItem hsi = iterator.next();
                bufferedWriter.write(String.format("%s\t%s", hsi.getScore(), hsi.getDate().toString()));
            }
        } finally {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }

        }


    }

}
