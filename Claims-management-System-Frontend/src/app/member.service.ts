import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Member } from './member';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class MemberService {

  constructor(private _http : HttpClient) { }

  public memberForm(member :Member):Observable<Member[]>{
    
    return this._http.get<Member[]>("http://localhost:8020/member/viewBills/"+member.memberId+"/"+member.policyId);
  }

 

  
}
