import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FrontOffice } from '../frontOffice';
import { environment } from 'src/environments/environment';
import { Doctor } from '../doctor';


@Injectable({
  providedIn: 'root'
})
export class LabtestRequestService {

  constructor(private httpClient:HttpClient) { }
 
  getPatientDetails(regId: number): Observable<FrontOffice>{
    return this.httpClient.get<FrontOffice>(environment.APIUrl +'/patientDetails/'+ regId);
    
  }

  
  getAllLabs():  Observable<Doctor[]>{
    return this.httpClient.get<Doctor[]>(environment.APIUrl+'/labtests')
  }

  addLabPrescrib(prescrib:Doctor){
    let body=JSON.stringify(prescrib);
    let headers=new HttpHeaders({'Content-Type':'application/json'});
    let options={headers:headers}
      return this.httpClient.post(environment.APIUrl+'/insertlabpres',body,options);
  }

  getPrecDetails(dId:number,regId:number):Observable<Doctor[]>{
    return this.httpClient.get<Doctor[]>(environment.APIUrl+'/alllabpreslist/'+dId+'/'+regId);
  }
 
  deleteLab(assignLabId: number){
    return this.httpClient.delete(environment.APIUrl +'/deleteLab/'+assignLabId);
  }


}