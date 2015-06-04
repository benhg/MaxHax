package com.haxlabs.maxhax.screens;


import java.io.File;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;


public class OurRenderer extends OrthogonalTiledMapRenderer {

	public OurRenderer(TiledMap map) {
		super(map);

		
		// TODO Auto-generated constructor stub
	}

	public OurRenderer(TiledMap map, Batch batch) {
		super(map, batch);
		// TODO Auto-generated constructor stub
	}

	public OurRenderer(TiledMap map, float unitScale) {
		super(map, unitScale);
	}

	public OurRenderer(TiledMap map, float unitScale, Batch batch) {
		super(map, unitScale, batch);
		
	}
	public void render(){
		super.render();
		renderMax();
		
	}
	
	public void render(int[] arr){
		super.render(arr);
		renderMax();
	}
	public void renderMax(){
		FileHandle fh = Gdx.files.internal("data/max.png");
		Texture t = new Texture(fh);
		TextureRegion g = new TextureRegion(t, 0, 0, 50, 50);
		batch = new SpriteBatch();
		batch.begin(); 
		batch.draw(g, 80, 80);
		batch.end();
		
		
	}
	
	//private void renderBob() {
	///
	//}
}
