package edu.cscc.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "vinyl")
public class Vinyl {
	
      @Id
      
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
     @NotEmpty(message = "Please enter a title")
    @Size(min = 1, max = 50, message = "Please enter a title that is no more than 50 characters in length")
    
    private String title;
    
     @NotEmpty(message = "Please enter an artist")
    @Size(min = 1, max = 50, message = "Please enter an artist that is no more than 40 characters")
    
     private String artist;
    @NotEmpty(message = "Please enter a label")
    @Size(min = 1, max = 50, message = "Please enter a label that is no more than 40 characters")
    
    private String label;
    @NotNull(message = "Please enter an year released")
     @Min(value = 1930, message = "Please enter a year released that is on or after 1930")
    
    private Integer yearReleased;
    @NotNull(message = "Please enter an year released")
      @Min(value = 1, message = "Please enter a number of tracks that is between 1 and 20")
    @Max(value = 20, message = "Please enter a number of tracks that is between 1 and 20")
    
    private int numOfTracks;
    private int size;
    private boolean isDamaged;

    public Vinyl() {
    }

    public Vinyl(Integer id, String title, String artist, String label, Integer yearReleased, int numOfTracks, int size, boolean isDamaged) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.label = label;
        this.yearReleased = yearReleased;
        this.numOfTracks = numOfTracks;
        this.size = size;
        this.isDamaged = isDamaged;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(Integer yearReleased) {
        this.yearReleased = yearReleased;
    }

    public int getNumOfTracks() {
        return numOfTracks;
    }

    public void setNumOfTracks(int numOfTracks) {
        this.numOfTracks = numOfTracks;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isDamaged() {
        return isDamaged;
    }

    public void setDamaged(boolean damaged) {
        isDamaged = damaged;
    }

    @Override
    public String toString() {
       return "Vinyl{" +
                 "id=" + id +
                ", title='" + title + '\'' +
                     ", artist='" + artist + '\'' +
                   ", label='" + label + '\'' +
                ", yearReleased='" + yearReleased + '\'' +
                  ", numOfTracks=" + numOfTracks +
                   ", size=" + size +
                  ", isDamaged=" + isDamaged +
                '}';
    }
}
