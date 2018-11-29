/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marek
 */
public class InputFile {
    
    private File input;
    private GameOfLifeBoard board;

    public InputFile(GameOfLifeBoard board) {
        this.input = new File("src/game/input.txt");
        this.board=board;
        
    }
    public void load(){
        
        try {
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(" ");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                board.turnToLiving(x + 60, y + 60);
            }
            
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InputFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
