package me.StevenLawson.TotalFreedom.Commands;
import me.StevenLawson.TotalFreedom.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@commandpermissions(Level = AdminLevel.SUPER, source = SourceType.PlayerOnly)
@commandparameters(description = "Shoot people with a non-existant bow!", usage = "/<command> [playername]")
public class Command_shoot extends TFM_Command
{
@override
public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args)
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

shoot(p);

return true;
}

public static void shoot(final Player p)
{
TFM_Util.playerMsg(p.getName() + " has been shot!",ChatColor.RED);
//Shooting Arrow
final Location target_pos = p.getLocation();
final World world = p.getWorld();
for (int x = -1; x <= 1; x++)
{
for (int z = -1; z <= 1; z++)
{
final Location strike_pos = new Location(world, target_pos.getBlockX() + x, target_pos.getBlockY(), target_pos.getBlockZ() + z);
player.ShootArrow(strike_pos);
}
}