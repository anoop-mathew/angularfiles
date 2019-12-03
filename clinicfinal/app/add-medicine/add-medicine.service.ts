import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Admin } from '../admin';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddMedicineService {

  constructor(private _httpService:HttpClient) { }


  addMedicine(medicine:Admin){
    let body = JSON.stringify(medicine);
    let headers= new HttpHeaders({'Content-Type':'application/json'});
    let options= { headers: headers }
    console.log(medicine.medId);
    if(medicine.medId!=0)
    {
      return this._httpService.put(environment.APIUrl +'/insertMedicine',body,options);
    }
    else
    {
      return this._httpService.post(environment.APIUrl +'/insertMedicine',body,options);
    }
    
  }

  getMedicineById(medId: string): Observable<Admin>{
    return this._httpService.get<Admin>(environment.APIUrl+'/getMedicineId/'+medId);
    
  }


}
