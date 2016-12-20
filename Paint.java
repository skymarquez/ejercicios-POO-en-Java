import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents a paint.
 */
class Paint {

   /**
    * Identifier
    */
      private String id;      
   /**
    * Type of paint
    */
      private String type;      
   /**
    * Color
    */
      private String color;

   /**
    * Constructor of the class.
    * Sets the value of its attributes.
    */
   public Paint (String id, String type, String color) {
      this.id=id;
      this.type=type;
      this.color=color;
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
      return ("Id: " + this.id + ";  Type: " + this.type + ";  Color: " + this.color);
   }

   /**
    * Method to compare two Paint instances (redefinition of equals()).
    * 
    * @return true if both instances have the same value of attribute id
    *         false otherwise.
    * 
    */
   public boolean equals(Object o) {
      return (this.id).equals(((Paint) o).getId());
   }

}

