import java.io.Serializable;
import java.util.Set;

/**
 * Write a description of class RelationshipManagerFactory here.
 * 
 * @author Bradley Woods
 * @version 03/19/2013
 */
public class RelationshipManagerFactory implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 5072713022524579088L;

    /**
     * Write a description of the method here.
     * 
     * @return
     */
    public static RelationshipManagerFactory getInstance()
    {
        // TODO: add your code here
        return null;
    }

    /**
     * Write a description of the constructor here.
     */
    private RelationshipManagerFactory()
    {
    }

    /**
     * Write a description of the method here.
     * 
     * @param <T> Source Type
     * @param <U> Destination Type
     * @param <V>
     * @param class1
     * @param class2
     * @param class3
     * @param name
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T, U, V> RelationshipManager<T, U, V> getRelationshipManagerFor(
        Class<T> class1, Class<U> class2, Class<V> class3, String name)
    {
        @SuppressWarnings("unused")
        String key = class1.getName() + class2.getName() + class3.getName()
            + name;

        RelationshipManager<T, U, V> mgr = null;

        // TODO: add your code here

        return mgr;
    }

    @SuppressWarnings("unused")
    private static class RelationshipManagerImpl<T, U, V> implements
        RelationshipManager<T, U, V>
    {

        /**
         * Write a description of the constructor here.
         * 
         * @param name
         */
        public RelationshipManagerImpl(String name)
        {
            // TODO Auto-generated method stub
        }

        /**
         * Write a description of the method here.
         * 
         * @see RelationshipManager#getName()
         * @return
         */
        public String getName()
        {
            // TODO Auto-generated method stub
            return null;
        }

        /**
         * Write a description of the method here.
         * 
         * @see RelationshipManager#addRelationship(T, U)
         * @param source
         * @param destination
         * @return
         */
        public boolean addRelationship(T source, U destination)
        {
            // TODO Auto-generated method stub
            return false;
        }

        /**
         * Write a description of the method here.
         * 
         * @see RelationshipManager#addRelationship(T, U, V)
         * @param source
         * @param destination
         * @param association
         * @return
         */
        public boolean addRelationship(T source, U destination, V association)
        {
            // TODO Auto-generated method stub
            return false;
        }

        /**
         * Write a description of the method here.
         * 
         * @see RelationshipManager#removeRelationship(T, U)
         * @param source
         * @param destination
         * @return
         */
        public boolean removeRelationship(T source, U destination)
        {
            // TODO Auto-generated method stub
            return false;
        }

        /**
         * Write a description of the method here.
         * 
         * @see RelationshipManager#findDestObjects(T)
         * @param source
         * @return
         */
        public Set<U> findDestObjects(T source)
        {
            // TODO Auto-generated method stub
            return null;
        }

        /**
         * Write a description of the method here.
         * 
         * @see RelationshipManager#findSourceObjects(U)
         * @param destination
         * @return
         */
        public Set<T> findSourceObjects(U destination)
        {
            // TODO Auto-generated method stub
            return null;
        }

        /**
         * Write a description of the method here.
         * 
         * @see RelationshipManager#findDestObject(T)
         * @param source
         * @return
         */
        public U findDestObject(T source)
        {
            // TODO Auto-generated method stub
            return null;
        }

        /**
         * Write a description of the method here.
         * 
         * @see RelationshipManager#findSourceObject(U)
         * @param destination
         * @return
         */
        public T findSourceObject(U destination)
        {
            // TODO Auto-generated method stub
            return null;
        }

        /**
         * Write a description of the method here.
         * 
         * @see RelationshipManager#areRelated(T, U)
         * @param source
         * @param destination
         * @return
         */
        public boolean areRelated(T source, U destination)
        {
            // TODO Auto-generated method stub
            return false;
        }

        /**
         * Write a description of the method here.
         * 
         * @see RelationshipManager#removeAllRelationships()
         */
        public void removeAllRelationships()
        {
            // TODO Auto-generated method stub

        }

        /**
         * Write a description of the method here.
         * 
         * @see RelationshipManager#removeAssociation(T, U)
         * @param source
         * @param destination
         * @return
         */
        public V removeAssociation(T source, U destination)
        {
            // TODO Auto-generated method stub
            return null;
        }

        /**
         * Write a description of the method here.
         * 
         * @see RelationshipManager#setAssociation(T, U, V)
         * @param source
         * @param destination
         * @param association
         * @return
         */
        public V setAssociation(T source, U destination, V association)
        {
            // TODO Auto-generated method stub
            return null;
        }

        /**
         * Write a description of the method here.
         * 
         * @see RelationshipManager#findAssociation(T, U)
         * @param source
         * @param destination
         * @return
         */
        public V findAssociation(T source, U destination)
        {
            // TODO Auto-generated method stub
            return null;
        }
    }
}
