package com.haxlabs.maxhax.screens;


import java.io.File;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.haxlabs.maxhax.Max;
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

		Texture max=new Texture(Gdx.files.internal("data/max.png"));
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
		FileHandle fh = Gdx.files.internal("data/max.png");
		Texture t = new Texture(fh);
		TextureRegion g = new TextureRegion(t, 0, 0, 50, 50);
		batch = new SpriteBatch();
		batch.begin(); 
		batch.draw(g, 80, 80);
		batch.end();
		
		
	}
	
	/*private void createAnimations () {
		this.tile = new TextureRegion(new Texture(Gdx.files.internal("data/tile.png")), 0, 0, 20, 20);
		Texture bobTexture = new Texture(Gdx.files.internal("data/max.png"));
		TextureRegion[] split = new TextureRegion(bobTexture).split(20, 20)[0];
		TextureRegion[] mirror = new TextureRegion(bobTexture).split(20, 20)[0];
		for (TextureRegion region : mirror)
			region.flip(true, false);
		TextureRegion spikes = split[5];
		Animation bobRight = new Animation(0.1f, split[0], split[1]);
		Animation bobLeft = new Animation(0.1f, mirror[0], mirror[1]);
		Animation bobJumpRight = new Animation(0.1f, split[2], split[3]);
		Animation bobJumpLeft = new Animation(0.1f, mirror[2], mirror[3]);
		Animation bobIdleRight = new Animation(0.5f, split[0], split[4]);
		Animation bobIdleLeft = new Animation(0.5f, mirror[0], mirror[4]);
		Animation bobDead = new Animation(0.2f, split[0]);
		split = new TextureRegion(bobTexture).split(20, 20)[1];
		
		Animation spawn = new Animation(0.1f, split[4], split[3], split[2], split[1]);
		
	}
	*/
	
	private void renderBob () {
		Animation anim = null;
		boolean loop = true;
	/*	if (map.bob.state == Max.RUN) {
			if (map.max.dir == Bob.LEFT)
				anim = bobLeft;
			else
				anim = bobRight;
		}
		if (map.bob.state == Bob.IDLE) {
			if (map.bob.dir == Bob.LEFT)
				anim = bobIdleLeft;
			else
				anim = bobIdleRight;
		}
		if (map.bob.state == Bob.JUMP) {
			if (map.bob.dir == Bob.LEFT)
				anim = bobJumpLeft;
			else
				anim = bobJumpRight;
		}
		if (map.bob.state == Bob.SPAWN) {
			anim = spawn;
			loop = false;
		}
		if (map.bob.state == Bob.DYING) {
			anim = dying;
			loop = false;
		}
		batch.draw(anim.getKeyFrame(map.bob.stateTime, loop), map.bob.pos.x, map.bob.pos.y, 1, 1);
	*/
	
		batch.begin();
		batch.draw(maxt, 400, 200);
		batch.end();
		}
	}

