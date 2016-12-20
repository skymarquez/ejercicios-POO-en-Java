/**
 * Main class used to test
 */
public class TestEx3{

   /**
    * Main method
    */
   public static void main (String []args) {

      // Creating a PaintShop object
      // -------------------------
      PaintShop ps = new PaintShop();

      // Creating Paint objects and adding them to the paints list of object ps
      // ----------------------------------------------------------------------
      Paint paintObj1 = new Paint("P1","Plastic","Red");
      ps.addPaint(paintObj1);
      Paint paintObj2 = new Paint("P2","Acrylic","Green");
      ps.addPaint(paintObj2);
      Paint paintObj3 = new Paint("P1","Plastic","Red"); // repeated object <----
      ps.addPaint(paintObj3);

      // Creating Tool objects and adding them to the tools list of object ps
      // --------------------------------------------------------------------
      Tool toolObj1 = new Tool("T1","Paintbrush");
      ps.addTool(toolObj1);
      Tool toolObj2 = new Tool("T2","Paintroller");
      ps.addTool(toolObj2);
      Tool toolObj3 = new Tool("T1","Paintbrusch"); // repeated object <----
      ps.addTool(toolObj3);

      // Listing Paint objects Information
      // ---------------------------------
      System.out.println ("--------------");
      System.out.println ("List of paints");
      System.out.println ("--------------");
      ps.listPaints();

      // Listing Tool objects Information
      // --------------------------------
      System.out.println ("-------------");
      System.out.println ("List of tools");
      System.out.println ("-------------");
      ps.listTools();

      System.out.println();

      // Searching Paints by its id
      // --------------------------
      System.out.println("-- Information related to Paint with id = P1:");
      System.out.println(ps.searchPaint("P1"));
      System.out.println("-- Information related to Paint with id = P3:");
      System.out.println(ps.searchPaint("P3"));  // This object does not exists <----

      System.out.println();

      // Comparing objects
      // -----------------
      System.out.println(paintObj1.equals(paintObj2));
      System.out.println(paintObj1.equals(paintObj3));
      System.out.println(paintObj1.equals(toolObj1));
      // this last sentence represents a possible unsuitable method call which could happens (for different reasons) in a program run <----

      System.out.println("End of the exercise");
      
   }

}
