// An animal shelter holds only dogs and cats, and operates on a strictly ¡°first in, first out¡± basis.
// People must adopt either the ¡°oldest¡± (based on arrival time) of all animals at the shelter, or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
// They cannot select which specific animal they would like.
// Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog and dequeueCat.
// You may use the built-in LinkedList data structure.

package StacksAndQueues;

import java.util.LinkedList;

public class q7 {
	
	public abstract class Animal {
		private int older;
		protected String name;
		
		public Animal(String n) {
			this.name = n;
		}
		
		public void setOld(int o) {
			this.older = o;
		}
		
		public int getOld() {
			return older;
		}
		
		public boolean isOlder(Animal a) {
			return this.getOld()> a.getOld();
		}
	}
	
	public class Cat extends Animal {

		public Cat(String n) {
			super(n);
		}
	}
	
	public class Dog extends Animal {

		public Dog(String n) {
			super(n);
		}
		
	}
	
	public class AnimalQuene {
		
		LinkedList<Cat> catList = new LinkedList<Cat>();
		LinkedList<Dog> dogList = new LinkedList<Dog>();
		private int o = 0;
		
		public void enqueue(Animal a) {
			
			a.setOld(o);
			o++;
			if (a instanceof Cat) 
				catList.addLast((Cat)a);
			else if (a instanceof Dog)
				dogList.addLast((Dog)a);
		}

		public Dog dequeueDog() {
			return dogList.poll();

		}
		
		public Cat dequeueCat() {
			return catList.poll();
		}
		
		public Animal dequeueAny() {
			if (dogList.isEmpty())
				return dequeueCat();
			else if (catList.isEmpty())
				return dequeueDog();
			
			Cat c = catList.peek();
			Dog d = dogList.peek();
			if(c.isOlder(d))
				return dequeueCat();
			else
				return dequeueDog();
		}
		
	}

}
