package dcp.core.domain.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class BadRequestErrorElement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
}
