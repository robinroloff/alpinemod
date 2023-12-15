package de.robin.alpine.entity.renderer;

import de.robin.alpine.AlpineMod;
import de.robin.alpine.entity.entities.AlpineChicken;
import de.robin.alpine.entity.entities.Marmot;
import de.robin.alpine.entity.model.AlpineChickenModel;
import de.robin.alpine.entity.model.MarmotModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MarmotRenderer extends MobRenderer<Marmot, MarmotModel<Marmot>> {

    public MarmotRenderer(EntityRendererProvider.Context context) {
        super(context, new MarmotModel<>(context.bakeLayer(MarmotModel.LAYER_LOCATION)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(Marmot p_114482_) {
        return new ResourceLocation(AlpineMod.MODID, "textures/entity/marmot.png");
    }

}
