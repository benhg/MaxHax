package com.haxlabs.maxhax.screens;

import com.badlogic.gdx.graphics.g2d.Batch;
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
		// TODO Auto-generated constructor stub
	}

	public OurRenderer(TiledMap map, float unitScale, Batch batch) {
		super(map, unitScale, batch);
		
	}
	public void render(){
		
		super.render();
		
	}
	
	public void render(int[] arr){
				imageBounds.x=800;
		imageBounds.y=600;
		imageBounds.width=800;
		imageBounds.height=600;
		super.render(arr);
		
	}

}
