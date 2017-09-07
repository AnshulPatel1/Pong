/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong;
import java.awt.*;
import java.awt.geom.Rectangle2D;
/**
 *
 * @author 323632257
 */
public class Ball {
    //instance variables
    private int width, height;
    private int x, y;
    private int velocityX, velocityY;
    /**Creating a ball Object
     * 
     * @param x - the x coordinates of the ball
     * @param y - the y coordinates of the ball
     * @param width - the width of the ball
     * @param height - the height of the ball
     */
    public Ball (int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.velocityY = -10;
        this.velocityX = -10;
        this.width = width;
        this.height = height;
    }
    /**Creating an imaginary rectangle around the ball for collision detection
     * 
     * @return a 2D rectangle with x coordinate, y coordinate, its height and width
     */ 
    public Rectangle2D getBoundaryRectangle(){
       return new Rectangle2D.Double(getX(), getY(), getHeight(), getWidth());
    }
    /** to flip x velocity of the ball when it hits the paddle
     * 
     */
    public void flipVelocityX(){
        int newVelocityX = getVelocityX()*-1;//flip the X direction
        setVelocityX(newVelocityX);
    }
    /** to flip y velocity when the ball hits the top and bottom wall
     * 
     */
    public void flipVelocityY(){
        int newVelocityY = getVelocityY()*-1;//flips the Y directions
        setVelocityY(newVelocityY);
    }
    //getters and setters
    public int getX(){
        return this.x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
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
    public int getHeight(){
        return this.height;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getVelocityX(){
        return this.velocityX;
    }
    public void setVelocityX(int velX){
        this.velocityX = velX;
    }
    public int getVelocityY(){
        return this.velocityY;
    }
    public void setVelocityY(int velY){
        this.velocityY = velY;
    }
    /** drawing the ball
     * 
     * @param g - allows to draw the ball
     */
    public void paint(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillOval(this.x, this.y, this.width, this.height);//drawing the oval
     
    }
    /** setting the velocity of the ball when the game starts
     * 
     */
    public void ballMovement(){
        this.setX(this.getX()+this.getVelocityX());
        this.setY(this.getY()+this.getVelocityY());
    }
}