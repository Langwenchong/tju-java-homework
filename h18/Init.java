package com.huawei.classroom.student.h18;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Init{
	
	public static Map<String,Map<String,Object>> myClasses=new HashMap();
	
	public static void Initialization(String filename) throws IOException {
		BufferedReader reader=null;
		try {
			reader=new BufferedReader(new FileReader(filename));
			String Line=new String();
			while(true) {
				Line=reader.readLine();
				if(Line==null) break;
				if(Line.isEmpty()||Line.charAt(0)=='#'||Line.charAt(0)==' ') continue;
				else {
					if(Line.charAt(0)==' ') continue;
					Line=Line.trim();
					String[] content1=Line.split("=");
					String[] content2=content1[0].split("\\.");
					String property=content2[6];
					String className=content1[0].substring(0, content1[0].lastIndexOf(property)-1);
					Map<String,Object> parameter=new HashMap<>();
					if(myClasses.containsKey(className)) {
						parameter=myClasses.get(className);
						if(content1[1].charAt(0)=='\"') {
							String value=content1[1].replaceAll("\"", "");
							parameter.put(property, value);
						}
						else {
							int value=Integer.valueOf(content1[1]);
							parameter.put(property, value);
						}
						myClasses.put(className, parameter);
					}
					else {
						myClasses.put(className, parameter);
						parameter=myClasses.get(className);
						if(content1[1].charAt(0)=='\"') {
							String value=content1[1].replaceAll("\"", "");
							parameter.put(property, value);
						}
						else {
							int value=Integer.valueOf(content1[1]);
							parameter.put(property, value);
						}
						myClasses.put(className, parameter);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}