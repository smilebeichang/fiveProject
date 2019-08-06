package net.wanho.exception;
/**
 * 
 * @包名:			[ net.wanho.exception ]  
 * @类名:			[ DaoException ]  
 * @描述:			[ 数据异常，运行时异常] 
 */
public class DaoException extends RuntimeException {

	
	private static final long serialVersionUID = -6179165801068071605L;

	public DaoException() {
		super();
	}

	public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}
	
}
