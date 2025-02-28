package com.lowdragmc.multiblocked.api.capability.proxy;

import com.lowdragmc.multiblocked.api.capability.MultiblockCapability;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;
import java.util.Objects;

/**
 * The Proxy of a Capability {@link Capability}
 */
public abstract class CapCapabilityProxy<C, K> extends CapabilityProxy<K>{
    public final Capability<? extends C> CAP;

    public CapCapabilityProxy(MultiblockCapability<? super K> capability, BlockEntity tileEntity, Capability<? extends C> cap) {
        super(capability, tileEntity);
        CAP = cap;
    }

    public C getCapability(@Nullable String slotName) {
        return super.getCapability(CAP, slotName);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CapCapabilityProxy && Objects.equals(getCapability(null), ((CapCapabilityProxy<?, ?>) obj).getCapability(null));
    }
}
