import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { FrontOffice } from '../frontOffice';

@Injectable({
  providedIn: 'root'
})
export class ViewPatientService {


  constructor(private _httpService:HttpClient) { }
  AllPatients(): Observable<FrontOffice[]>{
    return this._httpService.get<FrontOffice[]>(environment.APIUrl+'/patients');
  }

  SearchPatient(search: string): Observable<FrontOffice[]>{
    return this._httpService.get<FrontOffice[]>(environment.APIUrl+'/patient/'+search);
  }

  ViewPatientByRegId(regId: number): Observable<FrontOffice>{
    return this._httpService.get<FrontOffice>(environment.APIUrl+'/ViewPatient/'+regId);
  }

}
