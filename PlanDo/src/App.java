import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        TaskManager taskManager = new TaskManager();
        Scanner scan = new Scanner(System.in);
        
        boolean next = true;
        int input = 0;

        System.out.println("Bem vindo!");
        
        while (next) {
            System.out.println("Escolha uma opção:\n");
            System.out.println("1 - Adicionar uma tarefa");
            System.out.println("2 - Ver lista de tarefas");
            System.out.println("3 - Completar uma tarefa");
            System.out.println("4 - Ver tarefas concluídas");
            System.out.println("0 - Sair");

            input = scan.nextInt();

            switch (input) {
                case 0:
                    next = false;
                    break;
                case 1:
                    System.out.println("Digite o nome da tarefa a ser adicionada");
                    String nameTask = scan.nextLine();
                    taskManager.addTask(nameTask);
                    break;
                default:
                    break;
            }
        }
    }
}
