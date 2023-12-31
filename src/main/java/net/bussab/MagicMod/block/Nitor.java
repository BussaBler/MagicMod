package net.bussab.MagicMod.block;

import net.bussab.MagicMod.block.entities.NitorEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Nitor extends BaseEntityBlock {

    public String dye; 
    protected static final VoxelShape SHAPE = Shapes.box(0.25, 0.25, 0.25, 0.75, 0.75, 0.75);

    public Nitor(Properties pProperties, String pColor) {
        super(pProperties);
        this.dye = pColor; 
        
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        
        return new NitorEntity(pPos, pState);
    }

    public float getBlue(){
        
        return Integer.parseInt(dye.substring(4, 6), 16);
    }

    public float getGreen(){
        
        return Integer.parseInt(dye.substring(2, 4), 16);
    }

    public float getRed(){
        
        return Integer.parseInt(dye.substring(0, 2), 16);
    }

    

    @Override 
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom){
        
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMooving){
        if (pState.hasBlockEntity() && (!pState.is(pNewState.getBlock()) || !pNewState.hasBlockEntity())) {
            pLevel.removeBlockEntity(pPos);
        }
    }
    
}   
