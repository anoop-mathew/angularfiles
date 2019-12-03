import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Doctor } from '../doctor';
import { Observable } from 'rxjs';
import { FrontOffice } from '../frontOffice';

@Injectable({
  providedIn: 'root'
})
export class ViewDoctorsAppointmentService {

  constructor(private _httpService: HttpClient) { }

  getDocAppoinment(dId:number):Observable<Doctor[]>{
    return this._httpService.get<Doctor[]>(environment.APIUrl +'/getdoctorsappointment/'+ dId);
  }

  SearchAppointment(search: string,dId:number): Observable<Doctor[]>{
    return this._httpService.get<Doctor[]>(environment.APIUrl+'/searchAppointment/'+search+'/'+dId);
  }

  getCompletedApp(dId:number): Observable<Doctor[]>{
    return this._httpService.get<Doctor[]>(environment.APIUrl+'/getdoctorscompletedappointment/'+dId);
    //doctor id can't be passed(101)
  }
  
  getAnydApp(dId:number): Observable<Doctor[]>{
    return this._httpService.get<Doctor[]>(environment.APIUrl+'/getDoctorsAnyAppointment/'+dId);
    //doctor id can't be passed(101)
  }
}
