package com.github.mcp.fintech;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.mcp.fintech.service.AccountService;

@SpringBootApplication
public class FintechMcpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FintechMcpServerApplication.class, args);
	}

	@Bean
	public ToolCallbackProvider fintechTools(AccountService accountService) {
		return MethodToolCallbackProvider.builder().toolObjects(accountService).build();
	}

}
