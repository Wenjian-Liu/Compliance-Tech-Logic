package com.itheima.demo2map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTraverseDemo3 {
	public static void main(String[] args) {
		// 目标：掌握Map集合的遍历方式一：键找值
		Map<String, Integer> map = new HashMap<>();
		map.put("张三", 23);
		map.put("王五", 25);
		map.put("赵六", 26);
		map.put("张三", 25);
		map.put("李四", 28);
		System.out.println(map);

		// 1. 提取Map集合中所有的键到一个Set集合中
		Set<String> keys = map.keySet();
		System.out.println(keys);

		// 2. 遍历Set集合，得到每一个键
		for (String key : keys) {
			// 3. 根据键，获取对应的值
			Integer value = map.get(key);
			System.out.println(key + "=" + value);
		}
	}
}
