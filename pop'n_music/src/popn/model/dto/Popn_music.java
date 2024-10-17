package popn.model.dto;

import java.util.Set;

public class Popn_music {

	private String musicName; // 곡명
	private String composerName; // 작곡가명
	private String character; //담당캐릭터
	private String updateVersion; // 업데이트버전
	private int Bpm; // BPM
	private Set<String> difficultyType; // 난이도 종류
	private String difficulty; // 난이도 종류
	
	
	
	
	
	
	

	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	public String getComposerName() {
		return composerName;
	}
	public void setComposerName(String composerName) {
		this.composerName = composerName;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public String getUpdateVersion() {
		return updateVersion;
	}
	public void setUpdateVersion(String updateVersion) {
		this.updateVersion = updateVersion;
	}
	public int getBpm() {
		return Bpm;
	}
	public void setBpm(int bpm) {
		Bpm = bpm;
	}
	public Set<String> getDifficultyType() {
		return difficultyType;
	}
	public void setDifficultyType(Set<String> difficultyType) {
		this.difficultyType = difficultyType;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Popn_music(String musicName, String composerName, String character, String updateVersion, int bpm,
			Set<String> difficultyType, String difficulty) {
		super();
		this.musicName = musicName;
		this.composerName = composerName;
		this.character = character;
		this.updateVersion = updateVersion;
		Bpm = bpm;
		this.difficultyType = difficultyType;
		this.difficulty = difficulty;
	}
	
	
	
	public Popn_music() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("곡명 : %s / 작곡가명 : %s / 담당 캐릭터 : %s / 업데이트버전 : %s / BPM %d / 난이도 타입 : %s / 난이도 : %s",
				musicName, composerName, character, updateVersion, Bpm, difficultyType, difficulty
				);
	}
	
@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
}
