import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FrontOffice } from '../frontOffice';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ConsultationService {

  constructor(private httpClient:HttpClient) { }

  getAvaliableDoctors():Observable<FrontOffice[]>{
    return this.httpClient.get<FrontOffice[]>(environment.APIUrl+'/getAvailableDoctor');
  }
  getPatientDetails(regId:number): Observable<FrontOffice>{
    return this.httpClient.get<FrontOffice>(environment.APIUrl +'/patientDetails/'+ regId);
    
  }

  getDocAvail(sName:string): Observable<FrontOffice>{
    return this.httpClient.get<FrontOffice>(environment.APIUrl +'/searchDoctorByName/'+ sName);
    
  }
  
  addDocAppoinment(consult:FrontOffice){
    let body=JSON.stringify(consult);
    let headers=new HttpHeaders({'Content-Type':'application/json'});
    let options={headers:headers}

    return this.httpClient.post(environment.APIUrl+'/insertAppoinment',body,options);
    
  }
}
