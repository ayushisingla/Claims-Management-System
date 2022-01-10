import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Submit } from '../submit';
import { SubmitService } from '../submit.service';

@Component({
  selector: 'app-submit-input',
  templateUrl: './submit-input.component.html',
  styleUrls: ['./submit-input.component.css']
})
export class SubmitInputComponent implements OnInit {
submit = new Submit();
key1 : any;
errormsg ="";
  constructor(private _service : SubmitService , private _route : Router) { }

  ngOnInit(): void {
    this.key1 = sessionStorage.getItem("key");
  }

/**
* This function will get the data from backend
* and after successfull validation it will provide the data otherwise error
*/
  submitForm(){
    
    this._service.submitClaim(this.submit).subscribe(
      data =>{
        console.log("response received");
        console.log(data);
        /**
        * Sending data to output page through queryParam 
        */
        this._route.navigate(['/submitOutput'],{
          skipLocationChange : true,
          queryParams:{
            data : JSON.stringify(data)
          }
        });

      },
      error =>{
        this.errormsg="Please provide the correct details";
        // this._route.navigate(['/submit-input'])
        console.log("Bad credentials");
        
      }
    )
  }

  onLogout(){
    localStorage.clear();
  }
}
