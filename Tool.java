import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents a tool.
 */
class Tool {

   /**
    * Identifier
    */
      private String id;      
   /**
    * tool name
    */
      private String name;      

   /**
    * Constructor of the class.
    * Sets the value of its attributes.
    */
   public Tool (String id, String name) {
      this.id=id;
      this.name=name;
   }

   /**
    * getter method of attribute id
    * 
    * @return value of attribute id
    */
   public String getId() {
      return this.id;
   }

   /**
    * toString method.
    * 
    * @return A String containing the values of the class attributes.
    */
   public String toString() {
      return ("Id: " + this.id + ";  Name: " + this.name);
   }

   /**
    * Method to compare two Tool instances (redefinition of equals()).
    * 
    * @return true if both instances have the same value of attribute id
    *         false otherwise.
    * 
    */
   public boolean equals(Object o) {
      return (this.id).equals(((Tool) o).getId());
   }

}

