package com.luv2code.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration //spring in bir par�as� oldu�unu s�yl�yoruz
@EnableAspectJAutoProxy //hedef nesenleri �a��rmak i�in proxy'ler kullabiliriz , spring aop proxy support
@ComponentScan("com.luv2code.aopdemo") //bean veya spring componentlerinin nereye gidip taranac���n� s�yler
public class DemoConfig {
	
	
}
