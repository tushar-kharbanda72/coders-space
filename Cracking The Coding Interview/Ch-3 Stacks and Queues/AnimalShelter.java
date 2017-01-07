//Problem 3.6 - Animal Shelter 
import java.util.LinkedList;
abstract class Animal{
	String name;
	int order;
	public Animal(String n){
		name = n;
	}
	public void setOrder(int o){
		order = o;
	}
	private int getOrder(){
		return order;
	}
	public boolean isOlder(Animal a){
		return this.order < a.getOrder();
	}
}

class AnimalQueue{
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0;

	public void enque(Animal a){
		a.setOrder(order);
		order++;

		if(a instanceof Dog)
			dogs.addLast((Dog)a);
		else if(a instanceof Cat){
			cats.addLast((Cat)a);
		}		
	}

	public Animal dequeAny(){
		if(dogs.size() == 0){
			return dequeCats();
		}else if(cats.size() == 0){
			return dequeDogs();
		}
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if(dog.isOlder(cat)){
			return dequeDogs();
		}else{
			return dequeCats();
		}

	}
	public Cat dequeCats(){
		return cats.poll();
	}
	public Dog dequeDogs(){
		return dogs.poll();
	}

}

class Dog extends Animal{
	public Dog(String n){
		super(n);
	}
}
class Cat extends Animal{
	public Cat(String n){
		super(n);
	}
}

public class AnimalShelter{
	public static void main(String[] args){
		AnimalQueue q = new AnimalQueue();
		q.enque(new Dog("tommy"));
		q.enque(new Dog("max"));
		q.enque(new Cat("lucy"));
		q.enque(new Dog("charlie"));
		q.enque(new Cat("meaoww"));
		System.out.println(q.dequeAny().name);
		System.out.println(q.dequeCats().name);
		System.out.println(q.dequeDogs().name);

	}
}
