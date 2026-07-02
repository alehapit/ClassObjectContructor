package library.model;

import java.util.List;

public interface Searchable {
     List<Book> searchByTitle(String keyword);

    List<Book> searchByAuthor(String keyword);

    static String normalizeKeyword(String str) {

        if (str == null) {
            return "";
        }

        return str.trim().toLowerCase();
    }
}
