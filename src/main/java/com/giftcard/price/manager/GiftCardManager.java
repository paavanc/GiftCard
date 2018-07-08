package com.giftcard.price.manager;

import java.io.IOException;
import java.io.InputStream;

public interface GiftCardManager {

	String findPair(InputStream inputStream, int target) throws IOException;

}