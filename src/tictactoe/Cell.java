/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import static tictactoe.Cell.Figure.*;
import static tictactoe.Cell.Status.BARRIER;
import static tictactoe.Cell.Status.WINNER;

/**
 * @author Kapellan
 */
public class Cell {

    enum Figure {

        TIC, TAC, TIC_WON, TAC_WON, FREE;
    }

    enum Status {

        BARRIER, WINNER;
    }

    int X;
    int Y;
    Figure figure;
    Status status;
    String index;

    boolean isWinner() {
        return this.status == WINNER;

    }

    void setWinner() {
        this.status = WINNER;

    }

    boolean isBarrier() {
        return this.status == BARRIER;

    }

    void setBarrier() {
        this.status = BARRIER;

    }

    boolean isExist() {
        return this.figure == TIC || this.figure == TAC || this.figure == TIC_WON || this.figure == TAC_WON || this.figure == FREE;
    }

    boolean isFree() {
        return this.figure == FREE;
    }

    boolean isTic() {
        return this.figure == TIC;
    }

    void setTic() {
        this.figure = TIC;
    }

    boolean isTac() {
        return this.figure == TAC;
    }

    void setTac() {
        this.figure = TAC;
    }

    void setWinnerFigure() {
        if (this.figure == TIC) {
            this.figure = TIC_WON;
        }
        if (this.figure == TAC) {
            this.figure = TAC_WON;
        }
    }

    boolean isCorner() {
        return this.index.equals("00") || this.index.equals("02") || this.index.equals("22") || this.index.equals("20");
    }

    boolean isCenter() {
        return this.index.equals("11");
    }

    boolean isSide() {
        return this.index.equals("01") || this.index.equals("12") || this.index.equals("21") || this.index.equals("10");
    }

    Cell(int X, int Y, Figure figure, String index) {
        this.X = X;
        this.Y = Y;
        this.figure = figure;
        this.index = index;
    }

    Cell() {
    }
}
