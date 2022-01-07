package com.musify.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musify.model.Music;


public interface MusicRepo extends JpaRepository<Music,Integer>{

} 

