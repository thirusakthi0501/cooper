import java.util.*;
class User{
    String name;
    String password;
    List<String> bh;

    User(String name,String password){
        this.name=name;
        this.password=password;
        this.bh=new ArrayList<>();
    }
    void ab(String sname,int tickets){
        bh.add("Movie"+sname+"Ticket"+tickets);
    }
    void sh(){
        if(bh.isEmpty())
        System.out.println("no history");
        else{
            System.out.println("Booking history");
            for(String history: bh){
                System.out.println(history);
            }
        }
    }
}
class Movies{
    String name ;
    int atickets;

    Movies(String name,int atickets){
        this.name=name;
        this.atickets=atickets;
    }
    
}
public class TicketDemo{
    private static List<Movies> m = new ArrayList<>();
    private static List<User> up = new ArrayList<>();
    private static User currentUser=null;

    public static void main(String[] args){

        m.add(new Movies("amaran",10));
        m.add(new Movies("NGK",11));
        m.add(new Movies("Gilli",8));
        up.add(new User("u1","p1"));
        up.add(new User("u2","p2"));
        up.add(new User("u3","p3"));
        

        System.out.println("Welcome to ticket booking Web");
         Scanner sc=new Scanner(System.in);

         if(!au(sc)){
            System.out.println("give existing up");
            sc.close();
            return;
         }
        while(true){
            for(int i=0;i<m.size();i++){
                System.out.println((i+1)+"."+m.get(i).name+"Available seats :"+m.get(i).atickets);
            }
            System.out.println(m.size()+1 +"."+"History");
            System.out.println(m.size()+2 +"."+"exit");
            System.out.println("Enter your choice");
            int y=sc.nextInt();
            if(y==m.size()+2){
                System.out.println("Thank u for visiting our website");
                break;
            }
            else if(y==m.size()+1){
                if(currentUser!=null)
                currentUser.sh();
                else
                System.out.println("No");
            }
            else if(y>0 && y<m.size()+1){
                booking(sc,y-1);
            }
            else{
                System.out.println("Invalid choose");
            }
        }
        sc.close();
    }
    
    private static void booking(Scanner sc,int mindex){
        Movies d=m.get(mindex);
        System.out.println("yevlo ticket venum"+d.name+"ku:");
        int count=sc.nextInt();
        if(d.atickets<=0){
            System.out.println("kali");
            
        }
        else if(d.atickets<count){
            System.out.println("Ticket ivlo thaa iruku"+ d.atickets);
        }
        else{
            d.atickets-=count;
            currentUser.ab(d.name,count);
            System.out.println("unga ticket confirm aagitu"+ count);
            System.out.println("inum yevlo ticket irukuna"+ d.atickets);
        }
    }
    private static Boolean au(Scanner sc){
        System.out.println("enter u name");
        String un=sc.nextLine();
        System.out.println("enter password");
        String pw=sc.nextLine();
        for(User user:up){
            if(user.name.equals(un) && user.password.equals(pw)){
                System.out.println("Login success");
                currentUser=user;
                return true;
            }
        }
            
                System.out.println("Invalid");
                return false;
            
        
    }
}
    
    

