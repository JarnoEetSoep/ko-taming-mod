package net.jargneau.kotamingmod.entity;

import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Map;

public interface KOTamableEntity {

    ArrayList<Map<Item, Integer>> getTamingFood();

}
