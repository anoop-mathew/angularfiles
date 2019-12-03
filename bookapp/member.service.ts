import { Injectable } from '@angular/core';

import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Login } from './login';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MemberService {
  

  formData: Login 
  constructor(private _httpService: HttpClient,private router:Router) { }


  getAllMembers(): any{
    return this._httpService.get<Login[]>(environment.APIUrl+'/member');
  }

  addMember(member: Login){
    let body = JSON.stringify(member);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }

    if(member.userId)
    {
      return this._httpService.put(environment.APIUrl +'/updatemember', body, options);
    }else{
      return this._httpService.post(environment.APIUrl +'/insertmember', body, options);
    }
    
    
  }


  deleteMember(userId: string){
    return this._httpService.delete(environment.APIUrl +'/deletemember/'+ userId);
  }

  getMemberById(userId: string): Observable<Login>{
    return this._httpService.get<Login>(environment.APIUrl +'/member/'+ userId);
    
  }

  private handleError(error: Response){
    return Observable.throw(error);
  }

  getRole(formData:any):any{
    return this._httpService.get<Login>(environment.APIUrl +'/login/'+formData.username+'/'+formData.password);
 
}

logout() :void {    
  localStorage.setItem('isLoggedIn','false');    
  localStorage.removeItem('token');  
  localStorage.removeItem('tokenRoleId');
  this.router.navigate(['/login']);   
  } 
}
