package beans.output;

import java.io.Serializable;
import java.util.List;


import com.musify.model.Music;

public class ArtistOutputBean implements Serializable{
	
	private int id;
	
	private String name;
	
	private String username;
	
	private String email;
	
	private List<Music> songs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Music> getSongs() {
		return songs;
	}

	public void setSongs(List<Music> songs) {
		this.songs = songs;
	}

}
