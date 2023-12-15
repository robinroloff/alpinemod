package de.robin.alpine.entity.model;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class MarmotModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "murmeltier"), "main");
	private final ModelPart body;

	public MarmotModel(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 11).addBox(-3.0F, -3.0F, -10.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 1.0F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(25, 10).addBox(-4.0F, -8.0F, -5.1F, 7.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.309F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(60, 14).addBox(-3.0F, -4.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 17).addBox(1.0F, -4.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(57, 18).addBox(0.0F, -1.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(57, 18).addBox(-2.0F, -1.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(7, 23).addBox(-2.0F, -4.0F, -2.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -9.0F));

		PartDefinition backLegL = body.addOrReplaceChild("backLegL", CubeListBuilder.create().texOffs(21, 12).addBox(-0.1F, 5.0F, -2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(48, 9).addBox(-0.1F, 1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.1F, 1.0F, 2.0F));

		PartDefinition backLegL_r1 = backLegL.addOrReplaceChild("backLegL_r1", CubeListBuilder.create().texOffs(11, 0).addBox(-0.5F, -2.5F, -2.6F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4F, 1.9F, -1.1F, -0.2618F, 0.0F, 0.0F));

		PartDefinition backLegR = body.addOrReplaceChild("backLegR", CubeListBuilder.create().texOffs(48, 9).addBox(-2.9F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(21, 12).addBox(-2.9F, 4.0F, -2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.1F, 2.0F, 2.0F));

		PartDefinition backLegR_r1 = backLegR.addOrReplaceChild("backLegR_r1", CubeListBuilder.create().texOffs(11, 0).addBox(-8.5F, -2.5F, -2.6F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6F, 0.9F, -1.1F, -0.2618F, 0.0F, 0.0F));

		PartDefinition frontLegL = body.addOrReplaceChild("frontLegL", CubeListBuilder.create().texOffs(21, 12).addBox(-0.2F, 8.0F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(46, 2).addBox(-0.2F, 5.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.2F, -2.0F, -5.0F));

		PartDefinition frontLegL_r1 = frontLegL.addOrReplaceChild("frontLegL_r1", CubeListBuilder.create().texOffs(24, 1).addBox(-0.5F, -2.2F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3F, 4.0F, 0.0F, -0.2672F, -0.0102F, 0.0023F));

		PartDefinition frontLegR = body.addOrReplaceChild("frontLegR", CubeListBuilder.create().texOffs(46, 2).addBox(-2.8F, 5.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(21, 12).addBox(-2.8F, 8.0F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.2F, -2.0F, -5.0F));

		PartDefinition frontLegR_r1 = frontLegR.addOrReplaceChild("frontLegR_r1", CubeListBuilder.create().texOffs(24, 1).addBox(-8.5F, -2.2F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7F, 4.0F, 0.0F, -0.2672F, -0.0102F, 0.0023F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 3.0F, 6.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition tail_r1 = tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(56, 6).addBox(-1.5F, -1.3F, -0.6F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 1.9022F, 4.1765F, 1.9199F, 0.0F, 0.0F));

		PartDefinition tail_r2 = tail.addOrReplaceChild("tail_r2", CubeListBuilder.create().texOffs(36, 0).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.2663F, 0.2869F, 1.0908F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}