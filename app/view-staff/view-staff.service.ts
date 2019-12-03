import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Admin } from '../admin';
import {environment} from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ViewStaffService {

  constructor(private httpClient:HttpClient) { }

  getAllStaffs():Observable<Admin[]>{
    return this.httpClient.get<Admin[]>(environment.APIUrl+'/staff')
  }
  disableAStaff(staff:Admin){
    let body=JSON.stringify(staff);
    let headers=new HttpHeaders({'Content-Type':'application/json'});
    let options={headers:headers}

    return this.httpClient.put(environment.APIUrl+'/disableStaff',body,options);
  }

  searchStaff(searchString:string):Observable<Admin[]>{
    return this.httpClient.get<Admin[]>(environment.APIUrl+'/staffSearch/'+searchString);
  }
}
