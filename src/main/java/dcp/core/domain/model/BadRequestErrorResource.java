package dcp.core.domain.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class BadRequestErrorResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<BadRequestErrorElement> errors;
}
