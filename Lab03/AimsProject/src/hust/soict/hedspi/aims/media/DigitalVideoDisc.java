package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private String director;
    private int length;

    // Các constructor phải gọi super()
    public DigitalVideoDisc(int id, String title) {
        super(id, title);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public DigitalVideoDisc(int id, String title, String category, String director, float cost) {
        super(id, title, category, cost);
        this.director = director;
    }

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    // Chỉ giữ lại getter cho các trường riêng
    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    // Phương thức isMatch (sử dụng getTitle() từ lớp cha)
    public boolean isMatch(String title) {
        if (getTitle() == null || title == null) {
            return false;
        }
        return getTitle().trim().equalsIgnoreCase(title.trim());
    }

    // Phương thức toString (sử dụng getter từ lớp cha)
    @Override
    public String toString() {
        return String.format("DVD - %s - %s - %s - %d: %.2f$",
                getTitle(),
                getCategory(),
                director != null ? director : "Unknown",
                length,
                getCost());
    }
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
}