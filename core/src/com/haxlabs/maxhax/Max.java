package com.haxlabs.maxhax;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Max {
	static final int IDLE=0;
	static final int SPAWN=1;
	static final int LEFT=-1;
	static final int RIGHT=1;
	static final float ACCEL=20f;
	static final float JUMP_VEL=10;
	static final float MAX_VEL=6;
	static final float GRAV=20.0f;
	static final float DAMP=.90f;
	static final int JUMP=3;
	static final int RUN=4;
	private Rectangle[] r = {new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle(), new Rectangle()};
			
	private TiledMap map;
	private Vector2 pos=new Vector2();
	private Vector2 vel=new Vector2();
	private Vector2 accel=new Vector2();
	private int state=IDLE;
	private float stateTime=0;
	int dir=LEFT;
	boolean grounded=false;
	public Rectangle bounds=new Rectangle();
	

	public Max(TiledMap map, float x, float y) {
		this.map=map;
		pos.x=x;
		pos.y=y;
		bounds.width=0.6f;
		bounds.height=0.8f;
		bounds.x=pos.x+0.2f;
		bounds.y=pos.y;
		state=IDLE;
		stateTime=0;		
	}
	public void update(float deltaTime){
		processKeys();

		accel.y = -GRAV;
		accel.scl(deltaTime);
		vel.add(accel.x, accel.y);
		if (accel.x == 0) vel.x *= DAMP;
		if (vel.x > MAX_VEL) vel.x = MAX_VEL;
		if (vel.x < -MAX_VEL) vel.x = -MAX_VEL;
		tryMove();
		vel.scl(deltaTime);
		vel.scl(1.0f / deltaTime);

		if (state == SPAWN) {
			if (stateTime > 0.4f) {
				state = IDLE;
			}
		}

		stateTime += deltaTime;
		
	}
	
	private void processKeys () {
		if (state == IDLE || state == SPAWN) return;

		float x0 = (Gdx.input.getX(0) / (float)Gdx.graphics.getWidth()) * 480;
		float x1 = (Gdx.input.getX(1) / (float)Gdx.graphics.getWidth()) * 480;
		float y0 = 320 - (Gdx.input.getY(0) / (float)Gdx.graphics.getHeight()) * 320;

		boolean leftButton = (Gdx.input.isTouched(0) && x0 < 70) || (Gdx.input.isTouched(1) && x1 < 70);
		boolean rightButton = (Gdx.input.isTouched(0) && x0 > 70 && x0 < 134) || (Gdx.input.isTouched(1) && x1 > 70 && x1 < 134);
		boolean jumpButton = (Gdx.input.isTouched(0) && x0 > 416 && x0 < 480 && y0 < 64)
			|| (Gdx.input.isTouched(1) && x1 > 416 && x1 < 480 && y0 < 64);

		
		if ((Gdx.input.isKeyPressed(Keys.W) || jumpButton) && state != JUMP) {
			state = JUMP;
			vel.y = JUMP_VEL;
			grounded = false;
		}

		
		if (Gdx.input.isKeyPressed(Keys.A) || leftButton) {
			if (state != JUMP) state = RUN;
			dir = LEFT;
			accel.x = ACCEL * dir;
		} else if (Gdx.input.isKeyPressed(Keys.D) || rightButton) {
			if (state != JUMP) state = RUN;
			dir = RIGHT;
			accel.x = ACCEL * dir;
		} else {
			if (state != JUMP) state = IDLE;
			accel.x = 0;
		}
	}



private void tryMove () {
	bounds.x += vel.x;
	fetchCollidableRects();
	for (int i = 0; i < r.length; i++) {
		Rectangle rect = r[i];
		if (bounds.overlaps(rect)) {
			if (vel.x < 0)
				bounds.x = rect.x + rect.width + 0.01f;
			else
				bounds.x = rect.x - bounds.width - 0.01f;
			vel.x = 0;
		}
	}
	
	bounds.y += vel.y;
	fetchCollidableRects();
	for (int i = 0; i < r.length; i++) {
		Rectangle rect = r[i];
		if (bounds.overlaps(rect)) {
			if (vel.y < 0) {
				bounds.y = rect.y + rect.height + 0.01f;
				grounded = true;
			
				bounds.y = rect.y - bounds.height - 0.01f;
			vel.y = 0;
		}
	}

	pos.x = bounds.x - 0.2f;
	pos.y = bounds.y;
	}
}
private void fetchCollidableRects () {

}

}
