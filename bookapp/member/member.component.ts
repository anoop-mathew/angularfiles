import { Component, OnInit } from '@angular/core';
import { Login } from '../login';
import { MemberService } from '../member.service';

@Component({
  selector: 'app-member',
  templateUrl: './member.component.html',
  styleUrls: ['./member.component.scss']
})
export class MemberComponent implements OnInit {

  members: Login[];
  member = new Login();
  
  constructor(private _memberService: MemberService) { }

  ngOnInit() {

    this.getMembers();
  }

  getMembers(): void{
    this._memberService.getAllMembers()
    .subscribe((memberData) =>{
      this.members=memberData,
      console.log(memberData);
    }, (error) =>{
      console.log(error);
    });
  }

  addMember(): void{
    this._memberService.addMember(this.member)
      .subscribe((response)=>{
        console.log(response);
        this.reset();
        this.getMembers();
      }, (error)=>{
        console.log(error);
      });
  }

  private reset(){
    this.member.userName = null;
    this.member.userPassword = null;
    this.member.roleId = null;
  }

  deleteMember(userId: string){
    this._memberService.deleteMember(userId)
      .subscribe((response)=>{
        console.log(response);
        this.getMembers();
      }, (error)=>{
        console.log(error);
      });
  }

  getMemberById(userId: string){
    this._memberService.getMemberById(userId)
    .subscribe((bookData) =>{
      this.member=bookData;
      this.getMembers();
      console.log(bookData);
    }, (error) =>{
      console.log(error);
    });
  }

  logout() {  
    console.log('logout');  
    this._memberService.logout();  
  } 



}