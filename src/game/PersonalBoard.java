/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Marek
 */
public class PersonalBoard extends GameOfLifeBoard{
    
        public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double d) {
        Random random = new Random();
        int x = this.getWidth();
        int y = this.getHeight();
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(random.nextDouble()<d){
                    this.turnToLiving(i, j);
                }
            }
        }
    }

    @Override
    public boolean isAlive(int i, int i1) {
        if(i<0 || i1<0){
            return false;
        }
        if(i< this.getWidth() && i1<this.getHeight()){
            return getBoard()[i][i1];
        }
        return false;
    }

    @Override
    public void turnToLiving(int i, int i1) {
        if(i<0 || i1<0){
            return;
        }
        if(i<= this.getWidth() && i1<=this.getHeight()){
            getBoard()[i][i1] = true;
        }
        
    }

    @Override
    public void turnToDead(int i, int i1) {
        if(i<0 || i1<0){
            return;
        }
        if(i<= this.getWidth() && i1<=this.getHeight()){
            getBoard()[i][i1] = false;
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int i, int i1) {
        
        boolean first = isAlive(i-1, i1-1);
        boolean second = isAlive(i-1, i1);
        boolean third = isAlive(i-1, i1+1);
        boolean fourth = isAlive(i, i1-1);
        boolean fifth = isAlive(i, i1+1);
        boolean six = isAlive(i+1, i1-1);
        boolean seven = isAlive(i+1, i1);
        boolean eight = isAlive(i+1, i1+1);
        
        ArrayList<Boolean> list = new ArrayList<Boolean>();
        
        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);
        list.add(fifth);
        list.add(six);
        list.add(seven);
        list.add(eight);
        
        int counter = 0;
        for(Boolean bool : list){
            if(bool==true){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public void manageCell(int i, int i1, int i2) {
        if(i2<2){
            this.turnToDead(i, i1);
        }else if(i2==2){
            if(this.getBoard()[i][i1]==true){
                this.turnToLiving(i, i1);
            }else{
                this.turnToDead(i, i1);
            }
        }else if(i2==3){
            this.turnToLiving(i, i1);
        }else{
            this.turnToDead(i, i1);

        }
    }
    
}
