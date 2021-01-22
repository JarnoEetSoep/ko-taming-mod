package net.jargneau.kotamingmod.mixin;

import net.jargneau.kotamingmod.Main;
import net.jargneau.kotamingmod.Register;
import net.jargneau.kotamingmod.gui.MobInventoryScreenHandler;
import net.jargneau.kotamingmod.gui.PlayerInventoryScreenHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class MixinPlayerEntity extends LivingEntity {

    protected MixinPlayerEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("HEAD"), method = "interact", cancellable = true)
    public void interact(Entity entity, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        PlayerEntity self = (PlayerEntity) (Object) this;

        if(self.getEntityWorld().isClient || !(entity instanceof LivingEntity))
            return;

        LivingEntity target = (LivingEntity) entity;

        if(target.hasStatusEffect(Register.KNOCKOUT) && !Main.playersOpenedInventory.contains(self.getUuidAsString())) {

            if(entity instanceof MobEntity)
                self.openHandledScreen(new SimpleNamedScreenHandlerFactory((syncId, inv, playerEntity) ->
                        new MobInventoryScreenHandler(syncId, self.inventory, Main.mobInventories.get(entity.getUuidAsString()), 3),
                        target.getDisplayName()
                ));
            else
                self.openHandledScreen(new SimpleNamedScreenHandlerFactory((syncId, inv, playerEntity) ->
                        new PlayerInventoryScreenHandler(syncId, self.inventory, ((PlayerEntity) entity).inventory),
                        target.getDisplayName()
                ));

            Main.playersOpenedInventory.add(self.getUuidAsString());

            cir.setReturnValue(ActionResult.SUCCESS);
        }
    }

}
