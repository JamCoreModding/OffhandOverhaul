package com.jamalam360;

import com.jamalam360.config.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OffhandOverhaulModInit implements ModInitializer {
    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "offhandoverhaul";
    public static final String MOD_NAME = "Offhand Overhaul";

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing " + MOD_NAME + " under the ID '" + MOD_ID + "'");

        AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
    }

    public static void log(Level level, String message){
        LOGGER.log(level, message);
    }
}