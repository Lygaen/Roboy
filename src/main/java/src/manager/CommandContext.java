package src.manager;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;
import java.util.function.Consumer;

public class CommandContext {
    private final GuildMessageReceivedEvent event;
    private final List<String> args;

    public CommandContext(GuildMessageReceivedEvent event, List<String> args) {
        this.event = event;
        this.args = args;
    }

    public void reply(String msg, Consumer<Message> callback) { this.getChannel().sendMessage(msg).queue(callback); }

    public void reply(String msg) { this.getChannel().sendMessage(msg).queue(); }

    public void reply(MessageEmbed embed) {this.getChannel().sendMessage(embed).queue();}

    public void reply(MessageEmbed embed, Consumer<Message> callback) {this.getChannel().sendMessage(embed).queue(callback);}

    public TextChannel getChannel() {return this.getEvent().getChannel();}

    public Guild getGuild() {return this.getEvent().getGuild();}

    public GuildMessageReceivedEvent getEvent() { return this.event; }

    public User getUser() { return this.getEvent().getAuthor(); }

    public Member getMember() {return this.getEvent().getMember();}

    public List<String> getArgs() { return this.args; }

    public JDA getJDA() { return this.getEvent().getJDA(); }
}
