package dcp.core.controller.cards;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dcp.core.common.exceptionhandler.CommonException;
import dcp.core.common.exceptionhandler.CommonServiceUnavailableException;
import dcp.core.domain.model.SpendLimitPostReqResource;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * カード利用限度額情報照会コントローラークラス.
 */
@Log4j
@RestController
@RequiredArgsConstructor
public class Limit {

	@Data
	public class SpendLimitElement {

		/** 利用限度額 */
		private int spendLimit;
		/** WEB利用上限額 */
		private int webMaxAmt;
		/** 利用累積額 *個社対応でのみ使用* */
		@Deprecated
		private Long totAmt;
		/** 利用限度額制御区分 */
		private String ctlCode;

	}

	@Data
	public class SpendLimitResResource {

		/** 国内ショッピング1回の情報 */
		private SpendLimitElement domPurTran;
		/** 国内ショッピング1日の情報 */
		private SpendLimitElement domPurDay;
		/** 国内ショッピング一か月の情報 */
		private SpendLimitElement domPurMonth;
		/** 海外ショッピング1回の情報 */
		private SpendLimitElement intPurTran;
		/** 海外ショッピング1日の情報 */
		private SpendLimitElement intPurDay;
		/** 海外ショッピング1カ月の情報 */
		private SpendLimitElement intPurMonth;
		/** 海外キャッシング1回の情報 */
		private SpendLimitElement intCashTran;
		/** 海外キャッシング1日の情報 */
		private SpendLimitElement intCashDay;
		/** 海外キャッシング1カ月の情報 */
		private SpendLimitElement intCashMonth;
		/** メッセージ */
		private String message;
		/** エラーリスト */
	}

	@Data
	public class SpendLimitPostResResource {

		/** HTTPステータスコード */
		private String status;
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

