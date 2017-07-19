package music.model.dto;

import java.util.ArrayList;

public class StationDTO {
	private String email;
	private ArrayList<MusicDTO> musicList;
	
	public StationDTO(){
		super();
	}
	
	public StationDTO(String email, ArrayList<MusicDTO> musicList) {
		super();
		this.email = email;
		this.musicList = musicList;
	}
	
	
}
