package exception;

/**
 * @Author:TangJiLin
 * @Description:
 * @Date: Created in 2019/11/25 19:22
 * @Modified By:
 */
public class CustomizeException extends RuntimeException{
    private String message;

    private Integer code;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
