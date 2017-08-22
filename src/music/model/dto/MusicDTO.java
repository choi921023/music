package music.model.dto;

public class MusicDTO {
	   private String artist;
	   private String musicTitle;
	   private String genre;
	   private String bpm;
	   private String musicAddress;
	   private String melody;
	   private String gender;
	   private String albumAddress;
	   
   public MusicDTO() {
	      super();
	   }

   public MusicDTO(String artist, String musicTitle, String genre, String bpm,
	         String musicAddress, String melody, String gender, String albumAddress) {
	      super();
	      this.artist = artist;
	      this.musicTitle = musicTitle;
	      this.genre = genre;
	      this.bpm = bpm;
	      this.musicAddress = musicAddress;
	      this.melody = melody;
	      this.gender = gender;
	      this.albumAddress = albumAddress;
	   }

	public String getMusicAddress() {
		return musicAddress;
	}

	public void setMusicAddress(String musicAddress) {
		this.musicAddress = musicAddress;
	}

	public String getMusicTitle() {
		return musicTitle;
	}

	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getBpm() {
		return bpm;
	}

	public void setBpm(String bpm) {
		this.bpm = bpm;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMelody() {
		return melody;
	}

	public void setMelody(String melody) {
		this.melody = melody;
	}

	public String getAlbumAddress() {
		return albumAddress;
	}

	public void setAlbumAddress(String albumAddress) {
		this.albumAddress = albumAddress;
	}

}
