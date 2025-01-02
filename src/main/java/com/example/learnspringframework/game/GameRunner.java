package com.example.learnspringframework.game;

public class GameRunner {
	
	//Leveraging Interface -> instead of individual Game objects to pass on to GameRunner Constructor
	GamingConsole game;
	
	public GameRunner(GamingConsole game)
	{
		this.game = game;
	}
	
	public void run()
	{
		System.out.println("Running game: " + game);
		game.up();
		game.down();
		game.left();
		game.right();
	}

}
