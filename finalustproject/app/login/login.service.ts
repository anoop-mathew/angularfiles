import { Injectable } from '@angular/core';
import { Login } from '../login';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  formData: Login;
  constructor(private _httpService: HttpClient,private router:Router) { }
  getUserId(formData:any):any{
    return this._httpService.get<Login>(environment.APIUrl +'/login/'+formData.username+'/'+formData.password);
  }

}
