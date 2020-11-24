package com.luv2code.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration //spring in bir parçasý olduðunu söylüyoruz
@EnableAspectJAutoProxy //hedef nesenleri çaðýrmak için proxy'ler kullabiliriz , spring aop proxy support
@ComponentScan("com.luv2code.aopdemo") //bean veya spring componentlerinin nereye gidip taranacýðýný söyler
public class DemoConfig {
	
	
}
