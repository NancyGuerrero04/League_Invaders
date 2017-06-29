import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Aliens extends GameObject{
	
		Aliens(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	void update(){
		super.update();
		y+=10;
		int xdir = new Random().nextInt(2);
		if(xdir==0){
			x+=5;
		}
		else {
			x-=3;
		}
		
	}

	void draw(Graphics g){
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}
}
