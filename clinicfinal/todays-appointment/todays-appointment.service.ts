import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FrontOffice } from '../frontOffice';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TodaysAppointmentService {

  constructor(private _httpService: HttpClient) { }
  getappointments(): Observable<FrontOffice[]>{
    return this._httpService.get<FrontOffice[]>(environment.APIUrl+'/appointment/');
}

SearchPatient(search: string): Observable<FrontOffice[]>{
  return this._httpService.get<FrontOffice[]>(environment.APIUrl+'/searchPatient/'+search);
}
}
