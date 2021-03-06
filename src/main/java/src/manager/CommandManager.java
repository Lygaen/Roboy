package src.manager;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.requests.RestAction;
import src.others.Common;
import src.others.Config;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class CommandManager {
    private static CommandBase getCommand(String search) {
        String searchLower = search.toLowerCase();

        for (CommandBase cmd : Config.commands) {
            if (cmd.getName().equals(searchLower) || cmd.getAliases().contains(searchLower)) {
                return cmd;
            }
        }

        return null;
    }


    public static void handle(GuildMessageReceivedEvent event) {
        String[] split = event.getMessage().getContentRaw()
                .replaceFirst("(?i)" + Pattern.quote(Config.prefix), "")
                .split("\\s+");

        String invoke = split[0].toLowerCase();
        CommandBase cmd = getCommand(invoke);

        if (cmd != null) {
            List<String> args = Arrays.asList(split).subList(1, split.length);

            CommandContext ctx = new CommandContext(event, args);

            if (cmd.ownerOnly() && !ctx.getUser().getId().equals(Config.owner_id)) { Common.notOwner(ctx); }

            if (cmd.adminOnly() && !ctx.getMember().getPermissions().contains(Permission.ADMINISTRATOR)) { Common.notAdmin(ctx); }

            Permission perm = cmd.requirePermission();

            if (perm != null && !ctx.getMember().getPermissions().contains(perm)) { Common.missingPermission(perm, ctx);}
            cmd.handle(ctx);
        }
    }
}
