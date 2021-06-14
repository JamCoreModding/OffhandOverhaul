package com.jamalam360.config;

import com.jamalam360.OffhandOverhaulModInit;
import com.jamalam360.OffhandPlacementType;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

/**
 * @author Jamalam360
 */

@Config(name = OffhandOverhaulModInit.MOD_ID)
public class ModConfig implements ConfigData {
    public OffhandPlacementType offhandPlacementType = OffhandPlacementType.SNEAKING;
}
