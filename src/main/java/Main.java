import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "Main")
public class Main implements Callable<Integer> {

    //Ajout de la sous-commande new

    //Ajout de la sous-commande clean

    //Ajout de la sous-commande build

    //Ajout de la sous-commande serve

    @Override
    public Integer call() {
        System.out.println("Meesage au démarrage");
        return 0;
    }

    public static void main(String[] args) {
        int rc = new CommandLine(new Main()).execute(args);
        System.exit(rc);
    }

}
