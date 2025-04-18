package net.bon.oddsnends.particle.type;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ManaRuneParticle extends BaseAshSmokeParticle {
    private final SpriteSet spriteSet;

     ManaRuneParticle(ClientLevel level, double x, double y, double z, double velocityX, double velocityY, double velocityZ, float scaleMultiplier, SpriteSet spriteSet) {
        super(level, x, y, z, 3.0f, 4.0f, 3.0f, velocityX, velocityY, velocityZ, scaleMultiplier, spriteSet, 0.3f, 8, -1.0f, true);
        this.friction = 0.03F;
        this.spriteSet = spriteSet;
        this.rCol = 1.0f;
        this.gCol = 1.0f;
        this.bCol = 1.0f;
        this.quadSize *= 0.78564554f;
        int i = (int)(32.0 / (Math.random()* 0.8 + 0.2));
        this.lifetime = (int)Math.max((float)i * 0.9f, 1.0f);
        this.hasPhysics = false;
    }

    @Override
    protected int getLightColor(float f) {
        return 15728880;
    }

    @Override
    public @NotNull ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public float getQuadSize(float tickDelta) {
        return this.quadSize * Mth.clamp(((float)this.age + tickDelta) / (float)this.lifetime * 32.0f, 0.0f, 1.0f);
    }

    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Factory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType particleOptions, ClientLevel clientLevel, double d, double e, double f, double g, double h, double i) {
            return new ManaRuneParticle(clientLevel, d, e, f, g, h, i, 0.7f, this.spriteSet);
        }
    }
}
