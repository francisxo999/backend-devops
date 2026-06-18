package com.spotify.ms_playlists;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsPlaylistsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPlaylistsApplication.class, args);
	}

}
