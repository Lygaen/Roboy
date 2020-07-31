package main;

import commands.forceshutdown;
import commands.shutdown;
import net.dv8tion.jda.api.JDABuilder;
import src.manager.CommandBase;
import src.others.Config;
import src.shield.Category;
import src.shield.Listener;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;

import static src.others.Common.addCommand;

public class Main {


    public static void main(String[] args) throws LoginException {

        JDABuilder.createDefault(Config.token)
                .setActivity(Config.activity)
                .addEventListeners(new Listener())
                .setStatus(Config.status)
                .build();


        buildCommands();
    }

    private static void buildCommands() {
        addCommand(new shutdown());
        addCommand(new forceshutdown());
    }

}
