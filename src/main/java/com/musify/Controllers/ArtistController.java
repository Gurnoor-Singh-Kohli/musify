package com.musify.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.musify.dao.ArtistRepo;
import com.musify.model.Artist;
import com.musify.services.ArtistConfigurationService;

import beans.input.ArtistInputBean;
import beans.output.ArtistOutputBean;

@RestController
@RequestMapping("/artist")
public class ArtistController {

	@Autowired
	ArtistRepo repo;
	
	@Autowired
	ArtistConfigurationService artistConfService;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	private Artist addArtist(@RequestBody ArtistInputBean input) {
		return artistConfService.registerArtist(input);
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	private ArtistOutputBean getArtist(@PathVariable("id") int id) {
		return artistConfService.getArtist(id);
	}
	
	@RequestMapping(value = "/all",method=RequestMethod.GET)
	private List<ArtistOutputBean> getAllArtists(){
		return artistConfService.getAllArtists();
	}
}
