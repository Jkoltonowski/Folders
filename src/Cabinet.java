import java.util.List;
import java.util.Optional;

public interface Cabinet {
    // Zwraca dowolny element o podanej nazwie
    Optional<Folder> findFolderByName(String name);

    // Zwraca wszystkie foldery o podanym rozmiarze SMALL/MEDIUM/LARGE
    List<Folder> findFoldersBySize(String size);

    // Zwraca liczbę wszystkich obiektów tworzących strukturę
    int count();
}
