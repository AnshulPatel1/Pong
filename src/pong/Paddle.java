/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.*; 

/**
 *
 * @author 323632257
 */
public class Paddle {
    
    //instance variables
    private int length;
    private int width;
    private int x;
    private int y;
    private int velocityY;
    
    /**Creating a paddle object
     * 
     * @param x - x coordinate of the paddle
     * @param y - y coordinate of the paddle
     * @param length - length of the paddle
     * @param width - width of the paddle
     */
    public Paddle (int x, int y, int length, int width){
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
        this.velocityY = 0;
    }
    
    /** Imaginary rectangle to detect wall collision
     * 
     * @return - 2D Rectangle with x coordinate, y coordinate, length and width
     */
    public Rectangle2D getBoundryRectangle(){
        return new Rectangle2D.Double(getX(), getY(), getLength(), getWidth());
    }
    
    /**Imaginary rectangle on top of the paddle to detect ball collision
     * 
     * @return - 2D Rectangle with x coordinate, y coordinate, length and width
     */ 
    public Rectangle2D getTopBound(){
        return new Rectangle2D.Double(getX(), getY()-1, getLength(), 1);
    }
    /**Imaginary rectangle on bottom of the paddle to detect ball collision
     * 
     * @return - 2D Rectangle with x coordinate, y coordinate, length and width
     */ 
    public Rectangle2D getBottomBound(){
        return new Rectangle2D.Double(getX(), (getY()+getWidth()),getLength(),1);
    }
    /**Imaginary rectangle on right of the paddle to detect ball collision
     * 
     * @return - 2D Rectangle with x coordinate, y coordinate, length and width
     */ 
    public Rectangle2D getRightBound(){
        return new Rectangle2D.Double(getX()+getLength(), getY(), 1, getWidth());
    }
    
    /**How much to move the paddle in the y direction
     * 
     * @param yChange - the number of y pixel to move the paddle in y direction
     */
    public void change(int yChange){
        this.y += yChange;//changing the y value to move the paddle
    }
    
    //getters and setters
    public int getX(){
        return this.x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY() {
       return this.y;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getWidth(){
        return this.width;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public int getLength(){
        return this.length;
    }
    public void setLength(int length){
        this.length = length;
    }
    public int getVelocityY(){
        return this.velocityY;
    }
    public void setVelocityY(int velY){
        this.velocityY = velY;
    }
    
    /**to draw the paddle
     * 
     * @param g - allows to draw the paddle. Part of graphics class
     */
    public void paint(Graphics g){
        g.setColor(Color.green);
        g.fillRect(this.x, this.y, this.length, this.width);//drawing the rectangle
        g.setColor(Color.RED);
        g.fillRect(this.x, this.y, this.length, 1);
    }


}
