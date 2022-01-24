package com.musify.Controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.musify.dao.ArtistRepo;
import com.musify.dao.MusicRepo;
import com.musify.model.Artist;
import com.musify.model.Music;
import com.musify.services.MusicConfigurationService;

import beans.output.MusicOutputBean;

@RestController
public class MusicController {
	
	@Autowired
	MusicRepo musicRepo ;
	
	@Autowired
	ArtistRepo artistRepo;
	
	@Autowired
	MusicConfigurationService musicConfService;
	
	
	@RequestMapping(value = "/song", method= RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public String addSong(@RequestPart("artists")List<Integer> artistIds,@RequestPart("file") MultipartFile file ) {
		return musicConfService.addSong(artistIds, file);
	}
	
	@RequestMapping(value = "/songs", method= RequestMethod.GET)
	public List<MusicOutputBean> getSongs() {
		return musicConfService.getAllSongs();
		
	}
	
	
	@Transactional
	@RequestMapping(value = "/song/{id}", method= RequestMethod.GET)
	public ResponseEntity<StreamingResponseBody> getSong(@PathVariable("id") Integer id) {
		Music song = musicRepo.getOne(id);
		InputStream stream = new ByteArrayInputStream(song.getFile());
		
		
		StreamingResponseBody responseBody = outputStream -> {

	        int numberOfBytesToWrite;
	        byte[] data = new byte[1024];
	        while ((numberOfBytesToWrite = stream.read(data, 0, data.length)) != -1) {
	            outputStream.write(data, 0, numberOfBytesToWrite);
	        }

	        stream.close();
	    };
	    
	    return ResponseEntity.ok()
	    		.header("Content-Disposition", "attachment; filename=" + song.getFileName())
	    		.contentType(MediaType.APPLICATION_OCTET_STREAM)
	    		.body(responseBody);
				
		
	}
}
