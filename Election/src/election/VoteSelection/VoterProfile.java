/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package election.VoteSelection;

import election.Admin.Seat;
import election.Persona.Person;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class VoterProfile {
    Person person;
    String party;
    HashMap<Seat, Vote> votes;
    public VoterProfile(Person p){
        person = p;
        votes = new HashMap<Seat, Vote>();
        
    }
    public void newVoteForSeat(Seat s){
        
        Vote v = new Vote(this, s);
        votes.put(s, v);
        
    }
    
    
    
}
