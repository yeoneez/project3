package com.example.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Chef {

	private String name;
	
	public Chef()
	{
		name="백종원";
	}
}
