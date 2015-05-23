package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{ //game with different states or screens

	public static final String gameName = "No Hair 0.0.1";
	public static final int menu = 0; //screens reference
	public static final int play = 1;
	
	public Game(String gameName){ //put the title in a window
		super(gameName); //name on the top of the screen
		this.addState(new Menu(menu)); //every state will have a separated class 
		this.addState(new Play(play)); // get ready for them
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
	//one of the rules of StateBasedGame is have this method
	//game container managers the frame loop, input system etc
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
	// we are telling Java that our game will have two states
		this.enterState(menu); //the first screen to show
	}
	public static void main(String[] args) {
		AppGameContainer appgc; //object window when the game goes inside
		try{
			appgc = new AppGameContainer(new Game(gameName)); //take the main class and create a new window that holds the game
			//what game you will put in the window
			appgc.setDisplayMode(640, 360, false); //false because is note full screen
			//how big is the window
			appgc.start(); //star the window, "create"
		}catch(SlickException e){
		e.printStackTrace();
		 }
	}
}
