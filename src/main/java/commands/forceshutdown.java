package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import src.manager.CommandBase;
import src.manager.CommandContext;
import src.shield.Category;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class forceshutdown implements CommandBase {
    @Override
    public void handle(CommandContext ctx) {
        EmbedBuilder e = new EmbedBuilder()
                .setTitle("Killing...")
                .setDescription("Bot is getting killed...")
                .setColor(Color.GREEN);
        Consumer<Message> cm = (response) -> response.getJDA().shutdownNow();
        ctx.reply(e.build(), cm);
    }

    @Override
    public String getName() {
        return "forceshutdown";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("forcekill", "forceshut");
    }

    @Override
    public String getUsage() {
        return "";
    }

    @Override
    public String getDescription() {
        return "A Command to shutdown the bot forcefully !";
    }

    @Override
    public int getCategory() {
        return Category.OWNER;
    }
}
