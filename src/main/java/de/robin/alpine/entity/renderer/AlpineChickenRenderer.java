package de.robin.alpine.entity.renderer;

import de.robin.alpine.AlpineMod;
import de.robin.alpine.entity.entities.AlpineChicken;
import de.robin.alpine.entity.model.AlpineChickenModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AlpineChickenRenderer extends MobRenderer<AlpineChicken, AlpineChickenModel<AlpineChicken>> {
    public AlpineChickenRenderer(EntityRendererProvider.Context context) {
        super(context, new AlpineChickenModel<>(context.bakeLayer(AlpineChickenModel.LAYER_LOCATION)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(AlpineChicken p_114482_) {
        return new ResourceLocation(AlpineMod.MODID, "textures/entity/alpinechicken.png");
    }

}
