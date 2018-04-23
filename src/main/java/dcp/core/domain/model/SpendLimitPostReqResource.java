package dcp.core.domain.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class SpendLimitPostReqResource implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 国内ショッピング1回の情報 */
	private Integer domPurTran;
	/** 国内ショッピング1日の情報 */
	private Integer domPurDay;
	/** 国内ショッピング一か月の情報 */
	private Integer domPurMonth;
	/** 海外ショッピング1回の情報 */
	private Integer intPurTran;
	/** 海外ショッピング1日の情報 */
	private Integer intPurDay;
	/** 海外ショッピング1カ月の情報 */
	private Integer intPurMonth;
	/** 海外キャッシング1回の情報 */
	private Integer intCashTran;
	/** 海外キャッシング1日の情報 */
	private Integer intCashDay;
	/** 海外キャッシング1カ月の情報 */
	private Integer intCashMonth;
}
