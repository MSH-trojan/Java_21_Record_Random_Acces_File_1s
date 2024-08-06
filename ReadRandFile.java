package Records_Combined;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ReadRandFile extends JFrame {
   // Application window components
   JTextField acct,     // where user enters account number
             fName,     // where user enters first name
             lName,     // where user enters last name
             bal;       // where user enters balance
   JButton next,        // send record to file
          done;         // quit program
   JLabel acctLabel,    // account label
         fNameLabel,    // first name label
         lNameLabel,    // last name label
         balLabel;      // balance label
   
   RandomAccessFile input;  // file for output
   Record data;
   boolean moreRecords=true;
  
   public ReadRandFile()   {
      super( "Read from random access file" );
      data = new Record();
      try {
         input = new RandomAccessFile( "credit.dat", "r" );
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
      next = new JButton( "Next" );
      done = new JButton( "Done" );
      c.add( acctLabel );   // add label  
      c.add( acct );        // add TextField
      c.add( fNameLabel );  // add label  
      c.add( fName );       // add TextField
      c.add( lNameLabel );  // add label  
      c.add( lName );       // add TextField
      c.add( balLabel );    // add label  
      c.add( bal );         // add TextField
      c.add( next );       // add button
      c.add( done );        // add button
      done.addActionListener( new ActionListener () {  
	  public void actionPerformed( ActionEvent event ){
            System.exit( 0 );
          } }
      );  
      next.addActionListener( new ActionListener () {  
          public void actionPerformed( ActionEvent event ){
            readRecord();       
         } }
      );
      setSize( 300, 150 );
      setVisible( true );
   }
   public static void main( String args[] )   {
	      ReadRandFile accounts = new ReadRandFile();
	   }

	 public void readRecord()   {

	      try {
	         do {  // loop over empty records
	            data.read( input );
	         } while ( input.getFilePointer() < input.length() &&
	                   data.getAccount() == 0 );
	      }
	      catch( IOException e ) {
	         moreRecords = false;
	      }

	       // transfer full record data into textfields
	      if ( data.getAccount() != 0 ) {
	         acct.setText( String.valueOf( data.getAccount() ) );
	         String fN=data.getfName();
	         fName.setText(fN);
	         String lN=data.getlName();
	         lName.setText(lN);
	         bal.setText( String.valueOf( data.getBalance() ) );
	      }
	   }
	 }


