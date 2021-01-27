package me.border.portalcalculator.commands;

import me.border.spigotutilities.command.ICommand;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.border.spigotutilities.baseutils.CommandUtils.*;
import static me.border.spigotutilities.baseutils.ChatUtils.*;

public class PortalCommand extends ICommand {
    public PortalCommand() {
        super("portal", true, "");
    }

    @Override
    public boolean commandUsed(CommandSender sender, String[] args) {
        if (!argsCheck(sender, 0, args)) return false;
        Player player = (Player) sender;
        World.Environment worldType = player.getWorld().getEnvironment();
        if (worldType == World.Environment.NETHER){
            Location loc = player.getLocation();
            double x = getX(loc, true);
            double z = getZ(loc, true);
            sendMsg(sender, "PortalCommand.NetherToNormal", "%x%", String.valueOf(Math.round(x)), "%z%", String.valueOf(Math.round(z)));
        } else if (worldType == World.Environment.NORMAL){
            Location loc = player.getLocation();
            double x = getX(loc, false);
            double z = getZ(loc, false);
            sendMsg(sender, "PortalCommand.NormalToNether", "%x%", String.valueOf(Math.round(x)), "%z%", String.valueOf(Math.round(z)));
        } else {
            sendMsg(player, "PortalCommand.IllegalWorld");
        }

        return true;
    }

    public double getX(Location location, boolean multiply){
        if (multiply){
            return location.getX() * 8;
        } else {
            return location.getX() / 8;
        }
    }

    public double getZ(Location location, boolean multiply){
        if (multiply){
            return location.getZ() * 8;
        } else {
            return location.getZ() / 8;
        }
    }
}
