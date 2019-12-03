import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LogoutService {

  constructor(private httpClint: HttpClient, private router: Router) { }

  Logout(): void{    
    localStorage.setItem('isLoggedIn','false');    
    localStorage.removeItem('token');  
    localStorage.removeItem('tokenRoleId');
    this.router.navigate(['/Login']);   
    } 
}