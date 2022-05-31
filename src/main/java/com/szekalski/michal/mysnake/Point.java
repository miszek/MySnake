package com.szekalski.michal.mysnake;

public class Point {
    private int posX;
    private int posY;

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Point(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public int hashCode() {
        return posX+posY;
    }

    @Override
    public boolean equals(Object obj) {
        Point point1 = (Point) obj;

        if (obj==null) {
            return false;
        }


        if(point1.getPosX()==posX && point1.getPosY()==posY) {
            return true;
        }
        return false;
    }
}
