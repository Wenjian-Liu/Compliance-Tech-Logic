package com.itheima.demo2map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class MapTraverseDemo5 {
	public static void main(String[] args) {
		// 目标：掌握Map集合的遍历方式三：Lambda
		Map<String, Integer> map = new HashMap<>();
		map.put("张三", 23);
		map.put("王五", 25);
		map.put("赵六", 26);
		map.put("张三", 25);
		map.put("李四", 28);
		System.out.println(map);

		// 1. 直接调用Map集合的forEach方法完成遍历
//		map.forEach(new BiConsumer<String, Integer>() {
//			@Override
//			public void accept(String key, Integer value) {
//				System.out.println(key + "=" + value);
//			}
//		});

		map.forEach((k, v) -> System.out.println(k + "=" + v));

	}
}
