package exception;

/**
 * @author:tangjilin
 * @Description:异常信息统一接口
 * @Date:Created in 2019/11/25 19:22
 * @Modified By:
 */
public interface ICustomizeErrorCode {
    String getMessage() ;
    Integer getCode();
}
