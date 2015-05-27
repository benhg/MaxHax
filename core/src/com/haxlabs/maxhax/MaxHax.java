package com.haxlabs.maxhax;

import com.badlogic.gdx.Game;
import com.haxlabs.maxhax.screens.MainMenu;

public class MaxHax extends Game {
	@Override
	public void create () {
		setScreen(new MainMenu(this));
	}
}
