package org.api.bean.reponse;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * [OVERVIEW] User Role Of Response
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/01      (TanDX)     	 Create new
*/
public class ZipCodeInfoResponse implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	// Address1
    @JsonProperty("address1")
    private String address1;

    // Address2
    @JsonProperty("address2")
    private String address2;

    // Address3
    @JsonProperty("address3")
    private String address3;

    // kana1
    @JsonProperty("kana1")
    private String kana1;

    // kana2
    @JsonProperty("kana2")
    private String kana2;

    // kana3
    @JsonProperty("kana3")
    private String kana3;

    // prefCode
    @JsonProperty("prefCode")
    private String prefCode;

    // zipcode
    @JsonProperty("zipcode")
    private String zipcode;
}
