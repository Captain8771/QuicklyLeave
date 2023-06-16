package dev.captain8771.quicklyleave;

import dev.captain8771.quicklyleave.mixin.GameMenuScreenAccessor;
import dev.captain8771.quicklyleave.mixin.ScreenAccessor;
import com.mojang.blaze3d.platform.InputUtil;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.option.KeyBind;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.lifecycle.api.client.event.ClientTickEvents;

public class QuicklyLeaveModClient implements ClientModInitializer {


	@Override
	public void onInitializeClient(ModContainer mod) {
		// register a keybind
		KeyBind key = KeyBindingHelper.registerKeyBinding(
				new KeyBind(
						// translation key for "disconnect"
						"menu.disconnect",
						InputUtil.KEY_GRAVE_ACCENT_CODE,
						// translation key for multiplayer category
						"key.categories.multiplayer"
				)
		);

		ClientTickEvents.END.register(client -> {
			if (key.wasPressed()) {
				GameMenuScreen screen = new GameMenuScreen(false);
				// screen.client is null if I don't do this for some reason.
				// and for some ungodly reason I had to make GameMenuscreenAccessor extend ScreenAccessor
				// regardless, it works now.
				((ScreenAccessor) screen).setClient(MinecraftClient.getInstance());
				((GameMenuScreenAccessor) screen).callOnDisconnect();
			}
		});
	}
}
