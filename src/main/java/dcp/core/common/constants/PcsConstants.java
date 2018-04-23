package dcp.core.common.constants;

/**
 * 共通コンスタントクラス
 * 
 * @author tikK65339
 *
 */
public final class PcsConstants {
	private PcsConstants() {

	}

	/** システム名（ログ出力用） */
	public static final String SYSTEM_NAME = "PCSMembersWeb";

	/** テンプレートフォルダ */
	public static final String DEFAULT_TEMPLATES = "templates/";

	/**
	 * エラーコード
	 */
	/** 400 */
	public static final String ERROR_CD_PCC4001 = "PCC4001";
	public static final String ERROR_MSG_PCC4001 = "Illegal Parameters";
	/** 401 */
	public static final String ERROR_CD_PCC4011 = "PCC4011";
	public static final String ERROR_MSG_PCC4011 = "Unauthorized API";
	public static final String ERROR_CD_PCC4013 = "PCC4013";
	public static final String ERROR_MSG_PCC4013 = "Unauthorized Login";
	/** 404 */
	public static final String ERROR_CD_PCC4041 = "PCC4041";
	public static final String ERROR_MSG_PCC4041 = "Not Found";
	/** 404 */
	public static final String ERROR_CD_PCC4051 = "PCC4051";
	public static final String ERROR_MSG_PCC4051 = "Not Supported";
	/** 408 */
	public static final String ERROR_CD_PCC4081 = "PCC4081";
	public static final String ERROR_MSG_PCC4081 = "Request Timeout";
	public static final String ERROR_CD_PCC4082 = "PCC4082";
	public static final String ERROR_MSG_PCC4082 = "Request Timeout";
	/** 500 */
	public static final String ERROR_CD_PCC5001 = "PCC5001";
	public static final String ERROR_MSG_PCC5001 = "Internal Server Error";
	/** 503 */
	public static final String ERROR_CD_PCC5031 = "PCC5031";
	public static final String ERROR_MSG_PCC5031 = "Service Unavailable";

	/** thymeleaf用コンスタント */
	/** TemplateMode */
	public static final String THYMELEAF_MODE = "HTML5";
	/** サフィックス */
	public static final String THYMELEAF_SUFFIX = ".html";
	/** 文字種 */
	public static final String THYMELEAF_CHARACTOR_ENCODING = "UTF-8";
	/** キャッシュ */
	public static final boolean THYMELEAF_CACHEABLE = true;

	/** コネクションタイムアウト */
	public static final int CONNECTION_TIMEOUT = 5000;

	/** 読み込みタイムアウト */
	public static final int  READ_TIMEOUT = 5000;

}
