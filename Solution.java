package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Human children1 = new Human("Apple", true, 5);
        Human children2 = new Human("Watermelon", true, 7);
        Human children3 = new Human("Melon", false, 12);

        Human father = new Human("Tomato", true, 45, children1, children2, children3);
        Human mother = new Human("Carrot", false, 35, children1, children2, children3);


        Human grandFather1 = new Human("Cucumber", true, 70, father);
        Human grandMother1 = new Human("Potato", false, 65, father);


        Human grandFather2 = new Human("Garlic", true, 71, mother);
        Human grandMother2 = new Human("BeetRoot", false, 67, mother);

        System.out.println(grandFather1.toString());
        System.out.println(grandFather2.toString());
        System.out.println(grandMother1.toString());
        System.out.println(grandMother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(children1.toString());
        System.out.println(children2.toString());
        System.out.println(children3.toString());

    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children.add(children);
        }


        public Human(String name, boolean sex, int age, Human children1, Human children2, Human children3) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children.add(children1);
            this.children.add(children2);
            this.children.add(children3);
        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
