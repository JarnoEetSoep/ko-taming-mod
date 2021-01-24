package net.jargneau.kotamingmod.entity;

import net.minecraft.entity.player.PlayerEntity;

public interface TorporEntity {

    int getTorpor();

    void setTorpor(int amount);

    int getBaseTorpor();

    void tickTorpor();

    void setKnockedOutBy(PlayerEntity shooter);

}
