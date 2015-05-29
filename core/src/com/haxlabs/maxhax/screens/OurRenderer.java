package com.haxlabs.maxhax.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class OurRenderer extends OrthogonalTiledMapRenderer {
		private TextureRegion maxt;

	public OurRenderer(TiledMap map) {
		super(map);
		Texture max=new Texture(Gdx.files.absolute("/Users/csstudent/Desktop/MaxHax-master/data/max.png"));
		TextureRegion maxt=new TextureRegion(max);
		this.maxt=maxt;
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
		batch.begin();
		batch.draw(maxt, 400, 200);
		batch.end();
	}
}
