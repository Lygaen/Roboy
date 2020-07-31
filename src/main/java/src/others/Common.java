package src.others;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import src.manager.CommandBase;
import src.manager.CommandContext;
import src.shield.Category;

import java.awt.*;

import static src.others.Config.*;


public class Common {
    public static void notOwner(CommandContext ctx) {
        EmbedBuilder e = new EmbedBuilder()
                .setTitle("NOT OWNER")
                .setColor(Color.RED)
                .setDescription("You need to be the owner of the bot to use this command.");
        ctx.reply(e.build());
    }

    public static void notAdmin(CommandContext ctx) {
        EmbedBuilder e = new EmbedBuilder()
                .setTitle("NOT ADMIN")
                .setColor(Color.RED)
                .setDescription("You need to be the admin of the Server to use this command.");
        ctx.reply(e.build());
    }

    public static void missingPermission(Permission perm, CommandContext ctx) {
        EmbedBuilder e = new EmbedBuilder()
                .setTitle("MISSING PERM")
                .setColor(Color.RED)
                .setDescription("You need to have the permission `" + perm.getName() + "` to use this command.");
        ctx.reply(e.build());
    }


    public static void addCommand(CommandBase cmd) {
        commands.add(cmd);
        switch(cmd.getCategory()) {
            case Category.OWNER:
                owner_commands.add(cmd);
                break;
            case Category.ADMIN:
                admin_commands.add(cmd);
                break;
            case Category.FUN:
                fun_commands.add(cmd);
                break;
        }
    }
}
