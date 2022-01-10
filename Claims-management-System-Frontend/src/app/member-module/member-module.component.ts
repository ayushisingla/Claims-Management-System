import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Member } from '../member';
import { MemberService } from '../member.service';
import { User } from '../user';

@Component({
  selector: 'app-member-module',
  templateUrl: './member-module.component.html',
  styleUrls: ['./member-module.component.css']
})
export class MemberModuleComponent implements OnInit {
  member =new Member();

 
  res: any
  key1 : any
  constructor(private _service : MemberService, private _route : Router,
    private route : ActivatedRoute) { }

 

  ngOnInit(): void {
    this.route.queryParams.subscribe(
      result =>{
      this.res = JSON.parse(result.data);
      //  console.log(JSON.parse(result.data));
      })
       this.key1 = sessionStorage.getItem("key");
       
  }

  onLogout(){
    localStorage.clear();
  }

 

}
