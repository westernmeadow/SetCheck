//
//  Name:       Kwan, Wesley
//  Project:   1
//  Due:        2/24/20
//  Course:     cs-2400-02
//
//  Description:
//              Linked list implementation of SetInterface.
//
import java.util.Iterator;

public final class LinkedSet<T> implements SetInterface<T>
{
    private Node firstNode;
    private int numberOfEntries;
    
    public LinkedSet()
    {
        firstNode = null;
        numberOfEntries = 0; 
    }
    
    public boolean contains(T element)
    {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null))
        {
            if (element.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        }
        return found;
    }
    
    public boolean remove(T element)
    {
        if (firstNode == null)
            return false;
        if (firstNode.data.equals(element))
        {
            firstNode = firstNode.next;
            numberOfEntries--;
            return true;
        }
        if (contains(element))
        {
            Node referenceNode = getReferenceTo(element);
            T temp = (T)firstNode.data;
            firstNode.data = referenceNode.data;
            referenceNode.data = temp;
            firstNode = firstNode.next;
            numberOfEntries--;
            return true;
        }
        return false;
    }
     
    public boolean add(T element)
    {
        if (!contains(element))
        {
            Node newNode = new Node(element);
            newNode.next = firstNode;
            firstNode = newNode;
            numberOfEntries++;
            return true;
        }
        return false;
    }
    
    public int length()
    {
        return numberOfEntries;
    }
    
    public boolean subset(SetInterface set)
    {
        if (numberOfEntries == 0)
            return true;
        if (numberOfEntries > set.length())
            return false;
        boolean isSubset = true;
        Node currentNode = firstNode;
        while (isSubset && (currentNode != null))
        {
            if (!set.contains(currentNode.data))
                isSubset = false;
            currentNode = currentNode.next;
        }
        return isSubset;
    }
    
    public boolean equals(SetInterface set)
    {
        if (numberOfEntries != set.length())
            return false;
        return subset(set);
    }
    
    public SetInterface<T> union(SetInterface set)
    {
        SetInterface<T> newSet = new LinkedSet<>();
        Node currentNode = firstNode;
        while (currentNode != null)
        {
            if (!set.contains(currentNode.data))
                newSet.add((T)currentNode.data);
            currentNode = currentNode.next;
        }
        Iterator<T> setIterator = set.iterator();
        while (setIterator.hasNext())
        {
            newSet.add(setIterator.next());
        }
        return newSet;
    }
    
    public String toString()
    {
        String setString = "{";
        Node currentNode = firstNode;
        while (currentNode != null)
        {
            setString += currentNode.data.toString();
            if (currentNode.next != null)
                setString += ",";
            currentNode = currentNode.next;
        }
        setString += "}";
        return setString;
    }

    public Iterator<T> iterator() {
        return new LinkedSetIterator<>();
    }
    
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }
    
    private Node getReferenceTo(T element)
    { 
        boolean found = false;
        Node currentNode = firstNode;
        while(!found && (currentNode != null))
        { 
            if(element.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        }
        return currentNode;
    }
    
    private class Node<T>
    {
        private T data;
        Node<T> next;
        
        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }
        
        private Node(T dataPortion, Node nextNode)
        { 
            data = dataPortion; 
            next = nextNode; 
        }
    }
    
    private class LinkedSetIterator<T> implements Iterator<T>
    {
        private Node current;
        
        public LinkedSetIterator()
        {
            current = firstNode;
        }
        
        public boolean hasNext()
        {
            return current != null;
        }
        
        public T next()
        {
            T data = null;
            if (hasNext())
            {
                data = (T)current.data;
                current = current.next;
            }
            return data;
        }
    }
}
