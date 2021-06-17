package auth.service;
//이수하 추가파일
public class ServiceException extends RuntimeException {

	public ServiceException(String message, Exception cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

}