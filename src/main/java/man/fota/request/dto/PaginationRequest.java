package man.fota.request.dto;

import java.io.Serializable;

import com.sun.istack.NotNull;

public class PaginationRequest implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull
	private Integer page;
	
	@NotNull
	private Integer size;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
}