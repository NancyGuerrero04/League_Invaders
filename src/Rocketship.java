import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
 int xSpeed;
 int ySpeed;
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		
		xSpeed = 0;
		ySpeed = 0;
	}
	
	void update(){
		x += xSpeed;
		y += ySpeed;
	}
	
	void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);

	}
	
	
}
