package dcp.core.domain.model;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import lombok.Getter;
import lombok.Setter;

/**
 * セッションリソースクラス
 * 
 * @author tikK65339
 *
 */
@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS,
value = WebApplicationContext.SCOPE_SESSION)
@Getter
@Setter
public class SessionResource implements Serializable {

	/** シリアルバージョンUID */
	private static final long serialVersionUID = 1L;

	/** 会員ID */
	private String customerid;

	/** 参照IDリスト */
	private ArrayList<String> referenceidlist;

	/** ログイン成功日時 */
	private String lastlogin;

	/** 前回ログイン失敗日時 */
	private String lastfailedlogin;

	/** 前回パスワード変更日時 */
	private String lastchangepassword;

}
