import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from './login.service';
import { Router } from '@angular/router';
import { Login } from '../login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private router:Router,private loginService:LoginService) { }

  staff= new Login();
  sessionTokenUserName:string;
  sessionTokenVendorId:string;
   message:string;
  ngOnInit() {
    this.resetForm();
    this.sessionTokenUserName=localStorage.getItem('token');
    console.log(this.sessionTokenUserName=localStorage.getItem('token'));
    this.sessionTokenVendorId=localStorage.getItem('tokenVendorId');
  }
   
  resetForm(form?:NgForm)
  {
    if(form!=null)
    
      form.resetForm();
      this.loginService.formData={
        username:null,
        password:null,
        userId:null
      }
    }

  OnSubmit(form:NgForm){
    
    this.validLogin(form);
  }
  validLogin(form:NgForm){
    console.log(form.value);
 //if ((this.sessionTokenUserName==null) && (this.sessionTokenRoleId==null))
 // {
  this.loginService.getUserId(form.value).subscribe(data=>{
    this.staff=data;
    localStorage.setItem('isLoggedIn', "true");
    localStorage.setItem('token', data.username);
    localStorage.setItem('tokenRoleId', data.vendorId);
   if(this.staff.userId==100)
   {
    this.router.navigate(['Home']);
  }
  else if(this.staff.userId==101)
  {
    this.router.navigate(['Home']);
  }
  else
  {     this.message="Invalid username and password";
        this.router.navigate(['Login']);
  }
},
(error) =>{
  console.log(error);
});
}
}
//}