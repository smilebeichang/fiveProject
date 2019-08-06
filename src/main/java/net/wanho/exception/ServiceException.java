package net.wanho.exception;
/**
 * 
 * @包名:			[ net.wanho.exception ]  
 * @类名:			[ ServiceException ]  
 * @描述:			[ 业务异常，非运行时异常 ] 
 */
public class ServiceException extends RuntimeException {

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
	
}
