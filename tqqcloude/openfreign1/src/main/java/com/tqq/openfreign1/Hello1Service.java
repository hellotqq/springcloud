package com.tqq.openfreign1;

import com.tqq.api.IUserService;
import com.tqq.commoms.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author ： tqq
 * @date ： 2020/9/28 10:58
 * @Description:
 */
@FeignClient(value = "provider",fallback = HelloServiceFallBack.class)
public interface Hello1Service extends IUserService {

}
