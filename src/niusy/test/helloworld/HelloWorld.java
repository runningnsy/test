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
		attribute.add("attributeH");
		attribute.add("attributeH");
		list.add(2);
		attribute.add("attriB");
		list.add(3);
		attribute.add("attributeB");
		System.out.println(list);
	}
	public static void main(String[] args) {
		System.out.println(str1 + str2);
		HelloWorld hw = new HelloWorld();
		hw.getNumberOfList();
	}

}
