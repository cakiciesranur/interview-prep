package crackingCodingInterview._03stacksAndQueues;

import java.util.LinkedList;

/**
 * Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
 * out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 * or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
 * that type). They cannot select which specific animal they would like. Create the data structures to
 * maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
 * and dequeueCat. You may use the built-in Linkedlist data structure.
 */
public class _06_animalShelter {

    public class AnimalQueue {

        LinkedList<Dog> dogs = new LinkedList<>();
        LinkedList<Cat> cats = new LinkedList<>();
        int order = 0;

        public void enqueue(Animal a) {
            a.setOrder(order);
            order++;
            if (a instanceof Dog) {
                dogs.addLast((Dog) a);
            }
            if (a instanceof Cat) {
                cats.addLast((Cat) a);
            }
        }

        public Animal dequeueAny() {
            if (dogs.isEmpty() && cats.isEmpty()) {
                return null;
            }

            if (dogs.isEmpty()) {
                return dequeueCats();
            }
            if (cats.isEmpty()) {
                return dequeueDogs();
            }

            Dog dog = dogs.peek();
            Cat cat = cats.peek();

            if (dog.isOlderThan(cat)) {
                return dequeueCats();
            } else {
                return dequeueDogs();
            }
        }

        private Animal dequeueCats() {
            return cats.poll();
        }

        private Animal dequeueDogs() {
            return dogs.poll();
        }
    }
}

abstract class Animal {
    private int order;
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOlderThan(Animal a) {
        return this.order < a.order;
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}