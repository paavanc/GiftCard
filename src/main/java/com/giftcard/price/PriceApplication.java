package com.giftcard.price;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.giftcard.price.manager.impl.GiftCardManagerImpl;

//@SpringBootApplication
public class PriceApplication {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//SpringApplication.run(PriceApplication.class, args);
		GiftCardManagerImpl gi = new GiftCardManagerImpl();
		System.out.println(gi.findPair(new FileInputStream(args[0]), Integer.parseInt(args[1])));
	}
}
