package com.example.mentorsjoy.backend;
public class Section {
    public String title;
    public int size;
    public String[] subtitles;
    public String[] paragraphs;
    public Section(int size) {
        title = "";
        this.size = size;
        paragraphs = new String[size];
        subtitles = new String[size];
    }
}
