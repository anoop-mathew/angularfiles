import { Component, OnInit } from '@angular/core';
import { Login } from '../login';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { BookService } from '../book.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  login=new Login();
  sessionTokenUserName:string;
  sessionTokenRoleId:string;

  constructor(private router:Router, private _BookService: BookService) { }

  ngOnInit() {

    this.resetForm()
    this.sessionTokenUserName=localStorage.getItem('token');
    console.log(this.sessionTokenUserName=localStorage.getItem('token'));
    this.sessionTokenRoleId=localStorage.getItem('tokenRoleId');
  }
  resetForm(form?:NgForm){
   if(form!=null)
   form.resetForm();
   this._BookService.formData={
    roleId:null,
    userId:null,
    roleName:null,
    userName:'',
    userPassword:'',
   }
  }
  
  OnSubmit(form:NgForm)
  {
    this.validLogin(form)
  }
  validLogin(form: NgForm){
    console.log(form.value);
    
    //if ((this.sessionTokenUserName==null) && (this.sessionTokenRoleId==null))
   // {
      this._BookService.getRole(form.value).subscribe(data=> {
      this.login=data;
      console.log(this.login);
      localStorage.setItem('isLoggedIn', "true");
      localStorage.setItem('token', data.roleName);
      localStorage.setItem('tokenRoleId', data.roleId);
      console.log(data.roleId);
      if (data.roleId==1)
      {
        console.log(data.roleName);

        this.router.navigate(['/admin']);

      }
      else if (data.roleId==2)
      {
        console.log("Front Office");
         //this.router.navigate(['/frontoffice']);
        }
        else if(data.roleId==3)
        {
        // this.router.navigate(['/pharmacist']);
        console.log("Pharmacist");
        }
        else if(data.roleId==4)
        {
         //this.router.navigate(['/guest']);
         console.log("Guest");
        }
        else if(data.roleId==5)
        {
          console.log(data.roleName);
         this.router.navigate(['/memberview']);
         console.log("memberview");
        }
      
    },
    (error) =>{
      console.log(error);
    });
    }
  }
//}
