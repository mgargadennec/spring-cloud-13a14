package com.cardiweb.cloud.user.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("ORDER")
public interface OrderClient {

	@RequestMapping(method = RequestMethod.GET, value = "/test")
	public String getTest();

	@RequestMapping(method = RequestMethod.GET, value = "/whoami")
	public String getWhoAmI();
	
}
