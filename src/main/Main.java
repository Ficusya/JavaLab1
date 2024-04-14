package main;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyVeryGoodContainer myContainer = new MyVeryGoodContainer();

        //Adding elements to the container:

        //Adding elements to "head" of my container
        myContainer.addToHead(10);
        myContainer.addToHead(2);
        myContainer.addToHead(1);

        myContainer.printContainer();

        //Adding elements to "tail" of my container
        myContainer.addToTail(5);
        myContainer.addToTail(6);
        myContainer.addToTail(7);

        myContainer.printContainer();

        //Adding elements by index
        myContainer.addToIndex(3, 4);
        myContainer.addToIndex(5, 10);

        myContainer.printContainer();

        //Extraction of elements from the container

        //Extracting first element
        int extractedFirstValue = myContainer.extractFirst();
        System.out.println(extractedFirstValue);

        //Extracting last element
        int extractedLastValue = myContainer.extractLast();
        System.out.println(extractedLastValue);

        //Extracting element by index
        int extractedValue = myContainer.extractAtIndex(2);
        System.out.println(extractedValue);

        //Showing that elements are extracted from my container
        myContainer.printContainer();

        //Deletion of elements from the container

        //Deleting first element
        myContainer.deleteFirst();

        //Deleting last element
        myContainer.deleteLast();

        //Deleting element by index
        myContainer.deleteAtIndex(1);

        myContainer.printContainer();
    }
}