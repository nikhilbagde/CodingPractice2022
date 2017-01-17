package Java.RandomTest;

/**
 * Created by Nikhil on 1/4/2017 4:07 AM.
 */
class SuggestionBox{
  private void onSelection(){
        //Do action when item has been selected.
        System.out.println("Item selected.");
        }
public void onRemoveSelection(){
    //Do action when item selection has been removed.
    System.out.println("Item removed.");
}
}
public class TestDemo{
public static void main(String[] args){
         SuggestionBox officeSuggestionBox = new SuggestionBox()
{   public void onSelection(){
//Do action when item has been selected.
    System.out.println("Office selected.");
 }
  public void onRemoveSelection(){
                 //Do action when item selection has been removed.
                  onSelection();
   System.out.println("Office removed.");
 }
         };
         officeSuggestionBox.onRemoveSelection();
     }
 }