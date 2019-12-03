import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import {FrontOffice} from '../frontOffice';
import { HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddPatientService {
  

  constructor(private _httpService:HttpClient) { }

  savePatient(patientObj: FrontOffice){
    console.log(patientObj.regId);
    let body = JSON.stringify(patientObj); //to convert the ressult obtained in html to json format 
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }

    if(patientObj.regId){
      return this._httpService.post(environment.APIUrl+'/insertPatient',body,options); 
    }
else{
    return this._httpService.put(environment.APIUrl+'/insertPatient',body,options);
}
}

getPatientById(regId):Observable<FrontOffice>{
  return this._httpService.get<FrontOffice>(environment.APIUrl +'/patientDetails/'+regId);
}
}