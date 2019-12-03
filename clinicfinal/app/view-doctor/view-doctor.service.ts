import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Admin } from '../admin';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ViewDoctorService {

  constructor(private _httpService:HttpClient) { }

  getAllDoctors(): Observable<Admin[]>{
    return this._httpService.get<Admin[]>(environment.APIUrl+'/listdoctor');
}

disableDoctor(disable:Admin){
  let body=JSON.stringify(disable);
    let headers=new HttpHeaders({'Content-Type':'application/json'});
    let options={headers:headers}

      return this._httpService.put(environment.APIUrl+'/disableDoctor',body,options);
    
}
searchDoctor(search:string):Observable<Admin[]>{
  return this._httpService.get<Admin[]>(environment.APIUrl+'/doctor/'+search);
}
}
