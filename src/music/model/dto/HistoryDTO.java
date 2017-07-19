package music.model.dto;

public class HistoryDTO {
	private String email;
	private String musicAddress;
	private String startTime;

	public HistoryDTO() {
		super();
	}

	public HistoryDTO(String email, String musicAddress) {
		super();
		this.email = email;
		this.musicAddress = musicAddress;
	}

	public HistoryDTO(String email, String musicAddress, String startTime) {
		super();
		this.email = email;
		this.musicAddress = musicAddress;
		this.startTime = startTime;
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
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

}
