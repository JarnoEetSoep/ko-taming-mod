package net.jargneau.kotamingmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.networking.ClientSidePacketRegistryImpl;
import net.jargneau.kotamingmod.client.TranqArrowEntityRenderer;
import net.jargneau.kotamingmod.entity.TranqArrowEntity;
import net.minecraft.client.MinecraftClient;

import java.util.UUID;

@Environment(EnvType.CLIENT)
public class Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(Register.TRANQ_ARROW_ENTITYTYPE, (entityRenderDispatcher, context) -> new TranqArrowEntityRenderer(entityRenderDispatcher));

        ClientSidePacketRegistryImpl.INSTANCE.register(TranqArrowEntity.SPAWN_PACKET, (context, packet) -> {
            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

            int entityID = packet.readInt();
            UUID entityUUID = packet.readUuid();

            context.getTaskQueue().execute(() -> {
                TranqArrowEntity projectile = new TranqArrowEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, projectile);
            });
        });
    }

}
