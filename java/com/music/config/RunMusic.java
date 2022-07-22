package com.music.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import com.music.model.Albumm;
import com.music.model.Song;

public class RunMusic {
	
	private static ArrayList<Albumm> albums = new ArrayList<Albumm>();


	public static void main(String[] args) {
		
		
		Albumm kohinoor = new Albumm("Kohinoor", "Divine");
		kohinoor.addSong("Chal Bombay", 4.7);
		kohinoor.addSong("Remand", 3.2);
		kohinoor.addSong("Wallah", 3.7);
		kohinoor.addSong("Kohinoor", 4.1);
		
		Albumm damn = new Albumm("Damn", "Kendrick Lamar");
		damn.addSong("Love", 2.3);
		damn.addSong("Pride", 3.2);
		damn.addSong("Lust", 2.2);
		damn.addSong("DNA", 4.3);
		
		albums.add(kohinoor);
		albums.add(damn);
		
		LinkedList<Song> playList1 = new LinkedList<Song>();
		
		albums.get(1).addToPlayList("Love",playList1);
		albums.get(1).addToPlayList("Lust", playList1);
		albums.get(0).addToPlayList("Remand",playList1);
		albums.get(0).addToPlayList("Wallah", playList1);
		
		play(playList1);
		
	}
	
	private static void play(LinkedList<Song> playList) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playList.listIterator();
		
		if(playList.size()==0) {
			System.out.print("This list have no song");
		}
		else {
			System.out.println("Now playing: " + listIterator.next().toString());
			printItems();
		}
		
		while(!quit) {
			int action= sc.nextInt();
			sc.nextLine();
			
			switch(action) {
			
			case 0:
				System.out.println("Playlist has completed");
				quit=true;
				break;
			case 1:
				if(!forward) {
				if(listIterator.hasNext()) {
					listIterator.next();
				}
				forward=true;
				}
				if(listIterator.hasNext()) {
					System.out.println("Now playing "+ listIterator.next().toString());
				}
				else {
					System.out.println("No song available");
					forward = false;
				}
				break;
				
				
			case 2:
				if(forward) {
				if(listIterator.hasPrevious()) {
					listIterator.previous();
				}
				forward=false;
				}
				if(listIterator.hasPrevious()) {
					System.out.println("Now playing "+listIterator.previous().toString());
				}else {
					System.out.println("We are at the first song");
					forward=false;
				}
				break;
			case 3:
				if(forward) {
					if(listIterator.hasPrevious()) {
						System.out.println("Now playing "+listIterator.previous());
						forward=false;
					}else {
						System.out.println("We are at the start of the list");
					}
					
					}else {
						if(listIterator.hasNext()) {
						System.out.println("Now playing"+ listIterator.next().toString());
						forward=true;
						}
						else {
							System.out.println("We are at the end of the list");
						}
					
				}
				break;
			case 4:
				printList(playList);
				break;
				
			case 5:
				printItems();
				break;
			case 6:
				if(playList.size()>0) {
					listIterator.remove();
					if(listIterator.hasNext()) {
						System.out.println("Now playing "+ listIterator.next().toString());
					}
					else {
						if(listIterator.hasPrevious()) {
							System.out.println("Now playing "+listIterator.previous().toString());
						}
					}
				}
				break;
				
			}
			
		}
		
		
	}
	
	private static void printItems() {
		System.out.println("Available options are \n");
		System.out.println("0 - Toquit \n"
				+"1 - to play next song \n"
				+"2 - to play previous song \n"
				+"3 - to replay the current song \n"
				+"4 - to list all songs \n"
				+"5 - print all available options \n"
				+"6 - delete current song \n");
	}
	
	private static void printList(LinkedList<Song> playList) {
		 Iterator<Song> it = playList.iterator();
		 System.out.println("-----------------");
		 while(it.hasNext()) {
			  System.out.println(it.next());
			  }
		 System.out.println("-----------------");

	} 

}
