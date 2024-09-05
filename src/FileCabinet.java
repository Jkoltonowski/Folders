import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileCabinet implements Cabinet {
    private List<Folder> folders;
    public FileCabinet(List<Folder> folders) {
        this.folders = folders;
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        for (Folder folder : folders){
            if (folder.getName().equals(name)){
                return Optional.of(folder);
            }
            if (folder instanceof MultiFolder){
                Folder folder1 = findFolderInMultiFolderByName((MultiFolder) folder, name);
                if (folder1 != null){
                    return Optional.of(folder1);
                }
            }

        }
        return Optional.empty();
    }
    private Folder findFolderInMultiFolderByName(MultiFolder multiFolder, String name){
        for (Folder folder : multiFolder.getFolders()){
            if (folder.getName().equals(name)){
                return folder;
            }
            if (folder instanceof MultiFolder){
             Folder folder1 = findFolderInMultiFolderByName((MultiFolder) folder,name );
             if (folder1 != null){
                 return  folder1;
             }
            }
        }
        return null;
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        List<Folder> matchingFolders = new ArrayList<>();
        for(Folder folder : folders){
            if(folder.getSize().equalsIgnoreCase(size)){
                matchingFolders.add(folder);
            }
            if(folder instanceof MultiFolder)
                matchingFolders.addAll(findFolderInMultiFolderBySize((MultiFolder) folder, size));
        }
        return matchingFolders;
    }
    private List<Folder> findFolderInMultiFolderBySize(MultiFolder multiFolder, String size) {
        List<Folder> matchingFolders = new ArrayList<>();
        for (Folder folder : multiFolder.getFolders()) {
            if (folder.getSize().equalsIgnoreCase(size)){
                matchingFolders.add(folder);

            }
            if (folder instanceof MultiFolder){
                matchingFolders.addAll(findFolderInMultiFolderBySize((MultiFolder) folder, size));
            }
        }
        return matchingFolders;
    }

    @Override
    public int count() {
        int totalCount = 0;
        for (Folder folder : folders){
            totalCount++;
            if (folder instanceof MultiFolder){
                totalCount += countMultiFolders((MultiFolder) folder);
            }
        }
        return totalCount;
    }

    private int countMultiFolders(MultiFolder multiFolder){
        int totalCount = 0;
        for (Folder folder : multiFolder.getFolders()){
            totalCount++;
            if (folder instanceof MultiFolder){
                totalCount += countMultiFolders((MultiFolder) folder);
            }
        }

        return totalCount;
        }
}