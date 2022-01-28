package VirtualKeyForRepositories;

import java.util.Scanner;

public class WelcomeScreen {
    public WelcomeScreen() {
    }

    public void Intro() {
        String AppName = "Virtual Key For Your Repositories";
        String DeveloperName = "Arpit Arora";
        String details = "Computer Science Engineer, trying to learn new things";
        System.out.println("*****************************************************************");
        System.out.println("* Welcome to the " + AppName + " applicaiton! *");
        System.out.println("* Developer: " + DeveloperName + "                                   *");
        System.out.println("* Description: " + details + "                                   *");
        System.out.println("*****************************************************************");
    }

    public void MainMenu() {
        System.out.println("\nMain Menu");
        System.out.println("1.Show files\n2.File Options Menu\n3.Exit the application\n");
        boolean running = true;
        Scanner option = new Scanner(System.in);

        do {
            try {
                int input = option.nextInt();
                switch(input) {
                    case 1:
                        this.ShowFiles();
                        this.MainMenu();
                        break;
                    case 2:
                        FileOptionsMenu FileMenu = new FileOptionsMenu();
                        FileMenu.show();
                        break;
                    case 3:
                        System.out.println("Quit the application....");
                        System.out.println("Are you sure? Type 'Y' for yes and 'N' for no");
                        Scanner sure = new Scanner(System.in);
                        String s = sure.nextLine();
                        if (!s.equals("y") && !s.equals("Y")) {
                            this.MainMenu();
                        } else {
                            System.out.println("Applicaiton terminated");
                            running = false;
                            System.exit(0);
                        }
                    default:
                        System.out.println("Invalid option,please check the Input");
                }
            } catch (Exception var7) {
                System.out.println(var7.getClass().getName() + ": Please enter a valid option");
                this.MainMenu();
            }
        } while(running);

    }

    private void ShowFiles() {
        Directory obj = new Directory();
        obj.getFiles();
    }
}
