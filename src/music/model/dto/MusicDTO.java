

public class MusicDTO {
	private String musicAddress;
	private String musicTitle;
	private String artist;
	private String genre;
	private String bpm;
	private String gender;
	private String melody;
	private String albumAddress;

	public MusicDTO() {
		super();
	}

	public MusicDTO(String musicAddress, String musicTitle, String artist, String genre, String bpm,
			String gender, String melody, String albumAddress) {
		super();
		this.musicAddress = musicAddress;
		this.musicTitle = musicTitle;
		this.artist = artist;
		this.genre = genre;
		this.bpm = bpm;
		this.gender = gender;
		this.melody = melody;
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
