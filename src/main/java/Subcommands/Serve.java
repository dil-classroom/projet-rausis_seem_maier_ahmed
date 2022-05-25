package Subcommands;

import java.io.*;
import io.javalin.http.staticfiles.Location;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import io.javalin.Javalin;




@Command(name = "serve", description = "Open(Serve) the staic site in a navigator")
public class Serve implements Callable<Integer> {
    // (the url of the site)
    public Path site;
    int port = 1234;
    public Integer call() {
        //build
        new CommandLine(new Build()).execute(site.toString());
        //launch
        Javalin.create(config -> {
            config.addStaticFiles(site.resolve("build").toAbsolutePath().toString(), Location.EXTERNAL);
        }).start(port);
        return 0;
    }

}
