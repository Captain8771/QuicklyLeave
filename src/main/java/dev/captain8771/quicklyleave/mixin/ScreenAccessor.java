package dev.captain8771.quicklyleave.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Screen.class)
public interface ScreenAccessor {
	@Accessor
	MinecraftClient getClient();

	@Accessor
	void setClient(MinecraftClient client);
}
