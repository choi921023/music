package music.demo;

public class DemoMusicDTO {
	private String musicAddress;
	private String musicTitle;
	private String artist;
	private String albumAddress;

	public DemoMusicDTO() {
		super();
	}

	public DemoMusicDTO(String musicAddress, String musicTitle, String artist, String albumAddress) {
		super();
		this.musicAddress = musicAddress;
		this.musicTitle = musicTitle;
		this.artist = artist;
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

	public String getAlbumAddress() {
		return albumAddress;
	}

	public void setAlbumAddress(String albumAddress) {
		this.albumAddress = albumAddress;
	}

}

