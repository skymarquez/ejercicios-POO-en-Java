import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents a Paint Shop.
 */
class PaintShop {

   /**
    * List of paint registered in the shop
    */
      private List paints;      
   /**
    * List of tools registered in the shop
    */
      private List tools;      

   /**
    * Constructor of the class.
    * Sets empty the lists of paints and tools.
    */
   public PaintShop () {
      paints = new ArrayList();
      tools = new ArrayList();
   }

   /**
    * Add a paint to the list of paints
    * 
    * @param paint
    *    new paint
    * @return true if the operation has been suscessfully realized, else false.
    */
   public boolean addPaint(Paint paint) {
      if (paints.contains(paint))
         return false;
      else
	 return paints.add(paint);
   }

   /**
    * Add a tool to the list of tools
    * 
    * @param tool
    *    new tool
    * @return true if the operation has been suscessfully realized, else false.
    */
   public boolean addTool(Tool tool) {
      if (tools.contains(tool))
         return false;
      else
	 return tools.add(tool);
   }

   /**
    * Search for a paint by its id.
    * @param id
    * @return the object if found
    */
   public Paint searchPaint(String id) {
      Paint found = null;
      for (Iterator it = paints.iterator(); it.hasNext() & found == null;) {
         Paint aPaint = (Paint) it.next();
         if (id.equals(aPaint.getId()))
            found = aPaint;
      }
      return found;
   }

   /**
    * Lists the information of the registered paints.
    * 
    */
   public void listPaints() {
      for (Iterator it = paints.iterator(); it.hasNext();) {
         Paint aPaint = (Paint) it.next();
         System.out.println(aPaint);
      }
   }

   /**
    * Lists the information of the registered tools.
    * 
    */
   public void listTools() {
      for (Iterator it = tools.iterator(); it.hasNext();) {
         Tool aTool = (Tool) it.next();
         System.out.println(aTool);
      }
   }

}

