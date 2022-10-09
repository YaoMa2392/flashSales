package org.example.flashSales.controller.user;

import org.example.flashSales.domain.User;
import org.example.flashSales.result.ServerResponse;
import org.example.flashSales.service.UserService;
import org.example.flashSales.vo.LoginInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @description: 用户登录Controller
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public ServerResponse<String> doLogin(HttpServletResponse response, @Valid LoginInfoVO loginInfoVO) {
        // 打印用户输入信息日志
        logger.info(loginInfoVO.toString());
        // 登录，出错会抛出全局异常，并被捕获处理
        String token = userService.login(response, loginInfoVO);
        // 直接返回true即可
        return ServerResponse.success(token);
    }

    /**
     * 根据Token获取用户信息
     * @param user
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public ServerResponse<User> userInfo(User user) {
        return ServerResponse.success(user);
    }
}