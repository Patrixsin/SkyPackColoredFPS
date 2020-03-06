package client.mods.impl;

import client.gui.hud.ScreenPosition;
import client.mods.ModDraggable;
import net.minecraft.client.gui.Gui;

public class ModFps extends ModDraggable{

	@Override
	public int getWidth() {
		return font.getStringWidth("FPS: "+ mc.getDebugFPS());
	}

	@Override
	public int getHeight() {
		return font.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		Gui.drawRect(pos.getAbsoluteX(), pos.getAbsoluteY(), pos.getAbsoluteX() + getWidth() + 1, pos.getAbsoluteY() + getHeight(), 0x90000000);
		if(mc.getDebugFPS() >= 60) {
			font.drawString("FPS: "+ mc.getDebugFPS(), pos.getAbsoluteX(), pos.getAbsoluteY(), 0x0000FF00);
		}if(mc.getDebugFPS() >= 25 && mc.getDebugFPS() <= 59) {
			font.drawString("FPS: "+ mc.getDebugFPS(), pos.getAbsoluteX(), pos.getAbsoluteY(), 0x00FFFF00);
		}if(mc.getDebugFPS() >= 0 && mc.getDebugFPS() <= 24) {
			font.drawString("FPS: "+ mc.getDebugFPS(), pos.getAbsoluteX(), pos.getAbsoluteY(), 0x00FF0000);
		}
	}

	@Override
	public void renderDummy(ScreenPosition pos) {
		Gui.drawRect(pos.getAbsoluteX(), pos.getAbsoluteY(), pos.getAbsoluteX() + getWidth() + 1, pos.getAbsoluteY() + getHeight(), 0x90000000);
		font.drawString("FPS: "+ mc.getDebugFPS(), pos.getAbsoluteX(), pos.getAbsoluteY(), 0x0000FFFF);
	}

}
