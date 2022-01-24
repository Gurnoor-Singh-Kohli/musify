package com.musify.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musify.model.Artist;

public interface ArtistRepo extends JpaRepository<Artist,Integer> {

}
