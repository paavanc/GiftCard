package com.giftcard.price;

import java.io.FileInputStream;
import java.io.IOException;

import com.giftcard.price.manager.impl.GiftCardManagerImpl;

public class PriceApplication {

	public static void main(String[] args) throws NumberFormatException, IOException {
		GiftCardManagerImpl gi = new GiftCardManagerImpl();
		System.out.println(gi.findPair(new FileInputStream(args[0]), Integer.parseInt(args[1])));
	}
}
