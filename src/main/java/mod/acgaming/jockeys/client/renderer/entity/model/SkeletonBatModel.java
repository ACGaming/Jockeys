package mod.acgaming.jockeys.client.renderer.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SkeletonBatModel extends ModelBase
{
    public final ModelRenderer batHead;
    public final ModelRenderer batBody;
    public final ModelRenderer batRightWing;
    public final ModelRenderer batLeftWing;
    public final ModelRenderer batOuterRightWing;
    public final ModelRenderer batOuterLeftWing;

    public SkeletonBatModel()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.batHead = new ModelRenderer(this, 0, 0);
        this.batHead.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6);
        ModelRenderer modelrenderer = new ModelRenderer(this, 24, 0);
        modelrenderer.addBox(-4.0F, -6.0F, -2.0F, 3, 4, 1);
        this.batHead.addChild(modelrenderer);
        ModelRenderer modelRenderer = new ModelRenderer(this, 24, 0);
        modelRenderer.mirror = true;
        modelRenderer.addBox(1.0F, -6.0F, -2.0F, 3, 4, 1);
        this.batHead.addChild(modelRenderer);
        this.batBody = new ModelRenderer(this, 0, 16);
        this.batBody.addBox(-3.0F, 4.0F, -3.0F, 6, 12, 6);
        this.batBody.setTextureOffset(0, 34).addBox(-5.0F, 16.0F, 0.0F, 10, 6, 1);
        this.batRightWing = new ModelRenderer(this, 42, 0);
        this.batRightWing.addBox(-12.0F, 1.0F, 1.5F, 10, 16, 1);
        this.batOuterRightWing = new ModelRenderer(this, 24, 16);
        this.batOuterRightWing.setRotationPoint(-12.0F, 1.0F, 1.5F);
        this.batOuterRightWing.addBox(-8.0F, 1.0F, 0.0F, 8, 12, 1);
        this.batLeftWing = new ModelRenderer(this, 42, 0);
        this.batLeftWing.mirror = true;
        this.batLeftWing.addBox(2.0F, 1.0F, 1.5F, 10, 16, 1);
        this.batOuterLeftWing = new ModelRenderer(this, 24, 16);
        this.batOuterLeftWing.mirror = true;
        this.batOuterLeftWing.setRotationPoint(12.0F, 1.0F, 1.5F);
        this.batOuterLeftWing.addBox(0.0F, 1.0F, 0.0F, 8, 12, 1);
        this.batBody.addChild(this.batRightWing);
        this.batBody.addChild(this.batLeftWing);
        this.batRightWing.addChild(this.batOuterRightWing);
        this.batLeftWing.addChild(this.batOuterLeftWing);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        this.batHead.render(scale);
        this.batBody.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity)
    {
        this.batHead.rotateAngleX = headPitch * 0.017453292F;
        this.batHead.rotateAngleY = netHeadYaw * 0.017453292F;
        this.batHead.rotateAngleZ = 0.0F;
        this.batHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.batRightWing.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.batLeftWing.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.batBody.rotateAngleX = ((float) Math.PI / 4F) + MathHelper.cos(ageInTicks * 0.1F) * 0.15F;
        this.batBody.rotateAngleY = 0.0F;
        this.batRightWing.rotateAngleY = MathHelper.cos(ageInTicks * 0.8F) * (float) Math.PI * 0.25F;
        this.batLeftWing.rotateAngleY = -this.batRightWing.rotateAngleY;
        this.batOuterRightWing.rotateAngleY = this.batRightWing.rotateAngleY * 0.5F;
        this.batOuterLeftWing.rotateAngleY = -this.batRightWing.rotateAngleY * 0.5F;
    }
}
