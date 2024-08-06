description:

1 - Comments about Record.java:

RandomAccessFile with objects of Record type 
Reads or writes data using the file-position pointer
Reads one object at a time to file with obj.read(file)
Writes one object at a time to file with obj.write(file)
Both methods read() and write() use array of bytes instead of Strings to ensure that data is not larger than the size of the Record object 
In this example the size is 42 bytes, with the encapsulated Strings maximum 15 bytes.
There is no need to separately compile Record.java.  Compiling any java file containing the word Record will create Record.class.


2- comments about CreateRandFile.java:

This Java application creates an empty Random-Access file called “credit.dat” containing 100 objects of Record type. 
That is done with a loop containing  blank.write( file );  where blank = new Record(); 
The size of the file credit.dat is 4200 bytes. 


3 - comments about WritRandFile.java:

This JFrame application allows the user to enter data in the empty Random-Access file “credit.dat”.
It uses a simple GridLayout(5,2) with labels,textfields and two buttons.
The “Enter” button will write into the file a record containg the textfields data. The line output.seek( (long) ( acctNum-1 ) * data.size() );  is used to position the file pointer to the correct position. The variable acctNum corresponds to account number entered in the corresponding textfield.


4 - Comments about ReadRandFile.java:

This JFrame application allows the user to read data from the Random-Access file “credit.dat”.
It uses the same simple GridLayout(5,2) with labels,textfields and two buttons.
The use of “Next” button will trigger the method readRecord() which uses the line data.read(input);  to transfer a Record from input to the empty Record object data.  
A loop is used to ignore the file empty Records, which the account numbers equal to zero.


5 -  Comments about ListRecords.java:

This JFrame application reads all data from the  Random-Access file “credit.dat” and creates an array of Record objects using the non-empty objects.  
The sorted array is displayed in a text area using a specified format, with the customers names and balances.
