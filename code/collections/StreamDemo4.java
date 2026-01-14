package com.itheima.demo3stream;

import com.itheima.demo1hashset.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo4 {
	public static void main(String[] args) {
		// 目标：掌握Stream的统计、收集操作（终结方法）
		List<Student> students = new ArrayList<>();
		students.add(new Student("小王", 18, "北京", "110"));
		students.add(new Student("张三", 19, "上海", "152346"));
		students.add(new Student("金毛狮王", 54, "河北", "115470"));
		students.add(new Student("小明", 33, "北京", "154410"));

		students.stream().filter(s -> s.getAge() > 30).forEach(System.out::println);

		System.out.println("------------------------------------------------");

		long count = students.stream().filter(s -> s.getAge() > 30).count();
		System.out.println(count);

		System.out.println("------------------------------------------------");

		Optional<Student> max = students.stream().max((s1, s2) -> s1.getAge() - s2.getAge());
		Student maxStudent = max.get();
		System.out.println(maxStudent);
		System.out.println("------------------------------------------------");

		Optional<Student> min = students.stream().min((s1, s2) -> s1.getAge() - s2.getAge());
		Student minStudent = min.get();
		System.out.println(minStudent);
		System.out.println("------------------------------------------------");

		List<String> list = new ArrayList<>();
		list.add("张无忌");
		list.add("周芷若");
		list.add("赵敏");
		list.add("张强");
		list.add("张三丰");
		list.add("张三丰");
		list.add("张翠山");

		Stream<String> name1 = list.stream().filter(name -> name.startsWith("张"));
		List<String> list1 = name1.collect(Collectors.toList());
		System.out.println(list1);

//		Set<String> set2 = new HashSet<>();
//		set2.addAll(list1);

		// 收集到Set集合
		Stream<String> name2 = list.stream().filter(name -> name.startsWith("张"));
		Set<String> set = name2.collect(Collectors.toSet());
		System.out.println(set);

		Stream<String> name3 = list.stream().filter(name -> name.startsWith("张"));
		Object[] array = name3.toArray();
		System.out.println("数组：" + Arrays.toString(array));
		System.out.println("-------------------");

		Map<String, Integer> map = students.stream().collect(Collectors.toMap(Student::getName, Student::getAge));
		System.out.println(map);
	}
}
