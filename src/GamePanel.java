import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	Font titleFont;
	Rocketship ship;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	private Font startFont;
	private Font instructFont;
	private Font overFont;
	private Font scoreFont;
	private Font restartFont;
	private ObjectManager manager;
	GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		startFont = new Font("Arial", Font.PLAIN, 20);
		instructFont = new Font("Arial", Font.PLAIN, 20);
		overFont = new Font("Arial", Font.PLAIN, 48);
		scoreFont = new Font("Arial", Font.PLAIN, 20);
		restartFont = new Font("Arial", Font.PLAIN, 20);
		manager = new ObjectManager();
		

		ship = new Rocketship(250,700,50,50);
		manager.addObject(ship); 
	}
	
	void currentState(){
		
	}
	
	void updateMenuState(){
		
	}
	
	void updateGameState(){
		manager.update();
		
	}
	
	void updateEndState(){
		
	}

	void drawMenuState(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.windowWidth, LeagueInvaders.windowHeight);
		
		g.setColor(Color.DARK_GRAY);
		g.setFont(titleFont);
		g.drawString("League Invaders", 40, 200);
		
		g.setColor(Color.DARK_GRAY);
		g.setFont(startFont);
		g.drawString("Press ENTER to start", 40, 400);
		
		g.setColor(Color.DARK_GRAY);
		g.setFont(instructFont);
		g.drawString("Press SPACE for instructions", 40, 500);
		
	}
	
	void drawGameState(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.windowWidth, LeagueInvaders.windowHeight);
		
		manager.draw(g);
	}
	
	void drawEndState(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.windowWidth, LeagueInvaders.windowHeight);
		
		g.setColor(Color.DARK_GRAY);
		g.setFont(overFont);
		g.drawString("Game Over", 40, 200);
		
		g.setColor(Color.DARK_GRAY);
		g.setFont(scoreFont);
		g.drawString("You killed", 40, 400);
		
		g.setColor(Color.DARK_GRAY);
		g.setFont(restartFont);
		g.drawString("Press BACKSPACE to Restart", 40, 500);
	}
	void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		if(currentState == MENU_STATE){
			drawMenuState(g);
		}else if(currentState == GAME_STATE){
			drawGameState(g);
		}else if(currentState == END_STATE){
			drawEndState(g);
		}

	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		//System.out.println("action");
		
		if(currentState == MENU_STATE){
			updateMenuState();
		}else if(currentState == GAME_STATE){
			updateGameState();
		}else if(currentState == END_STATE){
			updateEndState();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key type");

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key press");
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			currentState++;
			
		}
		if(currentState > END_STATE){
			currentState = MENU_STATE;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			ship.xSpeed = 5; 
			
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			ship.xSpeed = -5; 
			
			
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			ship.ySpeed = -5; 
			
			
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			ship.ySpeed = 5; 
			
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			manager.addObject(new Projectiles(ship.x+25, ship.y, 10, 10));

			
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key released");
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			ship.xSpeed = 0; 
			
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			ship.xSpeed = 0; 
			
			
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			ship.ySpeed = 0; 
			
			
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			ship.ySpeed = 0; 
			
			
		}
	}

}
