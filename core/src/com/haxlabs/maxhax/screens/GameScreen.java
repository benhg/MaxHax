package com.haxlabs.maxhax.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;


public class GameScreen extends MaxHaxScreen {

	private TiledMap map;
	private OurRenderer renderer;
	private OrthographicCamera cam;
	float time = 0;
	
	
	public GameScreen(Game game) {
		super(game);
		
	}
	
	public void show(){
		map=new TmxMapLoader().load("/Users/csstudent/Desktop/MaxHax-master/data/MaxHaxLevel1.tmx");
		renderer=new OurRenderer(map,32);
		cam=new OrthographicCamera();
		cam.setToOrtho(false,800,600);
		renderer.setView(cam);
		renderer.render();
		
		
	}

	@Override
	public void render(float delta) {
		delta=Math.min(.06f, Gdx.graphics.getDeltaTime());
		
		Gdx.gl.glClearColor(0.1f,0.1f,0.1f,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); 
		renderer.setView(cam);
		renderer.render();

	}
	public void dispose(){
		map.dispose();
		renderer.dispose();
	}
	
	public void hide() {
		Gdx.app.debug("MaxHax", "dispose game screen");
		renderer.dispose();
		}
	@Override
	public void resize (int width, int height) {
		cam.setToOrtho(false,width,height);
		renderer.setView(cam);
		renderer.render();
	}

}
