package com.cardiweb.cloud.order.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("USER")
public interface UserClient {

	@RequestMapping(method = RequestMethod.GET, value = "/test2")
	public String getTestNonExistentService();

	@RequestMapping(method = RequestMethod.GET, value = "/whoami")
	public String getWhoAmI();
}
