package App;
import ch.wisv.toornament.ToornamentClient;
import ch.wisv.toornament.concepts.Disciplines;
import ch.wisv.toornament.concepts.Tournaments;
import ch.wisv.toornament.model.Discipline;
import ch.wisv.toornament.model.DisciplineDetails;
import ch.wisv.toornament.model.Tournament;
import ch.wisv.toornament.model.request.ApiTokenRequest;
import ch.wisv.toornament.model.request.TournamentRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Runner {
    /**
     * @param args the command line arguments
     */
 

    /*    public Runner() throws FileNotFoundException
    {
    Scanner linReader = new Scanner(new File("dataFile.txt"));
    
    
    API = linReader.nextLine();
    id = linReader.nextLine();
    secret = linReader.nextLine();
    
    linReader.close();
    
    }*/


    public static void main(String[] args) {
String API = "";
String id = "";
String secret = "";
    try (Scanner linReader = new Scanner(new File("C:\\Users\\Brenton\\Desktop\\dataFile.txt"))) {
        API = linReader.nextLine();
        id = linReader.nextLine();
        secret = linReader.nextLine();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
    }
        ToornamentClient Client = new ToornamentClient(API,id,secret);
        Client.authorize();
        
            
        try {
           List<Tournament> details = Client.tournaments().getAllTournaments();
           
           Iterator<Tournament> iterator = details.iterator();
	while (iterator.hasNext()) {
		System.out.println(iterator.next().getName());
	}
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        
        
    
        
        
    }
}
