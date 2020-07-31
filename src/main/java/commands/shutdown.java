package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import src.manager.CommandContext;
import src.shield.Category;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class shutdown implements src.manager.CommandBase {
    @Override
    public void handle(CommandContext ctx) {
        EmbedBuilder e = new EmbedBuilder()
                .setTitle("Shutting down...")
                .setDescription("Bot is now shutting down...")
                .setColor(Color.GREEN);
        Consumer<Message> cm = (response) -> response.getJDA().shutdown();
        ctx.reply(e.build(), cm);
    }

    @Override
    public String getName() {
        return "shutdown";
    }

    @Override
    public String getUsage() {
        return "";
    }

    @Override
    public String getDescription() {
        return "Shutdown the bot in a proper way.";
    }

    @Override
    public int getCategory() {
        return Category.OWNER;
    }

    @Override
    public Boolean ownerOnly() {
        return true;
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("kill", "shut");
    }
}
