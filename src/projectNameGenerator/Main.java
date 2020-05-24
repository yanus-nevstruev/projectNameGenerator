package projectNameGenerator;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Main {



    public static void main(String[] args)  {
        //Для проверки создаём лист из 100 последовательных чисел и удаляем 50 случайных
        Random random = new Random();
        List<Integer> integerList = Stream.iterate(1,x->x+1).limit(100).collect(Collectors.toList());
        for (int i = 0; i < 50; i++) integerList.remove(random.nextInt(integerList.size()-i));
        integerList.stream().sorted().forEach(System.out::println);

        //Вывод результатов самого метода
        System.out.println("Искомый номер для проекта N = " + generateNum(integerList));

    }

    /**
     * Generate three-digit string meaning number of new project.
     *
     * Method will be first space in List, which passing in parameter of method.
     *
     * As example in List{1,2,3,4,4,6,6,7,8} it returns String "005" ('5' is space of this list);
     *
     * Method will return {@Code maximal element + 1 } if original list will be present as simple sequence.
     *
     * As example in List{1,2,3,4,5} it returns String "006" ( 5 + 1 )
     *
     * @param numbers the non-uniq numbers of existing projects
     * @return the string
     */

    public static String generateNum(List<Integer> numbers){
        return  String.format("%03d", numbers.stream().reduce(0,(first,second) -> second - first == 1 ? second : first) + 1);
    }


}
