package game;

import gameoflife.Simulator;

public class Main {

    public static void main(String[] args) {
        PersonalBoard board = new PersonalBoard(180, 180);
        //board.initiateRandomCells(0.09);
        for(int i =0;i<180;i++){
            board.turnToLiving(i, 90);
        }
        //board.turnToLiving(90, 90);
        //InputFile file = new InputFile(board);
        //file.load();


        Simulator simulator = new Simulator(board);
        simulator.simulate();
    }
}
