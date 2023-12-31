package de.robin.alpine.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import de.robin.alpine.AlpineMod;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class AlpineChickenModel<T extends Entity> extends EntityModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(AlpineMod.MODID, "alpinechicken"), "main");
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart rightWing;
    private final ModelPart leftWing;
    private final ModelPart beak;
    private final ModelPart redThing;

    public AlpineChickenModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = body.getChild("head");
        this.beak = head.getChild("beak");
        this.rightLeg = body.getChild("leg0");
        this.leftLeg = body.getChild("leg1");
        this.rightWing = body.getChild("wing0");
        this.leftWing = body.getChild("wing1");
        this.redThing = head.getChild("comb");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, 6.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

        PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(30, 0).addBox(-6.0F, -0.1F, -5.6F, 12.0F, 0.2F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.173F, 10.3456F, 0.9599F, 0.0F, 0.0F));

        PartDefinition body_r2 = body.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(0, 15).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(49, 11).addBox(-2.0F, -8.0F, -2.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(15, 0).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -4.0F));

        PartDefinition comb = head.addOrReplaceChild("comb", CubeListBuilder.create().texOffs(31, 26).addBox(-1.0F, -5.0F, -4.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition beak = head.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(31, 20).addBox(-1.0F, -7.0F, -5.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition leg0 = body.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(50, 18).addBox(-2.0F, 3.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 3.0F, 1.0F));
        PartDefinition leg1 = body.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(50, 18).addBox(0.0F, 3.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 3.0F, 1.0F));
        PartDefinition wing0 = body.addOrReplaceChild("wing0", CubeListBuilder.create().texOffs(54, 24).addBox(-1.0F, 1.0F, 2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(41, 22).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 1.0F, 0.0F));
        PartDefinition wing1 = body.addOrReplaceChild("wing1", CubeListBuilder.create().texOffs(41, 22).addBox(0.0F, 0.0F, -3.0F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(54, 24).addBox(0.0F, 1.0F, 2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 1.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    public void setupAnim(T p_102392_, float p_102393_, float p_102394_, float p_102395_, float p_102396_, float p_102397_) {
//        this.head.xRot = p_102397_ * ((float)Math.PI / 180F);
//        this.head.yRot = p_102396_ * ((float)Math.PI / 180F);
//        this.beak.xRot = this.head.xRot;
//        this.beak.yRot = this.head.yRot;
//        this.redThing.xRot = this.head.xRot;
//        this.redThing.yRot = this.head.yRot;
//        this.rightLeg.xRot = Mth.cos(p_102393_ * 0.6662F) * 1.4F * p_102394_;
//        this.leftLeg.xRot = Mth.cos(p_102393_ * 0.6662F + (float)Math.PI) * 1.4F * p_102394_;
//        this.rightWing.zRot = p_102395_;
//        this.leftWing.zRot = -p_102395_;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}