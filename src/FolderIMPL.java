import java.util.List;

public class FolderIMPL implements Folder{
    private String name;
    private String size;
    public FolderIMPL(String name, String size){
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSize() {
        return size;
    }


}
