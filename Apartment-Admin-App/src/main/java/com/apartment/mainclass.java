package com.apartment;
import java.util.Scanner;
public class mainclass {

	public static void main(String[] args) {
		logincode l=new logincode();
		Guest g=new Guest();
		Tenant t=new Tenant();
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter username: ");
		String user=sc.next();
		System.out.print("Enter password: ");
		String pass=sc.next();
		boolean r=l.adlog(user, pass);
		
		if(r==true) {
		System.out.println("Welcome Admin");
		while(true) {
		System.out.print("1. Tenant\n2. Guest");
		System.out.println("\n3. Exit");
		System.out.print("Enter your choice: ");
		int ch=sc.nextInt();
		
		if(ch==1) {
			while(true) {
				System.out.print("1.New comer \n2.Already Stayer");
				System.out.println("\n3.Back to home page");
				System.out.print("Enter your choice: ");
				int tch=sc.nextInt();
				
				if(tch==1) {
					System.out.print("Enter Car Number(TN00AX0000): ");
					String num=sc.next();
					System.out.print("Enter Tenant Name: ");
					String name=sc.next();
					System.out.print("Enter Tenant Block: ");
					String block=sc.next();
					System.out.print("Enter Tenant Room No: ");
					int room=sc.nextInt();
					System.out.print("Enter Tenant Entry Time: ");
					String time=sc.next();
					System.out.print("Enter Tenant Entry Date(YYYY-MM-DD): ");
					String date=sc.next();
					t.insert(num,name,block,room,time,date);
					t.entryno(num);
					
				}
				else if(tch==2) {
					System.out.print("1. Update out time\n2. Update in time");
					System.out.println("\n3. Exit");
					System.out.print("Enter your choice: ");
					int tch1=sc.nextInt();
						if(tch1==1){
						System.out.print("Enter Tenant Entry id: ");
						int id=sc.nextInt();
						System.out.print("Enter Tenant Out Time: ");
						String otime=sc.next();
						System.out.print("Enter Tenant Out Date(YYYY-MM-DD): ");
						String odate=sc.next();
						t.updateout(id, otime, odate);
						
						}
						else if(tch1==2) {
							System.out.print("Enter Tenant Entry id: ");
							int id=sc.nextInt();
							System.out.print("Enter Tenant in Time: ");
							String itime=sc.next();
							System.out.print("Enter Tenant in Date(YYYY-MM-DD): ");
							String idate=sc.next();
							t.updatein(id, itime, idate);
							
						}else if(tch1==3) {
							break;
						}else { System.out.println("Invalid choice"); }
					
				}
				else if(tch==3) {
					break;
				}
				else {
					System.out.println("Invalid option");
				}
			}
			
		}
		else if(ch==2) {
			//guest class call
			while(true) {
				System.out.print("1.Enter details in portal");
				System.out.print("\n2. Update Out Time\n3. View details");
				System.out.println("\n4. Back to home page");
				System.out.print("Enter your choice: ");
				int gch=sc.nextInt();
				
				if(gch==1) {
				System.out.print("Enter Car Number(TN00AX0000): ");
				String num=sc.next();
				System.out.print("Enter Guest Name: ");
				String name=sc.next();
				System.out.print("Enter Tenant Block: ");
				String block=sc.next();
				System.out.print("Enter Tenant Room No: ");
				int room=sc.nextInt();
				System.out.print("Enter Guest Entry Time: ");
				String time=sc.next();
				System.out.print("Enter Guest Entry Date(YYYY-MM-DD): ");
				String date=sc.next();
				int res=g.insert(num,name,block,room,time,date);
				g.entryno(num);
				//System.out.println((res>=1)?"Details stored":"");
				
				}
			
			else if(gch==2) {
					//update out time
					System.out.print("Enter Car Number(TN00AX0000): ");
					String Cnum=sc.next();
					System.out.print("Enter Guest Out Time: ");
					String otime=sc.next();
					System.out.print("Enter Guest Out Date(YYYY-MM-DD): ");
					String odate=sc.next();
					int res=g.update(Cnum,otime,odate);
					System.out.println((res>=1)?"Updated":"Not updated");
				}
				else if(gch==3) {
					//view
					g.select();
				}
				else if(gch==4) {
					//exit
					break;
				}
				else {
					System.out.println("Invalid choice");
				}
			}
			
		}
		else if(ch==3) {
			//Exit
			System.out.println("Logout sucessfully");
			break;
		}
		}
	}else {
		System.out.println("Invalid user");
	}
		
		sc.close();		
	}

}
