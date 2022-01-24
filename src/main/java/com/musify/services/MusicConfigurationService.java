package com.musify.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.musify.dao.ArtistRepo;
import com.musify.dao.MusicRepo;
import com.musify.model.Artist;
import com.musify.model.Music;

import beans.output.MusicOutputBean;



@Service
public class MusicConfigurationService {
	@Autowired
	MusicRepo musicRepo;
	
	@Autowired
	ArtistRepo artistRepo;
	
	public List<MusicOutputBean> getAllSongs() {
		List<Music> songs =  musicRepo.findAll();
		List<MusicOutputBean> output = new ArrayList<MusicOutputBean>();
		
		songs.stream().forEach(song ->{
			MusicOutputBean bean = new MusicOutputBean();
			bean.setFile(song.getFile());
			bean.setFileName(song.getFileName());
			bean.setArtists(song.getArtists());
			bean.setSongId(song.getSong_id());
			output.add(bean);
		});
		
		return output;
		
	}
	
	public String addSong(List<Integer> artistIds,MultipartFile file ) {
		Music song = new Music();
		try {
			
			song.setFile(file.getBytes());
			song.setFileName(file.getOriginalFilename());
			
			List<Artist> artists = new ArrayList<Artist>();
			
			artistIds.stream().forEach(id->{
				Artist artist = artistRepo.getOne(id);
				artists.add(artist);
			});
			
			song.setArtists(artists);
			
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
		
		musicRepo.save(song);
		return "ok";
	}
}
