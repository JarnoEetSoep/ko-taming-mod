package net.jargneau.kotamingmod.mixin;

import net.jargneau.kotamingmod.Main;
import net.jargneau.kotamingmod.Register;
import net.jargneau.kotamingmod.entity.InventoryMob;
import net.jargneau.kotamingmod.entity.TorporEntity;
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
public abstract class MixinPlayerEntity extends LivingEntity implements TorporEntity {

    private int torpor;
    private final int BASETORPOR = Main.getBaseTorporConfig().basePlayerTorpor;

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

            if(entity instanceof InventoryMob)
                self.openHandledScreen(new SimpleNamedScreenHandlerFactory((syncId, inv, playerEntity) ->
                        new MobInventoryScreenHandler(syncId, self.inventory, ((InventoryMob) entity).getInventory(), 3),
                        target.getDisplayName()
                ));
            else if(entity instanceof PlayerEntity)
                self.openHandledScreen(new SimpleNamedScreenHandlerFactory((syncId, inv, playerEntity) ->
                        new PlayerInventoryScreenHandler(syncId, self.inventory, ((PlayerEntity) entity).inventory),
                        target.getDisplayName()
                ));
            else
                cir.setReturnValue(ActionResult.FAIL);

            Main.playersOpenedInventory.add(self.getUuidAsString());
            cir.setReturnValue(ActionResult.SUCCESS);
        }
    }

    @Override
    public int getTorpor() {
        return this.torpor;
    }

    @Override
    public void setTorpor(int amount) {
        this.torpor = amount;

        if(this.torpor > this.BASETORPOR)
            this.torpor = this.BASETORPOR;

        if(this.torpor < 0)
            this.torpor = 0;
    }

    @Override
    public int getBaseTorpor() {
        return this.BASETORPOR;
    }

    @Override
    public void tickTorpor() {
        return;
    }

}
