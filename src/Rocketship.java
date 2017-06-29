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
		super.update();
		x += xSpeed;
		y += ySpeed;
	}
	
	void draw(Graphics g){
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);


	}
	
	
}
