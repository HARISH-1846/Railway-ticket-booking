import java.util.Scanner;

public class Main {
    static TicketBooker TicketBooker = new TicketBooker();
    public static  void BookTicket() {
        TicketBooker.BookTicket();
    }
    public static  void CancelTicket() {
        TicketBooker.CancelTicket();
    }
    public static  void AvailableTicket() {
        TicketBooker.AvailableTicket();
    }
    public static  void BookedTicket() {
        TicketBooker.BookedTicket();
    } 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean flag = true;
        while(flag)
        {
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket"); 
            System.out.println("3. Available Ticket");
            System.out.println("4. Booked Ticket");
            System.out.println("5. Exit");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    BookTicket();
                    break;
                case 2:
                    CancelTicket();
                    break;
                case 3:
                    AvailableTicket();
                    break;
                case 4:
                    BookedTicket();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice, exiting...");
                    return;
            }
        }
        sc.close();
    }
}