/**
 * 
 */

import java.util.Set;

/**
 * A class that manages one-to-one, one-to-many, and many-to-many relationships
 * between objects. This is based on the Relationship Manager pattern described
 * by Andy Bulka at <a href ="http://www.atug.com/andypatterns/RM.htm">
 * http://www.atug.com/andypatterns/RM.htm</a>. Rather than internalize
 * relationships in a class (i.e. a one-to-many relationship represented as a
 * single reference in one class and a list of references in another class), the
 * representation of relationships is centralized in a single class. This has
 * some great advantages in that client code is very simple to write, but it has
 * the disadvantage of not being automatically persisted with the objects
 * themselves.
 * 
 * This class is an extension of Relationship Manager pattern in which each
 * relationship can have an object associated with the relationhsip itself. For
 * example, when relating Person objects to Skill objects (which is
 * many-to-many) there can be data associated with the level of the skill. In
 * that case the RelationshipManager would map Person to Skill with Integer on
 * the association.
 * 
 * Note that the ordering of operands is important. If both <code>T</code> and
 * <code>U</code> are the same type then <code>addRelationship(x, y)</code>
 * guarantees <code>areRelated(x, y)</code> but not
 * <code>areRelated(y, x)</code> Furthermore the association data in each
 * direction is unique. This makes RelationshipManager suitable for managing
 * arcs in a weighted, directed graph.
 * 
 * In order to guarantee that all relationships across many objects are
 * maintained correctly, all <code>RelationshipManager</code> instances should
 * be obtained from the <code>RelationshipManagerFactory</code> which is
 * itself a singleton instance. This ensures that all relationships are
 * centralized, guaranteeing consistency.
 * 
 * @author Todd A. Whittaker
 * @version 2006-06-01
 * 
 * @see RelationshipManagerFactory
 * 
 * @param <T> the type of the left hand side of a relationship (i.e. "one")
 * @param <U> the type of the right hand side of the relationship (i.e. "many")
 * @param <V> the type of the association data (i.e. data associated with the
 *        relationship itself)
 */
public interface RelationshipManager<T, U, V>
{
    /**
     * Returns the name of the relationship. For example, there can be many
     * different kinds of relationships between two <code>Person</code>
     * objects. The name is used to distinguish between them. For example a
     * relationship name of <code>"PARENT_OF"</code> determines parent-child
     * relationships getween two <code>Person</code> objects. Likewise, a
     * relationship of <code>"SUPERVISED_BY"</code> would determine
     * manager-subordinate relationships.
     * 
     * @return the name of the relationship.
     */
    String getName();

    /**
     * Adds a new relationship between the source object and the destination
     * with no association data. Souce and desitnation are linked together in a
     * one-to-one correspondence. A set of several destinations for the same
     * source makes the relationship one-to-many. If there are many sources for
     * a single destination then the relationship is many-to-one. If the same
     * source had many destinations and the same destination has many sources,
     * then the relationship is many-to-many.
     * 
     * @param source the left hand side object in the relationship
     * @param destination the right hand side object in the relationship
     * @return true when the relationship was successfully created
     */
    boolean addRelationship(T source, U destination);

    /**
     * Adds a new relationship between the source object and the destination
     * with the provided association data. Souce and desitnation are linked
     * together in a one-to-one correspondence. A set of several destinations
     * for the same source makes the relationship one-to-many. If there are many
     * sources for a single destination then the relationship is many-to-one. If
     * the same source had many destinations and the same destination has many
     * sources, then the relationship is many-to-many.
     * 
     * In any of the above cases, the data associated with the relationship is
     * kept. For example, when relating <code>Person</code> objects to
     * <code>Skill</code> objects the data associated with the relationship
     * itself could be an <code>Integer</code> object corresponding to the
     * level (1-10) of the <code>Skill</code>.
     * 
     * @see RelationshipManager#addRelationship(T, U)
     * @param source the left hand side object in the relationship
     * @param destination the right hand side object in the relationship
     * @param association the data associated with the relationship
     * @return true when the relationship was successfully created
     */
    boolean addRelationship(T source, U destination, V association);

