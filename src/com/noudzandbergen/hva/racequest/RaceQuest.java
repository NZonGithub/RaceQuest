package com.noudzandbergen.hva.racequest;

import com.noudzandbergen.hva.racequest.components.ParkingGridComponent;
import com.noudzandbergen.hva.racequest.components.RaceVisualizerComponent;
import com.noudzandbergen.hva.racequest.components.StatisticsComponent;
import com.noudzandbergen.hva.racequest.util.AtlasUtil;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import processing.event.KeyEvent;
import processing.opengl.PGraphicsOpenGL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceQuest extends PApplet {

	// Game Data
	public static final Shape I = new Shape("I", .5f, -.5f,-1, 0, 2, 0, 1, 0, 0, 0);
	public static final Shape J = new Shape("J", 0, 0, -1, 0, 1, 0, -1, 1, 0, 0);
	public static final Shape L = new Shape("L", 0, 0, -1, 0, 1, 0, 1, -1, 0, 0);
	public static final Shape O = new Shape("O", .5f, -.5f, 0, 0, 1, 0, 1, -1, 0, -1);
	public static final Shape S = new Shape("S", 0, 0, -1, 0, 1, -1, 0, -1, 0, 0);
	public static final Shape Z = new Shape("Z", 0, 0, 1, 0, -1, -1, 0, -1, 0, 0);
	public static final Shape T = new Shape("T", 0, 0, -1, 0, 1, 0, 0, -1, 0, 0);

	public final List<Car> cars = new ArrayList<>();
	public final List<Shape> shapes = Arrays.asList(I, J, L, O, S, Z, T);


	// Components. Public to allow any of them to access each other.
	public ParkingGridComponent parkingGrid;
	public RaceVisualizerComponent raceVisualizer;
	public StatisticsComponent statisticsDisplay;

	public int score = 0;

	// Startup code and settings
	@Override
	public void settings() {
		// Create a full-screen canvas.
		// Our game will be optimized for but not restricted to 1920x1080.
		fullScreen(P2D);
		//		size(640, 480, P2D);
		// size(1920, 1080, P2D);
		//		size(1280, 720, P2D);
	}


	@Override
	public void setup() {
		// Load game data
		PImage atlas = loadImage("res/atlas.png");

		for (AtlasUtil.ImageBounds bounds : AtlasUtil.generateBounds(4, 6, 280, 114, 20, 38, 18, 32)) {
			PImage sprite = atlas.get(bounds.x, bounds.y, bounds.width, bounds.height);
			System.out.println(bounds);
			cars.add(new Car(sprite, 6));
		}


		// Load components
		parkingGrid = new ParkingGridComponent(this, 14, 14);
		raceVisualizer = new RaceVisualizerComponent(this);
		statisticsDisplay = new StatisticsComponent(this);


		// Rendering settings
		noStroke(); // We'll likely never have to stroke within the entire game
		imageMode(CENTER);
		((PGraphicsOpenGL) getGraphics()).textureSampling(POINT); // Cheeky way to render textures as pixel art.
	}

	@Override
	public void keyPressed(KeyEvent event) {
		switch (event.getKeyCode()) {
			case 'E':
				parkingGrid.rotate(1);
				break;
			case 'Q':
				parkingGrid.rotate(-1);
				break;
			case 'A':
				parkingGrid.move(-1, 0);
				break;
			case 'D':
				parkingGrid.move(1, 0);
				break;
			case 'S':
				parkingGrid.move(0, 1);
				break;
		}
	}

	private long pFrameNanos;
	private float time;

	@Override
	public void draw() {
		// Calculate delta time. Might come in handy.
		float delta = (-pFrameNanos + (pFrameNanos = frameRateLastNanos)) / 1e9f;

		if (delta < 1) {
			time += delta;

			// Game logic & physics
			parkingGrid.update(delta);
		}


		// Game rendering
		// We're doing some manual transformation magic here to layout the components.
		// Because using a UI library isn't an option and I don't feel like writing one. Although I gave it a shot.
		clear();

		PVector renderArea = new PVector((float) height * parkingGrid.columns / parkingGrid.rows * .6f, height);
		parkingGrid.draw(getGraphics(), renderArea, time); // Draw parkingGrid at the left side of the screen


		translate(renderArea.x, 0); // Translate in order to draw at the top right side of the screen
		renderArea.set(width - renderArea.x, height * 0.6f);
		raceVisualizer.draw(getGraphics(), renderArea, time);


		translate(0, renderArea.y); // Translate in order to draw at the bottom right side of the screen
		renderArea.y = height - renderArea.y;
		statisticsDisplay.draw(getGraphics(), renderArea, time);

		// Voila. Here we have a moderately dynamic layout using messy code. But it works.
	}

	// Application entry point
	public static void main(String[] args) {
		// Create our game instance manually as to allow more control of the application.
		// For example, we could load up data here and pass it to the constructor of RaceQuest.
		// Plus I like it better than to have Processing handle all the magic itself.
		// PApplet.main() is made mainly for command-line use.
		RaceQuest game = new RaceQuest();
		runSketch(new String[]{game.getClass().getName()}, game);
	}

}
