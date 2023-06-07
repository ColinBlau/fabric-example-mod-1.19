package net.colin.wierd.itemclasses;

import net.fabricmc.fabric.impl.transfer.fluid.EmptyBucketStorage;
import net.fabricmc.fabric.impl.transfer.fluid.WaterPotionStorage;
import net.minecraft.item.BucketItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.GlassBottleItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;

public class TastelessBrick extends Item{

    public TastelessBrick(Item.Settings settings){
        super(settings
                .food(new FoodComponent.Builder().hunger(14).saturationModifier(0.6F).build()));
    }


}
