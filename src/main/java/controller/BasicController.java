package controller;
import entity.ResponseMessage;
import exception.WebsiteHttpException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller 基础类
 */
@RequestMapping("/website")
@Controller
class BasicController {
    // SLF4J日志
    private static final Logger logger = LoggerFactory.getLogger(BasicController.class);

    @Autowired
    private HttpServletRequest request;

    /**
     * 构造器
     */
    public BasicController() {
    }

    /**
     * 系统层-异常处理
     *
     * @return
     */
    @ExceptionHandler
    public ResponseMessage exception(Exception ex) {
        ex.printStackTrace();
        if (ex instanceof WebsiteHttpException) {
            return new ResponseMessage(ResponseMessage.RESPONSE_STATUS_ERROR, "HTTP请求出现错误",
                    ExceptionUtils.getMessage(ex), 30000);
        } else {
            return new ResponseMessage(ResponseMessage.RESPONSE_STATUS_ERROR, "内部错误",
                    ExceptionUtils.getMessage(ex), -10000);
        }
    }

    // 无明确失败原因的标识为服务器内部错误，无返回数据
    public ResponseMessage failMessage() {
        // 无明确失败原因的标识为服务器内部错误
        return failMessage(-10000);
    }

    // 无明确失败原因的标识为服务器内部错误，有返回数据
    public ResponseMessage failMessage(Object object) {

        return failMessage(-10000, object);
    }

    // 无失败附加
    public ResponseMessage failMessage(int code) {
        return failMessage(code, null);
    }

    // 验证类失败
    public ResponseMessage illegalMessage(String field, String message) {
        Map<String, String> illegal = new HashMap<String, String>();
        illegal.put("field", field);
        illegal.put("illegal", message);
        return failMessage(20000, illegal);
    }

    /**
     * 业务层-执行结果成功
     *
     * @param data
     * @return
     */
    public ResponseMessage successMessage(final Object data) {
        return new ResponseMessage(ResponseMessage.RESPONSE_STATUS_SUCCESS, null, data, null);
    }

    /**
     * 验证框架-返回验证结果
     */
    public Map<String, Boolean> validMessageMessage(final Boolean valid) {
        Map ret = new HashMap<String, Boolean>();
        ret.put("valid", valid);
        return ret;
    }

    /**
     * 业务层-执行结果失败
     *
     * @param code 失败码
     * @param data 失败后返回内容
     * @return
     */
    public ResponseMessage failMessage(int code, Object data) {
        return new ResponseMessage(ResponseMessage.RESPONSE_STATUS_FAIL, "10000", data, code);
    }


}
