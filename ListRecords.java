package Records_Combined;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class ListRecords extends JFrame implements ActionListener{ 
       Record[] cust;
       Record data;      
       String s="";
       int jj=0, acct;                    
       JButton b1;
       JTextArea ta;

       public static void main( String args[] )   {
          ListRecords a = new ListRecords();
       }

       public ListRecords() {

// reading the RA file information to create an array of records
       cust = new Record[100];
       data = new Record();
       try      {
         RandomAccessFile file = new RandomAccessFile( "credit.dat", "r" );

         for (int i=1; i<100; i++) {
              data.read( file );
              if (data.getAccount() !=0 ) 
               cust[jj++]= new Record(data.getAccount(),data.getlName(),data.getfName(),data.getBalance());   
        }      
       }
       catch ( IOException e ) {
         System.err.println( e.toString() );
         System.exit( 1 );
        }
       
//   GUI

          Container c = getContentPane();
//         c.setLayout(new BorderLayout());     //  this is not needed as BorderLayout is by default
          b1=new JButton("Display All");
          b1.addActionListener(this);
          c.add(b1, BorderLayout.NORTH);
          ta = new JTextArea(20, 20);
          ta.setEditable(false);
          c.add(new JScrollPane(ta), BorderLayout.SOUTH);
          setSize(500,400);
          setVisible(true);
      }
 
     public void actionPerformed(ActionEvent e) {
               sort();
               for (int i=0; i<jj; i++)
                  s+=cust[i].getlName()+" has=$"+ cust[i].getBalance() + "\n";             
               ta.setText(s);        
     }

     public void sort() { 
        for ( int pass = 1; pass < jj; pass++ ) { 
         for ( int element = 0; element < jj - 1; element++ ) {
            if ( cust[element].getlName().compareTo(cust[element+1].getlName())>0 )  
               swap(element,element+1);
         }
        }
     }

     private void swap(int i, int j)   {      
      Record temp = cust[i];
      cust[i] = cust[j];
      cust[j] = temp;
     }
}

