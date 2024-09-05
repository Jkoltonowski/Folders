import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Folder folder1 = new FolderIMPL("Dokument", "MEDIUM");
        Folder folder2 = new FolderIMPL("Dokument2", "LARGE");
        Folder folder3 = new FolderIMPL("ZDJ", "LARGE");

        List<Folder> subFolders = new ArrayList<>();
        subFolders.add(new FolderIMPL("Projekty", "SMALL"));
        subFolders.add(new FolderIMPL("Raport", "MEDIUM"));
        MultiFolder workFolder = new MultiFolderIMPL("Praca", "LARGE",subFolders);

        List<Folder> mainFolders = new ArrayList<>();
        mainFolders.add(folder1);
        mainFolders.add(folder2);
        mainFolders.add(workFolder);

        FileCabinet fileCabinet = new FileCabinet(mainFolders);
        FileManager fileManager = new FileManager(fileCabinet);

        fileManager.displeyFolderByName("Projekty");
        fileManager.displeyFolderBySize("LARGE");
        fileManager.displeyFolderBySize("MEDIUM");
        fileManager.displeyFolderCount();


    }
}