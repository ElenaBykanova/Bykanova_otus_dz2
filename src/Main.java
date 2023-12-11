import animals.Animal;
import animals.birds.IFlying;
import data.AnimalData;
import data.CommandsData;
import factory.AnimalFactory;
import validators.DataValidator;
import validators.NumberValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Animal> animalList = new ArrayList<>();

        AnimalFactory animalFactory = new AnimalFactory();
        DataValidator commandValidator = new DataValidator();
        NumberValidator numberValidator = new NumberValidator();


       while(true) {
           System.out.println("Введите команду: add/list/exit");
           String commandStr = scanner.next().toUpperCase().trim();

           if (!commandValidator.validate(commandStr,CommandsData.values())) {
               System.out.println("Вы ввели неверную команду");
               continue;
           }


           CommandsData commandsData = CommandsData.valueOf(commandStr);

           switch (commandsData){
               case ADD:

                   String animalTypeStr="";
                   while(true) {
                       System.out.println("Введите тип животного: cat/dog/duck");
                       animalTypeStr = scanner.next().toUpperCase().trim();

                       if (commandValidator.validate(animalTypeStr, AnimalData.values())) {
                          break;
                       }
                       System.out.println("Вы ввели неверный тип животного");
                   }

                   Animal animal = animalFactory.create(AnimalData.valueOf(animalTypeStr));

                   System.out.println("Введите имя");
                   String name = scanner.next();
                   animal.setName(name);

                   System.out.println("Введите возраст животного");
                   animal.setAge(scanner);

                   System.out.println("Введите вес животного");
                   animal.setWeight(scanner);

                   System.out.println("Введите цвет");
                   String colorStr = scanner.next();
                   animal.setColor(colorStr);

                    animalList.add(animal);
                    animal.say();
                   if (animal instanceof IFlying) {
                       ((IFlying) animal).fly();
                   }
                    break;

               case LIST:

                   if (animalList.isEmpty()){
                       System.out.println("В списке с животными пусто");
                       continue;
                   }

               for(Animal animalObj: animalList){
                       System.out.println(animalObj.toString());
                   }
               break;
               case EXIT:
                   System.exit(0);
           }
       }


    }
}
