package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Close to banning someone? Warn them first!.", usage = "/<command> [playername]")
public class Command_rwarn extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 1)
        {
            return false;
        }

        Player p;
        try
        {
            p = getPlayer(args[0]);
        }
        catch (CantFindPlayerException ex)
        {
            playerMsg(ex.getMessage(), ChatColor.RED);
            return true;
        }

        rwarn(p);

        return true;
    }

    public static void rwarn(final Player p)
    {
        TFM_Util.bcastMsg(p.getName() + ", Do not do those actions.   sender.getName() is really close to banning you. Now stop.", ChatColor.RED);

        p.setOp(false);

        p.setGameMode(GameMode.SURVIVAL);


    }
}
