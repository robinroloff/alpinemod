package de.robin.alpine.entity.renderer;

import de.robin.alpine.AlpineMod;
import net.minecraft.client.renderer.entity.CowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cow;

public class AlpineCowRenderer extends CowRenderer {
    public AlpineCowRenderer(EntityRendererProvider.Context p_173956_) {
        super(p_173956_);
    }

    @Override
    public ResourceLocation getTextureLocation(Cow p_114029_) {
        return new ResourceLocation(AlpineMod.MODID, "textures/entity/alpinecow.png");
    }
}
