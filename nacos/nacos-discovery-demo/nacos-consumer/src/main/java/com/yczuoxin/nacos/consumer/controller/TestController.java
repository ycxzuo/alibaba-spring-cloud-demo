package com.yczuoxin.nacos.consumer.controller;

import com.yczuoxin.nacos.consumer.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private RestTemplate restTemplate1;

	@Autowired
	private EchoService echoService;

	@Autowired
	private DiscoveryClient discoveryClient;

    @GetMapping(value = "/echo-rest/{str}")
	public String rest(@PathVariable String str) {
		return restTemplate.getForObject("http://nacos-provider/echo/" + str,
				String.class);
	}

	@GetMapping(value = "/index")
	public String index() {
		return restTemplate1.getForObject("http://nacos-provider", String.class);
	}

	@GetMapping(value = "/test")
	public String test() {
		return restTemplate1.getForObject("http://nacos-provider/test", String.class);
	}

	@GetMapping(value = "/sleep")
	public String sleep() {
		return restTemplate1.getForObject("http://nacos-provider/sleep", String.class);
	}

	@GetMapping(value = "/notFound-feign")
	public String notFound() {
		return echoService.notFound();
	}

	@GetMapping(value = "/divide-feign")
	public String divide(@RequestParam Integer a, @RequestParam Integer b) {
		return echoService.divide(a, b);
	}

	@GetMapping(value = "/echo-feign/{str}")
	public String feign(@PathVariable String str) {
		return echoService.echo(str);
	}

	@GetMapping(value = "/services/{service}")
	public Object client(@PathVariable String service) {
		return discoveryClient.getInstances(service);
	}

	@GetMapping(value = "/services")
	public Object services() {
		return discoveryClient.getServices();
	}

}
