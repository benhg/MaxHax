package com.haxlabs.maxhax.screens;

<<<<<<< HEAD
import java.io.File;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.haxlabs.maxhax.screens.GameOver;
=======
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
>>>>>>> 040fd696a0b6c06aa277fc965b8ea5f8e0740f05


public class GameScreen extends MaxHaxScreen {

	private TiledMap map;
<<<<<<< HEAD
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera cam;
	float time = 0;
	private float tileSize;
	float PPM=32;
	FixtureDef fdef;
	BodyDef b;
	World world;
	Box2DDebugRenderer b2dr=new Box2DDebugRenderer();
	OrthographicCamera b2dcam;
	Body body;
	TextureRegion maxT;
	int x=100;
	int y=90;
=======
	private OurRenderer renderer;
	private OrthographicCamera cam;
	float time = 0;
>>>>>>> 040fd696a0b6c06aa277fc965b8ea5f8e0740f05
	
	
	public GameScreen(Game game) {
		super(game);
<<<<<<< HEAD
		cam=new OrthographicCamera();
		cam.setToOrtho(true,800,600);
		world=new World(new Vector2(0,-1),true);
		map=new TmxMapLoader().load("data/MaxHaxLevel1.tmx");
		renderer=new OrthogonalTiledMapRenderer(map);
		TiledMapTileLayer layer=(TiledMapTileLayer) map.getLayers().get("Ground");
		tileSize=layer.getTileHeight();
		for(int row=0;row<layer.getHeight();row++){
			for(int col=0;col<layer.getWidth();col++){
				Cell c=layer.getCell(col,row);
				b=new BodyDef();
				b.type=BodyType.StaticBody;
				fdef=new FixtureDef();
				b.position.set(((col+0.5f)*(tileSize/PPM)),((row+0.5f)*(tileSize/PPM)));
				ChainShape cs=new ChainShape();
				Vector2[] v=new Vector2[3];
				v[0]=new Vector2(-tileSize/2/PPM,-tileSize/2/PPM);
				v[1]=new Vector2(-tileSize/2/PPM,tileSize/2/PPM);
				v[2]=new Vector2(tileSize/2/PPM,tileSize/2/PPM);
				cs.createChain(v);
				fdef.shape=cs;
				fdef.filter.categoryBits=1;
				fdef.filter.maskBits=-1;
				fdef.isSensor=false;
				world.createBody(b).createFixture(fdef);
			}
		}
		BodyDef bdef=new BodyDef();
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(50 / PPM, 5 / PPM);
		FixtureDef fdef = new FixtureDef();
		bdef.position.set(160, 200);
		bdef.type = BodyType.DynamicBody;
		body = world.createBody(bdef);
		body.setActive(true);
		System.out.println(body.getMass());
		System.out.println(body.getPosition());
		shape.setAsBox(50, 50);
		fdef.shape = shape;
		Fixture f=body.createFixture(fdef);
		this.b2dcam = new OrthographicCamera();
		b2dcam.setToOrtho(false, 800,600);
		
	
		
=======
>>>>>>> 040fd696a0b6c06aa277fc965b8ea5f8e0740f05
		
	}
	
	public void show(){
<<<<<<< HEAD
		cam=new OrthographicCamera();
		cam.setToOrtho(true,800,600);
		world=new World(new Vector2(0,-10),true);
		map=new TmxMapLoader().load("data/MaxHaxLevel1.tmx");
		renderer=new OrthogonalTiledMapRenderer(map);
		body.applyForceToCenter(new Vector2(2,2),true);
	
=======
		map=new TmxMapLoader().load("data/MaxHaxLevel1.tmx");
		renderer=new OurRenderer(map);
		cam=new OrthographicCamera();
		cam.setToOrtho(true,800,600);
		
		
		
>>>>>>> 040fd696a0b6c06aa277fc965b8ea5f8e0740f05
	}

	@Override
	public void render(float delta) {
		delta=Math.min(.06f, Gdx.graphics.getDeltaTime());
<<<<<<< HEAD
=======
		
>>>>>>> 040fd696a0b6c06aa277fc965b8ea5f8e0740f05
		Gdx.gl.glClearColor(0.1f,0.1f,0.1f,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); 
		cam.setToOrtho(false,820,490);
		renderer.setView(cam);
		renderer.render();
<<<<<<< HEAD
		cam=new OrthographicCamera();
		cam.setToOrtho(true,820,490);
		Vector2 pos=body.getWorldCenter();
		float angle=body.getAngle();
		ShapeRenderer r=new ShapeRenderer();
		r.begin(ShapeType.Filled);
		r.setColor(new Color(0,0,0, 0));
		r.circle(pos.x,pos.y,10);
		FileHandle fh = Gdx.files.internal("data/max.png");
		File f=fh.file();
		Texture t = new Texture(fh);
		maxT = new TextureRegion(t, 0, 0, 50, 50);
		SpriteBatch batch = new SpriteBatch();
		batch.begin(); 
		batch.draw(maxT, x, y);
		
		
		time += delta;
		if (time > 1) {
			if (Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.justTouched()) {
				x+=5;
				batch.draw(maxT, x, y);
			}
			if (Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.justTouched()) {
				x-=5;
				batch.draw(maxT, x, y);
			}
			if (Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.justTouched()) {
				y+=5;
				batch.draw(maxT, x, y);
			}
			if (Gdx.input.isKeyPressed(Keys.DOWN) || Gdx.input.justTouched()) {
				y-=5;
				batch.draw(maxT, x, y);
			}
			if (Gdx.input.isKeyPressed(Keys.SPACE) || Gdx.input.justTouched()) {
				y=90;
				x=100;
				batch.draw(maxT, x, y);
			}
		}
		batch.end();
		
		if((x>525&&x<900)&&(y>80&&y<100)){
			game.setScreen(new GameOver(game));
		}
		
		
		
=======
>>>>>>> 040fd696a0b6c06aa277fc965b8ea5f8e0740f05

	}
	public void dispose(){
		map.dispose();
		renderer.dispose();
	}
	
<<<<<<< HEAD
	void renderMax(){
		
	}
	
=======
>>>>>>> 040fd696a0b6c06aa277fc965b8ea5f8e0740f05
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
