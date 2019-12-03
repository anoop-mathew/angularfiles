import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Admin } from '../admin';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddStaffService {

  constructor(private httpClient:HttpClient) { }

  addStaffServ(staff:Admin){
    let body=JSON.stringify(staff);
    let headers=new HttpHeaders({'Content-Type':'application/json'});
    let options={headers:headers}

    if(staff.sId!=0){
      return this.httpClient.put(environment.APIUrl+'/insertStaff',body,options);
    }else{
      return this.httpClient.post(environment.APIUrl+'/insertStaff',body,options);
    }
    
  }

  getstafById(sId:number):Observable<Admin>{
    return this.httpClient.get<Admin>(environment.APIUrl +'/staffById/'+sId);
  }  

  getAllRoles():Observable<Admin[]>{
    return this.httpClient.get<Admin[]>(environment.APIUrl +'/getRole');
  }  
}
