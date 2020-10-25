/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package election.Admin;

import election.Persona.CandidateProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Seat {

    int code;
    String name;
    Election election;
    ArrayList<CandidateSeatAssignment> candidateseatassignmentlist;

    public Seat(Election e, int c, String name) {
        election = e;
        code = c;
        this.name = name;
        candidateseatassignmentlist = new ArrayList();

    }

    public void addCandidateSeatAssignment(CandidateSeatAssignment csa) {

//links seatassignment to seat
        if (!candidateseatassignmentlist.contains(csa)) {
            candidateseatassignmentlist.add(csa);
        }

    }

    public CandidateSeatAssignment newCandidateSeatAssignment(CandidateProfile cf) {

        CandidateSeatAssignment csa = new CandidateSeatAssignment(cf, this); //links seatassignment to seat
        candidateseatassignmentlist.add(csa);
        return csa;

    }
    public ArrayList<CandidateSeatAssignment> getRunningCandidates(){
        
        return candidateseatassignmentlist;
        

}
        public ArrayList<CandidateProfile> getRunningCandidatesProfiles(){
        
        ArrayList<CandidateProfile> cps = new ArrayList();
        for ( CandidateSeatAssignment csa: candidateseatassignmentlist)    {
            CandidateProfile cp = csa.getCandidateProfile();
            cps.add(cp);
        }
        return cps;
}
}