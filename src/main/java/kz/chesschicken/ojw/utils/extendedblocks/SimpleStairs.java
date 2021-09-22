package kz.chesschicken.ojw.utils.extendedblocks;

import kz.chesschicken.ojw.utils.structure.WorldUtils;
import net.minecraft.block.material.Material;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.block.BlockRenderer;
import net.minecraft.entity.Living;
import net.minecraft.level.BlockView;
import net.minecraft.level.Level;
import net.minecraft.util.maths.Box;
import net.minecraft.util.maths.MathHelper;
import net.modificationstation.stationapi.api.client.model.block.BlockWithInventoryRenderer;
import net.modificationstation.stationapi.api.client.model.block.BlockWithWorldRenderer;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

public class SimpleStairs extends TemplateBlockBase implements BlockWithWorldRenderer, BlockWithInventoryRenderer {

    public SimpleStairs(Identifier identifier, Material material) {
        super(identifier, material);
        this.setLightOpacity(255);
    }

    @Override
    public void afterPlaced(Level level, int x, int y, int z, Living living) {
        WorldUtils.setMeta(level, x, y, z, MathHelper.floor((double)(living.yaw * 4.0F / 360.0F) + 0.5D) & 3);
    }

    public void updateBoundingBox(BlockView tileView, int x, int y, int z) {
        this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void doesBoxCollide(Level level, int x, int y, int z, Box box, ArrayList blocksThatCollide) {
        int meta = level.getTileMeta(x, y, z) % 4;
        if (meta == 0) {
            this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
            super.doesBoxCollide(level, x, y, z, box, blocksThatCollide);
            this.setBoundingBox(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
            super.doesBoxCollide(level, x, y, z, box, blocksThatCollide);
        } else if (meta == 1) {
            this.setBoundingBox(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            super.doesBoxCollide(level, x, y, z, box, blocksThatCollide);
            this.setBoundingBox(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            super.doesBoxCollide(level, x, y, z, box, blocksThatCollide);
        } else if (meta == 2) {
            this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
            super.doesBoxCollide(level, x, y, z, box, blocksThatCollide);
            this.setBoundingBox(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
            super.doesBoxCollide(level, x, y, z, box, blocksThatCollide);
        } else if (meta == 3) {
            this.setBoundingBox(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
            super.doesBoxCollide(level, x, y, z, box, blocksThatCollide);
            this.setBoundingBox(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.doesBoxCollide(level, x, y, z, box, blocksThatCollide);
        }
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public void renderWorld(BlockRenderer tileRenderer, BlockView tileView, int x, int y, int z) {
        int meta = tileView.getTileMeta(x, y, z) % 4;

        if (meta == 0) {
            this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
            tileRenderer.renderStandardBlock(this, x, y, z);
            this.setBoundingBox(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
            tileRenderer.renderStandardBlock(this, x, y, z);
        } else if (meta == 1) {
            this.setBoundingBox(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            tileRenderer.renderStandardBlock(this, x, y, z);
            this.setBoundingBox(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            tileRenderer.renderStandardBlock(this, x, y, z);
        } else if (meta == 2) {
            this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
            tileRenderer.renderStandardBlock(this, x, y, z);
            this.setBoundingBox(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
            tileRenderer.renderStandardBlock(this, x, y, z);
        } else if (meta == 3) {
            this.setBoundingBox(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
            tileRenderer.renderStandardBlock(this, x, y, z);
            this.setBoundingBox(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            tileRenderer.renderStandardBlock(this, x, y, z);
        }
    }

    @Override
    public void renderInventory(BlockRenderer tileRenderer, int meta) {
        meta %= 4;
        Tessellator instance = Tessellator.INSTANCE;
        for(int q = 0; q < 2; ++q) {
            if (q == 0)
                this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);

            if (q == 1)
                this.setBoundingBox(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);

            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            instance.start();
            instance.setNormal(0.0F, -1.0F, 0.0F);
            tileRenderer.renderBottomFace(this, 0.0D, 0.0D, 0.0D, this.getTextureForSide(0, meta));
            instance.draw();
            instance.start();
            instance.setNormal(0.0F, 1.0F, 0.0F);
            tileRenderer.renderTopFace(this, 0.0D, 0.0D, 0.0D, this.getTextureForSide(1, meta));
            instance.draw();
            instance.start();
            instance.setNormal(0.0F, 0.0F, -1.0F);
            tileRenderer.renderEastFace(this, 0.0D, 0.0D, 0.0D, this.getTextureForSide(2, meta));
            instance.draw();
            instance.start();
            instance.setNormal(0.0F, 0.0F, 1.0F);
            tileRenderer.renderWestFace(this, 0.0D, 0.0D, 0.0D, this.getTextureForSide(3, meta));
            instance.draw();
            instance.start();
            instance.setNormal(-1.0F, 0.0F, 0.0F);
            tileRenderer.renderNorthFace(this, 0.0D, 0.0D, 0.0D, this.getTextureForSide(4, meta));
            instance.draw();
            instance.start();
            instance.setNormal(1.0F, 0.0F, 0.0F);
            tileRenderer.renderSouthFace(this, 0.0D, 0.0D, 0.0D, this.getTextureForSide(5));
            instance.draw();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        }
    }
}
