package dcp.core.domain.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * エラーリソースクラス
 * @author tikK65339
 *
 */
@Data
@AllArgsConstructor
public class ErrorResource implements Serializable {

	/** シリアルバージョンUID */
	private static final long serialVersionUID = 1L;


	/** メッセージ */
	private String message = null;

}
