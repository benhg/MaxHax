package com.haxlabs.maxhax.screens;

<<<<<<< HEAD
import java.io.File;
=======
>>>>>>> 245484bb1067646b6671d83254e784bfda233846

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
<<<<<<< HEAD
import com.badlogic.gdx.files.FileHandle;
=======
>>>>>>> 245484bb1067646b6671d83254e784bfda233846
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MainMenu extends MaxHaxScreen {
<<<<<<< HEAD
	TextureRegion intro;
=======
	TextureRegion title;
>>>>>>> 245484bb1067646b6671d83254e784bfda233846
	SpriteBatch batch;
	float time = 0;

	public MainMenu(Game game) {
		super(game);
	}

<<<<<<< HEAD
	@Override
	public void show () {
		FileHandle fh = Gdx.files.internal("data/unnamed.jpg");
		File f=fh.file();
		Texture t = new Texture(fh);
		intro = new TextureRegion(t, 0, 0, 800, 600);
		batch = new SpriteBatch();
		batch.getProjectionMatrix().setToOrtho2D(0, 0, 800, 600);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin(); 
		batch.draw(intro, 0, 0);
		batch.end();

		time += delta;
		if (time > 1) {
			if (Gdx.input.isKeyPressed(Keys.SPACE) || Gdx.input.justTouched()) {
=======
	
	public void show() {
		//title = new TextureRegion(new Texture(Gdx.files.internal("/Users/csstudent/Desktop/MaxHax 2 lol real tho/core/src/unnamed.png")), 0, 0, 800, 600);
		//batch = new SpriteBatch();
		//batch.getProjectionMatrix().setToOrtho2D(0, 0, 800, 600);
	}


	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//batch.begin();
		//.draw(title, 0, 0);
		//batch.end();

		time += delta;
		if (time > 1) {
			if (Gdx.input.isKeyPressed(Keys.ANY_KEY) || Gdx.input.justTouched()) {
>>>>>>> 245484bb1067646b6671d83254e784bfda233846
				game.setScreen(new GameScreen(game));
			}
		}
	}
<<<<<<< HEAD
	}

=======

	
	public void hide() {
		Gdx.app.debug("MaxHax", "dispose main menu");
		//batch.dispose();
		//title.getTexture().dispose();
	}
}
>>>>>>> 245484bb1067646b6671d83254e784bfda233846
