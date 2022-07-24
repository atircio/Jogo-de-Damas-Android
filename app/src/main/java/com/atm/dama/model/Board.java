package com.atm.dama.model;

public class Board {
    int size = 8;
    public static boolean eatObri = false;
    private Piece[][] boardElements;
    public Piece[][] getBoardElements() {
        return boardElements;
    }
    public boolean topleft=false,toprigth=false,bottonleft=false,bottonrigth=false;



    public Board(){
        boardElements = new Piece[this.size][this.size];
        this.createBoard(size);
    }
    public void dama(){
        try {
            for (int i = 0; i < size; i++ ){
                if (getBoardElements()[0][i]!=null){
                    if (getBoardElements()[0][i].topo==false){
                        getBoardElements()[0][i].setDama(true);
                    }

                }if(getBoardElements()[7][i]!=null){
                    if (getBoardElements()[7][i].topo){
                        getBoardElements()[7][i].setDama(true);
                    }
                }
            }
        }catch (Exception e){
        }
    }
    public  String winner(){
        int l=0,r=0;
        String vencedor=null;
        for (int i = 0; i < getBoardElements().length; i++) {
            for (int j = 0; j < getBoardElements()[0].length; j++) {
                if(getBoardElements()[i][j] != null && getBoardElements()[i][j].topo){
                    l++;
                }else if(getBoardElements()[i][j] != null && getBoardElements()[i][j].topo==false){
                    r++;
                }
            }
        }

        if (l==0 && r>0){
            vencedor = "O VENCEDOR É: "+ Player.getNomePlayer2();
        }else if (r==0 && l>0){
            vencedor = "O VENCEDOR É: "+ Player.getNomePlayer1();
        }

        if (vencedor==null){
            return null;
        }else {
            return vencedor;
        }
    }
    public Board(int size){
        this.size = size;
        boardElements = new Piece[this.size][this.size];
        createBoard(size);
    }
    private void createBoard(int size) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i + j) % 2 == 0 && i < (size / 2) - 1) {
                    boardElements[i][j] = new Piece(i, j, true);
                }
                else if ((i + j) % 2 == 0 && i > (size / 2)) {
                    boardElements[i][j] = new Piece(i, j, false);
                }
                else {
                    boardElements[i][j] = null;
                }
            }
        }
    }
    public boolean eatPiece(int startRow, int endRow, int startCol, int endCol, boolean topo) {

            if (topo) {
                if (((startRow == endRow - 2) && (startCol == endCol - 2)) ) {
                    if (boardElements[endRow - 1][endCol - 1] != null){
                        boardElements[endRow - 1][endCol - 1] = null;
                        return true;
                    }else {
                        return false;
                    }


                } else if (((startRow == endRow - 2) && (startCol == endCol + 2))){
                    if (boardElements[endRow - 1][endCol + 1] != null){
                        boardElements[endRow - 1][endCol + 1] = null;
                        return true;
                    }else{
                        return false;
                    }

                }
                else {
                    return false;
                }
            } else if (topo == false) {
                if (((startRow == endRow + 2) && (startCol == endCol + 2)) ) {
                    if (boardElements[endRow + 1][endCol + 1] != null){
                        boardElements[endRow + 1][endCol + 1] = null;
                        return true;
                    }else {
                        return false;
                    }

                } else if (((startRow == endRow + 2) && (startCol == endCol - 2))){
                    if (boardElements[endRow + 1][endCol - 1] != null){
                        boardElements[endRow + 1][endCol - 1] = null;
                        return true;
                    }else{
                        return false;
                    }
                }
                else {
                    return false;
                }
            }else {
                return  false;
            }

    }
    public boolean eatPieceDama(int startRow, int endRow, int startCol, int endCol) {
        if (this.getBoardElements()[startRow][startCol].isDama()){
            if (((startRow == endRow-(endRow-startRow)) &&  (startCol == endCol-(endCol-startCol)))) {
                int j=startCol+1;
                for (int i=startRow+1; i < endRow; i++){

                    if (getBoardElements()[i][j]!=null && getBoardElements()[i+1][j+1]==null){
                        boardElements[i][j] = null;
                        return true;
                    }
                    j++;

                }
                int a=startCol-1;
                for (int i=startRow-1; i > endRow; i--){
                    if (getBoardElements()[i][a]!=null && getBoardElements()[i-1][a-1]==null){
                        boardElements[i][a] = null;
                        return true;
                    }
                    a--;
                }

                /*if (boardElements[endRow - 1][endCol - 1] != null){
                    boardElements[endRow - 1][endCol - 1] = null;
                    return true;
                }else {
                    return false;
                }*/
            }else if(((startRow == endRow-(endRow-startCol)) &&  (startCol == endCol-(endCol+startCol)))){
                int j=startCol+1;
                for (int i=startRow+1; i < endRow; i++){

                    if (getBoardElements()[i][j]!=null && getBoardElements()[i+1][j+1]==null){
                        boardElements[i][j] = null;
                        return true;
                    }
                    j++;

                }
                int a=startCol-1;
                for (int i=startRow-1; i > endRow; i--){
                    if (getBoardElements()[i][a]!=null && getBoardElements()[i-1][a-1]==null){
                        boardElements[i][a] = null;
                        return true;
                    }
                    a--;
                }
            }


            /*else if ((startRow == endRow-(endRow-startCol)) &&  (startCol == endCol-(endCol+startCol))){
                if (boardElements[endRow - 1][endCol + 1] != null){
                    boardElements[endRow - 1][endCol + 1] = null;
                    return true;
                }else{
                    return false;
                }

            } /*else if (((startRow == endRow-(endRow-startRow)) &&  (startCol == endCol-(endCol-startCol)))) {
                if (boardElements[endRow + 1][endCol + 1] != null){
                    boardElements[endRow + 1][endCol + 1] = null;
                    return true;
                }else {
                    return false;
                }

                } else if (((startRow == endRow-(endRow-startCol)) &&  (startCol == endCol-(endCol+startCol)))){
                    if (boardElements[endRow + 1][endCol - 1] != null){
                        boardElements[endRow + 1][endCol - 1] = null;
                        return true;
                    }else{
                        return false;
                    }
                } */else {
                return false;
            }

        }

        return true;
    }
    public Boolean ContainEnemy(boolean topo){
        boolean result=false;
        for (int i = 0; i < this.getBoardElements().length; i++) {
            for (int j = 0; j < this.getBoardElements()[0].length; j++) {
                if ((getBoardElements()[i][j] != null && getBoardElements()[i][j].topo)){
                    if (getBoardElements()[i+1][j+1] != null & getBoardElements()[i+1][j+1].topo==false){
                        result= true;
                    }
                    result= true;
                }
            }
        }

        return result;
    }
    public void damaMove(int startRow, int endRow, int startCol, int endCol){
        if (eatPieceDama(startRow, endRow, startCol, endCol)){

        }
            if (((startRow == endRow-(endRow-startRow)) &&  (startCol == endCol-(endCol-startCol))) || ((startRow == endRow-(endRow-startCol)) &&  (startCol == endCol-(endCol+startCol))) ){
                Piece p = boardElements[startRow][startCol];
                p.setX(endRow);
                p.setY(endCol);
                boardElements[startRow][startCol] = null;
                boardElements[endRow][endCol] = p;
                Piece.topoTurn=!Piece.topoTurn;
            }else  if(this.eatPiece(startRow,endRow,startCol,endCol,this.getBoardElements()[startRow][startCol].topo)){
                Piece p = boardElements[startRow][startCol];
                p.setX(endRow);
                p.setY(endCol);
                boardElements[startRow][startCol] = null;
                boardElements[endRow][endCol] = p;
                Piece.topoTurn=!Piece.topoTurn;
            }else if (((startRow == endRow-(endRow-startRow)) &&  (startCol == endCol-(endCol-startCol))) || ((startRow == endRow-(endRow-startRow)) &&  (startCol == endCol-(endCol+startCol))) ){
                Piece p = boardElements[startRow][startCol];
                p.setX(endRow);
                p.setY(endCol);
                boardElements[startRow][startCol] = null;
                boardElements[endRow][endCol] = p;
                Piece.topoTurn=!Piece.topoTurn;
            }else  if(this.eatPiece(startRow,endRow,startCol,endCol,this.getBoardElements()[startRow][startCol].topo)) {
                Piece p = boardElements[startRow][startCol];
                p.setX(endRow);
                p.setY(endCol);
                boardElements[startRow][startCol] = null;
                boardElements[endRow][endCol] = p;
                Piece.topoTurn = !Piece.topoTurn;
            }


    }
    public void move(Move m){
        if(this.getBoardElements()[m.startRow][m.startCol] != null){
            if (this.getBoardElements()[m.endRow][m.endCol] == null){
                if (Piece.topoTurn){
                    if (this.getBoardElements()[m.startRow][m.startCol].topo){
                        if (this.getBoardElements()[m.startRow][m.startCol].isDama()){
                            this.damaMove(m.startRow, m.endRow, m.startCol, m.endCol);
                            return;
                        }
                        if (((m.startRow == m.endRow-1) &&  (m.startCol == m.endCol-1)) || ((m.startRow == m.endRow-1) &&  (m.startCol == m.endCol+1)) ){
                            Piece p = boardElements[m.startRow][m.startCol];
                            p.setX(m.endRow);
                            p.setY(m.endCol);
                            boardElements[m.startRow][m.startCol] = null;
                            boardElements[m.endRow][m.endCol] = p;
                            Piece.topoTurn=false;
                        }else  if(this.eatPiece(m.startRow,m.endRow,m.startCol,m.endCol,this.getBoardElements()[m.startRow][m.startCol].topo)){
                            Piece p = boardElements[m.startRow][m.startCol];
                            p.setX(m.endRow);
                            p.setY(m.endCol);
                            boardElements[m.startRow][m.startCol] = null;
                            boardElements[m.endRow][m.endCol] = p;
                            Piece.topoTurn=false;
                        }
                    }
                }else{
                    if (this.getBoardElements()[m.startRow][m.startCol].topo==false){
                        if (this.getBoardElements()[m.startRow][m.startCol].isDama()){
                            this.damaMove(m.startRow, m.endRow, m.startCol, m.endCol);
                            return;
                        }
                        if (this.getBoardElements()[m.startRow][m.startCol].isDama()){
                            this.damaMove(m.startRow, m.endRow, m.startCol, m.endCol);
                            return;
                        }
                        if (((m.startRow == m.endRow+1) &&  (m.startCol == m.endCol+1)) || ((m.startRow == m.endRow+1) &&  (m.startCol == m.endCol-1)) ){
                            Piece p = boardElements[m.startRow][m.startCol];
                            p.setX(m.endRow);
                            p.setY(m.endCol);
                            boardElements[m.startRow][m.startCol] = null;
                            boardElements[m.endRow][m.endCol] = p;
                            Piece.topoTurn=true;
                        }else  if(this.eatPiece(m.startRow,m.endRow,m.startCol,m.endCol,this.getBoardElements()[m.startRow][m.startCol].topo)) {
                            Piece p = boardElements[m.startRow][m.startCol];
                            p.setX(m.endRow);
                            p.setY(m.endCol);
                            boardElements[m.startRow][m.startCol] = null;
                            boardElements[m.endRow][m.endCol] = p;
                            Piece.topoTurn = true;
                        }
                    }
                }

            }
        }
    }

    public void canGo(int startRow, int startCol){
        topleft=true;toprigth=true;bottonleft=true;bottonrigth=true;
        if (this.getBoardElements()[startRow][startCol] != null && this.getBoardElements()[startRow][startCol].topo){

            try {
                /*if (getBoardElements()[startRow-1][startCol-1] != null){
                    topleft=true;
                }
                if (getBoardElements()[startRow-1][startCol+1] != null){
                    toprigth=true;
                }*/
                if (getBoardElements()[startRow+1][startCol+1] != null){
                    bottonrigth=false;
                }
                if (getBoardElements()[startRow+1][startCol-1] != null){
                    bottonleft=false;
                }
            }catch (Exception e){

            }

        }
        else if (this.getBoardElements()[startRow][startCol] != null && this.getBoardElements()[startRow][startCol].topo==false){

            try {
                if (getBoardElements()[startRow-1][startCol-1] != null){
                    topleft=false;
                }
                if (getBoardElements()[startRow-1][startCol+1] != null){
                    toprigth=false;
                }

            }catch (Exception e){

            }

        }

    }


}
