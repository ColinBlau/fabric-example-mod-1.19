package net.colin.wierd.itemclasses;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class TheBug extends Item{

    public TheBug(Settings settings){
        super(settings.food((new FoodComponent.Builder())
                .hunger(1).saturationModifier(0.6F).build()));
    }

    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        // default white text
        tooltip.add(Text.translatable("Yes, this is supposed to be here..."));
    }
}

