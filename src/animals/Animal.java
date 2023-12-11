package animals;

import validators.NumberValidator;

import java.util.Scanner;

public abstract class Animal {
    private String name="";
    private int age = -1;
    private int weight=-1;
    private String color="";

    NumberValidator numberValidator = new NumberValidator();

    public void setName(String name){
        this.name=name;
    }
    public void setAge(Scanner scanner) {
        int animalAge = -1;
        while (true) {
            String ageStr = scanner.next();
                if (numberValidator.isNumber(ageStr)) {
                    animalAge = Integer.parseInt(ageStr);
                    if (animalAge>50||animalAge<0){
                        System.out.println("Ввели некорректный возраст. Допустимый возраст от 0 до 50");
                        System.out.println("Введите возраст");
                        continue;
                    }
                    break;
                }
            System.out.println("Возраст должен быть числом");
            System.out.println("Введите возраст");
            }
            this.age = animalAge;
        }
    public void setWeight(Scanner scanner){
        int animalWeight = -1;
        while (true) {
            String weightStr = scanner.next();
            if (numberValidator.isNumber(weightStr)) {
                animalWeight = Integer.parseInt(weightStr);
                if (animalWeight>100||animalWeight<=0){
                    System.out.println("Ввели некорректный вес. Допустимый вес от 1 до 100");
                    System.out.println("Введите вес");
                    continue;
                }
                break;
            }
            System.out.println("Вес должен быть числом");
            System.out.println("Введите вес");
        }
        this.weight=animalWeight;
    }
    public void setColor(String color){
        this.color = color;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getWeight(){
        return weight;
    }
    public String getColor(){
        return color;
    }



    public void say(){
        System.out.println("Я говорю");
    }

    public void go(){
        System.out.println("Я иду");
    }

    public void drink(){
        System.out.println("Я пью");
    }

    public void eat(){
        System.out.println("Я ем");
    }

    @Override
    public String toString(){
        return String.format("Привет! меня зовут %s, мне %d %s, я вешу - %d кг, мой цвет - %s",
                this.name,
                this.age,
                getYearPadej(),
                this.weight,
                this.color);
    }

    private String getYearPadej() {
        if(this.age>=11 && this.age<=19){
            return "лет";
        }

        int ostatok = this.age % 10;

        if (ostatok==0||ostatok>=5){
            return "лет";
        }

        if(ostatok==1){
            return "год";
        }

        if(ostatok>=2){
            return "года";
        }

        return null;
    }
}
