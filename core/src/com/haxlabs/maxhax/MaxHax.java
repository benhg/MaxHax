package com.haxlabs.maxhax;

import com.badlogic.gdx.Game;
import com.haxlabs.maxhax.screens.IntroMenu;

public class MaxHax extends Game {
	@Override
	public void create () {
		setScreen(new IntroMenu(this));
	}
}
