import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AddNewTask {

    public static void main(String[] args) {

        if (args.length == 0) {
            printUsage();
        }
        if(args[0].equals ("-l")){
            listTasks();
        }
        if(args[0].equals ("-a")) {
            if (args.length < 2) {
                System.out.println("nem irtal be eleget");
            } else {
            addTask(args[1]); }
        }
    }



    public static void listTasks () {

        try {Path filePath = Paths.get("listoftasks3.txt");
            List<String> lines = Files.readAllLines(filePath);

            if (lines.size() == 0) {
                System.out.println("No todos for today! :)");
            }

            for (int i = 0; i < lines.size(); i++) {
                System.out.println((i+1) + " " + "-" + " " + lines.get(i)+"\n");


            }

        } catch (Exception e){
            System.out.println("Uh-oh, could not read the file!");
        }

    }

    public static void addTask (String xy) {


                try {

                    Path filePath = Paths.get("listoftasks3.txt");
                    List<String> lines = Files.readAllLines(filePath);

                    lines.add(xy);

                    Files.write(filePath, lines);
                }

                catch (Exception e) {
                    System.out.println("Uh-oh, could not write the file!");
                }

    }


    public static void printUsage() {

        System.out.println("Command Line Todo application\n" +
                "=============================\n" +
                "\n" +
                "Command line arguments:\n" +
                "    -l   Lists all the tasks\n" +
                "    -a   Adds a new task\n" +
                "    -r   Removes an task\n" +
                "    -c   Completes an task");
    }
}

