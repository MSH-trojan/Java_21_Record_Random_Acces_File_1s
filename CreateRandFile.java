package Records_Combined;

/*
 * This program creates a random access file sequentially by writing 100 empty records to disk.
 */

import java.io.*;
public class CreateRandFile {
   private Record blank;
   RandomAccessFile file;
   public CreateRandFile()   {
      blank = new Record();
      try {
         file = new RandomAccessFile( "credit.dat", "rw" );
      }
      catch( IOException e ) {
         System.err.println( "File not opened properly\n" +
                             e.toString() );
         System.exit( 1 );
      }
   }
   public void create()   {
      try {
         for ( int i = 0; i < 100; i++ ) {
            blank.write( file );
      }}
      catch ( IOException e ) {
         System.err.println( e.toString() );
      }
   }
   public static void main( String args[] )   {
      CreateRandFile accounts = new CreateRandFile();
      accounts.create();
   }   
}   
  