

import static org.junit.jupiter.api.Assertions.assertTrue;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import Subcommands.Serve;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;
import tools.FileManager;


public class ServeTest {
    Path site;

    @BeforeEach
    void setUp() throws IOException {
        site = Files.createTempDirectory(Paths.get("."), "site_");
    }

    @AfterEach
    void tearDown() throws IOException {
        FileManager fm = new FileManager();
        fm.deleteRecursive(new File(site.toString()));
    }

    @Test
    public void serve() throws IOException {
        new CommandLine(new Serve()).execute(site.toString());
        String homepage = new String(new URL("http://localhost:1234/").openStream().readAllBytes());
        assertTrue(homepage.contains("<title> Contenue a comparer </title>"));
    }
}
