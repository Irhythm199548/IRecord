

package com.how2java.tmall.web;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.UserService;
import com.how2java.tmall.util.Page4Navigator;

@RestController
public class UserController {
	@Autowired UserService userService;

    @GetMapping("/users")
    public Page4Navigator<User> list(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
    	start = start<0?0:start;
    	Page4Navigator<User> page = userService.list(start,size,5);
        return page;
    }

    @GetMapping("/usersQyery")
    public JSONObject queryTest(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        String msg = "测试连接通过";
        String json = "{\"2\":\"efg\",\"1\":\"abc\"}";
        JSONObject json_test = JSONObject.fromObject(json);
        System.out.println("收到访问请求");
        return json_test;
    }


}



