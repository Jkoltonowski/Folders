import java.util.List;

public class FileManager {
    private FileCabinet fileCabinet;
    public FileManager(FileCabinet fileCabinet){
        this.fileCabinet = fileCabinet;
    }
    public void displeyFolderByName(String name){
        Folder folder = fileCabinet.findFolderByName(name).orElse(null);
        if (folder != null){
            System.out.println("Znaleziony folder: " + folder.getName());
        }
        else {
            System.out.println("Nie znaleziono folderu");
        }
    }

    public void displeyFolderBySize(String size){
        List<Folder> folders = fileCabinet.findFoldersBySize(size);
        System.out.println("Foldery o rozmiarze "+ size + ":");
        for (Folder folder : folders) {
            System.out.println(folder.getName());
        }
    }

    public void displeyFolderCount(){
        int totalCount = fileCabinet.count();
        System.out.println("Łączna liczba folderów: "+ totalCount);
    }
}
