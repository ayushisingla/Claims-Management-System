import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Claim } from './claim';
import { Member } from './member';

@Injectable({
  providedIn: 'root'
})
export class ClaimService {
  claimForm(claim: Claim) {
    throw new Error('Method not implemented.');
  }

  constructor(private _http :HttpClient) { }

  public claimStatus(claim : Claim):Observable<Claim>{
   
    return this._http.get<Claim>("http://localhost:8020/member/getClaimStatus/"+claim.claimId+"/"+claim.policyId+"/"+claim.memberId)
  }
}
