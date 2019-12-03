import { Injectable } from '@angular/core';
import { FrontOffice } from '../frontOffice';
import { Observable } from 'rxjs';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Doctor } from '../doctor';

@Injectable({
  providedIn: 'root'
})
export class AddMedicineRequestService {

  constructor(private httpClient:HttpClient) { }

  getPatientDetails(regId:number): Observable<FrontOffice>{
    return this.httpClient.get<FrontOffice>(environment.APIUrl +'/patientDetails/'+ regId);
    
  }

  getAllMedicines():  Observable<Doctor[]>{
    return this.httpClient.get<Doctor[]>(environment.APIUrl+'/medlists')
  }

  addPrescrib(prescrib:Doctor){
    let body=JSON.stringify(prescrib);
    let headers=new HttpHeaders({'Content-Type':'application/json'});
    let options={headers:headers}

    
      return this.httpClient.post(environment.APIUrl+'/insertpres',body,options);
  }

  getPrecDetails(dId:number,regId:number):Observable<Doctor[]>{
    return this.httpClient.get<Doctor[]>(environment.APIUrl+'/allpreslist/'+dId+'/'+regId);
  }

  deleteMed(prescId: string){
    return this.httpClient.delete(environment.APIUrl +'/deleteMed/'+ prescId);
  }


}
