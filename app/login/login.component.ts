import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { NgForm } from '@angular/forms';
import { LoginService } from './login.service';
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
  sessionTokenRoleId:string;
  message:string;

  ngOnInit() {
    this.resetForm();
    this.sessionTokenUserName=localStorage.getItem('token');
    console.log(this.sessionTokenUserName=localStorage.getItem('token'));
    this.sessionTokenRoleId=localStorage.getItem('tokenRoleId');
  }

  resetForm(form?:NgForm)
  {
    if(form!=null)
    
      form.resetForm();
      this.loginService.formData={
        username:null,
        password:null,
        roleId:null,
        roleName:null,
        sName:null,
        dId:null,
        isSActive:null,
        sId:null,
      }
    }
  OnSubmit(form:NgForm){
    
    this.validLogin(form);
  }
 
    validLogin(form:NgForm){
      console.log(form.value);
  //if ((this.sessionTokenUserName==null) && (this.sessionTokenRoleId==null))
 // {
      this.loginService.getRoleId(form.value).subscribe(data=>{
      this.staff=data;
      localStorage.setItem('isLoggedIn', "true");
      localStorage.setItem('token', data.roleName);
      localStorage.setItem('tokenRoleId', data.roleId);
     if(this.staff.roleId==1)
    {
      this.router.navigate(['AdminHome/'+this.staff.sId]);
    }
      
    else if(this.staff.roleId==5)
    {
      this.router.navigate(['frontHome/'+this.staff.sId]);
    }
    else if(this.staff.roleId==2)
    {
      this.router.navigate(['docHome/'+this.staff.dId]);
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
         
 
      

/*  loginUser(event){

    event.preventDefault()
    console.log(event)
    var username=event.target.elements[0].value;
    var password=event.target.elements[1].value;
    
    if(username=='admin' && password=='admin')
    {
      this.router.navigate(['Admin']);
    }
      
    else if(username=='front' && password=='front')
    {
      this.router.navigate(['TodaysApp']);
    }
    else if(username=='doctor' && password=='doctor')
    {
      this.router.navigate(['ViewDocApp']);
    }
      
    else
    {     this.message="Invalid username and password";
          this.router.navigate(['Login']);
    }

    console.log(username,password);
  }*/
