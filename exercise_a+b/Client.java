import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
	private static String name = "";
	
    private Client() {}

    public static void main(String[] args) {
        String host = "localhost";
        try {
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			
            Registry registry = LocateRegistry.getRegistry(host);
            MediaManagement stub = (MediaManagement) registry.lookup("MediaManagement");
			
			while (true) {
				String line = console.readLine();
				
				boolean login = false;
				while (!login) {
					Scanner sc= new Scanner(System.in);
					String username = sc.nextLine();
					System.out.println("Username: " + username);
					String password = sc.nextLine();
					System.out.println("Password: " + password);
					login = stub.login(username, password);
					System.out.println("Login: " + login);

					Client.name = username;
				}
				
				Thread output = new Thread(new Runnable(){
		            @Override
		            public void run() {
		                try {
		                	int slot1 = 0;
		                	while(true) {
		              
			                	if (slot1 != stub.getSlot()) {
			                		int[][] arr = stub.getArr();
			                		slot1 = stub.getSlot();
			                		for (int i = 0; i<3; i++) {
			    						for (int j=0; j<3; j++) {
			    							System.out.print(arr[i][j]+" ");
			    						}
			    						System.out.println();
			    					}
			                		System.out.println();
			                	}
		                	}
		                	
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		            }
		        });
		        output.start();
				
				while(stub.getWinner().equals("")) {
					Scanner sc= new Scanner(System.in);
					System.out.println("Enter your move (row[1-3]): ");
					int pos1 = sc.nextInt();
					System.out.println("Enter your move (column[1-3]): ");
					int pos2 = sc.nextInt();
					System.out.println("Character: ");
					int character = sc.nextInt();
					stub.play(pos1, pos2, character);
					
					
				}
				
				System.out.println("Winner: " + stub.getWinner());
				
				
			}
            
        } catch (IOException ioe) {
			System.out.println("Unexpected exception: " + ioe.getMessage());
		}		
		catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

