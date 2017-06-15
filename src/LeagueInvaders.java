import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	final int windowWidth = 500;
	final int windowHeight = 800;
	GamePanel GamePanel;

	public static void main(String[] args) {

		LeagueInvaders invade = new LeagueInvaders();
		invade.setup();
	}

	LeagueInvaders() {
		frame = new JFrame();
		GamePanel = new GamePanel();
	}

	void setup() {
		frame.add(GamePanel);
		frame.setSize(windowWidth, windowHeight);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel.startGame();
		frame.addKeyListener(GamePanel);
	}
}
