package net.jargneau.kotamingmod.entity;

import net.minecraft.item.Item;

import java.util.Map;

public interface KOTamableEntity {

    Map<Item, Integer> getTamingFood();

}
