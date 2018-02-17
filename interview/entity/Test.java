package interview.entity;

import java.io.File;
import java.io.RandomAccessFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test {
    
    
    public static void main(String[] args) throws Exception{
        RandomAccessFile fin = null;
        Scanner sc = null;
        File f1 = new File("");
        File f2 = new File("");
        Map<String,Customer> allCustomers = new HashMap<String,Customer>();
        Map<String,Driver> allDrivers = new HashMap<String,Driver>();
        NearByCabs allCabs = new NearByCabs();
        try{
            sc = new Scanner(System.in);
            String line = null;
            while((line = fin.readLine()) != null ){
                String[] data = line.split(" ");
                String c = data[0].trim(), d = data[2].trim();
                double cr = Double.parseDouble(data[1].trim()), dr = Double.parseDouble(data[3].trim());
                Customer C;
                Driver D;
                if(allCustomers.containsKey(c) == false){
                    C = new Customer(c);
                    allCustomers.put(c,C);
                }
                else
                    C = allCustomers.get(c);
                if(allDrivers.containsKey(d) == false){
                    D = new Driver(d);
                    allDrivers.put(d,D);
                }
                C.updateRating(cr);
                D.updateRating(dr);
            }
            int seq = 0;
            while((line = fin.readLine()) != null){
                seq++;
                String[] data = line.split(" ");
                Driver d = allDrivers.get(data[0].trim());
                Cab cab = new Cab(d);
                int n = Integer.parseInt(data[1].trim());
                for(int i=0;i<n;++i){ 
                    Customer dummy = new Customer(String.valueOf(seq)+String.valueOf(i));
                    String locData[] = data[2+i].trim().split(",");
                    Location loc = new Location(Integer.parseInt(locData[0]), Integer.parseInt(locData[1]));
                    Booking B = new Booking(dummy,loc,1);
                    cab.addBooking(B);
                }
                allCabs.addCab(cab);
            }
            
            //customer input
            String newCust = sc.nextLine().trim();
            int seats = Integer.parseInt(sc.nextLine());
            String locData[] = sc.nextLine().split(",");
            Location destination = new Location(Integer.parseInt(locData[0]), Integer.parseInt(locData[1]));
            Booking newBooking = new Booking(allCustomers.get(newCust),destination,seats);
            
            System.out.print("Customer rating is - ");
            System.out.println(allCustomers.get(newCust).getRating());
            
            List<Cab> L = allCabs.getMatch(newBooking);
            System.out.println("Cab matches found are - ");
            for(int i=0;i<L.size();++i){
                System.out.print(" Driver name -");
                System.out.println(L.get(i).getDriver().getName());
            }            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(fin != null)
                fin.close();
            if(sc != null)
                sc.close();
        }
            
    }
    
}
