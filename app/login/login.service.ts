import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Admin } from '../admin';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router';
import { Login } from '../login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  formData: Login;
  constructor(private _httpService: HttpClient,private router:Router) { }
  getRoleId(formData:any):any{
    return this._httpService.get<Admin>(environment.APIUrl +'/verifyLogin/'+formData.username+'/'+formData.password);
  }


 

}
