package music.model.dto;

public class LikeDTO {
	private String email;
	private String musicAddress;

	public LikeDTO() {
		super();
	}

	public LikeDTO(String email, String musicAddress) {
		super();
		this.email = email;
		this.musicAddress = musicAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMusicAddress() {
		return musicAddress;
	}

	public void setMusicAddress(String musicAddress) {
		this.musicAddress = musicAddress;
	}

}
