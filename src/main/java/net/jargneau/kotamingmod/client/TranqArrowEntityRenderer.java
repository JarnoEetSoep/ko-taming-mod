package net.jargneau.kotamingmod.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jargneau.kotamingmod.Main;
import net.jargneau.kotamingmod.entity.TranqArrowEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class TranqArrowEntityRenderer extends ProjectileEntityRenderer<TranqArrowEntity> {

    public static final Identifier TEXTURE = new Identifier(Main.MOD_ID, "textures/entity/projectiles/tranq_arrow.png");

    public TranqArrowEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher);
    }

    @Override
    public Identifier getTexture(TranqArrowEntity tranqArrowEntity) {
        return TEXTURE;
    }

}
