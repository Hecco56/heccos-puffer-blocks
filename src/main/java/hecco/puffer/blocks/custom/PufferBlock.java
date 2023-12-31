package hecco.puffer.blocks.custom;

import hecco.puffer.blocks.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.Items;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class PufferBlock extends HorizontalFacingBlock {

    public PufferBlock(Settings settings) {
        super(settings);
    }
    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(!entity.bypassesSteppingEffects() && entity instanceof LivingEntity livingEntity && !((LivingEntity) entity).hasStatusEffect(StatusEffects.POISON)) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 60, 1));
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getStackInHand(hand).isOf(Items.CARROT) || player.getStackInHand(hand).isOf(Items.GOLDEN_CARROT)) {
            if (!player.isCreative()) {
                player.getStackInHand(hand).decrement(1);
            }
            world.playSound(null, pos, ModSounds.PUFFER_BLOCK_BURP, SoundCategory.BLOCKS, 0.6f, 0.9f + world.random.nextFloat() / 2);
            if (state.get(FACING) == Direction.NORTH) {
                for (int i = 0; i < 4 + world.random.nextBetween(0, 4); i++) {
                    world.addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, player.getStackInHand(hand)),
                            pos.getX() + world.random.nextGaussian() / 12 + 0.5,
                            pos.getY() + 0.45,
                            pos.getZ() + world.random.nextGaussian() / 12 -0.1,
                            (world.random.nextFloat() - 0.5) / 6,
                            (world.random.nextFloat() - 0.5) / 8,
                            (world.random.nextFloat() - 0.5) / 16);
                }
            }
            if (state.get(FACING) == Direction.SOUTH) {
                for (int i = 0; i < 4 + world.random.nextBetween(0, 4); i++) {
                    world.addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, player.getStackInHand(hand)),
                            pos.getX() + world.random.nextGaussian() / 12 + 0.5,
                            pos.getY() + 0.45,
                            pos.getZ() + world.random.nextGaussian() / 12 + 1.1,
                            (world.random.nextFloat() - 0.5) / 6,
                            (world.random.nextFloat() - 0.5) / 8,
                            (world.random.nextFloat() - 0.5) / 16);
                }
            }
            if (state.get(FACING) == Direction.WEST) {
                for (int i = 0; i < 4 + world.random.nextBetween(0, 4); i++) {
                    world.addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, player.getStackInHand(hand)),
                            pos.getX() + world.random.nextGaussian() / 12 - 0.1,
                            pos.getY() + 0.45,
                            pos.getZ() + world.random.nextGaussian() / 12 + 0.5,
                            (world.random.nextFloat() - 0.5) / 6,
                            (world.random.nextFloat() - 0.5) / 8,
                            (world.random.nextFloat() - 0.5) / 16);
                }
            }
            if (state.get(FACING) == Direction.EAST) {
                for (int i = 0; i < 4 + world.random.nextBetween(0, 4); i++) {
                    world.addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, player.getStackInHand(hand)),
                            pos.getX() + world.random.nextGaussian() / 12 + 1.1,
                            pos.getY() + 0.45,
                            pos.getZ() + world.random.nextGaussian() / 12 + 0.5,
                            (world.random.nextFloat() - 0.5) / 6,
                            (world.random.nextFloat() - 0.5) / 8,
                            (world.random.nextFloat() - 0.5) / 16);
                }
            }
            return ActionResult.SUCCESS;
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}

