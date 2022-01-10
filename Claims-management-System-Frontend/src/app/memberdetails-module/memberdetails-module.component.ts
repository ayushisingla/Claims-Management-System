import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Member } from '../member';
import { MemberService } from '../member.service';
import { User } from '../user';

@Component({
  selector: 'app-memberdetails-module',
  templateUrl: './memberdetails-module.component.html',
  styleUrls: ['./memberdetails-module.component.css']
})
export class MemberdetailsModuleComponent implements OnInit {
  member =new Member();
  key1 : any;
  mem : any;
  errormsg='';
 
  
  constructor(private _service : MemberService, private _route : Router) { }

  ngOnInit(): void {
    this.key1 = sessionStorage.getItem("key");
   
}
/**
* This function will get the data from backend
* and after successfull validation it will provide the data otherwise error
*/
  memberl(){
    this._service.memberForm(this.member).subscribe(
      (data : Member[]) => { console.log("response received");
      console.log(data);
       /**
        * Sending data to output page through queryParam
        */
      this._route.navigate(['/memberdet1Module'],{
        skipLocationChange : true,
        queryParams:{
          data : JSON.stringify(data)
        }
      });
    },
    error =>{
      this.errormsg="Please Enter Correct Member ID or Policy ID";
      this._route.navigate(['/memberdetailsModule'])
      console.log("Bad credentials");
    }
  )

  }

  onLogout(){
    localStorage.clear();
  }
  

}
