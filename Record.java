package record;

import java.io.*;

public class Record {
   private int account;
   private String lastName;
   private String firstName;
   private double balance;
   public Record(int a, String f, String l, double b) {
      account=a;
      firstName=f;
      lastName=l;
      balance=b;
   }
   public Record() {
      account=0;
      firstName=null;
      lastName=null;
      balance=0;
   }
   // Read a record from the specified RandomAccessFile
   public void read( RandomAccessFile file ) throws IOException   {
      account = file.readInt();
      byte b1[] = new byte[ 15 ];
      file.readFully( b1 );
      firstName = new String( b1 );
      firstName=firstName.trim();
      byte b2[] = new byte[ 15 ];
      file.readFully( b2 );
      lastName = new String( b2 );
      lastName=lastName.trim();
      balance = file.readDouble();
   }
   public void write( RandomAccessFile file ) throws IOException   {
      file.writeInt( account );
      byte b1[] = new byte[ 15 ];
      if ( firstName != null )
         b1 = firstName.getBytes();
      file.write( b1 );
      byte b2[] = new byte[ 15 ];
      if ( lastName != null )
         b2 = lastName.getBytes();
      file.write( b2 );
      file.writeDouble( balance );
   }
     public void setAccount(int a) { account=a;}
     public void setLastName(String l) { lastName=l;}
     public void setFirstName(String f) { firstName=f;}
     public void setBalance(double b) { balance=b; }

     public int getAccount(){ return account;}
     public String getlName(){ return lastName;}
     public String getfName(){ return firstName;}
     public double getBalance(){ return balance;}

     public int size() { return 42; }
}

