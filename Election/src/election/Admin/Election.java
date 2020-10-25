/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package election.Admin;

import election.Area.District;
import election.Persona.CandidateDirectory;
import election.Persona.CandidateProfile;
import election.Persona.Person;
import election.Persona.PersonDirectory;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */

public class Election {
    PersonDirectory persondirectory;
    CandidateDirectory candidatedirectory;
    ArrayList<Seat> seatlist;
    District district;
    
    public Election(District d){
        candidatedirectory = new CandidateDirectory(this);
        seatlist = new ArrayList();
        district = d;        
    }
    
    public Seat newSeat(int code, String name){
        
        Seat s = new Seat(this, code, name);
        seatlist.add(s);
        return s;
    }
    public Person RegisterPerson(String ssn){
        
        Person p = persondirectory.newPerson(ssn);
        
        return p;
    }
    
    public CandidateProfile registerCandidateProfile(String ssn){
        
        Person p = persondirectory.findPerson(ssn);
        CandidateProfile cp = candidatedirectory.newCandidateProfile(p);
        return cp;
        
    }
    public void assignCandidateToASeat(String name, int code, CandidateProfile cp){
        
        Seat seat = findSeat(name, code);       
        seat.newCandidateSeatAssignment(cp);
    }
    
    public ArrayList<CandidateProfile> getRunningCandidatesForSeat(String n, int c){
        
        Seat seat = findSeat(n, c);
        return seat.getRunningCandidatesProfiles();    
}
    private Seat findSeat(String n, int c){
    
        for (Seat s: seatlist){
            if(s.name.equals(n)&&s.code==c) return s;              
            }
        return null;
        }
    }

