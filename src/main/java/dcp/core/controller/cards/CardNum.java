package dcp.core.controller.cards;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.transaction.TransactionTimedOutException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dcp.core.common.exceptionhandler.CommonException;
import dcp.core.common.exceptionhandler.CommonServiceUnavailableException;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * カード情報照会コントローラークラス.
 */
@RestController
@RequiredArgsConstructor
public class CardNum {

	@Data
	public class CrdNumResResource {

		/** カード番号 */
		private String crdNum;
		/** 旧カード番号 */
		private String oldCrdNum;
	}

	@GetMapping(path = "/v1/crdNum", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> get(
			@RequestParam(value = "bankCode") String bankCode,
			@RequestParam(value = "branchCode") String branchCode,
			@RequestParam(value = "depositType") String depositType, 
			@RequestParam(value = "actNum") String actNum,
			@RequestParam(value = "actNumBnm") String actNumBnm) {
		CrdNumResResource response = new CrdNumResResource();
		response.setCrdNum("0000000000000099");
		response.setOldCrdNum("xxxx");

		String userId = branchCode + depositType + actNum;
		String crdNum = "";
		// 正常系
		if (actNumBnm.equals("BCD") || actNumBnm.equals("   ")) {
			//　停止中
			switch (userId) {
			// Start 内結用設定
			case "12310000001":
				crdNum = "1234123412340100";
				break;
			case "12310000002":
				crdNum = "1234123412340200";
				break;
			case "12310000003":
				crdNum = "1234123412340300";
				break;
			case "12310000004":
				crdNum = "1234123412340400";
				break;
			case "12310000005":
				crdNum = "1234123412340500";
				break;
			case "22210000006":
				crdNum = "6000003412340600";
				break;
			case "22210000007":
				crdNum = "6000003412340700";
				break;
			case "12310000009":
				crdNum = "1234123412340900";
				break;
			case "12310000010":
				//crdNum = "1234123412341000";
				crdNum = "1234123412341001";
				break;
			case "22210000011":
				crdNum = "6000003412341100";
				break;
			case "12310000012":
				crdNum = "1234123412341200";
				break;
			case "12310000013":
				crdNum = "1234123412341300";
				break;
			case "22210000014":
				crdNum = "6000003412341400";
				break;
			case "12310000015":
				crdNum = "1234123412341500";
				break;
			case "12310000016":
				crdNum = "1234123412341600";
				break;
			case "12310000020":
				crdNum = "1234123412342000";
				break;
			case "12310000021":
				crdNum = "1234123412342100";
				break;
			case "12310000022":
				crdNum = "1234123412342200";
				// 400
				throw new HttpMessageNotReadableException("Illegal Parameters");
			case "12310000023":
				crdNum = "1234123412342300";
				// 404
				throw new NotFoundException("404 NotFound");
			case "12310000024":
				crdNum = "1234123412342400";
				// 408
				throw new TransactionTimedOutException("Timeout");
			case "12310000025":
				crdNum = "1234123412342500";
				// 500
				throw new CommonException();
			case "12310000026":
				crdNum = "1234123412342600";
				// 503
				throw new CommonServiceUnavailableException("service unavailavle");
			case "12310000027":
				crdNum = "1234123412342700";
				break;
			case "12310000028":
				crdNum = "1234123412342800";
				break;
			case "12310000030":
				crdNum = "1234123412343000";
				break;
			case "12310000031":
				crdNum = "1234123412343100";
				break;
			case "12310000032":
				crdNum = "1234123412343200";
				break;
			case "12310000040":
				crdNum = "1234123412344000";
				break;
			case "22210000041":
				crdNum = "1234123412344100";
				break;
			case "12310000042":
				crdNum = "1234123412344200";
				break;
			case "12310000060":
				crdNum = "1234123412346000";
				break;
			case "12310000061":
				crdNum = "1234123412346100";
				break;
            // コントロールルール試験用 同じカード番号
			case "12310001400":
				crdNum = "1234123412343000";
				break;
			case "12310001404":
				crdNum = "1234123412343000";
				break;
			case "12310001408":
				crdNum = "1234123412343000";
				break;
			case "12310001500":
				crdNum = "1234123412343000";
				break;
			case "12310001503":
				crdNum = "1234123412343000";
				break;
			case "12310002400":
				crdNum = "1234123412343000";
				
				break;
			case "12310002404":
				crdNum = "1234123412343000";
				break;
			case "12310002408":
				crdNum = "1234123412343000";
				break;
			case "12310002500":
				crdNum = "1234123412343000";
				break;
			case "12310002503":
				crdNum = "1234123412343000";
				break;
			case "12310003400":
				crdNum = "1234123412343000";
				// 400
				throw new HttpMessageNotReadableException("Illegal Parameters");
			case "12310003404":
				crdNum = "1234123412343000";
				// 404
				throw new NotFoundException("404 NotFound");
			case "12310003408":
				crdNum = "1234123412343000";
				// 408
//				throw new TransactionTimedOutException("Timeout");
				setSleep();
				break;
			case "12310003500":
				crdNum = "1234123412343000";
				// 500
				throw new CommonException();
			case "12310003503":
				crdNum = "1234123412343000";
				// 503
				throw new CommonServiceUnavailableException("service unavailavle");
			case "12310004400":
				crdNum = "1234123412343000";
				break;
			case "12310004404":
				crdNum = "1234123412343000";
				break;
			case "12310004408":
				crdNum = "1234123412343000";
				break;
			case "12310004500":
				crdNum = "1234123412343000";
				break;
			case "12310004503":
				crdNum = "1234123412343000";
				break;
			case "12310005400":
				crdNum = "1234123412343000";
				break;
			case "12310005404":
				crdNum = "1234123412343000";
				break;
			case "12310005408":
				crdNum = "1234123412343000";
				break;
			case "12310005500":
				crdNum = "1234123412343000";
				break;
			case "12310005503":
				crdNum = "1234123412343000";
				break;

			// End 内結用設定
			
			// Start 結合(個社)用設定
			case "12310000050":
				crdNum = "1234123412345000";
				break;
			case "12310000051":
				crdNum = "1234123412345100";
				break;
			case "12310000052":
				crdNum = "1234123412345200";
				break;
			case "12310000053":
				crdNum = "1234123412345300";
				break;
			case "12310000054":
				crdNum = "1234123412345400";
				break;
			// End 結合(個社)用設定
			default:
				crdNum = "0000000000000099";
				break;
			}
				
			response.setCrdNum(crdNum);
			
		} else if("EFG".equals(actNumBnm))  {
			// 利用可能
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
		// カード情報照会サービス
		return new ResponseEntity<CrdNumResResource>(response, HttpStatus.OK);
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
