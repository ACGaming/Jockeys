package mod.acgaming.batjockeys.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import mod.acgaming.batjockeys.BatJockeys;
import mod.acgaming.batjockeys.client.renderer.entity.SkeletonBatModel;
import mod.acgaming.batjockeys.client.renderer.entity.SkeletonBatRenderer;
import mod.acgaming.batjockeys.client.renderer.entity.VexBatModel;
import mod.acgaming.batjockeys.client.renderer.entity.VexBatRenderer;
import mod.acgaming.batjockeys.init.BatJockeysRegistry;

@Mod.EventBusSubscriber(modid = BatJockeys.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientHandler
{
    public static ModelLayerLocation SKELETON_BAT_LAYER = new ModelLayerLocation(new ResourceLocation(BatJockeys.MOD_ID, "skeleton_bat"), "skeleton_bat");
    public static ModelLayerLocation VEX_BAT_LAYER = new ModelLayerLocation(new ResourceLocation(BatJockeys.MOD_ID, "vex_bat"), "vex_bat");

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(BatJockeysRegistry.SKELETON_BAT.get(), SkeletonBatRenderer::new);
        event.registerEntityRenderer(BatJockeysRegistry.VEX_BAT.get(), VexBatRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinition(final EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(SKELETON_BAT_LAYER, SkeletonBatModel::createBodyLayer);
        event.registerLayerDefinition(VEX_BAT_LAYER, VexBatModel::createBodyLayer);
    }

    public static void init()
    {
    }
}