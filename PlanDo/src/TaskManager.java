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
            System.out.println("Task added successfully!");

            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void showTaskList() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String st;

            // flag to see if task list is empty
            boolean flag = false;

            // While the reader is not null, print the line
            while ((st = reader.readLine()) != null) {
                System.out.println(st);
                flag = true;
            }
            if (flag == false)
                System.out.println("Lista vazia");

            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
