package de.tum.cit.ase;

// TODO 2.1 Implement the interface MyList
public class LinkedList<T> implements MyList<T> {
    private ListNode<T> first;
    private ListNode<T> last;


    // TODO 2.1 Add a constructor
    public LinkedList() {
        this.first = null;
        this.last = null;
    }

    // TODO 2.1 Add getters and setters

    public ListNode<T> getFirst() {
        return first;
    }

    public void setFirst(ListNode<T> first) {
        this.first = first;
    }

    public ListNode<T> getLast() {
        return last;
    }

    public void setLast(ListNode<T> last) {
        this.last = last;
    }


    // TODO 2.1 Implement interface methods
    @Override
    public int size() {
        int count = 0;
        ListNode<T> current = first;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

@Override
public boolean isEmpty() {
    return first == null;
}

@Override
public boolean contains(T o) {
    ListNode<T> current = first;
    while (current != null) {
        if ((o == null && current.getValue() == null) || (o != null && o.equals(current.getValue()))) {
            return true;
        }
        current = current.getNext();
    }
    return false;
}

@Override
public void add(T t) {
    ListNode<T> newNode = new ListNode<>(t);
    if (isEmpty()) {
        first = last = newNode;
    } else {
        last.setNext(newNode);
        newNode.setPrevious(last);
        last = newNode;
    }
}

@Override
public void remove(T o) {
    ListNode<T> current = first;

    while (current != null) {
        if ((o == null && current.getValue() == null) || (o != null && o.equals(current.getValue()))) {
            if (current.getPrevious() != null) {
                current.getPrevious().setNext(current.getNext());
            } else {
                first = current.getNext();
            }

            if (current.getNext() != null) {
                current.getNext().setPrevious(current.getPrevious());
            } else {
                last = current.getPrevious();
            }
            return;
        }
        current = current.getNext();
    }
}

@Override
public void add(int index, T element) {
    if (index < 0 || index > size()) {
        throw new IndexOutOfBoundsException("List index is out of bound");
    }

    ListNode<T> newNode = new ListNode<>(element);

    if (index == 0) {
        newNode.setNext(first);
        if (first != null) {
            first.setPrevious(newNode);
        }
        first = newNode;
        if (last == null) {
            last = newNode;
        }
    } else {
        ListNode<T> current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        newNode.setNext(current.getNext());
        if (current.getNext() != null) {
            current.getNext().setPrevious(newNode);
        }
        current.setNext(newNode);
        newNode.setPrevious(current);
        if (newNode.getNext() == null) {
            last = newNode;
        }
    }
}

@Override
public T remove(int index) {
    if (index < 0 || index >= size()) {
        throw new IndexOutOfBoundsException("List index is out of bound");
    }

    ListNode<T> current = first;

    for (int i = 0; i < index; i++) {
        current = current.getNext();
    }

    if (current.getPrevious() != null) {
        current.getPrevious().setNext(current.getNext());
    } else {
        first = current.getNext();
    }

    if (current.getNext() != null) {
        current.getNext().setPrevious(current.getPrevious());
    } else {
        last = current.getPrevious();
    }

    return current.getValue();
}

@Override
public int indexOf(T o) {
    ListNode<T> current = first;
    int index = 0;

    while (current != null) {
        if ((o == null && current.getValue() == null) || (o != null && o.equals(current.getValue()))) {
            return index;
        }
        current = current.getNext();
        index++;
    }
    return -1;
}

@Override
public String toString() {
    StringBuilder sb = new StringBuilder("[");
    ListNode<T> current = first;
    while (current != null) {
        sb.append(current.getValue());
        if (current.getNext() != null) {
            sb.append(", ");
        }
        current = current.getNext();
    }
    sb.append("]");
    return sb.toString();
}
}

