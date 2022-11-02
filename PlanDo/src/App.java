public class App {
    public static void main(String[] args) throws Exception {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("oi");
        System.out.println(taskManager.readTaskList()); 
    }
}
