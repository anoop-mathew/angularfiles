import { Injectable } from '@angular/core';
import { Login } from './login';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MemberviewService {

  
  formData: Login 
  constructor(private _httpService: HttpClient,private router:Router) { }

  getMemberView(): any{
    return this._httpService.get<Login[]>(environment.APIUrl+'/memberview');
  }

  
logout() :void {    
  localStorage.setItem('isLoggedIn','false');    
  localStorage.removeItem('token');  
  localStorage.removeItem('tokenRoleId');
  this.router.navigate(['/login']);   
  } 

}
