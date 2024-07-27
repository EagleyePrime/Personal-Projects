public class WebSite {
  
  //Realistically, we're probably going to have to create subclasses. Not now, but may
  private float gpa;                                                                   
  private String[] favorites;                                                          
  private float income;                                                                
  private int age;                                                                     
                                                                                      
  private boolean isPoor;                                                              
  private boolean isAtCasino;                                                          
                                                                                      
  private String[] tips = new String[1];                                                               
                                                                                      
  public WebSite() {                                                                   
      if (isPoor) {                                                                   
          isAtCasino = true;                                                          
      }                                                                               
      else {                                                                          
          isAtCasino = true;                                                          
      }          
      tips[0] = "Get rich. Gamble.";                                                                 
  }                                                                                   
                                                                                      
  //Precondition: tips.length > 0                                                     
  public String randMsg() {                                                            
      int rIndex = (int) (Math.random() * tips.length);   //Random index.             
      return tips[rIndex];                                                            
  } 

}