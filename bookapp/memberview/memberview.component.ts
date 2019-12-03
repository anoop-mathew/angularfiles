import { Component, OnInit } from '@angular/core';
import { MemberService } from '../member.service';
import { Login } from '../login';
import { MemberviewService } from '../memberview.service';

@Component({
  selector: 'app-memberview',
  templateUrl: './memberview.component.html',
  styleUrls: ['./memberview.component.scss']
})
export class MemberviewComponent implements OnInit {

  members: Login[];
  member = new Login();
  
  constructor(private _memberviewService: MemberviewService) { }

  ngOnInit() {

    this.getMemberView();
   
  }
  getMemberView(): void{
    this._memberviewService.getMemberView()
    .subscribe((memberData) =>{
      this.members=memberData,
      console.log(memberData);
    }, (error) =>{
      console.log(error);
    });
  }
  logout() {  
    console.log('logout');  
    this._memberviewService.logout();  
  } 

}
