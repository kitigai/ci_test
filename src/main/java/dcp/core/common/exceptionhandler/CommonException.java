package dcp.core.common.exceptionhandler;

/** 
 * 共通例外クラス
 * @author tikK65339
 *
 */
public class CommonException extends RuntimeException {
	
	/** * シリアルバージョンUID */
	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ.
	 */
	public CommonException() {
		super();
	}

	/**
	 * コンストラクタ.
	 * 
	 * @param message メッセージ
	 * @param cause 例外
	 */
	public CommonException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * コンストラクタ.
	 * 
	 * @param message メッセージ
	 */
	public CommonException(String message) {
		super(message);
	}

	/**
	 * コンストラクタ.
	 * 
	 * @param cause 例外
	 */
	public CommonException(Throwable cause) {
		super(cause);
	}

}
