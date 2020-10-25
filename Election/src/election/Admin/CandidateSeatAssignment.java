/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package election.Admin;

import election.Persona.CandidateProfile;
import election.VoteSelection.Vote;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CandidateSeatAssignment {
    
    CandidateProfile candidateprofile;
    Seat seat;
    ArrayList<Vote> receivedvotes;
    public CandidateSeatAssignment(CandidateProfile cf, Seat s){
        
        candidateprofile = cf;
        seat = s;
        seat.addCandidateSeatAssignment(this);
        receivedvotes = new ArrayList();
    }
    public CandidateProfile getCandidateProfile(){
        return candidateprofile;
    }
    public CandidateProfile castVoteForCandidate(Vote v){
        receivedvotes.add(v);
        v.assignCandidateToVote(this); //vote complete
        return candidateprofile;
        
    }
    
}
