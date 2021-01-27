package me.border.portalcalculator;

import me.border.portalcalculator.commands.PortalCommand;
import me.border.spigotutilities.plugin.Setting;
import me.border.spigotutilities.plugin.SpigotPlugin;

public class PortalCalculator extends SpigotPlugin {

    @Override
    protected void enable() {
        new PortalCommand();
    }

    @Override
    protected void load() {
        getSettings().add(Setting.DISABLE_ENTITY_REFERENCE);
    }

    @Override
    protected void disable() {

    }
}
