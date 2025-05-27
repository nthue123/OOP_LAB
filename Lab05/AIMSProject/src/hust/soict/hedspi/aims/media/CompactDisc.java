package hust.soict.hedspi.aims.media;


import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public String getArtist(){
        return artist;
    }

    public CompactDisc(String title, String artist){
        super(0, title, null, 0, 0, null);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost, 0, director);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " has been added.");
        } else {
            System.out.println("Track " + track.getTitle() + " is already in the list.");
        }
    }

    public void removeTrack(Track track) {
        if (track == null) {
            throw new IllegalArgumentException("Track cannot be null");
        }
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " has been removed.");
        } else {
            System.out.println("Track " + track.getTitle() + " is not in the list.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + getTitle());
        System.out.println("CD artist: " + getArtist());
        System.out.println("CD length: " + getLength());
        System.out.println("Tracks:");
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + artist + " - " + getLength() + ": " + getCost() + " $";
    }
}