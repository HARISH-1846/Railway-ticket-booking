import java.util.*;
public class TicketBooker {
    static int availableLowerBerth=21;
    static int availableMiddleBerth=21;
    static int availableUpperBerth=21;  
    static int availableRacTicket=18;
    static int availableWaitingList=10;
     
    static Queue<Integer> racList= new LinkedList<>();
    static Queue<Integer> waitingList= new LinkedList<>();
    static List<Integer> bookedList = new ArrayList<>();

    static List<Integer> lowerBerthPosition= new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21));
    static List<Integer> middleBerthPosition= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21));
    static List<Integer> upperBerthPosition= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21));
    static List<Integer> racPosition= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18));
    static List<Integer> waitingListPosition= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

    static Map<Integer,Passenger> passengerMap = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void bookticket1(Passenger p, int position, String berthType)
    {
        p.number=position;
        p.allotted=berthType;
        passengerMap.put(p.passengerId, p);
        bookedList.add(p.passengerId);
        System.out.println("Ticket Booked Successfully");
    }
    public void addtorac(Passenger p, int position, String rac)
    {
        p.number=position;
        p.allotted=rac;
        passengerMap.put(p.passengerId, p);
        racList.add(p.passengerId);
        availableRacTicket--;
        racPosition.remove(0);
        System.out.println("RAC Ticket Booked Successfully");
    }
    public void addtowaitinglist(Passenger p, int position, String wl)
    {
        p.number=position;
        p.allotted=wl;
        passengerMap.put(p.passengerId, p);
        waitingList.add(p.passengerId);
        availableWaitingList--;
        waitingListPosition.remove(0);
        System.out.println("Waiting List Ticket Booked Successfully");
    }
    public void BookTicket()
    {
        System.out.println("Enter Passenger Name:");
        String name=sc.next();
        System.out.println("Enter Berth Preference (Lower/Middle/Upper):");
        String berthPreference=sc.next();
        berthPreference = berthPreference.toUpperCase();
        System.out.println("Enter Age:");
        int age=sc.nextInt();
        Passenger p=new Passenger(name, berthPreference, age);
        if(availableWaitingList==0)
        {
            System.out.println("No tickets available");
            return;
        }
        if((p.berthPreference.equals("L") && availableLowerBerth>0) ||
        (p.berthPreference.equals("M") && availableMiddleBerth>0) ||
        (p.berthPreference.equals("U") && availableUpperBerth>0))
        {
            System.out.println("Berth Preference is available");
            if(p.berthPreference.equals("L"))
            {
                System.out.println("Lower Berth is available");
                bookticket1(p,(lowerBerthPosition.get(0)),"L");
                lowerBerthPosition.remove(0);
                availableLowerBerth--;
            }
            else if(p.berthPreference.equals("M"))
            {
                System.out.println("Middle Berth is available");
                bookticket1(p,(middleBerthPosition.get(0)),"M");
                middleBerthPosition.remove(0);
                availableMiddleBerth--;
            }
            else if(p.berthPreference.equals("U"))
            {
                System.out.println("Upper Berth is available");
                bookticket1(p,(upperBerthPosition.get(0)),"U");
                upperBerthPosition.remove(0);
                availableUpperBerth--;
            }
        }
        else if(availableLowerBerth>0)
        {
            System.out.println("Lower Berth is Allotted");
            bookticket1(p,(lowerBerthPosition.get(0)),"L");
            lowerBerthPosition.remove(0);
            availableLowerBerth--;
        }
        else if(availableMiddleBerth>0)
        {
            System.out.println("Middle Berth is Allotted");
            bookticket1(p,(middleBerthPosition.get(0)),"M");
            middleBerthPosition.remove(0);
            availableMiddleBerth--;
        }
        else if(availableUpperBerth>0)
        {
            System.out.println("Upper Berth is Allotted");
            bookticket1(p,(upperBerthPosition.get(0)),"U");
            upperBerthPosition.remove(0);
            availableUpperBerth--;
        }
        else if(availableRacTicket>0)
        {
            System.out.println("Rac available");
            addtorac(p,(racPosition.get(0)),"RAC");
        }
        else if(availableWaitingList>0)
        {
            System.out.println("Waiting List available");
            addtowaitinglist(p,(waitingListPosition.get(0)),"WL");
        }
        else
        {
            System.out.println("No tickets available");
        }
    }
    public void CancelTicket()
    {
        System.out.println("Enter id to cancel");
        int id=sc.nextInt();
        if(!passengerMap.containsKey(id))
        {
            System.out.println("Invalid ID");
            return;
        }
        Passenger p = passengerMap.get(id);
        passengerMap.remove(id);
        bookedList.remove(Integer.valueOf(id));
        int posbooked=p.number;
        if(p.allotted.equals("L"))
        {
            availableLowerBerth++;
            lowerBerthPosition.add(posbooked);
        }
        else if(p.allotted.equals("M"))
        {
            availableMiddleBerth++;
            middleBerthPosition.add(posbooked);
        }
        else if(p.allotted.equals("U"))
        {
            availableUpperBerth++;
            upperBerthPosition.add(posbooked);
        }
        else if(!racList.isEmpty())
        {
            Passenger racPassenger = passengerMap.get(racList.poll());
            int posnumber=racPassenger.number;
            availableRacTicket++;
            racList.remove(racPassenger.passengerId);
            racPosition.add(posnumber);

            if(!waitingList.isEmpty())
            {
                Passenger wPassenger= passengerMap.get(waitingList.poll());
                int wposnumber=wPassenger.number;
                waitingListPosition.add(wposnumber);
                waitingList.remove(wPassenger.passengerId);

                wPassenger.number = racPosition.get(0);
                wPassenger.allotted = "RAC";
                racPosition.remove(0);
                racList.add(wPassenger.passengerId);
                availableWaitingList++;
                availableRacTicket--;
            }
            bookticket1(racPassenger, posnumber, "RAC");
        }

    }    
    public void AvailableTicket()
    {
        System.out.println("Available Lower Berth: " + availableLowerBerth);
        System.out.println("Available Middle Berth: " + availableMiddleBerth);
        System.out.println("Available Upper Berth: " + availableUpperBerth);
        System.out.println("Available RAC Tickets: " + availableRacTicket);
        System.out.println("Available Waiting List Tickets: " + availableWaitingList);
    }
    public void BookedTicket()
    {
        if(passengerMap.isEmpty())
        {
            System.out.println("No tickets booked");
            return;
        }
        for(Passenger p : passengerMap.values())
        {
            System.out.println("Passenger ID: " + p.passengerId);
            System.out.println("Name: " + p.name);
            System.out.println("Berth Preference: " + p.berthPreference);
            System.out.println("Age: " + p.age);
            System.out.println("Allotted Berth: " + p.allotted);
            System.out.println("Position Number: " + p.number);
            System.out.println("-----------------------------");
        }
    }
}