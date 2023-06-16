package dev.captain8771.quicklyleave.mixin;

import net.minecraft.client.gui.screen.GameMenuScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GameMenuScreen.class)
public interface GameMenuScreenAccessor extends ScreenAccessor {
	@Invoker
	void callOnDisconnect();

}
