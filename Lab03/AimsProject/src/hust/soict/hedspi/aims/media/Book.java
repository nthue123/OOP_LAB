package hust.soict.hesdpi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {  // Kế thừa từ Media
    // Chỉ giữ lại trường riêng của Book
    private List<String> authors = new ArrayList<>();

    // Constructors phải gọi super()
    public Book(int id, String title) {
        super(id, title);
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public Book(int id, String title, String category, List<String> authors, float cost) {
        super(id, title, category, cost);
        this.authors.addAll(authors);
    }

    // Giữ nguyên các phương thức quản lý authors
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        authors.remove(authorName);
    }

    public List<String> getAuthors() {
        return new ArrayList<>(authors);
    }
}