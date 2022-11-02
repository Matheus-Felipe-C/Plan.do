import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class TaskManager {

    // file path
    private File file = new File("tasks/tasks.txt");

    // Adds task to tasks/tasks.txt file
    public void addTask(String taskName) {
        try {
            FileWriter writer = new FileWriter(file, true);

            writer.write("task_name: " + taskName + "\n\n");
            //writer.write("id: " + genId());
            System.out.println("Task added successfully!");

            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //Generates an ID for each task that is added
    private String genId() {
                
        return null;
    }

    public String readTaskList() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            //String that will be used to check on while
            String st;

            //String that will receive the whole data
            String data = "";

            // flag to see if task list is empty
            boolean flag = false;

            // While the reader is not null, print the line
            while ((st = reader.readLine()) != null) {
                data += st + "\n";
                flag = true;
            }
            if (flag == false) data = "Lista vazia";

            reader.close();

            return data;
        } catch (Exception e) {
            System.out.println(e);
            
            return null;
        }
    }

    public void completeTask() {

    }
}