    /**
     * Removes the relationship between the source and destination objects if
     * there is one. Other relationships involving the source or destination are
     * not touched. Returns true if the relationship existed and was removed,
     * false otherwise. Note, this also removes any data associated with the
     * relationship as well.
     * 
     * @param source the left hand side object in the relationship
     * @param destination the right hand side object in the relationship
     * @return true when the relationship was successfully removed
     */
    boolean removeRelationship(T source, U destination);

    /**
     * Finds all the destination objects within the relationship that are
     * associated with the given source object. In a one-to-many relationship,
     * this will return the list of objects on the "many" side. For example,
     * <code>addRelationship(x, y)</code> guarantees
     * <code>findDestObjects(x).contains(y)</code>.
     * 
     * @param source the left hand side object in the relationship
     * @return a list of objects associated with the source object
     */
    Set<U> findDestObjects(T source);

    /**
     * Finds all the source objects within the relationship that are associated
     * with the given destination object. In a many-to-one relationship, this
     * will return the list of objects on the many side. For example,
     * <code>addRelationship(x, y)</code> guarantees
     * <code>findSourceObjects(y).contains(x)</code>.
     * 
     * @param destination the right hand side object in the relationship
     * @return a list of objects associated with the destination object
     */
    Set<T> findSourceObjects(U destination);

    /**
     * Finds the first destination object within the relationship that is
     * associated with the given source object. In a many-to-one relationship,
     * this returns the one object.
     * 
     * @param source the left hand side object in the relationship
     * @return the first object found associated with the source object
     */
    U findDestObject(T source);

    /**
     * Finds the first source object within the relationship that is associated
     * with the given destination object. In a one-to-many relationship, this
     * returns the one object.
     * 
     * @param destination the right hand side object in the relationship
     * @return the first object found associated with the destination object
     */
    T findSourceObject(U destination);

    /**
     * Answers whether or not the given source and destination objects are
     * related.
     * 
     * @param source the left hand side object in the relationship
     * @param destination the right hand side object in the relationship
     * @return true when two objects are associated within the relationship
     */
    boolean areRelated(T source, U destination);

    /**
     * Removes all relationships in this relationship manager. This has the
     * effect of repeated calls to <code>removeRelationship</code> for every
     * source and destination pair currently in this relationship manager.
     */
    void removeAllRelationships();

    /**
     * Remove the data associated with the source and destination relationship.
     * Note that this does not remove the relationship, but only the ancilary
     * data associated with the relationship. Again, using the example relating
     * <code>Person</code> to <code>Skill</code>, this would remove the
     * <code>Integer</code> level information.
     * 
     * @see RelationshipManager#findAssociation(T, U)
     * @param source the source of the relationship
     * @param destination the destination of the relationship
     * @return the old association data being removed
     */
    V removeAssociation(T source, U destination);

    /**
     * Change or create the data associated with the source and destination
     * relationship. Again, using the example relating <code>Person</code> to
     * <code>Skill</code>, this would change the <code>Integer</code> level
     * information.
     * 
     * @see RelationshipManager#findAssociation(T, U)
     * @param source the source of the relationship
     * @param destination the destination of the relationship
     * @param association the new data to associate with the relationship
     * @return the old association data being removed
     */
    V setAssociation(T source, U destination, V association);

    /**
     * Finds the data associated with the relationship between the soucre and
     * destination objects given as parameters.. Again, using the example
     * relating <code>Person</code> to <code>Skill</code>, this would
     * return the <code>Integer</code> level information.
     * 
     * @param source the source of the relationship
     * @param destination the destination of the relationship
     * @return the data associated with the relationship between source and
     *         destination, or null if no relationship or association data
     *         exists
     */
    V findAssociation(T source, U destination);
}
