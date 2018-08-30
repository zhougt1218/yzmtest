package com.sdyy.springboot.cs.controller;
import java.util.Random;

public class SuiJiShuTest {

	public static int SJTest(){
		Random rd=new Random();
        int n=rd.nextInt(999)*999;
        return n;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(SuiJiShuTest.SJTest());;
	}

}
