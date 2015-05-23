package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState{ //command to create a basic screen
	
	Animation noHair, movingUp, movingDown, movingLeft, movingRight; //No Hair movements
	Image worldMap; //
	boolean quit = false; //user has the option to quit the game changing to true
	int[] duration = {200,200}; //tell the animation how long it will last - specified the frame
							  //200 something like half second
	float noHairPositionX = 0;
	float noHairPositionY = 0; //will start location 0 0
	float shiftX = noHairPositionX + 320; //half of the screen size to put the center
	float shiftY = noHairPositionY + 160;
			
	public Play(int state){	//that will be 0 like we said it to be
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
	//the class and the stuff that the class needs 
		worldMap = new Image("res/land.png"); //all the pieces to create a animation
		Image[] walkUp = {new Image("res/noHairWalkBack.png"), new Image("res/noHairWalkBack2.png")};
		Image[] walkDown = {new Image("res/noHairWalkFront.png"), new Image("res/noHairWalkFront2.png")};
		Image[] walkLeft = {new Image("res/noHairWalkLeft.png"), new Image("res/noHairWalkLeft2.png")};
		Image[] walkRight = {new Image("res/noHairWalkRight.png"), new Image("res/noHairWalkRight2.png")};
		
		movingUp = new Animation(walkUp, duration, true); //new animation object with image from walkUp
		movingDown = new Animation(walkDown, duration, true);//duration - how long each image will last
		movingLeft = new Animation(walkLeft, duration, true);
		movingRight = new Animation(walkRight, duration, true);
		noHair = movingDown;
	}												
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{//drop the stuff on the screen
		worldMap.draw(noHairPositionX, noHairPositionY); //put the map in 0 0 starting in left
		noHair.draw(shiftX, shiftY, 20, 70); //put the player in center
		g.drawString("Hair X position: "+noHairPositionX+" \nHair Y position: "+noHairPositionY, 400, 200);
	
		if(quit == true){ //esc key will pop-up a menu
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 120);
			g.drawString("Quit Game (Q)", 250, 140);
			if(quit == false){
				g.clear(); //get out with all the graphics
			}
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{//update the images on the screen
		Input input = gc.getInput();//Input class input object
		
		//up 
		if(input.isKeyDown(Input.KEY_UP)){//always player press up this code will happen
			noHair = movingUp; //change the image to looks like is moving up
			noHairPositionY += delta * 0.15f; //increase the Y position, makes things move
			if(noHairPositionY>159){ //colision detection
				noHairPositionY -= delta * 0.15f;
			}
		}
		//down 
		if(input.isKeyDown(Input.KEY_DOWN)){
			noHair = movingDown;
			noHairPositionY -= delta * 0.15f;
			if(noHairPositionY<-339){
				noHairPositionY += delta * 0.15f;
			}
		}
		//left 
		if(input.isKeyDown(Input.KEY_LEFT)){
			noHair = movingLeft;
			noHairPositionX += delta * 0.15f;
			if(noHairPositionX>329){
				noHairPositionX -= delta * 0.15f;
			}
		}
		//right 
		if(input.isKeyDown(Input.KEY_RIGHT)){
			noHair = movingRight;
			noHairPositionX-= delta * 0.15f;
			if(noHairPositionX<-460){
				noHairPositionX += delta * 0.15f;
			}
		}
		// escape
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			quit = true;
		}
		//when the menu is up
		if(quit==true){
			if(input.isKeyDown(Input.KEY_R)){
				quit = false;
			}
			if(input.isKeyDown(Input.KEY_M)){
				sbg.enterState(0);
			}
			if(input.isKeyDown(Input.KEY_Q)){
				System.exit(0);
			}
		}
		
	} //to move around etc, have the illusion of movement  the images updates
	
	public int getID(){ //return the id of this state
		return 1;
	}
}

