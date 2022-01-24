package com.musify.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musify.dao.ArtistRepo;
import com.musify.model.Artist;

import beans.input.ArtistInputBean;
import beans.output.ArtistOutputBean;

@Service
public class ArtistConfigurationService {
	
	@Autowired
	ArtistRepo repo;
	
	private static ArtistConfigurationService instance;
	
	private ArtistConfigurationService(){
	}
	
	public static synchronized ArtistConfigurationService getInstance() {
		if(instance == null) {
			instance = new ArtistConfigurationService();
		}
		return instance;
	}
	
	public Artist registerArtist(ArtistInputBean input) {
		Artist artist = new Artist();
		artist.setName(input.getName());
		artist.setUsername(input.getUsername());
		artist.setEmail(input.getEmail());
		artist.setPassword(input.getPassword());
		repo.save(artist);
		return artist;
	}
	
	public ArtistOutputBean getArtist(Integer id) {
		Artist artist = repo.getOne(id);
		ArtistOutputBean output = new ArtistOutputBean();
		output.setId(artist.getArtist_id());
		output.setEmail(artist.getEmail());
		output.setName(artist.getName());
		output.setUsername(artist.getUsername());
		output.setSongs(artist.getSongs());
		return output;
	}
	
	public List<ArtistOutputBean> getAllArtists(){
		List<Artist> artists =  repo.findAll();
		List<ArtistOutputBean> output = new ArrayList();
		artists.stream().forEach(artist->{
			
			ArtistOutputBean bean = new ArtistOutputBean();
			bean.setId(artist.getArtist_id());
			bean.setEmail(artist.getEmail());
			bean.setName(artist.getName());
			bean.setUsername(artist.getUsername());
			bean.setSongs(artist.getSongs());
			output.add(bean);
			
		});
		
		return output;
	}
	
}
