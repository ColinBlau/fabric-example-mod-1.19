package net.colin.wierd;

import net.fabricmc.api.ModInitializer;
import net.colin.wierd.itemclasses.SuspiciousBeef;
import net.colin.wierd.itemclasses.TastelessBrick;
import net.colin.wierd.itemclasses.TheBug;
import net.colin.wierd.itemclasses.TrollingTable;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColinWierdMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("cwierd");



	//initialise Items
	/*public static final Item tastelessBrick =
			Registry.register(Registries.ITEM, new Identifier("wtf","tasteless_brick"),
			new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.6F).build())));
	 */

	//initialise Sounds
	public static final Identifier SECRET_MUSIC_ID = new Identifier("cwierd:secret_music");
	public static SoundEvent SECRET_MUSIC_EVENT = SoundEvent.of(SECRET_MUSIC_ID);


	//register Items (those who are initialised in their separate classes)
	public static final Item THE_BUG =
			Registry.register(Registries.ITEM, new Identifier("wtf", "the_bug"),
					new TheBug(new FabricItemSettings()));

	public static final Item TASTELESS_BRICK =
			Registry.register(Registries.ITEM, new Identifier("wtf", "tasteless_brick"),
					new TastelessBrick(new FabricItemSettings()));
	// TODO: 5/20/2023 not working currently: MusicDiscItem can be put into Juke Box but nothing happens after that -> no music

	public static final Item SUSPICIOUS_BEEF =
			Registry.register(Registries.ITEM, new Identifier("wtf", "suspicious_beef"),
					new SuspiciousBeef(7, SECRET_MUSIC_EVENT, new FabricItemSettings().maxCount(1), 139));


	//Initialise Blocks
	public static final Block TROLLING_TABLE =
			new TrollingTable(FabricBlockSettings.of(Material.WOOD).strength(2.5f));

	//initialise ItemGroups
	private static final ItemGroup COLINS_WIERD_SHIT = FabricItemGroup.builder(new Identifier("wtf", "wierd_shit"))
			.icon(() -> new ItemStack(TASTELESS_BRICK))
			.build();

	private static final ItemGroup NOT_FUNCTIONAL = FabricItemGroup.builder(new Identifier("wtf", "not_functional"))
			.icon(() -> new ItemStack(THE_BUG))
			.build();


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("The weird Logger from a Colin mod went through, I guess");

		//register SoundEvents
		Registry.register(Registries.SOUND_EVENT, net.colin.wierd.ColinWierdMod.SECRET_MUSIC_ID, SECRET_MUSIC_EVENT);

		//register blocks
		Registry.register(Registries.BLOCK, new Identifier("wtf", "trolling_table"), TROLLING_TABLE);
		Registry.register(Registries.ITEM, new Identifier("wtf", "trolling_table"), new BlockItem(TROLLING_TABLE, new FabricItemSettings()));

		//register ItemGroups
		ItemGroupEvents.modifyEntriesEvent(COLINS_WIERD_SHIT).register(content -> {
			content.add(TASTELESS_BRICK);
		});
		ItemGroupEvents.modifyEntriesEvent(NOT_FUNCTIONAL).register(content -> {
			content.add(THE_BUG);
			content.add(SUSPICIOUS_BEEF);
			content.add(TROLLING_TABLE);
		});
	}
}
