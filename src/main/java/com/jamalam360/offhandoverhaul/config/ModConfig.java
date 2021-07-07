package com.jamalam360.offhandoverhaul.config;

import com.jamalam360.offhandoverhaul.OffhandOverhaulModInit;
import com.jamalam360.offhandoverhaul.OffhandPlacementType;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

/**
 * @author Jamalam360
 */

@Config(name = OffhandOverhaulModInit.MOD_ID)
public class ModConfig implements ConfigData {
    public OffhandPlacementType offhandPlacementType = OffhandPlacementType.SNEAKING;
}
