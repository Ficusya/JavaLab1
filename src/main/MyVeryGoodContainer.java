package main;

public class MyVeryGoodContainer
{
    private static class ContainerElement {
        int number;
        ContainerElement next;

        public ContainerElement(int number) {
            this.number = number;
            this.next = null;
        }
    }

    private ContainerElement first;
    private ContainerElement last;
    private int size;

    public MyVeryGoodContainer() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addToHead(int number) {
        ContainerElement newElement = new ContainerElement(number);
        if (first == null) {
            first = newElement;
            last = newElement;
        } else {
            newElement.next = first;
            first = newElement;
        }
        size++;
    }

    public void addToTail(int number) {
        ContainerElement newElement = new ContainerElement(number);
        if (last == null) {
            first = newElement;
            last = newElement;
        } else {
            last.next = newElement;
            last = newElement;
        }
        size++;
    }

    public void addToIndex(int index, int number) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            addToHead(number);
        } else if (index == size) {
            addToTail(number);
        } else {
            ContainerElement newElement = new ContainerElement(number);
            ContainerElement prev = getElementAtIndex(index - 1);
            newElement.next = prev.next;
            prev.next = newElement;
            size++;
        }
    }

    public ContainerElement getElementAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        ContainerElement current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void deleteFirst() {
        if (first == null) {
            throw new IllegalStateException("Container is empty");
        }
        first = first.next;
        size--;
    }

    public void deleteLast() {
        if (last == null) {
            throw new IllegalStateException("Container is empty");
        }
        if (first == last) {
            first = null;
            last = null;
        } else {
            ContainerElement prev = getElementAtIndex(size - 2);
            prev.next = null;
            last = prev;
        }
        size--;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            deleteFirst();
        } else if (index == size - 1) {
            deleteLast();
        } else {
            ContainerElement prev = getElementAtIndex(index - 1);
            prev.next = prev.next.next;
            size--;
        }
    }

    public int extractAtIndex(int index)
    {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            return extractFirst();
        } else if (index == size - 1) {
            return extractLast();
        } else {
            ContainerElement prev = getElementAtIndex(index - 1);
            ContainerElement elementToExtract = prev.next;
            prev.next = elementToExtract.next;
            size--;
            return elementToExtract.number;
        }
    }

    public int extractFirst()
    {
        if (first == null) {
            throw new IllegalStateException("Container is empty");
        }
        int extractedValue = first.number;
        first = first.next;
        size--;
        return extractedValue;
    }

    public int extractLast()
    {
        if (last == null) {
            throw new IllegalStateException("Container is empty");
        }
        int extractedValue = last.number;
        if (first == last) {
            first = null;
            last = null;
        } else {
            ContainerElement prev = getElementAtIndex(size - 2);
            prev.next = null;
            last = prev;
        }
        size--;
        return extractedValue;
    }

    public void printContainer()
    {
        ContainerElement current = first;
        while(current != null)
        {
            System.out.print(current.number + " ");
            current = current.next;
        }
        System.out.println();
    }
}
