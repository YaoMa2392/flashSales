package org.example.flashSales.controller.user;

import org.example.flashSales.result.ServerResponse;
import org.example.flashSales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 用户注册Controller
 */
@Controller
@RequestMapping("/user")
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("/batch_register/{num}")
    @ResponseBody
    public ServerResponse<Boolean> batchRegister(@PathVariable("num") Integer num) {
        userService.batchRegister(num);
        return ServerResponse.success(true);
    }
}