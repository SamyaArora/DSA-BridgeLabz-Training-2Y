package com.linkedlist;

import java.util.Scanner;

class Process{
    int id,bt,pt,wt=0,tt=0; Process next;
    public Process(int id,int bt,int pt){this.id=id;this.bt=bt;this.pt=pt;}
}

public class RoundRobin{
    private Process head=null;
    Scanner sc=new Scanner(System.in);

    void addProcess(Process p){ if(head==null){head=p; p.next=p;} else {Process cur=head; while(cur.next!=head) cur=cur.next; cur.next=p; p.next=head;}}

    void simulate(int tq){
        if(head==null){System.out.println("No processes"); return;}
        int n=0; Process cur=head; do{n++; cur=cur.next;}while(cur!=head);
        int sumWT=0,sumTT=0;
        cur=head;
        boolean done; do{
            done=true;
            Process start=cur;
            do{
                if(cur.bt>0){
                    done=false;
                    int exec=Math.min(tq,cur.bt);
                    cur.bt-=exec;
                    cur.tt+=exec;
                    Process temp=cur.next;
                    Process p=head;
                    do{if(p!=cur && p.bt>0) p.wt+=exec; p=p.next;}while(p!=head);
                    cur=temp;
                } else cur=cur.next;
            }while(cur!=start);
        }while(!done);
        cur=head; do{sumWT+=cur.wt; sumTT+=cur.tt; cur=cur.next;}while(cur!=head);
        System.out.println("Avg WT: "+(sumWT/n)+" | Avg TT: "+(sumTT/n));
    }

    public void menu(){
        System.out.print("Time Quantum: "); int tq=sc.nextInt();
        while(true){
            System.out.println("\n1.AddProcess 2.Simulate 3.Exit"); int ch=sc.nextInt();
            switch(ch){
                case 1 -> {System.out.print("ID:");int id=sc.nextInt(); System.out.print("BT:");int bt=sc.nextInt(); System.out.print("Priority:");int pt=sc.nextInt(); addProcess(new Process(id,bt,pt));}
                case 2 -> simulate(tq);
                case 3 -> {sc.close(); return;}
                default -> System.out.println("Invalid");
            }
        }
    }

    public static void main(String[] args){new RoundRobin().menu();}
}