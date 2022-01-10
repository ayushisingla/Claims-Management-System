import { compileDeclareDirectiveFromMetadata } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Claim } from '../claim';
import { ClaimService } from '../claim.service';
import { Member } from '../member';

@Component({
  selector: 'app-claim-input',
  templateUrl: './claim-input.component.html',
  styleUrls: ['./claim-input.component.css']
})
export class ClaimInputComponent implements OnInit {
  claim = new Claim();
  key1 : any;
  errormsg ="";
  constructor(private _service : ClaimService, private _route : Router) { }

  ngOnInit(): void {
    this.key1 = sessionStorage.getItem("key");
  }

  // This function will get the data from backend
  //  and after successfull validation it will provide the data 
  //  otherwise error
  
  claims(){
    this._service.claimStatus(this.claim).subscribe(
      (data : Claim) => { 
        // console.log("response received");
        // console.log(data);

      // Sending data to output page ie /claimOutput through queryParam
        
      this._route.navigate(['/claimOutput'],{
        skipLocationChange : true,
        queryParams:{
          data : JSON.stringify(data)
        }
      });
     
    },

    // if details are not correct,
    // send user again to claimsInput form 
    error =>{
      this.errormsg="Please provide the correct details";
      this._route.navigate(['/claimInput'])
      // console.log(error);
    }
  )

  }

  onLogout(){
    localStorage.clear();
  }
  

}
