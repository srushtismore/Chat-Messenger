import java.net.*;
import java.io.*;

class ChatServerXX
{
    public static void main(String A[])    throws Exception
    {
        ServerSocket ssobj = new ServerSocket(5100);
        System.out.println("MArvellous Server is waiting at port number 5100");
        Socket sobj = ssobj.accept();
        System.out.println("Marvellous Server Successfullu connected with the client");

       
        PrintStream pobj = new PrintStream(sobj.getOutputStream());

        BufferedReader bobj1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));

        BufferedReader bobj2 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("--------------------------------------------------");
        System.out.println("Marvellous chat messenger is ready to use");
        System.out.println("--------------------------------------------------");

        String str1 = null, str2 = null;

      
        FileWriter fwobj = new FileWriter("MarvellousChatMessenger.txt");

        while(((str1) = bobj1.readLine()) != null)
        {
            System.out.println("Client says : "+str1);
            fwobj.write("Clinet Says : "+str1);
            fwobj.write(System.lineSeparator());
            System.out.println("Enter the message from client : ");
            str2 = bobj2.readLine();
            pobj.println(str2);
            fwobj.write ("Server says : "+str2);
            fwobj.write(System.lineSeparator()); 
            fwobj.flush();
        }

        fwobj.close();


    }
}