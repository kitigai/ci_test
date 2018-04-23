package dcp.core.common.exceptionhandler;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.UnexpectedTypeException;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.transaction.TransactionTimedOutException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dcp.core.common.constants.PcsConstants;
import dcp.core.domain.model.BadRequestErrorElement;
import dcp.core.domain.model.BadRequestErrorResource;
import dcp.core.domain.model.ErrorResource;

/**
 * 例外ハンドラー
 * 
 * @author tikK65339
 *
 */
@RestControllerAdvice
public class PcsExceptionHandler {
	/**
	 * サポート外HTTPメソッド使用時例外ハンドリング処理.
	 * <p>
	 * 以下の値をResponseとして設定する
	 * <ul>
	 * <li>コード : XX405
	 * <li>メッセージ : Not Supported
	 * </ul>
	 * 
	 * @param e
	 *            サポート外HTTPメソッド使用例外
	 * @return エラーレスポンス
	 */
	@ExceptionHandler
	ResponseEntity<?> httpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e) {
		ErrorResource errorResource = new ErrorResource(PcsConstants.ERROR_MSG_PCC4051);
		return new ResponseEntity<ErrorResource>(errorResource, HttpStatus.METHOD_NOT_ALLOWED);
	}

	/**
	 * URIテンプレート内パス変数不備例外ハンドリング. ※「@PathVariable」を使用した時に発生する例外
	 * <p>
	 * 以下の値をResponseとして設定する
	 * <ul>
	 * <li>コード : PCC5001
	 * <li>メッセージ : Internal Server Error
	 * </ul>
	 * 
	 * @param ex
	 *            URIテンプレート内パス変数不備例外
	 * @return エラーレスポンス
	 */
	@ExceptionHandler
	ResponseEntity<?> missingPathVariable(MissingPathVariableException ex) {
		ErrorResource errorResource = new ErrorResource(PcsConstants.ERROR_MSG_PCC5001);
		return new ResponseEntity<ErrorResource>(errorResource, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * 必須パラメータ未指定例外ハンドリング処理. ※「@RequestParam」を使用した時に発生する例外
	 * <p>
	 * 以下の値をResponseとして設定する
	 * <ul>
	 * <li>コード : XX404
	 * <li>メッセージ : Missing Parameter
	 * </ul>
	 * 
	 * @param e
	 *            必須パラメータ未指定例外
	 * @return エラーレスポンス
	 */
	@ExceptionHandler
	ResponseEntity<?> missingServletRequestParameter(MissingServletRequestParameterException e) {
		ErrorResource errorResource = new ErrorResource("Missing Parameter");
		return new ResponseEntity<ErrorResource>(errorResource, HttpStatus.NOT_FOUND);
	}

	/**
	 * 対象データが存在しない例外ハンドリング処理
	 * <p>
	 * 以下の値をResponseとして設定する
	 * <ul>
	 * <li>コード : PCC4041
	 * <li>メッセージ : Not Found
	 * </ul>
	 * 
	 * @param e
	 *            必須パラメータ未指定例外
	 * @return エラーレスポンス
	 */
	@ExceptionHandler
	ResponseEntity<?> notFound(NotFoundException e) {
		ErrorResource errorResource = new ErrorResource(PcsConstants.ERROR_MSG_PCC4041);
		return new ResponseEntity<ErrorResource>(errorResource, HttpStatus.NOT_FOUND);
	}
	/**
	 * 型変換例外ハンドリング処理.
	 * <p>
	 * 以下の値をResponseとして設定する
	 * <ul>
	 * <li>コード : XX400
	 * <li>メッセージ : Type MisMatch
	 * </ul>
	 * 
	 * @param e
	 *            型変換例外
	 * @return エラーレスポンス
	 */
	@ExceptionHandler
	ResponseEntity<?> typeMismatch(TypeMismatchException e) {
		ErrorResource errorResource = new ErrorResource("Type MisMatch");
		return new ResponseEntity<ErrorResource>(errorResource, HttpStatus.BAD_REQUEST);
	}

	/**
	 * リクエストBODY読み込み失敗例外ハンドリング処理.
	 * <p>
	 * 以下の値をResponseとして設定する
	 * <ul>
	 * <li>コード : PCC4001
	 * <li>メッセージ : Illegal Parameters
	 * </ul>
	 * 
	 * @param e
	 *            リクエストBODY読み込み失敗例外
	 * @return エラーレスポンス
	 */
	@ExceptionHandler
	ResponseEntity<?> httpMessageNotReadable(HttpMessageNotReadableException e) {
		BadRequestErrorResource errorResource = new BadRequestErrorResource();
		List<BadRequestErrorElement> element = new ArrayList<BadRequestErrorElement>();
		BadRequestErrorElement e1 = new BadRequestErrorElement();
		e1.setMessage("some error messages");
		element.add(e1);
		element.add(e1);
		element.add(e1);
		
		errorResource.setErrors(element);
		return new ResponseEntity<BadRequestErrorResource>(errorResource, HttpStatus.BAD_REQUEST);
	}

	/**
	 * バリデート例外ハンドリング処理. ※「@RequestBody」、「@RequestPart」を使用した時に発生する例外
	 * <p>
	 * 以下の値をResponseとして設定する
	 * <ul>
	 * <li>コード : PCC4001
	 * <li>メッセージ : Illegal Parameters
	 * </ul>
	 * 
	 * @param e
	 *            バリデート例外
	 * @return エラーレスポンス
	 */
	@ExceptionHandler
	ResponseEntity<?> methodArgumentNotValid(MethodArgumentNotValidException e) {
		ErrorResource errorResource = new ErrorResource(PcsConstants.ERROR_MSG_PCC4001);
		return new ResponseEntity<ErrorResource>(errorResource, HttpStatus.BAD_REQUEST);
	}

	/**
	 * バリデート型不整合例外ハンドリング処理.
	 * <p>
	 * 以下の値をResponseとして設定する
	 * <ul>
	 * <li>コード : XX400
	 * <li>メッセージ : Illegal Parameters
	 * </ul>
	 * 
	 * @param e
	 *            バリデート型不整合例外
	 * @return エラーレスポンス
	 */
	@ExceptionHandler
	ResponseEntity<?> methodUnexpectedType(UnexpectedTypeException e) {
		ErrorResource errorResource = new ErrorResource(PcsConstants.ERROR_MSG_PCC4001);
		return new ResponseEntity<ErrorResource>(errorResource, HttpStatus.BAD_REQUEST);
	}

	/**
	 * システムエラーハンドリング処理.
	 * <p>
	 * 以下の値をResponseとして設定する
	 * <ul>
	 * <li>コード : XX500
	 * <li>メッセージ : Internal Server Error
	 * </ul>
	 * 
	 * @param ex
	 *            システムエラー
	 * @return エラーレスポンス
	 */
	@ExceptionHandler
	ResponseEntity<?> commonSystemErrorException(CommonException ex) {
		ErrorResource errorResource = new ErrorResource(
				PcsConstants.ERROR_MSG_PCC5001 + ":" + ex.getMessage());
		return new ResponseEntity<ErrorResource>(errorResource, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * API認証エラー処理.
	 * <p>
	 * 以下の値をResponseとして設定する
	 * <ul>
	 * <li>コード : XX4011
	 * <li>メッセージ : Unauthorized API
	 * </ul>
	 * 
	 * @param ex
	 *            システムエラー
	 * @return エラーレスポンス
	 */
	@ExceptionHandler
	ResponseEntity<?> unauthorizedAPI(BadCredentialsException ex) {
		ErrorResource errorResource = new ErrorResource(
				PcsConstants.ERROR_MSG_PCC4011 + ":" + ex.getMessage());
		return new ResponseEntity<ErrorResource>(errorResource, HttpStatus.UNAUTHORIZED);
	}

	/**
	 * TIS-DBタイムアウト処理.
	 * <p>
	 * 以下の値をResponseとして設定する
	 * <ul>
	 * <li>コード : XX4081
	 * <li>メッセージ : Request Timeout
	 * </ul>
	 * 
	 * @param ex
	 *            システムエラー
	 * @return エラーレスポンス
	 */
	@ExceptionHandler
	ResponseEntity<?> timeoutTISDB(TransactionTimedOutException ex) {
		ErrorResource errorResource = new ErrorResource(
				PcsConstants.ERROR_MSG_PCC4081 + ":" + ex.getMessage());
		return new ResponseEntity<ErrorResource>(errorResource, HttpStatus.REQUEST_TIMEOUT);
	}
	
	/**
	 * i2cタイムアウト処理.
	 * <p>
	 * 以下の値をResponseとして設定する
	 * <ul>
	 * <li>コード : XX4082
	 * <li>メッセージ : Request Timeout
	 * </ul>
	 * 
	 * @param ex
	 *            システムエラー
	 * @return エラーレスポンス
	 */
	@ExceptionHandler
	ResponseEntity<?> timeoutI2C(SocketTimeoutException ex) {
		ErrorResource errorResource = new ErrorResource(
				PcsConstants.ERROR_MSG_PCC4082 + ":" + ex.getMessage());
		return new ResponseEntity<ErrorResource>(errorResource, HttpStatus.REQUEST_TIMEOUT);
	}
	
	/**
	 * サービス不能処理
	 * <p>
	 * 以下の値をResponseとして設定する
	 * <ul>
	 * <li>コード : XX5031
	 * <li>メッセージ : Service Unavailable
	 * </ul>
	 * 
	 * @param ex
	 *            システムエラー
	 * @return エラーレスポンス
	 */
	@ExceptionHandler
	ResponseEntity<?> serviceUnavailable(CommonServiceUnavailableException ex) {
		ErrorResource errorResource = new ErrorResource(
				PcsConstants.ERROR_MSG_PCC5031 + ":" + ex.getMessage());
		return new ResponseEntity<ErrorResource>(errorResource, HttpStatus.SERVICE_UNAVAILABLE);
	}
}
