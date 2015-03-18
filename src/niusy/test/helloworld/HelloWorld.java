package niusy.test.helloworld;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

	static String str1 = "Hello World,";
	static String str2 = "I Love You!";
	List<String> attribute = new ArrayList<String>();
	List<Integer> list = new ArrayList<Integer>();

	public void getNumberOfList(){
		list.add(1);
		//delete
		attribute.add("attributeKD");
		attribute.add("attributeKD");
		list.add(2);
		attribute.add("attriB");
		list.add(3);
		//add
		attribute.add("attributeB");
		System.out.println(list);
		System.out.println(attribute);
	}
	public static void main(String[] args) {
		//test1
		System.out.println(str1 + str2);
		HelloWorld hw = new HelloWorld();
		hw.getNumberOfList();
		System.out.println(hw.list);
		System.out.println(hw.attribute);
		//end1
		//end2
		//end3
		//end4
	}

}
