package com.giftcard.price.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.giftcard.price.manager.GiftCardManager;
import com.giftcard.price.manager.impl.GiftCardManagerImpl;

@Configuration
public class BeanConfig {
	
	@Bean
	GiftCardManager getGiftCardManager() {
		return new GiftCardManagerImpl();
	}

}
