import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> listaMiast = new LinkedList<String>();
        addInOrder(listaMiast, "Radom");
        addInOrder(listaMiast, "Warszawa");
        addInOrder(listaMiast, "Dębki");
        addInOrder(listaMiast, "Kraków");
        addInOrder(listaMiast, "Szklarska Poręba");
        addInOrder(listaMiast, "Szczawnica");
        addInOrder(listaMiast, "Rajec");
        printList(listaMiast);
        visit(listaMiast);
    }
    public static void printList (LinkedList<String> listaMiast){
        Iterator<String> iteratorMiast = listaMiast.iterator();
        while (iteratorMiast.hasNext()){
            System.out.println(iteratorMiast.next());
        }
        System.out.println("==============");
    }
    public static boolean addInOrder (LinkedList<String> listaMiast, String newCity){
        ListIterator<String> iteratorMiast = listaMiast.listIterator();
            while (iteratorMiast.hasNext()) {
                int compare = iteratorMiast.next().compareTo(newCity);
                if (compare == 0) {
                    System.out.println("The city " + newCity + " is already on the list");
                    return true;
                } else if (compare > 0) {
                    iteratorMiast.previous();
                    iteratorMiast.add(newCity);
                    return true;
                }
            }
            iteratorMiast.add(newCity);
            return true;
    }
    public static void visit (LinkedList listaMiast){
        ListIterator<String> iteratorMiast = listaMiast.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean goingForward = true;
        boolean quit = false;
        if (listaMiast.isEmpty()) {
            System.out.println(" There's no cities on your list yet. Add some!");
            quit = true;
        }
        else {
            printMenu();
            while(!quit) {
                int action = scanner.nextInt();
                scanner.nextLine();
                switch (action) {
                    case 0:
                        System.out.println("Holidays are over!");
                        quit = true;
                        break;
                    case 1:
                        if (!goingForward){
                            if (iteratorMiast.hasNext()){
                                iteratorMiast.next();
                            }
                            goingForward = true;
                        }
                        if (iteratorMiast.hasNext()){
                            System.out.println("Now you are visiting " + iteratorMiast.next());
                            break;
                        }
                        else {
                            System.out.println("You are at the end of the list!");
                            goingForward = false;
                            break;
                        }
                    case 2:
                        if (goingForward){
                            if (iteratorMiast.hasPrevious()){
                                iteratorMiast.previous();
                            }
                            goingForward = false;
                        }
                        if (iteratorMiast.hasPrevious()){
                            System.out.println("Now you are visiting " + iteratorMiast.previous());
                            break;
                        }
                        else{
                            System.out.println("You are at the beginning of the list!");
                            goingForward = true;
                            break;
                        }
                    case 3:
                        printMenu();
                        break;
                    default:
                        System.out.println("Invalid choice. Try again!");
                        break;
                }
            }
        }
    }
    public static void printMenu(){
        System.out.println("Choose your option:\n" +
                "0 - End holidays\n" +
                "1 - Travel forward\n" +
                "2 - Travel backwards\n" +
                "3 - Printe menu again\n");
    }
}
