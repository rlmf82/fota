package man.fota.request.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SaveOrUpdateFileRequest implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
    private String name;

    private LocalDateTime lastExecution;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getLastExecution() {
		return lastExecution;
	}

	public void setLastExecution(LocalDateTime lastExecution) {
		this.lastExecution = lastExecution;
	}
}