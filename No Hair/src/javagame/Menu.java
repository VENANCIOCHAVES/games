package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState{ //command to create a basic screen

	Image playNow; 
	Image exitGame;
	
	
	public Menu(int state){	//that will be 0 like we said it to be
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		playNow = new Image("res/continue.png");
		exitGame = new Image("res/exit.png");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{//drop the stuff on the screen
		g.drawString("No Hair 0.0.1", 100, 50);
		playNow.draw(100, 100);
		exitGame.draw(100, 200);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{//update the images on the screen
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		//Continue button
		if((posX>100 && posX<311) && (posY>209 && posY<260)){ //coordinates of the mouse in the button continue
			if(Mouse.isButtonDown(0)){
				sbg.enterState(1);
			}
		}
		//Exit button
		if((posX>100 && posX<311) && (posY>109 && posY<160)){ //coordinates of the mouse in the button continue
			if(Mouse.isButtonDown(0)){ //0 is the left click
				System.exit(0); //0 to exit properly without crash
			}
		}
	} //to move around etc, have the illusion of movement, the images updates, chance things
	
	public int getID(){ //return the id of this state
		return 0;
	}
}
