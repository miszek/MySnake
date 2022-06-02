package com.szekalski.michal.mysnake;

import java.time.LocalDate;
import java.util.Objects;

public class HighScoreItem {
    private Integer score;
    private LocalDate date;

    public HighScoreItem(Integer score, LocalDate date) {
        this.score = score;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HighScoreItem)) return false;
        HighScoreItem that = (HighScoreItem) o;
        return that.getScore()==score;
    }

    @Override
    public int hashCode() {
        return score;
    }

    public Integer getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "HighScoreItem{" +
                "score=" + score +
                ", date=" + date +
                '}';
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
