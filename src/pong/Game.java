/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.awt.Graphics;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.awt.geom.*;
import java.text.AttributedString;
import java.util.Random;
import javax.swing.*;
import java.io.*;
/**
 *
 * @author 323632257
 */
public class Game {
    //creating humanpaddle, computerpaddle, ball and background
    Rectangle2D backGround = new Rectangle(0,0, X_MAX, Y_MAX);
    Paddle humanPaddle = new Paddle(14,140,7,90);
    Paddle computerPaddle = new Paddle (573, 140, 7, 90);
    Ball ball = new Ball(300,170,14,14);
    public static final int X_MAX = 600;
    public static final int Y_MAX = 400;
    private int humanScore = 0;
    private int computerScore = 0;
    /**Creating a game object
     * 
     */    
    public Game(){
       
    }
    
    /**calling the ball movement method from ball class
     * 
     */
    public void ballUpdate(){
        ball.ballMovement();//calling the ballmovement method from ball class
    }
    
    /**Checking for ball collision and flipping the velocity of the ball when collision is detected
     * 
     */
    public void ballCollision(){
        if(ball.getY() <= 0){
            ball.flipVelocityY();//flipping the balls y direction when it hits top wall
        }
        else if(ball.getY() >= 362){
            ball.flipVelocityY();//flippinf the balls y direction when it hits the bottom wall
        }
    }
    
    /**Checking for an paddle collision with the wall and ball
     * 
     */
    public void paddleCollision(){

        if(ball.getBoundaryRectangle().intersects(humanPaddle.getBoundryRectangle())){//flipping direction when it hits the paddle
            ball.flipVelocityX();
        }
        else if(ball.getBoundaryRectangle().intersects(computerPaddle.getBoundryRectangle())){//flipping the x direction when hiting the computer paddle
            ball.flipVelocityX();
        }
        if(ball.getBoundaryRectangle().intersects(humanPaddle.getTopBound())){//flipping the Y direction when hitting the human paddle at the top
            ball.flipVelocityY();
        }
        if(ball.getBoundaryRectangle().intersects(humanPaddle.getBottomBound())){//flipping the Y direction when hitting the human paddle at the bottom
            ball.flipVelocityY();
        }
       
    }
    
    /**Setting the movement for the computer paddle
     * 
     */
    public void computerPaddleMovement(){
        double ballVelocityY = ball.getVelocityY();
        if (ballVelocityY > 0){//moving the computer paddle up if the ball velocity is greater than 0
            computerPaddle.change(4);
        } else if (ballVelocityY < 0){//moving the computer paddle down if the ball velocity is less than 0
            computerPaddle.change(-4);
        }
         if(computerPaddle.getY() <= 0){//top wall collision
            computerPaddle.setY(0);
        }
        else if(computerPaddle.getY() >= 290){//bottom wall collision
            computerPaddle.setY(290);
        }
    }
    
    /**When the human or computer score, the ball resets
     * 
     */
    public void ballReset(){
        if ((ball.getX() <= 0) || (ball.getX() >= 600)){//reseting the ball after a score
            ball.setX(300);
            ball.setY(170);
            ball.setVelocityX(-7);
            ball.setVelocityY(-7);
        }
        if(humanScore == 7 || computerScore == 7){//stoping the game when someone wins
            ball.setVelocityX(0);
            ball.setVelocityY(0);
        }
    }
    
    /**Keeping the score between the human and computer
     * 
     */
    public void gameScore(){//tracking the score 
        if (ball.getX() <= 10){
            this.computerScore++;
            paddleReset();//reseting the paddle position when some one score
        } else if (ball.getX() >= 590){
            this.humanScore++;
            paddleReset();
        }
    }
    
    /**Reseting the position of the paddle when either opponent score
     * 
     */
    public void paddleReset(){
        humanPaddle.setY(140);//reseting the paddle position
        computerPaddle.setY(140);
    }
    
    /**drawing the score of both opponents on the game screen
     * 
     * @param g - ability to draw the score on the screen. Calls the graphics class
     */
    public void drawScore(Graphics g){//drawing the score on the screen 
        g.setColor(Color.red);
        Font courier = new Font("TimesNewRoman", Font.BOLD, 25);//type of font and size
        AttributedString computerScoreDisplay = new AttributedString(" " + this.computerScore);
        AttributedString humanScoreDisplay = new AttributedString(" " + this.humanScore);
        computerScoreDisplay.addAttribute(TextAttribute.FONT, courier);//setting the font to the string
        humanScoreDisplay.addAttribute(TextAttribute.FONT, courier);
        g.drawString(computerScoreDisplay.getIterator(),450, 30);//position of the string
        g.drawString(humanScoreDisplay.getIterator(),150, 30);
    }
    
    /**if human wins, it tell the human that he won
     * 
     * @param g - ability to draw "YOU WIN", calls the graphics class
     */
    public void winScreen(Graphics g){
        g.setColor(Color.WHITE);
        Font courier = new Font("Courier", Font.BOLD, 30);
        AttributedString humanWin = new AttributedString("YOU WIN!");
        humanWin.addAttribute(TextAttribute.FONT, courier);
        g.drawString(humanWin.getIterator(), 220, 300);
    }
    
    /**Called when the human loses to the computer
     * 
     * @param g - ability to draw "YOU LOSE". Calls the graphics class 
     */
    public void loseScreen(Graphics g){
        g.setColor(Color.WHITE);
        Font courier = new Font("Courier", Font.BOLD, 30);
        AttributedString humanWin = new AttributedString("YOU LOSE!");
        humanWin.addAttribute(TextAttribute.FONT, courier);
        g.drawString(humanWin.getIterator(), 220, 300);
    }
    
    /**Draws the paddle and ball in the game screen
     * 
     * @param g - lets us draw the paddle, ball, score and win or lose screen on the game screen.
     */
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, X_MAX, Y_MAX);
        drawScore(g); 
        if(humanScore == 7){
            winScreen(g);//draw the win screen when human wins
        }
        if(computerScore == 7){
            loseScreen(g);//draw the lose screen when computer wins
        }
        humanPaddle.paint(g);
        computerPaddle.paint(g);
        ball.paint(g);

    }

}
