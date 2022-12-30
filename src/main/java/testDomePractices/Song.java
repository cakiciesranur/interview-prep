package testDomePractices;

import java.util.HashSet;
import java.util.Set;

/*
* A playlist is considered a repeating playlist if any of the songs contain a reference to a previous song in the playlist.
* Otherwise, the playlist will end with the last song which points to null.
Implement a function isInRepeatingPlaylist that, efficiently with respect to time used,
* returns true if a playlist is repeating or false if it is not.
* if the playlist repeats, the starting songs can be skipped!!
For example, the following code prints "true" as both songs point to each other.
Song first = new Song("Hello");
Song second = new Song("Eye of the tiger");

first.setNextSong(second);
second.setNextSong(first);
System.out.println(first.isInRepeatingPlaylist());
* */
public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isInRepeatingPlaylist() {
        Set<Song> playList = new HashSet<>();
        Song next = this.nextSong;

        while (next != null) {
            if (playList.contains(next)) {
                return true;
            } else {
                playList.add(next);
                next = next.nextSong;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isInRepeatingPlaylist());
    }
}