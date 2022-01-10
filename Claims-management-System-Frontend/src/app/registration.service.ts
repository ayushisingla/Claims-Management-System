import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  v : any;
  
  constructor(private _http : HttpClient) { }

  
  public loginUserFormRemote(user :User):Observable<any>{
    sessionStorage.setItem("key" , user.username);
    
    return this._http.post("http://localhost:8089/authorization/login",user)
  }
}
