package dcp.core.common.exceptionhandler;

/**
 * 
 */
public class CommonServiceUnavailableException extends CommonException {

	/** * シリアルバージョンUID */
	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ
	 */
	public CommonServiceUnavailableException() {
		super();
	}
	
	/**
	 * コンストラクタ
	 * 
	 * @param message メッセージ / message
	 * @param cause 例外 / exception
	 */
	public CommonServiceUnavailableException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * コンストラクタ
	 * 
	 * @param message メッセージ / message
	 */
	public CommonServiceUnavailableException(String message) {
		super(message);
	}

	/**
	 * コンストラクタ
	 * 
	 * @param cause 例外 / exception
	 */
	public CommonServiceUnavailableException(Throwable cause) {
		super(cause);
	}

}
