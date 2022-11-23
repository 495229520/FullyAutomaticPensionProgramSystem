package mvc.mqtt.controller;

import mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 包名:mvc.mqtt.controller
 *
 * @author hwf
 * 日期2022-10-2022/10/30   21:59
 */

@Controller
public class MessageController {

    @Autowired
    private UserService userService;



}
