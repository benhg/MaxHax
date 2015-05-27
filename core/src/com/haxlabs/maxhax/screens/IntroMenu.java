package com.haxlabs.maxhax.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class IntroMenu extends MaxHaxScreen {
	TextureRegion intro;
	SpriteBatch batch;
	float time = 0;

	public IntroMenu(Game game) {
		super(game);
	}

	@Override
	public void show () {
		FileHandle fh = Gdx.files.absolute("/Users/csstudent/Desktop/MaxHax-master/core/src/unnamed.png");
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
				game.setScreen(new GameScreen(game));
			}
		}
	}
	}

