package com.linkedlist;

import java.util.Scanner;

class Ticket {
    int id; String custName, movieName, seat; String time; Ticket next;
    Ticket(int id,String c,String m,String s,String t){this.id=id; custName=c; movieName=m; seat=s; time=t;}
}

public class TicketReservation {
    private Ticket head;
    Scanner sc=new Scanner(System.in);

    void addTicket(Ticket t){
        if(head==null){head=t; t.next=t;}
        else{Ticket cur=head; while(cur.next!=head) cur=cur.next; cur.next=t; t.next=head;}
    }

    void removeTicket(int id){
        if(head==null){System.out.println("No tickets"); return;}
        Ticket cur=head, prev=null;
        do{
            if(cur.id==id){
                if(prev!=null) prev.next=cur.next;
                else{
                    Ticket last=head; while(last.next!=head) last=last.next;
                    head=cur.next; last.next=head;
                }
                System.out.println("Removed "+id); return;
            }
            prev=cur; cur=cur.next;
        }while(cur!=head);
        System.out.println("Ticket not found");
    }

    void displayTickets(){
        if(head==null){System.out.println("No tickets"); return;}
        Ticket cur=head;
        do{System.out.println(cur.id+" | "+cur.custName+" | "+cur.movieName+" | "+cur.seat+" | "+cur.time); cur=cur.next;}while(cur!=head);
    }

    public void menu(){
        while(true){
            System.out.println("\n1.AddTicket 2.RemoveTicket 3.DisplayTickets 4.Exit"); int ch=sc.nextInt(); sc.nextLine();
            switch(ch){
                case 1 -> {System.out.print("ID:");int id=sc.nextInt(); sc.nextLine(); System.out.print("Customer:");String c=sc.nextLine(); System.out.print("Movie:");String m=sc.nextLine(); System.out.print("Seat:");String s=sc.nextLine(); System.out.print("Time:");String t=sc.nextLine(); addTicket(new Ticket(id,c,m,s,t));}
                case 2 -> {System.out.print("ID:");int id=sc.nextInt(); removeTicket(id);}
                case 3 -> displayTickets();
                case 4 -> {sc.close(); return;}
                default -> System.out.println("Invalid");
            }
        }
    }

    public static void main(String[] args){new TicketReservation().menu();}
}