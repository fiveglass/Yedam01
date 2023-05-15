package com.yedam.abs;

public class AnimalExample {
	public static void main(String[] args) {
	Dog dog = new Dog();
	Cat cat = new Cat();
	dog.sound();
	cat.sound();
	System.out.println("-----------");
	
	//추상클래스 다형성 변형
	//스스로를 객체로 만들지 못하기 때문
	//변수의 다형성/ 필드의 다형성
	Animal animal = dog;
	animal.sound();
	
	animal = cat;
	animal.sound();
	
	animalSound(new Dog());
	}
	
	
	
	//매개변수의 다형성을 활용
	public static void animalSound(Animal animal) {
		animal.sound();
	}
}


