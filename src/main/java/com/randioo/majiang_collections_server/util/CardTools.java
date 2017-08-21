package com.randioo.majiang_collections_server.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.randioo.majiang_collections_server.entity.po.CardSort;

public class CardTools {
	public static final int TONG = 1;
	public static final int TIAO = 2;
	public static final int WAN = 3;
	public static final int ZHONG = 8;

	public final static int[] CARDS = { 101, 102, 103, 104, 105, 106, 107, 108, 109, // 条
			101, 102, 103, 104, 105, 106, 107, 108, 109, // 条
			101, 102, 103, 104, 105, 106, 107, 108, 109, // 条
			101, 102, 103, 104, 105, 106, 107, 108, 109, // 条

			201, 202, 203, 204, 205, 206, 207, 208, 209, // 筒
			201, 202, 203, 204, 205, 206, 207, 208, 209, // 筒
			201, 202, 203, 204, 205, 206, 207, 208, 209, // 筒
			201, 202, 203, 204, 205, 206, 207, 208, 209, // 筒

			301, 302, 303, 304, 305, 306, 307, 308, 309, // 万
			301, 302, 303, 304, 305, 306, 307, 308, 309, // 万
			301, 302, 303, 304, 305, 306, 307, 308, 309, // 万
			301, 302, 303, 304, 305, 306, 307, 308, 309, // 万
			// 401, 401, 401, 401,// 东
			// 501, 501, 501, 501,// 南
			// 601, 601, 601, 601,// 西
			// 701, 701, 701, 701,// 北
			801, 801, 801, 801,// 中
	// 901, 901, 901, 901,// 发
	// 1001, 1001, 1001, 1001,// 白
	// 1101,// 春
	// 1102,// 夏
	// 1103,// 秋
	// 1104,// 冬
	// 1105,// 梅
	// 1106,// 兰
	// 1107,// 竹
	// 1108,// 菊
	// B9,// 财神
	// BA,// 猫
	// BB,// 老鼠
	// BC,// 聚宝盆
	// C1,// 白搭
	// C1,// 白搭
	// C1,// 白搭
	// C1,// 白搭

	// 11, 12, 13, 14, 15, 16, 17, 18, 19, // 条
	// 11, 12, 13, 14, 15, 16, 17, 18, 19, // 条
	// 11, 12, 13, 14, 15, 16, 17, 18, 19, // 条
	// 11, 12, 13, 14, 15, 16, 17, 18, 19, // 条
	//
	// 21, 22, 23, 24, 25, 26, 27, 28, 29, // 筒
	// 21, 22, 23, 24, 25, 26, 27, 28, 29, // 筒
	// 21, 22, 23, 24, 25, 26, 27, 28, 29, // 筒
	// 21, 22, 23, 24, 25, 26, 27, 28, 29, // 筒
	//
	// 31, 32, 33, 34, 35, 36, 37, 38, 39, // 万
	// 31, 32, 33, 34, 35, 36, 37, 38, 39, // 万
	// 31, 32, 33, 34, 35, 36, 37, 38, 39, // 万
	// 31, 32, 33, 34, 35, 36, 37, 38, 39, // 万
	// // 41, 41, 41, 41,// 东
	// // 51, 51, 51, 51,// 南
	// // 61, 61, 61, 61,// 西
	// // 71, 71, 71, 71,// 北
	// 81, 81, 81, 81,// 中
	// 91, 91, 91, 91,// 发
	// A1, A1, A1, A1,// 白
	// B1,// 梅
	// B2,// 兰
	// B3,// 竹
	// B4,// 菊
	// B5,// 春
	// B6,// 夏
	// B7,// 秋
	// B8,// 冬
	// B9,// 财神
	// BA,// 猫
	// BB,// 老鼠
	// BC,// 聚宝盆
	// C1,// 白搭
	// C1,// 白搭
	// C1,// 白搭
	// C1,// 白搭
	};

	public static void main(String[] args) {
		CardSort cardSort = new CardSort(4);
		List<Integer> cards = new ArrayList<>();

		cards.add(1);
		cards.add(1);
		cards.add(1);
		cards.add(3);
		cards.add(4);
		cards.add(2);
		cards.add(2);
		cards.add(2);

		cardSort.fillCardSort(cards);
		for (Set<Integer> set : cardSort.getList()) {
			System.out.println(set);
		}
	}

}
