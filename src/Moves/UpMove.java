package moves;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.Board;
import main.Level;
import units.Player;
import units.Unit;


//UpMove is one of our move options
//The UpMove is differentiated by its name "UP"
//The action doMove actually carries out the move- it changes the Y coordinate of the player by -1.
public class UpMove extends Move{

	//the constructor
	//no returns
	//the parameters are the parameters that are used by the MOVE class which is extended here
	public UpMove(String d, Board b, BufferedImage s)
	{
		super(d, b, s); 
		//By setting the name of the move, we pass this name to the ArrayList storing the moves.
		name = "UP"; 
	}
	
	//Actually carries out the move when "moveList.get(i).doMove(player);" (Board 63) is called.
	//this actually moves the player up one
	//the parameters are the player that is being moved and the graphics to put it on the screen
	public void doMove(Player player, Graphics g)
	{
		//Criteria for carrying out move:
		//If there is not an obstacle in the way, the move is carried out.
		
		//Get in the level currently being played.
		Level l = board.getCurrentLevel(); 
		ArrayList<ArrayList<Unit>> layout = l.getLayout();
		//System.out.println("inside up move, but not in the move yet");
		//If the move will make the Player pass through an obstacle, do not carry out the move.
		//Otherwise, carry out the move.
		if(player.getY() > 0 && !layout.get(player.getY() - 1).get(player.getX()).isObstacle)
		{
			player.setY(player.getY()-1);
			player.setDirection(player.NORTH); 
			//System.out.println("inside up move");
		}
	
	}
}