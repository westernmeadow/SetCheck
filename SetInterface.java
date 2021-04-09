//
//  Name:       Kwan, Wesley
//  Project:   1
//  Due:        2/24/20
//  Course:     cs-2400-02
//
//  Description:
//              Interface of the set ADT.
//
public interface SetInterface<T> extends Iterable<T>
{
    /**
     * Checks if the specified element is in this set.
     * @param  element  the element whose presence in this
     *                  set is to be tested
     * @return          true if this set contains the
     *                  specified element
     */
    public boolean contains(T element);
    /**
     * Removes the specified element from this set if it is
     * present.
     * @param  element  the element to be removed, if present
     * @return          true if this set contained the
     *                  specified element
     */
    public boolean remove(T element);
    /**
     * Adds the specified element to this set if it is not
     * already present.
     * @param  element  the element to be added to this set
     * @return          true if this set did not already
     *                  contain the specified element
     */
    public boolean add(T element);
    /**
     * Returns the number of elements in this set, its
     * cardinality
     * @return  the cardinality of this set
     */
    public int length();
    /**
     * Compares the specified set with this set to determine
     * whether this set is a subset of the specified set:
     * every member of this set is contained in the specified
     * set.
     * @param  set  the set to be compared to with this set
     * @return          true if this set is a subset of the
     *                  specified set
     */
    public boolean subset(SetInterface set);
    /**
     * Compares the specified set with this set for equality:
     * the two sets have the same size, and every member of
     * the specified set is contained in this set.
     * @param  element  the element to be removed, if present
     * @return          true if this set contained the
     *                  specified element
     */
    public boolean equals(SetInterface set);
    /**
     * Performs the union operation on two sets, this set
     * and the set specified.
     * @param  set  the set to be operated with this set
     * @return      a set containing the elements in this set
     *              and the set specified 
     */
    public SetInterface<T> union(SetInterface set);
    /**
     * Removes all the elements from this set. The set will
     * be empty after this call.
     */
    public void clear();
}