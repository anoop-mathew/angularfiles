import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Admin } from '../admin';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddDoctorService {

  constructor(private httpClient:HttpClient) { }

  addDoctor(doctor:Admin){
    let body=JSON.stringify(doctor);
    let headers=new HttpHeaders({'Content-Type':'application/json'});
    let options={headers:headers}

    if(doctor.sId!=0){
      return this.httpClient.put(environment.APIUrl+'/saveDoctor',body,options);
    }else{
    return this.httpClient.post(environment.APIUrl+'/saveDoctor',body,options);
    }
  }

  getDocById(sId:number):Observable<Admin>{
    return this.httpClient.get<Admin>(environment.APIUrl +'/getDoctorById/'+ sId);
  }
}
