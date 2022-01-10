import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClaimService } from '../claim.service';

@Component({
  selector: 'app-claim-output',
  templateUrl: './claim-output.component.html',
  styleUrls: ['./claim-output.component.css']
})
export class ClaimOutputComponent implements OnInit {
  res: any
  key1 : any;
  constructor(private _service : ClaimService, private _route : Router,
    private route : ActivatedRoute) { }

  ngOnInit(): void {
    this.key1 = sessionStorage.getItem("key");
    
    //  Receiving data from input thorugh queryParam
    
    this.route.queryParams.subscribe(
      result =>{
      this.res = JSON.parse(result.data);
      //  console.log(JSON.parse(result.data));
      })
  }

  onLogout(){
    localStorage.clear();
  }
}
