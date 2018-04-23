package dcp.core.domain.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class SuspendInfoResResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 0の場合利用可能、1の場合利用停止中 */
	private String suspendStatus;

}
