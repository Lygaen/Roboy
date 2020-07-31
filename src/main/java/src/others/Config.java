package src.others;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import src.manager.CommandBase;

import java.util.ArrayList;
import java.util.List;

public class Config {

    public static List<CommandBase> commands = new ArrayList<>();
    public static List<CommandBase> owner_commands = new ArrayList<>();
    public static List<CommandBase> admin_commands = new ArrayList<>();
    public static List<CommandBase> fun_commands = new ArrayList<>();

    public static String token = "NzM4MDQ4NjAyMzc0NjY4Mjk4.XyGPUw.i95beCoOkcX6pj0TFN6CCr9eYS0";
    public static String prefix = "!";
    public static String owner_id = "413743021759135745";

    public static Activity activity = Activity.watching("getting programmed...");

    public static OnlineStatus status = OnlineStatus.DO_NOT_DISTURB;
}
