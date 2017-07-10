package com.ithema.demo;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class TestXPath {
	public static void main(String[] args) throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/Dom4jTest.xml");
		List nodes = document.selectNodes("/bookstore//book/title");//两个杠表示忽略深度后的book

		for (int i = 0; i < nodes.size(); i++) {
			Node node = (Node) nodes.get(i);
			System.out.println(node.getText());
		}
	}
}
