package de.robin.alpine.entity.renderer;

import de.robin.alpine.AlpineMod;
import de.robin.alpine.entity.entities.AlpineChicken;
import de.robin.alpine.entity.entities.AlpineKillerBunny;
import de.robin.alpine.entity.model.AlpineChickenModel;
import de.robin.alpine.entity.model.AlpineKillerBunnyModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AlpineKillerBunnyRenderer extends MobRenderer<AlpineKillerBunny, AlpineKillerBunnyModel<AlpineKillerBunny>> {
    public AlpineKillerBunnyRenderer(EntityRendererProvider.Context context) {
        super(context, new AlpineKillerBunnyModel<>(context.bakeLayer(AlpineKillerBunnyModel.LAYER_LOCATION)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(AlpineKillerBunny p_114482_) {
        return new ResourceLocation(AlpineMod.MODID, "textures/entity/alpinekillerbunny.png");
    }

}