	/**
	 * カード利用限度額情報照会処理
	 *
	 * @param crdNum
	 * @return
	 */
	@GetMapping(path = "/v1/card/spendLimit", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> get(
			@RequestParam(value = "bankCode") String bankCode,
			@RequestParam(value = "branchCode") String branchCode,
			@RequestParam(value = "depositType") String depositType, 
			@RequestParam(value = "actNum") String actNum,
			@RequestParam(value = "actNumBnm") String actNumBnm) {
		
		// ボディ部初期化
		SpendLimitResResource spendLimit;
		spendLimit = new SpendLimitResResource();
		SpendLimitElement element = new SpendLimitElement();
		
		
		String userId = branchCode + depositType + actNum;
		int spendLimitation = 0;
		int webMaxAmt = 0;
		Long toAmt = 0L;
		String ctlCode = "";
		// 正常系
		if (actNumBnm.equals("BCD")) {
			
			switch (userId) {
			case "12310000001":
				spendLimitation = 100000;
				webMaxAmt = 3000;
				toAmt = 1000L;
				ctlCode = "1";
				break;
			case "12310000002":
				spendLimitation = 100000;
				webMaxAmt = 3000;
				toAmt = 1000L;
				ctlCode = "1";
				break;
			case "12310000003":
				spendLimitation = 100000;
				webMaxAmt = 3000;
				toAmt = 1000L;
				ctlCode = "1";
				break;
			case "12310000004":
				spendLimitation = 100000;
				webMaxAmt = 3000;
				toAmt = 1000L;
				ctlCode = "1";
				break;
			case "12310000005":
				spendLimitation = 100000;
				webMaxAmt = 3000;
				toAmt = 1000L;
				ctlCode = "1";
				break;
			case "22210000006":
				spendLimitation = 100000;
				webMaxAmt = 3000;
				toAmt = 1000L;
				ctlCode = "1";
				break;
			case "22210000007":
				spendLimitation = 100000;
				webMaxAmt = 3000;
				toAmt = 1000L;
				ctlCode = "1";
				break;
			case "12310000009":
				spendLimitation = 100000;
				webMaxAmt = 3000;
				toAmt = 1000L;
				ctlCode = "1";
				break;
			case "12310000010":
				spendLimitation = 100000;
				webMaxAmt = 3000;
				toAmt = 1000L;
				ctlCode = "1";
				break;
			case "22210000011":
				spendLimitation = 100000;
				webMaxAmt = 3000;
				toAmt = 1000L;
				ctlCode = "1";
				break;
			case "12310000012":
				spendLimitation = 100000;
				webMaxAmt = 3000;
				toAmt = 1000L;
				ctlCode = "1";
				break;
			case "12310000013":
				spendLimitation = 100000;
				webMaxAmt = 3000;
				toAmt = 1000L;
				ctlCode = "1";
				break;
			case "22210000014":
				spendLimitation = 100000;
				webMaxAmt = 3000;
				toAmt = 1000L;
				ctlCode = "1";
				break;
			case "12310000015":
				spendLimitation = 100000;
				webMaxAmt = 3000;
				toAmt = 1000L;
				ctlCode = "1";
				break;
			case "12310000016":
				spendLimitation = 100000;
				webMaxAmt = 3000;
				toAmt = 1000L;
				ctlCode = "1";
				break;
			case "12310000027":
				// 500
				throw new CommonException();
			case "11111111112":
				spendLimitation = 2000;
				webMaxAmt = 3000;
				toAmt = null;
				ctlCode = "1";
				break;
			case "12310002400":
				// 400
				throw new HttpMessageNotReadableException("Illegal Parameters");
			case "12310002404":
				// 404
				throw new NotFoundException("404 NotFound");
			case "12310002408":
				// 408
//				throw new TransactionTimedOutException("Timeout");
				// 待ち時間の設定
				setSleep();
				break;
			case "12310002500":
				// 500
				throw new CommonException();
			case "12310002503":
				// 503
				throw new CommonServiceUnavailableException("service unavailavle");
			case "12310000030":
				//　正常
				break;
			default:
				spendLimitation = 1999;
				webMaxAmt = 2999	;
				toAmt = 99L;
				ctlCode = "2";
				break;
			}
			// 各Limit値は一括
			element.setSpendLimit(spendLimitation);
			element.setWebMaxAmt(webMaxAmt);
			element.setTotAmt(toAmt);
			element.setCtlCode(ctlCode);
			
			spendLimit.setDomPurTran(element);
			spendLimit.setDomPurDay(element);
			spendLimit.setDomPurMonth(element);
			spendLimit.setIntPurTran(element);
			spendLimit.setIntPurDay(element);
			spendLimit.setIntPurMonth(element);
			spendLimit.setIntCashTran(element);
			spendLimit.setIntCashDay(element);
			spendLimit.setIntCashMonth(element);
			
			if(userId.equals("11101234567")) { 
				SpendLimitElement element2 = new SpendLimitElement();
				int spendLimitation2 = 1998;
				int webMaxAmt2 = 2998;
				Long toAmt2 = 98L;
				String ctlCode2 = "9";
				element2.setSpendLimit(spendLimitation2);
				element2.setWebMaxAmt(webMaxAmt2);
				element2.setTotAmt(toAmt2);
				element2.setCtlCode(ctlCode2);
				spendLimit.setDomPurTran(element2);

				SpendLimitElement element3 = new SpendLimitElement();
				spendLimitation = 1997;
				webMaxAmt = 2997;
				toAmt = 97L;
				ctlCode = "8";
				element3.setSpendLimit(spendLimitation);
				element3.setWebMaxAmt(webMaxAmt);
				element3.setTotAmt(toAmt);
				element3.setCtlCode(ctlCode);
				spendLimit.setDomPurDay(element3);

				SpendLimitElement element4 = new SpendLimitElement();
				spendLimitation = 1996;
				webMaxAmt = 2996;
				toAmt = 96L;
				ctlCode = "7";
				element4.setSpendLimit(spendLimitation);
				element4.setWebMaxAmt(webMaxAmt);
				element4.setTotAmt(toAmt);
				element4.setCtlCode(ctlCode);
				spendLimit.setDomPurMonth(element4);
				
				SpendLimitElement element5 = new SpendLimitElement();
				spendLimitation = 1995;
				webMaxAmt = 2995;
				toAmt = 95L;
				ctlCode = "6";
				element5.setSpendLimit(spendLimitation);
				element5.setWebMaxAmt(webMaxAmt);
				element5.setTotAmt(toAmt);
				element5.setCtlCode(ctlCode);
				spendLimit.setIntPurTran(element5);
				
				SpendLimitElement element6 = new SpendLimitElement();
				spendLimitation = 1994;
				webMaxAmt = 2994;
				toAmt = 94L;
				ctlCode = "5";
				element6.setSpendLimit(spendLimitation);
				element6.setWebMaxAmt(webMaxAmt);
				element6.setTotAmt(toAmt);
				element6.setCtlCode(ctlCode);
				spendLimit.setIntPurDay(element6);
				
				SpendLimitElement element7 = new SpendLimitElement();
				spendLimitation = 1993;
				webMaxAmt = 2993;
				toAmt = 93L;
				ctlCode = "4";
				element7.setSpendLimit(spendLimitation);
				element7.setWebMaxAmt(webMaxAmt);
				element7.setTotAmt(toAmt);
				element7.setCtlCode(ctlCode);				
				spendLimit.setIntPurMonth(element7);
				
				SpendLimitElement element8 = new SpendLimitElement();
				spendLimitation = 1992;
				webMaxAmt = 2992;
				toAmt = 92L;
				ctlCode = "3";
				element8.setSpendLimit(spendLimitation);
				element8.setWebMaxAmt(webMaxAmt);
				element8.setTotAmt(toAmt);
				element8.setCtlCode(ctlCode);
				spendLimit.setIntCashTran(element8);
				
				SpendLimitElement element9 = new SpendLimitElement();
				spendLimitation = 1991;
				webMaxAmt = 2991;
				toAmt = 91L;
				ctlCode = "1";
				element9.setSpendLimit(spendLimitation);
				element9.setWebMaxAmt(webMaxAmt);
				element9.setTotAmt(toAmt);
				element9.setCtlCode(ctlCode);
				spendLimit.setIntCashDay(element9);
				
				SpendLimitElement element10 = new SpendLimitElement();
				spendLimitation = 1990;
				webMaxAmt = 2990;
				toAmt = 90L;
				ctlCode = "0";
				element10.setSpendLimit(spendLimitation);
				element10.setWebMaxAmt(webMaxAmt);
				element10.setTotAmt(toAmt);
				element10.setCtlCode(ctlCode);
				spendLimit.setIntCashMonth(element10);
			} else if (userId.equals("12310000040")) {
				// 内結用
				spendLimit.setDomPurTran(getSpendLimitElement(10000));
				spendLimit.setIntPurTran(getSpendLimitElement(10001));
				spendLimit.setIntCashTran(getSpendLimitElement(10002));
				spendLimit.setDomPurDay(getSpendLimitElement(10003));
				spendLimit.setIntPurDay(getSpendLimitElement(10004));
				spendLimit.setIntCashDay(getSpendLimitElement(10005));
				spendLimit.setDomPurMonth(getSpendLimitElement(10006));
				spendLimit.setIntPurMonth(getSpendLimitElement(10007));
				spendLimit.setIntCashMonth(getSpendLimitElement(10008));
			} else if (userId.equals("12310000042")) {
				// 内結用
				spendLimit.setDomPurTran(getSpendLimitElement(20000));
				spendLimit.setIntPurTran(getSpendLimitElement(20001));
				spendLimit.setIntCashTran(getSpendLimitElement(20002));
				spendLimit.setDomPurDay(getSpendLimitElement(20003));
				spendLimit.setIntPurDay(getSpendLimitElement(20004));
				spendLimit.setIntCashDay(getSpendLimitElement(20005));
				spendLimit.setDomPurMonth(getSpendLimitElement(20006));
				spendLimit.setIntPurMonth(getSpendLimitElement(20007));
				spendLimit.setIntCashMonth(getSpendLimitElement(20008));
			}
		} else if ("EFG".equals(actNumBnm)) {
			// 400
			throw new HttpMessageNotReadableException("Illegal Parameters");
		} else if ("HIJ".equals(actNumBnm)) {
			// 404
			throw new NotFoundException("404 NotFound");

		} else if ("KLM".equals(actNumBnm)) {
			// 408
//			throw new TransactionTimedOutException("Timeout");
			// 待ち時間の設定
			setSleep();
		} else if ("NOP".equals(actNumBnm)) {
			// 500
			throw new CommonException();
		} else {
			throw new CommonException("acquirerid faild");
		}

		return new ResponseEntity<SpendLimitResResource>(spendLimit, HttpStatus.OK);
	}

	/**
	 * カード利用限度額情報更新処理
	 *
	 * @param crdNum
	 * @return
	 */
	@PutMapping(path = "/v1/card/spendLimit", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> post(
			@RequestParam(value = "bankCode") String bankCode,
			@RequestParam(value = "branchCode") String branchCode,
			@RequestParam(value = "depositType") String depositType, 
			@RequestParam(value = "actNum") String actNum,
			@RequestParam(value = "actNumBnm") String actNumBnm,
			@RequestBody(required = false) SpendLimitPostReqResource requestBody
			) {

//		// ボディ部初期化
//		SpendLimitResResource spendLimit;
//		spendLimit = new SpendLimitResResource();
//		SpendLimitElement element = new SpendLimitElement();
//		// 各Limit値は一括
//		element.setSpendLimit(1999);
//		
//		spendLimit.setDomPurTran(element);
//		spendLimit.setDomPurDay(element);
//		spendLimit.setDomPurMonth(element);
//		spendLimit.setIntPurTran(element);
//		spendLimit.setIntPurDay(element);
//		spendLimit.setIntPurMonth(element);
//		spendLimit.setIntCashTran(element);
//		spendLimit.setIntCashDay(element);
//		spendLimit.setIntCashMonth(element);
//		
//		
		
		// ユーザID
		String userId = branchCode + depositType + actNum;
		// 正常系
		if (actNumBnm.equals("BCD") || actNumBnm.equals("   ")) {
			switch (userId) {
			case "12310005400":
				// 400
				throw new HttpMessageNotReadableException("Illegal Parameters");
			case "12310005404":
				// 404
				throw new NotFoundException("404 NotFound");
			case "12310005408":
//			case "tstA1234567":// for local
				// 408
//				 throw new TransactionTimedOutException("Timeout");
				// 待ち時間の設定
				setSleep();
				break;
			case "12310005500":
				// 500
				 throw new CommonException();
			case "12310005503":
				// 503
				throw new CommonServiceUnavailableException("service unavailavle");
			case "12310000030":
				// 正常
				break;
			default:
				break;
			}
				

		} else if ("EFG".equals(actNumBnm)) {
			// 400
			throw new HttpMessageNotReadableException("Illegal Parameters");
		} else if ("HIJ".equals(actNumBnm)) {
			// 404
			throw new NotFoundException("404 NotFound");

		} else if ("KLM".equals(actNumBnm)) {
			// 408
//			throw new TransactionTimedOutException("Timeout");
			// 待ち時間の設定
			setSleep();
		} else if ("NOP".equals(actNumBnm)) {
			// 500
			throw new CommonException();
		} else {
			throw new CommonException("acquirerid faild");
		}


		SpendLimitPostResResource postResSpendLimit;
		postResSpendLimit = new SpendLimitPostResResource();

		postResSpendLimit.setDomPurTran(requestBody.getDomPurTran());
		postResSpendLimit.setDomPurDay(requestBody.getDomPurDay());
		postResSpendLimit.setDomPurMonth(requestBody.getDomPurMonth());
		postResSpendLimit.setIntPurTran(requestBody.getIntPurTran());
		postResSpendLimit.setIntPurDay(requestBody.getIntPurDay());
		postResSpendLimit.setIntPurMonth(requestBody.getIntPurMonth());
		postResSpendLimit.setIntCashTran(requestBody.getIntCashTran());
		postResSpendLimit.setIntCashDay(requestBody.getIntCashDay());
		postResSpendLimit.setIntCashMonth(requestBody.getIntCashMonth());
		return new ResponseEntity<SpendLimitPostResResource>(postResSpendLimit, HttpStatus.OK);
	}

	/**
	 * 待ち時間の設定（レスポンスタイムアウト用）
	 *
	 */
	private void setSleep() {
		
		try{ 
			// 1分間スリープ
			Thread.sleep(60040);		
		} catch(InterruptedException e){ 
			e.printStackTrace(); 
		}		
	}

	private SpendLimitElement getSpendLimitElement(int spendLimit) {
		SpendLimitElement element = new SpendLimitElement();
		element.setSpendLimit(spendLimit);
		return element;
	}
}
