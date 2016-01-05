package com.review.www.exception;


import com.jopool.jweb.enums.Code;
import com.jopool.jweb.exceptions.JWebException;

/**
 * 自定义异常
 *
 * @author jianghm
 * @version $Revision: 1.0 $, $Date: 2013-11-4 上午11:47:10 $
 */
public class REVException extends JWebException {
    public REVException(Code code) {
        super(code);
    }

    public REVException(Code code, String message) {
        super(code, message);
    }
}
