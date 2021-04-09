//
//  Name:       Kwan, Wesley
//  Project:   1
//  Due:        2/24/20
//  Course:     cs-2400-02
//
//  Description:
//              The program checks the set ADT logic by
//              calling each method test for review.
//
public class SetCheck
{
    public static void main(String[] args)
    {
        System.out.println("W. Kwan's Set ADT\n");
        
        SetInterface<Integer> setA = new LinkedSet<>();
        SetInterface<Integer> setB = new LinkedSet<>();
        
        System.out.println("Case 1: A and B are equal but " +
                           "distinct sets, for example, " +
                           "A = {1, 2, 3}, B = {2, 1, 3}");
        testAdd(setA, 3); testAdd(setA, 2); testAdd(setA, 1);
        testAdd(setB, 3); testAdd(setB, 1); testAdd(setB, 2);
        testSubset(setA, setB); testSubset(setB, setA);
        testEquals(setA,setB);
        testUnion(setA, setB);
        testRemove(setA, 2); testRemove(setA, 4);
        testRemove(setB, 2); testRemove(setB, 4);
        testClear(setA); testClear(setB);
        
        System.out.println("Case 2: A and B are such that " +
                           "they have different lengths but " +
                           "one is a subset of the other, " +
                           "for example, A = {1}, B = {1, 2}");
        testAdd(setA, 1);
        testAdd(setB, 2); testAdd(setB, 1);
        testSubset(setA, setB); testSubset(setB, setA);
        testEquals(setA,setB);
        testUnion(setA, setB);
        testRemove(setA, 1); testRemove(setA, 2);
        testRemove(setB, 2); testRemove(setB, 3);
        testClear(setA); testClear(setB);
        
        System.out.println("Case 3: A and B are non-empty " +
                           "and different in size but have " +
                           "common elements, for example, " +
                           "A = {1, 2, 3}, B = {2, 3, 4, 5}");
        testAdd(setA, 3); testAdd(setA, 2); testAdd(setA, 1);
        testAdd(setB, 5); testAdd(setB, 4); testAdd(setB, 3);
        testAdd(setB, 2);
        testSubset(setA, setB); testSubset(setB, setA);
        testEquals(setA,setB);
        testUnion(setA, setB);
        testRemove(setA, 2); testRemove(setA, 4);
        testRemove(setB, 4); testRemove(setB, 6);
        testClear(setA); testClear(setB);
        
        System.out.println("Case 4: A and B are non-empty " +
                           "with nothing in common, for " +
                           "example, A = {1}, B = {2, 3}");
        testAdd(setA, 1);
        testAdd(setB, 3); testAdd(setB, 2);
        testSubset(setA, setB); testSubset(setB, setA);
        testEquals(setA,setB);
        testUnion(setA, setB);
        testRemove(setA, 1); testRemove(setA, 2);
        testRemove(setB, 3); testRemove(setB, 4);
        testClear(setA); testClear(setB);
        
        System.out.println("Case 5: one is non-empty and " +
                           "the other empty, for example, " +
                           "A = {1, 2}, B = {}");
        testAdd(setA, 2); testAdd(setA, 1);
        testSubset(setA, setB); testSubset(setB, setA);
        testEquals(setA,setB);
        testUnion(setA, setB);
        testRemove(setA, 1); testRemove(setA, 2);
        testRemove(setB, 3); testRemove(setB, 4);
        testClear(setA); testClear(setB);
    }
    
    public static void testContains(SetInterface set, int element)
    {
        System.out.println("Test: contains(T element)");
        System.out.println("Method call on: " + set);
        System.out.println("Method argument: " + element);
        System.out.println("Return value: " + set.contains(element));
        System.out.println("After method call: " + set);
        System.out.println("Test completed.\n");
    }
    
    public static void testRemove(SetInterface set, int element)
    {
        System.out.println("Test: remove(T element)");
        System.out.println("Method call on: " + set);
        System.out.println("Method argument: " + element);
        System.out.println("Return value: " + set.remove(element));
        System.out.println("After method call: " + set);
        System.out.println("Test completed.\n");
    }
    
    public static void testAdd(SetInterface set, int element)
    {
        System.out.println("Test: add(T element)");
        System.out.println("Method call on: " + set);
        System.out.println("Method argument: " + element);
        System.out.println("Return value: " + set.add(element));
        System.out.println("After method call: " + set);
        System.out.println("Test completed.\n");
    }
    
    public static void testLength(SetInterface set)
    {
        System.out.println("Test: length(T element)");
        System.out.println("Method call on: " + set);
        System.out.println("Method argument: none");
        System.out.println("Return value: " + set.length());
        System.out.println("After method call: " + set);
        System.out.println("Test completed.\n");
    }
    
    public static void testSubset(SetInterface leftSet, SetInterface rightSet)
    {
        System.out.println("Test: subset(SetInterface set)");
        System.out.println("Method call on: " + leftSet);
        System.out.println("Method argument: " + rightSet);
        System.out.println("Return value: " + leftSet.subset(rightSet));
        System.out.println("After method call (left): " + leftSet);
        System.out.println("After method call (right): " + rightSet);
        System.out.println("Test completed.\n");
    }
    
    public static void testEquals(SetInterface leftSet, SetInterface rightSet)
    {
        System.out.println("Test: equals(SetInterface set)");
        System.out.println("Method call on: " + leftSet);
        System.out.println("Method argument: " + rightSet);
        System.out.println("Return value: " + leftSet.equals(rightSet));
        System.out.println("After method call (left): " + leftSet);
        System.out.println("After method call (right): " + rightSet);
        System.out.println("Test completed.\n");
    }
    
    public static void testUnion(SetInterface leftSet, SetInterface rightSet)
    {
        System.out.println("Test: union(SetInterface set)");
        System.out.println("Method call on: " + leftSet);
        System.out.println("Method argument: " + rightSet);
        System.out.println("Return value: " + leftSet.union(rightSet));
        System.out.println("After method call (left): " + leftSet);
        System.out.println("After method call (right): " + rightSet);
        System.out.println("Test completed.\n");
    }
    
    public static void testClear(SetInterface set) {
        System.out.println("Test: clear()");
        System.out.println("Method call on: " + set);
        System.out.println("Method argument: none");
        System.out.println("Return value: none");
        set.clear();
        System.out.println("After method call: " + set);
        System.out.println("Test completed.\n");
    }
}