package com.music.model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Albumm {

	private String name;
	private String artist;
	private ArrayList<Song> songs;
	
	public Albumm(String name, String artist) {
		super();
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}
	
	public Albumm() {}
	
	public boolean addSong(String title, double duration) {
		if(findSong(title)==null) {
			songs.add(new Song(title, duration));
		//	System.out.println("Song " + title + " successfully added to the list.");
			return true;
			}
		else{
		//	System.out.println("Song "+title+" already exists");
			return false;
			}
		
	}

	private Song findSong(String title) {
		
		for (Song checkedSong: songs) {
			if(checkedSong.getTitle().equals(title))  return checkedSong;
		}
		return null;
	}
	
	public boolean addToPlayList(int trackNum, LinkedList<Song> playList) {
		int index = trackNum-1;
		if(index>0 && index<=this.songs.size()) {
			playList.add(this.songs.get(index));
			return true;
		}
		else {
//			System.out.println("This album does not have the song with trackNumber" + trackNum);
			return false;
		}
	}
	
	public boolean addToPlayList(String title, LinkedList<Song> playList) {
		for (Song song: songs) {
			if(song.getTitle().equals(title)) {
				playList.add(song);
				return true;
			}
		}
	//	System.out.println(title+" does not exist");
		return false;
		
	}

	
}
