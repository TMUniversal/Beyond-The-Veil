package com.valeriotor.BTV.shoggoth.buildings;

import com.valeriotor.BTV.gui.GuiCityMapper;
import com.valeriotor.BTV.shoggoth.BuildingTemplate;

public class BuildingPyramid extends BuildingTemplate{

	public BuildingPyramid(String name, int index) {
		super(28, 28, false, name, index);
	}

	@Override
	public void drawScaledTexture(GuiCityMapper gui, int xTopLeft, int yTopLeft, float scale, int width, int height) {
		this.drawHelper(gui, xTopLeft, yTopLeft, 64, 0, scale);
	}

	@Override
	public boolean isDefault() {
		return true;
	}

}
