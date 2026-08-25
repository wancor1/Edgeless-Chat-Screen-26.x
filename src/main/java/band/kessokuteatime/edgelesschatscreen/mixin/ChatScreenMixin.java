package band.kessokuteatime.edgelesschatscreen.mixin;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.ChatScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(ChatScreen.class)
public class ChatScreenMixin {
    @ModifyArgs(
        method = "render",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/GuiGraphics;fill(IIIII)V"
        )
    )
    private void edgelessChatScreen$expandBackground(Args args) {
        args.set(0, (int) args.get(0) - 2); // left
        args.set(2, (int) args.get(2) + 2); // right
        args.set(3, (int) args.get(3) + 2); // bottom
    }
}
