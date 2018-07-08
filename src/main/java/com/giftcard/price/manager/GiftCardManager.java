package com.giftcard.price.manager;

import java.io.IOException;

public interface GiftCardManager {

	String findPair(String file, int target) throws IOException;

}