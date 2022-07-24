package com.atm.dama.model;

public class Move {

    int startRow;

    public int getStartRow() {
        return startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public int getEndRow() {
        return endRow;
    }

    public int getEndCol() {
        return endCol;
    }

    int startCol;
    int endRow;
    int endCol;

    public Move(String startPos, String endPos) {
        this.startRow = Integer.parseInt(startPos.substring(0,1));
        this.startCol =  Integer.parseInt(startPos.substring(2,3));
        this.endRow =  Integer.parseInt(endPos.substring(0,1));
        this.endCol =  Integer.parseInt(endPos.substring(2,3));


    }
}
