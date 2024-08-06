package Records_Combined;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class WriteRandFile extends JFrame {
   JTextField acct, fName,  lName,  bal; 
   JButton enter,  done; 
   JLabel acctLabel, fNameLabel,  lNameLabel,  balLabel; 
   
   RandomAccessFile output;  // file for output
   Record data;
   
   public WriteRandFile()   {
      super( "Write to random access file" );
      data = new Record();

      try {
         output = new RandomAccessFile( "credit.dat", "rw" );
      }
      catch ( IOException e ) {
         System.err.println( e.toString() );
         System.exit( 1 );
      }

  Container c = getContentPane();
      c.setLayout( new GridLayout( 5, 2 ) );
      acct = new JTextField( 20 );
      acctLabel = new JLabel( "Account Number" );
      fName = new JTextField( 20 );
      fNameLabel = new JLabel( "First Name" );
      lName = new JTextField( 20 );
      lNameLabel = new JLabel( "Last Name" );
      bal = new JTextField( 20 );
     balLabel = new JLabel( "Balance" );
      enter = new JButton( "Enter" );
      done = new JButton( "Done" );
      c.add( acctLabel );   // add label  
      c.add( acct );        // add TextField
      c.add( fNameLabel );  // add label  
      c.add( fName );       // add TextField
      c.add( lNameLabel );  // add label  
      c.add( lName );       // add TextField
      c.add( balLabel );    // add label  
      c.add( bal );         // add TextField
      c.add( enter );       // add button
      c.add( done );        // add button

      done.addActionListener( new ActionListener () {  
           public void actionPerformed( ActionEvent event ){
             System.exit( 0 );
           }
        }
      ); 
      enter.addActionListener( new ActionListener () {  
          public void actionPerformed( ActionEvent event ){
            addRecord();       
         } }
      );
      setSize( 300, 150 );
      setVisible( true );
   }

  public static void main( String args[] )   {
      WriteRandFile accounts = new WriteRandFile();
   }
  
 public void addRecord()   {

      int acctNum = 0;
      acctNum = (new Integer(acct.getText())).intValue();

             // output the values to the file

      try {
         if ( acctNum > 0 && acctNum <= 100 ) {
            data.setAccount(acctNum);
            data.setFirstName(fName.getText());
            data.setLastName(lName.getText());
            data.setBalance(Double.parseDouble(bal.getText()));  

            output.seek( (long) ( acctNum-1 ) * data.size() );
            data.write( output );

            // clear the TextFields
            acct.setText( "" );
            fName.setText( "" );
            lName.setText( "" );
            bal.setText( "" );
         }

         else {
            acct.setText( "Enter valid account (1-100)" );
            acct.selectAll();
         }
      }
      catch ( IOException e ) {
         System.err.println( "Error during write to file\n" +
                             e.toString() );
         System.exit( 1 );
      }
   }
 }


