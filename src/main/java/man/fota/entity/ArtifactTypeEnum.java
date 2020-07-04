package man.fota.entity;

public enum ArtifactTypeEnum{

	SOFTWARE("soft"),
	HARDWARE("hard");
	
	private String prefix;
	
	private ArtifactTypeEnum(String prefix) {
		this.setPrefix(prefix);
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}