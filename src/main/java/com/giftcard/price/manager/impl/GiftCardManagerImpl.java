package com.giftcard.price.manager.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.giftcard.price.manager.GiftCardManager;
import com.giftcard.price.vo.Gift;

public class GiftCardManagerImpl implements GiftCardManager {

	private static final String NOT_POSSIBLE = "Not possible";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.giftcard.price.manager.impl.GiftCardManager#findPair(java.lang.String,
	 * int)
	 */
	@Override
	public String findPair(InputStream inputStream, int target) throws IOException {

		Map<Integer, Gift> gifts = readFile(inputStream);
		int tmpMax = 0;
		int right = gifts.size() - 1;
		int left = 0;
		int savedRight = -1;
		int savedLeft = -1;
		while (left < right) {
			Gift lg = gifts.get(left);
			Gift rg = gifts.get(right);
			int leftPrice = lg.getPrice();
			int rightPrice = rg.getPrice();
			int tmpSum = leftPrice + rightPrice;
			if (tmpMax < tmpSum && tmpSum <= target) {
				tmpMax = tmpSum;
				savedRight = right;
				savedLeft = left;
			}
			if (tmpSum == target) {
				return getPair(lg, rg);
			} else if (tmpSum < target) {
				left++;
			} else {
				right--;
			}
		}
		if (savedRight == -1) {
			return NOT_POSSIBLE;
		}
		return getPair(gifts.get(savedLeft), gifts.get(savedRight));

	}

	private String getPair(Gift g1, Gift g2) {
		return g1.toString() + ", " + g2.toString();
	}

	private Map<Integer, Gift> readFile(InputStream inputStream) throws IOException {
		Map<Integer, Gift> result = new HashMap<>();
		int counter = 0;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] tmpArr = line.split(",");
				result.put(counter, new Gift(tmpArr[0], Integer.parseInt(tmpArr[1].trim())));
				counter++;
			}
		}
		return result;
	}

}
