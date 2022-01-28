package VirtualKeyForRepositories;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Directory {
    public static final String pathName = "C:\\Users\\arpiaror\\OneDrive - Cisco\\Desktop\\java project directory\\";
    private ArrayList<File> files = new ArrayList();
    Path path = FileSystems.getDefault().getPath("C:\\Users\\arpiaror\\OneDrive - Cisco\\Desktop\\java project directory\\").toAbsolutePath();
    File Dfiles;

    public Directory() {
        this.Dfiles = this.path.toFile();
    }

    public String getPathName() {
        return "C:\\Users\\arpiaror\\OneDrive - Cisco\\Desktop\\java project directory\\";
    }

    public ArrayList<File> ListFiles() {
        File[] directoryFiles = this.Dfiles.listFiles();
        this.files.clear();
        File[] var5 = directoryFiles;
        int var4 = directoryFiles.length;

        for(int var3 = 0; var3 < var4; ++var3) {
            File directoryFile = var5[var3];
            if (directoryFile.isFile()) {
                this.files.add(directoryFile);
            }
        }

        Collections.sort(this.files);
        return this.files;
    }

    public ArrayList<File> getFiles() {
        this.ListFiles();
        if (this.files.isEmpty()) {
            System.out.println("No files exist");
        } else {
            System.out.println("Existing files: ");
            Iterator var2 = this.ListFiles().iterator();

            while(var2.hasNext()) {
                File file = (File)var2.next();
                System.out.println(file.getName());
            }
        }

        return this.files;
    }
}