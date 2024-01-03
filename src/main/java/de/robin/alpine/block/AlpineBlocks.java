package de.robin.alpine.block;

import de.robin.alpine.AlpineMod;
import de.robin.alpine.item.AlpineItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class AlpineBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AlpineMod.MODID);

    public static final RegistryObject<Block> EDELWEISS = registerBlock("edelweiss",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.OXEYE_DAISY).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_EDELWEISS = BLOCKS.register("potted_edelweiss",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), AlpineBlocks.EDELWEISS,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_OXEYE_DAISY).noOcclusion()));

    public static final RegistryObject<Block> ENZIAN = registerBlock("enzian",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.CORNFLOWER).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_ENZIAN = BLOCKS.register("potted_enzian",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), AlpineBlocks.ENZIAN,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_CORNFLOWER).noOcclusion()));

    public static final RegistryObject<Block> RESIN = registerBlock("resin",
            () -> new VineBlock(
                    BlockBehaviour.Properties.of().replaceable().noCollission().
                            randomTicks().strength(0.2F).sound(SoundType.VINE).ignitedByLava().pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> MOREL_MUSHROOM = registerBlock("morel_mushroom",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_MOREL_MUSHROOM = BLOCKS.register("potted_morel_mushroom",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), AlpineBlocks.MOREL_MUSHROOM,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_BROWN_MUSHROOM).noOcclusion()));

    public static final RegistryObject<Block> SALT_BLOCK = registerBlock("salt_block", () -> new Block
            (BlockBehaviour.Properties.copy(Blocks.ANDESITE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return AlpineItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
