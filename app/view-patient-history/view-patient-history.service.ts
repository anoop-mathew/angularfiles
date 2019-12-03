import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Doctor } from '../doctor';
import { FrontOffice } from '../frontOffice';

@Injectable({
  providedIn: 'root'
})
export class ViewPatientHistoryService {

  constructor(private _httpService:HttpClient) { }

  getpatientMedicineHistory(regId:number):Observable<Doctor[]>
  {

    return this._httpService.get<Doctor[]>(environment.APIUrl + '/medHis/'+regId);
    
  }

  getpatientLabHistory(regId:number):Observable<Doctor[]>
  {

    return this._httpService.get<Doctor[]>(environment.APIUrl + '/labtestshis/'+regId);
    
  }

  getpatientObsHistory(regId:number):Observable<Doctor[]>
  {

    return this._httpService.get<Doctor[]>(environment.APIUrl + '/Obsshis/'+regId);
    
  }

  getPatientDetails(regId:number): Observable<FrontOffice>{
    return this._httpService.get<FrontOffice>(environment.APIUrl +'/patientDetails/'+ regId);
    
  }
  addObserv(ObserNote:Doctor)
  {
    let body=JSON.stringify(ObserNote);
    let headers=new HttpHeaders({'Content-Type':'application/json'});
    let options={headers:headers}

      return this._httpService.post(environment.APIUrl+'/addPatientComment',body,options);
    
  }
}
