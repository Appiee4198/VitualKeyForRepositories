
package VirtualKeyForRepositories;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class FileOptionsMenu {
    private Directory dir = new Directory();

    public FileOptionsMenu() {
    }

    public void MenuHandler() {
        System.out.println("1. Add a File\n2. Delete a file\n3. Search a file\n4. Return to Main Menu");
        boolean running = true;
        Scanner option = new Scanner(System.in);

        do {
            try {
                int input = option.nextInt();
                switch(input) {
                    case 1:
                        this.AddFile();
                        this.show();
                        break;
                    case 2:
                        this.DeleteFile();
                        this.show();
                        break;
                    case 3:
                        this.SearchFile();
                        this.show();
                        break;
                    case 4:
                        WelcomeScreen obj = new WelcomeScreen();
                        obj.MainMenu();
                        break;
                    default:
                        System.out.println("Invalid Option");
                }
            } catch (InputMismatchException var5) {
                System.out.println(var5 + ": Please select a valid option");
                this.MenuHandler();
            }
        } while(running);

    }

    public void show() {
        System.out.println("\nFile Options Menu");
        this.MenuHandler();
    }

    private String getInputSting() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    private void AddFile() {
        System.out.println("Enter file name:");
        String filename = this.getInputSting();
        System.out.println("Adding file:" + filename);

        try {
            Path path = FileSystems.getDefault().getPath("C:\\Users\\arpiaror\\OneDrive - Cisco\\Desktop\\java project directory\\" + filename).toAbsolutePath();
            File file = new File(this.dir.getPathName() + filename);
            if (file.createNewFile()) {
                System.out.println("File added: " + file.getName());
                this.dir.ListFiles().add(file);
            } else {
                System.out.println("File already Exists");
            }
        } catch (IOException var4) {
            System.out.println(var4);
        }

    }

    private void DeleteFile() {
        Directory obj = new Directory();
        obj.getFiles();
        System.out.println("Enter filename to delete:");
        String filename = this.getInputSting();
        System.out.println("Deleting file: " + filename + "\nAre you sure? (Y/N)");
        String sure = this.getInputSting();
        if (sure.equals("y") || sure.equals("Y")) {
            Path path = FileSystems.getDefault().getPath("C:\\Users\\arpiaror\\OneDrive - Cisco\\Desktop\\java project directory\\" + filename).toAbsolutePath();
            File file = path.toFile();
            if (file.delete()) {
                System.out.println("Deleted file: " + file.getName());
                this.dir.ListFiles().remove(file);
            } else {
                System.out.println("Failed, file not found");
            }

        }
    }

    private void SearchFile() {
        boolean found = false;
        System.out.println("Enter file name:");
        String fileName = this.getInputSting();
        System.out.println("Searching for file: " + fileName);
        ArrayList<File> files = this.dir.ListFiles();
        Iterator var5 = files.iterator();

        while(var5.hasNext()) {
            File file = (File)var5.next();
            if (file.getName().equals(fileName)) {
                System.out.println("Found " + fileName);
                found = true;
            }
        }

        if (!found) {
            System.out.println("File not found");
        }

    }
}