import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Submit } from './submit';

@Injectable({
  providedIn: 'root'
})
export class SubmitService {

  constructor(private _http : HttpClient) { }

  public submitClaim(submit : Submit):Observable<any>{
   
    return this._http.post<Submit>("http://localhost:8020/member/submitClaim/"+submit.policyId+"/"+submit.claimId+"/"+submit.memberId+"/"+submit.providerId+"/"+submit.benefitId+"/"+submit.totalBilledAmount+"/"+submit.totalClaimedAmount,submit)
  }

}
