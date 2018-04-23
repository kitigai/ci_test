package dcp.core.controller.cards;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.transaction.TransactionTimedOutException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dcp.core.common.exceptionhandler.CommonException;
import dcp.core.common.exceptionhandler.CommonServiceUnavailableException;
import dcp.core.domain.model.SuspendInfoResResource;
import lombok.RequiredArgsConstructor;

/**
 * カード利用停止情報照会コントローラークラス.
 */
@RestController
@RequiredArgsConstructor
public class Suspend {

	/**
	 * カード利用停止情報照会処理
	 *
	 * @param crdNum
	 *            カードNo(トークン)
	 * @return
	 */
	@GetMapping(path = "/v1/card/suspendInfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> get(@RequestParam(value = "bankCode") String bankCode,
			@RequestParam(value = "branchCode") String branchCode,
			@RequestParam(value = "depositType") String depositType, @RequestParam(value = "actNum") String actNum,
			@RequestParam(value = "actNumBnm") String actNumBnm) {

		SuspendInfoResResource suspendInfo;
		suspendInfo = new SuspendInfoResResource();
		suspendInfo.setSuspendStatus("1");

		// ユーザID
		String userId = branchCode + depositType + actNum;
		
		// 正常系
		if (actNumBnm.equals("BCD")) {
			// 利用可能
			suspendInfo.setSuspendStatus("0");
			switch (userId) {
			case "12310001400":
				// 400
				throw new HttpMessageNotReadableException("Illegal Parameters");
			case "12310001404":
				// 404
				throw new NotFoundException("404 NotFound");
			case "12310001408":
				// 408
				throw new TransactionTimedOutException("Timeout");
			case "12310001500":
				// 500
				throw new CommonException();
			case "12310001503":
				// 503
				throw new CommonServiceUnavailableException("service unavailavle");
			case "12310000030":
				// 正常
				break;
			case "12310000009":
				// 500
				throw new CommonException();
			case "12310000010":
				// 500
				throw new CommonException();
			default:
				break;
			}
		} else if ("EFG".equals(actNumBnm)) {
			// 停止中

		} else if ("HIJ".equals(actNumBnm)) {
			// 400
			throw new HttpMessageNotReadableException("Illegal Parameters");
		} else if ("KLM".equals(actNumBnm)) {
			// 404
			throw new NotFoundException("404 NotFound");

		} else if ("NOP".equals(actNumBnm)) {
			// 408
			throw new TransactionTimedOutException("Timeout");
		} else if ("QRS".equals(actNumBnm)) {
			// 500
			throw new CommonException();
		} else {
			throw new CommonException("acquirerid faild");
		}

		return new ResponseEntity<SuspendInfoResResource>(suspendInfo, HttpStatus.OK);
	}

	/**
	 * カード利用停止情報更新処理
	 *
	 * @param crdNum
	 *            カードNo(トークン)
	 * @return
	 */
	@PutMapping(path = "/v1/card/suspendInfo", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> post(
			@RequestParam(value = "bankCode") String bankCode,
			@RequestParam(value = "branchCode") String branchCode,
			@RequestParam(value = "depositType") String depositType, 
			@RequestParam(value = "actNum") String actNum,
			@RequestParam(value = "actNumBnm") String actNumBnm,
			@RequestBody(required = false) SuspendInfoResResource requestBody
			) {
		
		
		 SuspendInfoResResource suspendInfo;
		 suspendInfo = new SuspendInfoResResource();
		 suspendInfo.setSuspendStatus("1");
		
		// ユーザID
		String userId = branchCode + depositType + actNum;
			
		 // 正常系
		 if (actNumBnm.equals("BCD") || actNumBnm.equals("   ")) {
		 // 停止中
				switch (userId) {
				case "12310001400":
				case "12310004400":
					// 400
					throw new HttpMessageNotReadableException("Illegal Parameters");
				case "12310004404":
					// 404
					throw new NotFoundException("404 NotFound");
				case "12310004408":
					// 408
//					 throw new TransactionTimedOutException("Timeout");
					setSleep();
					break;
				case "12310004500":
					// 500
					 throw new CommonException();
				case "12310004503":
					// 503
					throw new CommonServiceUnavailableException("service unavailavle");
				case "12310000030":
					// 正常
					break;
				default:
					break;
				}
					
		 } else if("EFG".equals(actNumBnm)) {
		 // 利用可能
			 suspendInfo.setSuspendStatus("0");
		 } else if ("HIJ".equals(actNumBnm)) {
		 // 400
		 throw new HttpMessageNotReadableException("Illegal Parameters");
		 } else if ("KLM".equals(actNumBnm)) {
		 // 404
		 throw new NotFoundException("404 NotFound");
		
		 } else if ("NOP".equals(actNumBnm)) {
		 // 408
		 throw new TransactionTimedOutException("Timeout");
		 } else if ("QRS".equals(actNumBnm)) {
		 // 500
		 throw new CommonException();
		 } else {
		 throw new CommonException("acquirerid faild");
		 }
		
		return new ResponseEntity<SuspendInfoResResource>(suspendInfo, HttpStatus.OK);
	}

	/**
	 * 待ち時間の設定（レスポンスタイムアウト用）
	 *
	 */
	private void setSleep() {
		
		try{ 
			// 1分間スリープ
			Thread.sleep(70001);		
		} catch(InterruptedException e){ 
			e.printStackTrace(); 
		}		
	}
}
