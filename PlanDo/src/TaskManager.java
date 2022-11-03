import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class TaskManager {

    // file path
    private File todos = new File("PlanDo/tasks/todos.txt");
    private File completed = new File("PlanDo/tasks/completed.txt");

    // Adds task to tasks/tasks.txt file
    public void addTask(String taskName) {
        try {
            FileWriter writer = new FileWriter(todos, true);

            writer.write("task_name: " + taskName + "\n");
            writer.write("id: " + genId() + "\n");
            System.out.println("Task added successfully!");

            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //Generates an ID for each task that is added
    private String genId() {
        String data = readTaskList();

        if (data.equals("Lista vazia")) return "0001";

        else {
            String taskList[] = data.split("\n");
            
            int len = (taskList.length);
            int index = compId(taskList[len-1]);
            System.out.println(index);
            String pre = "";
            if (len == 1)  pre= "000" ; 
            if (len < 10)  pre="000";
            else if (len < 100)  pre="00";
            else if (len < 1000)  pre="0";

            pre +=  (index+1);
            
            return pre;
            
        } 


    }

    public String readTaskList() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(todos));

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
            if (!flag) data = "Lista vazia";

            reader.close();

            return data;
        } catch (Exception e) {
            System.out.println(e);
            
            return null;
        }
    }

    public void completeTask(int taskId) {        
        boolean flag = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(todos));
            FileWriter writer = new FileWriter(completed, true);

            String taskName = reader.readLine();
            String id;

            while (taskName != null) {
                id = reader.readLine();
                
                //Gets the comparable integer
                int compId = compId(id);

                //if current id is equal to the passed id, write it to completed.txt
                if (id.contains("id: ") && taskId == compId) {
                    flag = true;

                    writer.write(taskName + "\n");

                    //Remove completed task from todos.txt
                    removeTask(taskName, id);
                    break;
                }

                taskName = reader.readLine();
            }
        
            if (!flag) System.out.println("Could not find task by the provided task id");
            else System.out.println("Task completed!");

            reader.close();
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean removeTask(String name, String id) {
        try {
            File tempFile = new File("PlanDo/tasks/temp.txt");
            FileWriter writer = new FileWriter(tempFile);
            BufferedReader reader = new BufferedReader(new FileReader(todos));
            String currentLine;
            String nextLine;

            while((currentLine = reader.readLine()) != null) {
                nextLine = reader.readLine();
                //If current line equals to task name or next line is equal to the id, write to temp
                if(currentLine.equals(name) && nextLine.equals(id)) continue;
                writer.write(currentLine + System.getProperty("line.separator") + nextLine + System.getProperty("line.separator"));
            }
            writer.close(); 
            reader.close(); 

            
            boolean successful = tempFile.renameTo(todos);

            return successful;
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /* generates an integer that is the 4 last characters of the
    * "id" line, minus the whitespaces before and after the line
    */
    private int compId(String id) {
        return Integer.parseInt(id.substring(id.length() - 4).trim());
    }
}
