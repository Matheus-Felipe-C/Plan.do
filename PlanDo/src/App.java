public class App {
    public static void main(String[] args) throws Exception {
        TaskManager taskManager = new TaskManager();
        System.out.println(taskManager.readTaskList()); 
        taskManager.completeTask(1);
    }
}
