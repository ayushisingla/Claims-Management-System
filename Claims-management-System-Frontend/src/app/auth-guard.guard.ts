import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

/**
* Authguard is use for blocking the access to other webpages before logging
*/
export class AuthGuardGuard implements CanActivate {
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    /**
    * if it will get the jwt token from localstorage then only it will provide routing
    * if not then it will redirect to login page 
    */  
    if(localStorage.getItem("jwtToken")){
      return true;
    }
  this.route.navigate(["/loginModule"]);
      return false;
  }
  constructor(private route:Router){}
}
