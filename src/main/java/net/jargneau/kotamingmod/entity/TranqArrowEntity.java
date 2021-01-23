package net.jargneau.kotamingmod.entity;

import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.impl.networking.ServerSidePacketRegistryImpl;
import net.jargneau.kotamingmod.Main;
import net.jargneau.kotamingmod.Register;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

import java.util.UUID;

public class TranqArrowEntity extends PersistentProjectileEntity {

    public static Identifier SPAWN_PACKET = new Identifier(Main.MOD_ID, "tranq_arrow_entity");

    public TranqArrowEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public TranqArrowEntity(LivingEntity owner, World world) {
        super(Register.TRANQ_ARROW_ENTITYTYPE, owner, world);
    }

    @Environment(EnvType.CLIENT)
    public TranqArrowEntity(World world, double x, double y, double z, int id, UUID uuid) {
        super(Register.TRANQ_ARROW_ENTITYTYPE, x, y, z, world);
        updateTrackedPosition(x, y, z);
        setEntityId(id);
        setUuid(uuid);
    }

    @Override
    public Packet<?> createSpawnPacket() {
        PacketByteBuf packet = new PacketByteBuf(Unpooled.buffer());

        packet.writeDouble(getX());
        packet.writeDouble(getY());
        packet.writeDouble(getZ());

        packet.writeInt(getEntityId());
        packet.writeUuid(getUuid());

        return ServerSidePacketRegistryImpl.INSTANCE.toPacket(SPAWN_PACKET, packet);
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(Register.TRANQ_ARROW);
    }

    @Override
    public void onEntityHit(EntityHitResult hitResult) {
        super.onEntityHit(hitResult);

        if(!this.world.isClient) {
            if(!(hitResult.getEntity() instanceof TorporEntity))
                return;

            TorporEntity victim = (TorporEntity) hitResult.getEntity();

            victim.setTorpor(victim.getTorpor() + 25);
        }
    }

}
